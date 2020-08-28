/**
 * 
 */
package com.Linw.LinwDocument.model;

import java.util.ArrayList;

import com.Linw.LinwDocument.DAO.ClientDao;

/**
 * @author AguusHeredia
 *
 */
public class Linw {
	
	public ArrayList <Client> clients = new ArrayList <Client>();
	
	public void loadClients () {
		clients = ClientDao.read();
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
}
