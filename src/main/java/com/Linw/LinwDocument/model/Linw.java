/**
 * 
 */
package com.Linw.LinwDocument.model;

import java.util.ArrayList;

import com.Linw.LinwDocument.DAO.BoxDao;
import com.Linw.LinwDocument.DAO.ClientDao;

/**
 * @author AguusHeredia
 *
 */
public class Linw {
	
	public ArrayList <Client> clients = new ArrayList <Client>();
	public ArrayList <Box> boxes = new ArrayList <Box>();
	
	public void loadClients () {
		clients = ClientDao.read();
	}
	
	public void loadBoxes () {
		boxes = BoxDao.read();
	}

	public void printClients () {
		
		StringBuilder sb = new StringBuilder ("Clientes:");
		sb.append("\n");
		for (Client c: this.clients) {
			sb.append(c.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public void printBoxes () {
		
		StringBuilder sb = new StringBuilder();
		for (Box b: this.boxes) {
			sb.append(b.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
