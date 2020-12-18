/**********************************************************************
 * This file is part of iDempiere ERP Open Source                      *
 * http://www.idempiere.org                                            *
 *                                                                     *
 * Copyright (C) Contributors                                          *
 *                                                                     *
 * This program is free software; you can redistribute it and/or       *
 * modify it under the terms of the GNU General Public License         *
 * as published by the Free Software Foundation; either version 2      *
 * of the License, or (at your option) any later version.              *
 *                                                                     *
 * This program is distributed in the hope that it will be useful,     *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of      *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
 * GNU General Public License for more details.                        *
 *                                                                     *
 * You should have received a copy of the GNU General Public License   *
 * along with this program; if not, write to the Free Software         *
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
 * MA 02110-1301, USA.                                                 *
 *                                                                     *
 * Contributors:                                                       *
 * - Carlos Ruiz - globalqss                                           *
 **********************************************************************/

package org.globalqss.util;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MSysConfig;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.globalqss.model.X_LCO_TaxIdType;

public class LEC_TaxIDDigit implements ILCO_TaxIDDigit {

	private static final int NATURAL = 0;
	private static final int PUBLICA = 1;
	private static final int JURIDICA = 2;

	@Override
	public int calculateDigit(String taxID, int taxidtype_id) {
		// validacion inicial longitud (10 o 13) - validado por tipo mas adelante
		int longdoc = taxID.length();
		if (longdoc != 13 && longdoc != 10) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LEC_TaxIDWrongLength"));
		}
		try {
			long taxIDnum = Long.parseLong(taxID);
			if (taxIDnum < 0)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LCO_NotANumber"));
		}
		int provincia = Integer.parseInt(taxID.substring(0, 2));
		if (provincia < 1 || provincia > 24) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LEC_WrongProvince"));
		}
		int tipo = Integer.parseInt(taxID.substring(2, 3));
		int longconsec;
		int tipopersona;
		int mod;
		Integer[] coeficientes;
		switch (tipo) {
		case 0: case 1: case 2: case 3: case 4: case 5:
			longconsec = 6; // natural
			tipopersona = NATURAL;
			mod = 10;
			coeficientes = new Integer[] {2,1,2,1,2,1,2,1,2};
			break;
		case 6:
			longconsec = 5; // publica
			tipopersona = PUBLICA;
			mod = 11;
			coeficientes = new Integer[] {3,2,7,6,5,4,3,2};
			break;
		case 9:
			longconsec = 6; // juridica o extranjera
			tipopersona = JURIDICA;
			mod = 11;
			coeficientes = new Integer[] {4,3,2,7,6,5,4,3,2};
			break;
		default:
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LEC_WrongTaxCode"));
		}
		// valida longitud por tipo de documento
		if (longdoc == 10) {  // ya se sabe arriba que si no es 10 es 13 y 13 es correcto
			if (   tipopersona != NATURAL
				|| ! MSysConfig.getBooleanValue("QSSLEC_Allow10DigitDoc", true, Env.getAD_Client_ID(Env.getCtx()))) {
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LEC_TaxIDWrongLength"));
			}
		}
		if (MSysConfig.getBooleanValue("QSSLEC_ValidateWithTaxCode", true, Env.getAD_Client_ID(Env.getCtx()))) {
			X_LCO_TaxIdType taxidtype = new X_LCO_TaxIdType(Env.getCtx(), taxidtype_id, null);
			if (! taxidtype.getLCO_TaxCodeDian().contains(taxID.substring(2, 3))) {
				// Para habilitar esta validacion se debe llenar taxcode con 012345 para RUC Natural, 6 para RUC Publico, 9 para RUC Juridico
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LEC_WrongTaxCode"));
			}
		}
		String valida = taxID.substring(0, 3+longconsec);
		int digitoInterno = Integer.parseInt(taxID.substring(3+longconsec, 3+longconsec+1));
		if (longdoc > 10) {
			int suc = Integer.parseInt(taxID.substring(3+longconsec+1, 13));
			if (tipopersona == NATURAL && suc != 1) {
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LEC_WrongBranch"));
			}
		}
		int digito = modulo(valida, coeficientes, mod);
		if (digito != digitoInterno) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LEC_WrongDigit"));
		}
		return digito;
	}

	/**
	 * Implementa algoritmos modulo 10 y 11 con coeficientes
	 * @param valida - cadena de numeros a generar el digito de verificacion
	 * @param coeficientes - arreglo de enteros usados como coeficientes
	 * @param mod - modulo (LEC usa 10 u 11)
	 * @return
	 */
	public static int modulo(String valida, Integer[] coeficientes, int mod) {
		if (valida.length() > coeficientes.length) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LCO_WrongLength"));
		}
		int iOperacion = 0;

		//Ciclo para multiplicar cada uno de los digitos con el vector
		for (int i = 0; i < valida.trim().length() ; i++) {
			try {
				int sumando = Integer.parseInt(valida.substring(i, i + 1)) * coeficientes[i];
				if (mod == 10 && sumando > 9) // para el algoritmo modulo 10 (Luhn algorithm) se utiliza el residuo de 9
					sumando -= 9;
				iOperacion = iOperacion + sumando;
			} catch (NumberFormatException e) {
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LCO_NotANumber"));
			}
		}

		// Obtener el residuo de la operacion
		iOperacion %= mod;
		iOperacion = mod - iOperacion;
		if (iOperacion >= 10) {
			iOperacion = mod - iOperacion;
		}

		return iOperacion;
	}

	/*
	public static void main(String[] args) {
		LEC_TaxIDDigit test = new LEC_TaxIDDigit();
		test.testDigit("1790011674001", 4); // juridico
		test.testDigit("1760001550001", 5); // publico
		test.testDigit("1710034065001", 5); // natural
		test.testDigit("0801895186001", 6); // natural
		test.testDigit("0919171819"   , 9); // natural
		test.testDigit("1716742687"   , 7); // natural
	}

	private void testDigit(String taxID, int digitExpected) {
		int digit = calculateDigit(taxID, 0);
		System.out.println(taxID + (digit == digitExpected ? " right " : " wrong ") + " " + digit + " expected " + digitExpected);
	}
	*/

}
