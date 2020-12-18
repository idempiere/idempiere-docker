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
import org.compiere.util.Env;
import org.compiere.util.Msg;


public class LCO_TaxIDDigit implements ILCO_TaxIDDigit {

	@Override
	public int calculateDigit(String taxID, int taxidtype_id) {
		//Vector de numeros primos
		Integer nrosPrimos[] = { 3, 7, 13, 17, 19, 23, 29, 37,	41, 43, 47, 53, 59, 67, 71 };
		int digit = modulo(taxID, nrosPrimos, 11);
		return digit;
	}

	/**
	 * Implementa algoritmo modulo 11 con vector de primos en sentido inverso
	 * @param valida - cadena de numeros a generar el digito de verificacion
	 * @param coeficientes - arreglo de enteros usados como coeficientes (LCO usa primos)
	 * @param mod - LCO usa 11
	 * @return
	 */
	public static int modulo(String valida, Integer[] coeficientes, int mod) {
		if (valida.length() > coeficientes.length) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LCO_WrongLength"));
		}
		int iOperacion = 0;
		int posini = 0;

		//Ciclo para multiplicar cada uno de los digitos con el vector
		for (int i = 0; i < valida.trim().length() ; i++) {
			posini = valida.trim().length() - (i + 1); // el vector de primos se recorre en sentido inverso
			try {
				int sumando = Integer.parseInt(valida.substring(posini, posini + 1)) * coeficientes[i];
				iOperacion = iOperacion + sumando;
			} catch (NumberFormatException e) {
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LCO_NotANumber"));
			}
		}

		//Obtener el residuo de la operacion
		iOperacion %= mod;

		if (iOperacion == 0 || iOperacion == 1)	{
			return iOperacion;
		} else {
			return mod - iOperacion;
		}
	}

	/*
	public static void main(String[] args) {
		LCO_TaxIDDigit test = new LCO_TaxIDDigit();
		test.testDigit("830085359", 4);
		test.testDigit("79458637", 5);
	}

	private void testDigit(String taxID, int digitExpected) {
		int digit = calculateDigit(taxID, 0);
		System.out.println(taxID + (digit == digitExpected ? " right " : " wrong ") + " " + digit + " expected " + digitExpected);
	}
	*/
	
}
