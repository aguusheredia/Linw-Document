/**
 * 
 */
package com.Linw.LinwDocument.Service;

import java.util.ArrayList;
import java.util.Scanner;

import com.Linw.LinwDocument.DAO.BoxDao;
import com.Linw.LinwDocument.model.Box;
import com.Linw.LinwDocument.model.Client;

/**
 * @author AguusHeredia
 *
 */
public class BoxService {

	public static void newBox () {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Seleccione el cliente de la caja");
		String cuit = scan.nextLine();
		
		Box box = new Box ();
		Client client = ClientService.findClient(cuit);
		box.setClient(client);
		String label = client.getLabel() + "-" + (ClientService.ClientBoxes(cuit) + 1);
		box.setLabel(label);
		
		BoxDao.newBox (box);
	}

	public static void deleteBox() {
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Ingrese la etiqueta de la caja a eliminar");
		String label = scan.nextLine();
		
		BoxDao.deleteBox(label);
	}
	
	public static Box findBox() {

		Box box;
		Scanner scan = new Scanner (System.in);
		System.out.println("Ingrese la etiqueta de la caja a eliminar");
		String label = scan.nextLine();
		
		box = BoxDao.read(label);
		return box;
	}
	
	public static void printBoxesClient () {

		ArrayList <Box> boxes = new ArrayList <Box>();
		Scanner scan = new Scanner (System.in);
		System.out.println("Ingrese el cuit de la empresa");
		String cuit = scan.nextLine();
		
		boxes = BoxDao.readFromClient(cuit);
		for (Box box : boxes) {
			System.out.println(box.toString());
		}
	}
}
