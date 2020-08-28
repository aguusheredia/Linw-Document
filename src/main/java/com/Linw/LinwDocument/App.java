package com.Linw.LinwDocument;

import java.sql.Connection;
import java.util.Scanner;

import com.Linw.LinwDocument.DB.DBConnection;
import com.Linw.LinwDocument.Service.ClientService;
import com.Linw.LinwDocument.model.Client;
import com.Linw.LinwDocument.model.Linw;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DBConnection connection = new DBConnection();	
        
        try (Connection cnx = connection.getConnection()){
        	
        	Linw linw = new Linw();
        	clientMenu(linw);
        	
//        	
        	
        }catch (Exception e) {
        	System.out.println(e);
        }
    }
    
    public static void clientMenu (Linw linw) {

    	printClientMenu();
    	Scanner scan = new Scanner (System.in);
    	int i = scan.nextInt();
    	
    	switch(i) {
    	case 1:
    		ClientService.newClient();
    		break;
    	case 2:
    		ClientService.deleteClient();
    		break;
    	case 3:
    		linw.loadClients();
    		linw.printClients();
    		break;
    	case 4:
    		ClientService.findClient();
    		break;
    	default:
    		System.out.println("Opcion incorrecta");
    		printClientMenu();
    		break;
    	}
    }
    
    public static void printClientMenu () {
    	StringBuilder sb = new StringBuilder ();
    	sb.append("Bienvenido a LinwDocument").append("\n").append("\n");
    	sb.append("Elija una opción").append("\n").append("\n");
    	sb.append("1. Agregar un nuevo cliente").append("\n");
    	sb.append("2. Eleminar un cliente").append("\n");
    	sb.append("3. Ver listas de clientes").append("\n");
    	sb.append("4. Buscar cliente por cuil");
    	System.out.println(sb.toString());
    }
}

