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
	
	static ArrayList <Client> clients = new ArrayList <Client>();
	
	public void loadClients () {
		clients = ClientDao.read();
	}

	public void printClients () {
		
		for (Client c: this.clients) {
			StringBuilder sb = new StringBuilder ();
			sb.append("Nombre: ").append(c.getName()).append("\n");
			sb.append("Cuil: ").append(c.getCuil()).append("\n");
		}
	}
}
