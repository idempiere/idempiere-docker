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

package org.globalqss.process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.compiere.model.MAttachment;
import org.compiere.model.MAttachmentEntry;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MLocation;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTable;
import org.compiere.model.MUser;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.globalqss.model.MLCOConversion;
import org.globalqss.model.MLCODIANConcept;
import org.globalqss.model.MLCODIANFormat;
import org.globalqss.model.X_LCO_DIAN_FieldFormat;
import org.globalqss.model.X_LCO_DIAN_SendSchedule;
import org.globalqss.model.X_LCO_DIAN_SendScheduleLine;
import org.globalqss.model.X_LCO_DIAN_XMLPrintLabel;
import org.globalqss.model.X_LCO_DIAN_XML_Header;
import org.xml.sax.helpers.AttributesImpl;

/**
 *	LCO_DianExportXML
 *
 *  @author Carlos Ruiz - globalqss - Quality Systems & Solutions - http://globalqss.com
 */
public class LCO_DianExportXML  extends SvrProcess {

	/** The Record						*/
	private int		p_Record_ID = 0;

	private int		p_LCO_DIAN_XML_Header_ID = 0;
	/** Dir				*/
	private String folder = "";

	private boolean isAttachXML = false;
	/**
	 *  Prepare - e.g., get Parameters.
	 */
	protected void prepare()
	{
		ProcessInfoParameter[] para = getParameter();

		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName().trim();
			if (name.equals("IsAttachXML")) {
				if (para[i].getParameter().equals("Y")) {
					isAttachXML = true;
				}
			}
			if (name.equals("Folder")) {
				if (para[i].getParameter()!=null)
					folder = para[i].getParameter().toString();
			}
		}
		p_Record_ID = getRecord_ID();
		p_LCO_DIAN_XML_Header_ID = p_Record_ID;
	}	//	prepare

	/**
	 * 	Process
	 *	@return message
	 *	@throws Exception
	 */
	protected String doIt() throws Exception{
		/**
		 * Parametros
			-> IsAttachXML
			-> Path/Directory
			-  Validar XML --Flag
			Para XML Header
			    Genere el nombre del archivo de acuerdo a la resolucion
			    Escribir encabezado
			    Para cada Send Line del XML Header
			        Para Campo
			            Escriba campo
			        Fin Campo
			    Fin Para
			    Cerrrar Archivo
			    Si IsAttachXML
			        Anexar el archivo XML al XML Header (probar con Archivador
			a ver si funciona, si no con Attachment)
			        NOTA: ¿Que hacer si ya hay un archivo previo generado?
			Verificar si el archivador es read-only, y si podria renombrar
			un archivo previo generado para añadirle un sufijo _old_yyyymmdd
			Fin XML Header
		 **/
		if (! MSysConfig.getBooleanValue("LCO_USE_MAGNETIC_MEDIA", true, Env.getAD_Client_ID(Env.getCtx())))
			return "@invalid@";

		OutputStream  mmDocStream = null;
		X_LCO_DIAN_XML_Header xmlheader = new X_LCO_DIAN_XML_Header (getCtx(),p_LCO_DIAN_XML_Header_ID , get_TrxName());
		X_LCO_DIAN_SendSchedule sendScheduleProcess = new X_LCO_DIAN_SendSchedule (getCtx(), xmlheader.getLCO_DIAN_SendSchedule_ID(), get_TrxName());

		if (sendScheduleProcess.getLCO_DIAN_SendSchedule_ID() <= 0)
			throw new AdempiereUserError("@No@ @LCO_DIAN_SendSchedule@");

		if (sendScheduleProcess.getLCO_DIAN_Format_ID() <= 0)
			throw new AdempiereUserError("@No@ @LCO_DIAN_Format@");
		MLCODIANFormat format = new MLCODIANFormat (getCtx(), sendScheduleProcess.getLCO_DIAN_Format_ID(), get_TrxName());

		X_LCO_DIAN_XMLPrintLabel labelDet = new X_LCO_DIAN_XMLPrintLabel(getCtx(), format.getLCO_DIAN_XMLPrintLabel_ID(), get_TrxName());
		String printLbDet = labelDet.getValue();

		/**Dmuisca_ccmmmmmvvaaaacccccccc.xml
		   cc : Concepto (Inserción = 01, Reemplazo = 02)
		   mmmmm : Formato (Retenciones en la fuente practicadas = 01002)
		   vv : Versión del formato (Versión = 07).
		   aaaa : Año de envío.
		   cccccccc : Consecutivo de envío por año.
		 **/
		String xmlFileName = "Dmuisca_"
				+ String.format("%2s", sendScheduleProcess.getSendConceptCode()).replace(" ", "0")
				+ String.format("%5s", format.getValue()).replace(" ", "0")
				+ String.format("%2s", format.getVersionNo()).replace(" ", "0")
				+ String.format("%tY", sendScheduleProcess.getSendDate())
				+ String.format("%08d", xmlheader.getSequence())
				+ ".xml";

		if ( folder.equals(""))
			throw new AdempiereUserError("Folder is mandatory");

		//crea los directorios para los archivos xml
		(new File(folder+File.separator+ "XMLGenerated"+File.separator)).mkdirs();
		//ruta completa del archivo xml
		String file_name = folder+File.separator+ "XMLGenerated"+File.separator+xmlFileName;
		//Stream para el documento xml
		mmDocStream = new FileOutputStream (file_name, false);
		StreamResult streamResult_menu = new StreamResult(new OutputStreamWriter(mmDocStream,"ISO-8859-1"));
		SAXTransformerFactory tf_menu = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		try {
			tf_menu.setAttribute("indent-number", Integer.valueOf(0));
		} catch (Exception e) {
			// swallow
		}
		TransformerHandler mmDoc = tf_menu.newTransformerHandler();
		Transformer serializer_menu = mmDoc.getTransformer();
		serializer_menu.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
		try {
			serializer_menu.setOutputProperty(OutputKeys.INDENT,"yes");
		} catch (Exception e) {
			// swallow
		}
		mmDoc.setResult(streamResult_menu);
		mmDoc.startDocument();
		AttributesImpl atts = new AttributesImpl();
		//XML Header
		//Para XML Header
		atts.clear();
		// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="../xsd/1002.xsd"
		atts.addAttribute("", "", "xmlns:xsi", "CDATA", "http://www.w3.org/2001/XMLSchema-instance");
		atts.addAttribute("", "", "xsi:noNamespaceSchemaLocation", "CDATA", "../xsd/"+format.getValue()+".xsd");
		mmDoc.startElement("","","mas",atts);
		atts.clear();
		mmDoc.startElement("","","Cab",atts);
		//Escribir encabezado
		//Año de envío,int4,Formato AAAA
		addHeaderElement(mmDoc, "Ano", String.format("%tY", sendScheduleProcess.getSendDate()), atts);
		//Concepto ,int2 , 1= Inserción 2= Reemplazo
		addHeaderElement(mmDoc, "CodCpt", sendScheduleProcess.getSendConceptCode(), atts);
		//Código del formato ,int5 ,Retenciones en la fuente practicadas = 1002
		addHeaderElement(mmDoc, "Formato", format.getValue(), atts);
		//Versión del formato ,int2 ,Versión = 7
		addHeaderElement(mmDoc, "Version", format.getVersionNo(), atts);
		/**Número de envío ,int8
		   Debe ser un número consecutivo por año para todos los formatos que el remitente envíe a la DIAN
		   Consecutivo de envío por año.**/
		addHeaderElement(mmDoc, "NumEnvio", "" + xmlheader.getSequence(), atts);
		//Fecha de envío,datetime19 ,Debe ser la fecha calendario. Formato AAAA-MM-DDTHH:MM:SS
		addHeaderElement(mmDoc, "FecEnvio", String.format("%1$tFT%1$tT", sendScheduleProcess.getSendDate()), atts);
		//Fecha Inicial ,date10 ,Debe ser la fecha calendario.Los registros corresponden mínimo esta fecha inicial. Formato AAAA-MM-DD
		addHeaderElement(mmDoc, "FecInicial", String.format("%1$tF", sendScheduleProcess.getStartDate()), atts);
		//Fecha Final ,date10 ,Debe ser la fecha calendario.Los registros corresponden máximo a esta fecha final. Formato AAAA-MM-DD
		addHeaderElement(mmDoc, "FecFinal", String.format("%1$tF", sendScheduleProcess.getEndDate()), atts);
		//Valor Total , double20
		//Corresponde a la sumatoria de la casilla vret (Valor de la Retención en la fuente practicada) de los registros reportados.
		addHeaderElement(mmDoc, "ValorTotal", String.format("%.0f", xmlheader.getCumulatedAmt()), atts);
		//Cantidad de registros ,int4 ,Se enviarán archivos con máximo 5000 registros (*).
		//Cantidad de registros reportados en el contenido.
		addHeaderElement(mmDoc, "CantReg", String.format("%.0f", xmlheader.getRecordsQty()), atts);

		mmDoc.endElement("","","Cab");

		X_LCO_DIAN_FieldFormat[] fieldFormats = format.getFields();

		//body
		atts.clear();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlschline = "SELECT * FROM LCO_DIAN_SendScheduleLine WHERE LCO_DIAN_XML_Header_ID =? ORDER BY LCO_DIAN_SendScheduleLine_ID";
		try
		{
			pstmt = DB.prepareStatement(sqlschline, get_TrxName());
			pstmt.setInt(1, p_LCO_DIAN_XML_Header_ID);
			rs = pstmt.executeQuery();
			//Para cada Send Line del XML Header
			while (rs.next()) {
				X_LCO_DIAN_SendScheduleLine dssl = new X_LCO_DIAN_SendScheduleLine (getCtx(),rs, get_TrxName());
				int line_id = dssl.getLCO_DIAN_SendScheduleLine_ID();
				MLCODIANConcept concept = new MLCODIANConcept(getCtx(), dssl.getLCO_DIAN_Concept_ID(),get_TrxName());
				MBPartner bp = null;
				MBPartnerLocation bpl = null;
				MLocation loc = null;
				boolean isColombia = true;
				boolean isDetailedNames = false;
				if (dssl.getC_BPartner_ID() > 0) {
					bp = new MBPartner(getCtx(), dssl.getC_BPartner_ID(), get_TrxName());
					bpl = bp.getLocation(dssl.getC_BPartner_Location_ID());
					loc = bpl.getLocation(false);
					isColombia = (loc.getC_Country_ID() == 156);  /* HARDCODED = Colombia C_Country_ID */
					isDetailedNames = (Boolean) bp.get_Value("IsDetailedNames");
				}
				MBPartner bp2 = null;
				boolean isDetailedNames2 = false;
				if (dssl.getC_BPartnerRelation_ID() > 0) {
					bp2 = new MBPartner(getCtx(), dssl.getC_BPartnerRelation_ID(), get_TrxName());
					isDetailedNames2 = (Boolean) bp2.get_Value("IsDetailedNames");
				}

				//Para Campo
				for (X_LCO_DIAN_FieldFormat fieldFormat : fieldFormats) {
					if (!fieldFormat.isPrinted())
						continue;
					X_LCO_DIAN_XMLPrintLabel label = new X_LCO_DIAN_XMLPrintLabel(getCtx(), fieldFormat.getLCO_DIAN_XMLPrintLabel_ID(), get_TrxName());
					String printLb = label.getValue();

					// Condicion de error
					if (bp == null
							&& (   printLb.equals("tdoc")
								|| printLb.equals("tdoce")
								|| printLb.equals("tdocb")
								|| printLb.equals("nid")
								|| printLb.equals("nite")
								|| printLb.equals("nitb")
								|| printLb.equals("dv")
								|| printLb.equals("apl1")
								|| printLb.equals("pap")
								|| printLb.equals("apl2")
								|| printLb.equals("sap")
								|| printLb.equals("nom1")
								|| printLb.equals("pno")
								|| printLb.equals("nom2")
								|| printLb.equals("ono")
								|| printLb.equals("raz")
								|| printLb.equals("dir")
								|| printLb.equals("dpto")
								|| printLb.equals("mun")
								|| printLb.equals("mcpo")
								|| printLb.equals("pais")
								|| printLb.equals("email"))) {
						throw new AdempiereUserError(printLb + " cannot be used without BP detail");
					}

					// Condicion de error
					if (bp2 == null
							&& (   printLb.equals("tdocm")
								|| printLb.equals("nitm")
								|| printLb.equals("dvm")
								|| printLb.equals("apl1m")
								|| printLb.equals("apl2m")
								|| printLb.equals("nom1m")
								|| printLb.equals("nom2m")
								|| printLb.equals("razm"))) {
						throw new AdempiereUserError(printLb + " cannot be used without BP 2 detail");
					}

					if (printLb.equals("cpt") || printLb.equals("ctp") || printLb.equals("top")) {
						// Concepto ( Siempre debe diligenciarse )
						add_Attribute(atts, printLb, concept.getValue(), line_id, true);
					} else if (printLb.equals("tdoc") || printLb.equals("tdoce") || printLb.equals("tdocb")) {
						//Tipo de Documento ( Siempre debe diligenciarse )
						add_Attribute(atts, printLb, getTdoc(dssl.getC_BPartner_ID()), line_id, true);
					} else if (printLb.equals("tdocm")) {
						add_Attribute(atts, printLb, getTdoc(dssl.getC_BPartnerRelation_ID()), line_id, true);
					} else if (printLb.equals("nid") || printLb.equals("nite") || printLb.equals("nitb")) {
						//Número de Identificación ( Siempre debe diligenciarse )
						add_Attribute(atts, printLb, bp.getTaxID(), line_id, true);
					} else if (printLb.equals("nitm")) {
						add_Attribute(atts, printLb, bp2.getTaxID(), line_id, true);
					} else if (printLb.equals("dv")) {
						//Digito de Verificación ( Si se conoce debe diligenciarse)
						String dv = (String) bp.get_Value("TaxIdDigit");
						if (dv != null && dv.length() > 0)
							add_Attribute(atts, printLb, dv, line_id, false);
					} else if (printLb.equals("dvm")) {
						String dvm = (String) bp2.get_Value("TaxIdDigit");
						if (dvm != null && dvm.length() > 0)
							add_Attribute(atts, printLb, dvm, line_id, false);
					} else if (printLb.equals("apl1") || printLb.equals("pap")) {
						//Primer Apellido del informado
						//En caso de ser una Persona Natural siempre debe diligenciarse.
						if (isDetailedNames) {
							add_Attribute(atts, printLb, (String) bp.get_Value("LastName1"), line_id, isDetailedNames);
						}
					} else if (printLb.equals("apl1m")) {
						if (isDetailedNames2) {
							add_Attribute(atts, printLb, (String) bp2.get_Value("LastName1"), line_id, isDetailedNames2);
						}
					} else if (printLb.equals("apl2") || printLb.equals("sap")) {
						//Segundo Apellido del informado
						//En caso de ser una Persona Natural y si se conoce debe diligenciarse.
						if (isDetailedNames) {
							String aux = (String) bp.get_Value("LastName2");
							if (aux != null && aux.length() > 0)
								add_Attribute(atts, printLb, aux, line_id, false);
						}
					} else if (printLb.equals("apl2m")) {
						if (isDetailedNames2) {
							String aux = (String) bp2.get_Value("LastName2");
							if (aux != null && aux.length() > 0)
								add_Attribute(atts, printLb, aux, line_id, false);
						}
					} else if (printLb.equals("nom1") || printLb.equals("pno")) {
						//Primer Nombre del informado
						//En caso de ser una Persona Natural siempre debe diligenciarse.
						if (isDetailedNames) {
							add_Attribute(atts, printLb, (String) bp.get_Value("FirstName1"), line_id, isDetailedNames);
						}
					} else if (printLb.equals("nom1m")) {
						if (isDetailedNames2) {
							add_Attribute(atts, printLb, (String) bp2.get_Value("FirstName1"), line_id, isDetailedNames2);
						}
					} else if (printLb.equals("nom2") || printLb.equals("ono")) {
						//Otros Nombres del informado
						//En caso de ser una Persona Natural y si se conoce debe diligenciarse.
						if (isDetailedNames) {
							String aux = (String) bp.get_Value("FirstName2");
							if (aux != null && aux.length() > 0)
								add_Attribute(atts, printLb, aux, line_id, false);
						}
					} else if (printLb.equals("nom2m")) {
						if (isDetailedNames2) {
							String aux = (String) bp2.get_Value("FirstName2");
							if (aux != null && aux.length() > 0)
								add_Attribute(atts, printLb, aux, line_id, false);
						}
					} else if (printLb.equals("raz")) {
						//Razón Social del Informado
						//En caso de ser una Persona Jurídica siempre debe diligenciarse.
						if (!isDetailedNames) {
							add_Attribute(atts, printLb, bp.getName(), line_id, !isDetailedNames);
						}
					} else if (printLb.equals("razm")) {
						if (!isDetailedNames2) {
							add_Attribute(atts, printLb, bp2.getName(), line_id, !isDetailedNames2);
						}
					} else if (printLb.equals("email")) {
						//EMail del Informado
						if (isDetailedNames) {
							MUser[] user = MUser.getOfBPartner(getCtx(), bp.getC_BPartner_ID(), get_TrxName());
							if (user.length > 0) {
								add_Attribute(atts, printLb, user[0].getEMail(), line_id, false);
							}
						}
					} else if (printLb.equals("dir")) {
						//Dirección
						//En caso que el País de residencia sea Colombia siempre debe diligenciarse
						String dir = loc.getAddress1();
						if (isColombia)
							add_Attribute(atts, printLb, dir, line_id, isColombia);
					} else if (printLb.equals("dpto")) {
						//Código del Departamento
						//Código DANE Numérico, debe incluir los ceros a la izquierda. En caso que el País de residencia sea Colombia siempre debe diligenciarse
						if (isColombia)
							add_Attribute(atts, printLb, getDpto(loc.getC_Region_ID()), line_id, isColombia);
					} else if (printLb.equals("mun") || printLb.equals("mcpo")) {
						//Código del Municipio
						//Código DANE Numérico, debe incluir los ceros a la izquierda. En caso que el País de residencia sea Colombia siempre debe diligenciarse
						if (isColombia)
							add_Attribute(atts, printLb, getMun(loc.getC_City_ID()), line_id, true);
					} else if (printLb.equals("pais")) {
						//País de Residencia o domicilio
						//Siempre debe diligenciarse
						add_Attribute(atts, printLb, getPais(loc.getC_Country_ID()), line_id, true);
					} else {
						// Fin de las 13 columnas hardcoded
						// Label de una columna calculada
						int col = fieldFormat.getCalcColumnPosition();
						if (col < 1 || col > 20)
							throw new AdempiereUserError(label + " col not valid (" + col + ") in line " + line_id);
						BigDecimal amt = (BigDecimal) dssl.get_Value("FieldAmt"+col);
						if (amt == null)
							amt = Env.ZERO;
						// TODO: Aplicar fieldFormat.getFieldPrintFormat
						add_Attribute(atts, printLb, String.format("%.0f", amt), line_id, true);
					}
				}
				mmDoc.startElement("","",printLbDet,atts);
				mmDoc.endElement("","",printLbDet);
				atts.clear();
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, sqlschline , e);
			if (mmDocStream != null) {
				try {
					mmDocStream.close();
				} catch (Exception e2) {}
			}
			throw e;
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
		mmDoc.endElement("","","mas");
		mmDoc.endDocument();

		if (mmDocStream != null) {
			try {
				mmDocStream.close();
			} catch (Exception e2) {}
		}

		if (isAttachXML) {
			int  AD_Table_ID = MTable.getTable_ID(X_LCO_DIAN_XML_Header.Table_Name);
			//if one attach is found , it means that a xml file was attached before
			MAttachment attach =  MAttachment.get(getCtx(),AD_Table_ID,xmlheader.getLCO_DIAN_XML_Header_ID());
			//no se encontro archivo previo
			if (attach == null ) {
				attach = new  MAttachment(getCtx(),AD_Table_ID ,xmlheader.getLCO_DIAN_XML_Header_ID(),get_TrxName());
				attach.addEntry(new File (file_name));
				attach.saveEx();

			} else {
				// se encontro un archivo adjunto previamente
				//toma el index  del penultimo archivo y lo renombra
				//REVIEWME
				int index = (attach.getEntryCount()-1);
				MAttachmentEntry entry = attach.getEntry(index) ;
				String renamed = folder+File.separator+entry.getName().substring(0,entry.getName().length()-4 )+"_old_"+getDateTime()+ ".xml";
				entry.setName(renamed);
				attach.saveEx();
				//agrega el nuevo archivo ya q el anterior ha sido renombrado
				attach.addEntry(new File (file_name));
				attach.saveEx();
			}
			//DB.getSQLValue(get_TrxName(),"SELECT AD_Attachment_ID FROM AD_Attachment WHERE AD_Table_ID=? AND Record_ID=?",AD_Table_ID)
		}
		// MAttachment
		/*
		  Si IsAttachXML
	      Anexar el archivo XML al XML Header (probar con Archivador
		  a ver si funciona, si no con Attachment)
	      NOTA: ¿Que hacer si ya hay un archivo previo generado?
		  Verificar si el archivador es read-only, y si podria renombrar
		  un archivo previo generado para añadirle un sufijo _old_yyyymmdd
		 */

		return "@LCO_FileGenerated@ -> " + file_name;
	}

	private void add_Attribute(AttributesImpl atts, String label, String value, int line_id, boolean raiseErrorIfEmpty) throws Exception {
		if (value != null && value.length() > 0) {
			atts.addAttribute("", "", label, "CDATA", value);
		} else {
			if (raiseErrorIfEmpty)
				throw new AdempiereUserError(label + " field empty in line " + line_id);
			else
				atts.addAttribute("", "", label, "CDATA", "");
		}
	}

	private void addHeaderElement(TransformerHandler mmDoc, String att, String value, AttributesImpl atts) throws Exception {
		if (att != null) {
			mmDoc.startElement("","",att,atts);
			mmDoc.characters(value.toCharArray(),0,value.toCharArray().length);
			mmDoc.endElement("","",att);
		} else {
			throw new AdempiereUserError(att + " empty");
		}
	}

	/**
	 * Document type
	 * @param C_BPartner_ID
	 * @return lco_taxcodedian
	 */
	public String getTdoc(int C_BPartner_ID) {
		return DB.getSQLValueString(
				get_TrxName(),
				"SELECT LCO_TaxCodeDian FROM C_BPartner, LCO_TaxIdType "
				+ "WHERE C_bpartner.lco_taxidtype_id = lco_taxidtype.lco_taxidtype_id AND "
				+ "C_bpartner.C_bpartner_ID= ?",
				C_BPartner_ID);
	}

	/**
	 * Get DIAN code from C_Region_ID
	 * @param C_Location_ID
	 * @return Dane Code for C_Region_ID
	 */
	public String getDpto(int C_Region_ID) {
		return MLCOConversion.getConvertedCode(getCtx(), "C_Region","C_Region_ID", "DIAN_Region", "" + C_Region_ID, get_TrxName());
	}

	/**
	 * Get DIAN code from C_City_ID
	 * @param C_Location_ID
	 * @return Dane Code for C_City_ID
	 */
	public String getMun(int C_City_ID) {
		return MLCOConversion.getConvertedCode(getCtx(), "C_City","C_City_ID", "DIAN_City", "" + C_City_ID, get_TrxName());
	}

	/**
	 * Get DIAN code from C_Country_ID
	 * @param C_Location_ID
	 * @return Dane Code for C_Country_ID
	 */
	public String getPais(int C_Country_ID) {
		return MLCOConversion.getConvertedCode(getCtx(), "C_Country","C_Country_ID", "DIAN_Country", "" + C_Country_ID, get_TrxName());
	}

	/**
	 * Get Current date in format yyyy/MM/dd HH:mm:ss
	 * @return Date
	 */
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

} // LCO_DianExportXML
