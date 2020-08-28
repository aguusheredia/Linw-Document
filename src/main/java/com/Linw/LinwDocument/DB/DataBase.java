/**
 * 
 */
package com.Linw.LinwDocument.DB;

/**
 * @author AguusHeredia
 *
 */
public class DataBase {
	
	public static final String URL = "jdbc:mysql://localhost/Linw_Document?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	
	public static final String TCLIENT = "client";
	public static final String TCLIENT_CUIT = "cuit";
	public static final String TCLIENT_NAME = "name";
	
	public static final String TBOX = "box";
	public static final String TBOX_LABEL = "label";
	public static final String TBOX_CLIENT = "client";
	public static final String TBOX_UBICATION = "ubication";
	public static final String TBOX_ENTRY = "entry";
	
	public static final String TDOCUMENT = "document";
	public static final String TDOCUMENT_ID = "id";
	public static final String TDOCUMENT_TIPE = "tipe";
	public static final String TDOCUMENT_PAGES = "pages";
	public static final String TDOCUMENT_BOX = "box";
}
