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
		
		String cuit = "";
		String name = "";
		
		System.out.println("Indique su numero de cuil");
		cuit = scan.nextLine();
		
		System.out.println("Indique el nombre de la empresa");
		name = scan.nextLine();
		
		while (!(name.length() > 0)) {
			System.out.println("La empresa debe tener un nombre");
			System.out.println("Indique el nombre de la empresa");
			name = scan.nextLine();
		}
		
		while (!cuit.matches("^[0-9]{11}$")) {
			System.out.println("El numero de cuil debe estar compuesto por 11 numeros");
			System.out.println("Indique su numero de cuil");
			cuit = scan.nextLine();
		}
		
		Client client = new Client ();
		client.setCuit(cuit);
		client.setName(name);
		
		ClientDao.newClientDB(client);
	}
	
	public static void deleteClient () {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Indique su numero de cuil");
		String cuit = scan.nextLine();
		
		while (!cuit.matches("^[0-9]{11}$")) {
			System.out.println("El numero de cuil debe estar compuesto por 11 numeros");
			System.out.println("Indique su numero de cuil");
			cuit = scan.nextLine();
		}
		
		ClientDao.deleteClient(cuit);
	}
	
	public static void findClient () {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Indique su numero de cuil");
		String cuit = scan.nextLine();
		
		while (!cuit.matches("^[0-9]{11}$")) {
			System.out.println("El numero de cuil debe estar compuesto por 11 numeros");
			System.out.println("Indique su numero de cuil");
			cuit = scan.nextLine();
		}
		
		Client client = ClientDao.read(cuit);
		System.out.println(client.toString());
	}
}
