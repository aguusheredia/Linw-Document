/**
 * 
 */
package com.Linw.LinwDocument.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author AguusHeredia
 *
 */
public class DBConnection {

	public Connection getConnection () {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LaSantafesi", "root", "");
			if (connection != null) {
				System.out.println("Connection sucesfull");
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return connection;
		
	}
}
