package com.Linw.LinwDocument.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Linw.LinwDocument.DB.DBConnection;
import com.Linw.LinwDocument.Service.ClientService;
import com.Linw.LinwDocument.model.Box;
import com.Linw.LinwDocument.model.Client;

import static com.Linw.LinwDocument.DB.DataBase.*;

/**
 * @author La falsa Mac
 *
 */
public class BoxDao {

	public static void newBox(Box box) {

		DBConnection dbConnection = new DBConnection();
		try (Connection connection = dbConnection.getConnection()){
			PreparedStatement ps = null;
			try {
				String query = "INSERT INTO box (" + TBOX_LABEL +", " + TBOX_CLIENT + ") VALUES (?, ?)";
				ps = connection.prepareStatement(query);
				ps.setString(1, box.getLabel());
				ps.setString(2, box.getClient().getCuit());
				ps.executeUpdate();
				
				System.out.println("Se ha cargado la caja a la base de datos");
			
			}catch (java.sql.SQLIntegrityConstraintViolationException e) {
				System.out.println("Ya existe una Caja con la misma etiqueta");
			}catch (Exception e) {
				System.out.println(e);
			}
			
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	public static ArrayList <Box> read (){
		
		ArrayList <Box> boxes = new ArrayList <Box>();
		DBConnection dbConnection = new DBConnection();
		try (Connection connection = dbConnection.getConnection()){
			String query = "Select * FROM " + TBOX;
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Box box = new Box();
				Client client = ClientService.findClient(rs.getString(TBOX_CLIENT));
				box.setClient(client);
				box.setLabel(rs.getString(TBOX_LABEL));
				box.setEntry(rs.getString(TBOX_ENTRY));
				boxes.add(box);
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return boxes;
	}

	public static ArrayList <Box> readFromClient (String cuit){
		
		ArrayList <Box> boxes = new ArrayList <Box>();
		DBConnection dbConnection = new DBConnection();
		try (Connection connection = dbConnection.getConnection()){
			String query = "SELECT * FROM " + TBOX + " WHERE " + TBOX_CLIENT + " = " + cuit;
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Box box = new Box();
				Client client = ClientService.findClient(rs.getString(TBOX_CLIENT));
				box.setClient(client);
				box.setLabel(rs.getString(TBOX_LABEL));
				box.setEntry(rs.getString(TBOX_ENTRY));
				boxes.add(box);
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return boxes;
	}
	
	public static void deleteBox(String label) {
		
		DBConnection dbConnection = new DBConnection();
		try (Connection connection = dbConnection.getConnection()){
			String query = "DELETE FROM " + TBOX + " WHERE " + TBOX + "." + TBOX_LABEL + " = \'" + label + "\'";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate(query);
			System.out.println("La caja fue eliminada");
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	public static Box read (String label) {
		
		Box box = new Box ();
		DBConnection dbConnection = new DBConnection();
		try (Connection connection = dbConnection.getConnection()){
			String query = "SELECT * FROM " + TBOX + " WHERE " + TBOX_LABEL + " = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, label);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Client client = ClientService.findClient(rs.getString(TBOX_CLIENT));
			box.setClient(client);
			box.setLabel(rs.getString(TBOX_LABEL));
			box.setEntry(rs.getString(TBOX_ENTRY));
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		
		return box;
	}
}
