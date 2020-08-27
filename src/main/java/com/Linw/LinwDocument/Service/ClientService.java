/**
 * 
 */
package com.Linw.LinwDocument.Service;

import java.util.Scanner;

import com.Linw.LinwDocument.DAO.ClientDao;
import com.Linw.LinwDocument.model.Client;

/**
 * @author AguusHeredia
 *
 */
public class ClientService {

	public static void newClient () {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Indique su numero de cuil");
		String cuil = scan.nextLine();
		
		System.out.println("Indique el nombre de la empresa");
		String name = scan.nextLine();
		
		Client client = new Client ();
		client.setCuil(cuil);
		client.setName(name);
		
		ClientDao.newClientDB(client);
	}
	
	public static void deleteClient () {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Indique su numero de cuil");
		String cuil = scan.nextLine();
		ClientDao.deleteClient(cuil);
	}
}
