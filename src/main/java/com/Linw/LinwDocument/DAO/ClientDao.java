
package com.Linw.LinwDocument.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Linw.LinwDocument.DB.DBConnection;
import com.Linw.LinwDocument.model.Client;
import static com.Linw.LinwDocument.DB.DataBase.*;

/**
 * @author AguusHeredia
 *
 */
public class ClientDao {

	public static void newClientDB(Client client) {

		DBConnection dbConnection = new DBConnection();
		
		try (Connection connection = dbConnection.getConnection()){
			PreparedStatement ps = null;
			try {
				String query = "INSERT INTO client (" + TCLIENT_CUIL +", " +TCLIENT_NAME+ ") VALUES (?, ?)";
				ps = connection.prepareStatement(query);
				ps.setString(1, client.getCuil());
				ps.setString(2, client.getName());
				ps.executeUpdate();
				
				System.out.println("Se ha cargado el nuevo cliente a la base de datos");
				
			}catch (Exception e) {
				System.out.println(e);
			}
			
			
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<Client> read() {
			
		ArrayList<Client> clients = new ArrayList<Client>();
		DBConnection dbConnection = new DBConnection();
		try (Connection connection = dbConnection.getConnection()){
			String query = "SELECT * FROM " + TCLIENT;
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Client client = new Client ();
				client.setCuil(rs.getString(TCLIENT_CUIL));
				client.setName(rs.getString(TCLIENT_NAME));
				clients.add(client);
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return clients;
	}

	public static void deleteClient(String cuil) {
		
		DBConnection dbConnection = new DBConnection();
		try (Connection connection = dbConnection.getConnection()){
			String query = "DELETE FROM " + TCLIENT + " WHERE " + TCLIENT + "." + TCLIENT_CUIL + " = \'" + cuil + "\'";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate(query);
			System.out.println("El cliente fue eliminado");
			
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
}
