/**
 * 
 */
package com.Linw.LinwDocument.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.Linw.LinwDocument.DB.DataBase.*;

/**
 * @author AguusHeredia
 *
 */
public class DBConnection {

	public Connection getConnection () {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			if (connection != null) {
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return connection;
		
	}
}
