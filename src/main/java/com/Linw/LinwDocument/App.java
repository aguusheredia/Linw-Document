package com.Linw.LinwDocument;

import java.sql.Connection;
import java.util.Scanner;

import com.Linw.LinwDocument.DAO.ClientDao;
import com.Linw.LinwDocument.DB.DBConnection;
import com.Linw.LinwDocument.Service.BoxService;
import com.Linw.LinwDocument.Service.ClientService;
import com.Linw.LinwDocument.model.Linw;

/**
 * @author AguusHeredia
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DBConnection connection = new DBConnection();	
        
        try (Connection cnx = connection.getConnection()){
        	
        	Linw linw = new Linw();
        	
        	menu(linw);
        	
//        	
        	
        }catch (Exception e) {
        	System.out.println(e);
        }
    }
    
    public static void menu (Linw linw) {
    	
    	printMenu();
    	Scanner scan = new Scanner (System.in);
    	int i = scan.nextInt();
    	
    	switch (i) {
    		case 1:
    			clientMenu(linw);
    			break;
    		case 2:
    			boxMenu(linw);
    			break;
    		default:
    			System.out.println("Opción incorrecta");
    			printMenu();
    			break;
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
    	case 5:
    		BoxService.printBoxesClient();
    		break;
    	default:
    		System.out.println("Opcion incorrecta");
    		printClientMenu();
    		break;
    	}
    }
    
    public static void boxMenu(Linw linw) {
    	
    	printBoxMenu();
    	Scanner scan = new Scanner (System.in);
    	int i = scan.nextInt();
    	
    	switch(i) {
    		case 1:
    			BoxService.newBox();
    			break;
    		case 2:
    			BoxService.deleteBox();
    			break;
    		case 3:
    			linw.loadBoxes();
    			linw.printBoxes();
    			break;
    		case 4:
    			System.out.println(BoxService.findBox());
    			break;
    		default:
    			System.out.println("Opcion incorrecta");
        		printBoxMenu();
        		break;
    	}
    }
    
    public static void printMenu () {
    	StringBuilder sb = new StringBuilder ();
    	sb.append("Bienvenido a Linw-Document").append("\n");
    	sb.append("Elija una opción").append("\n");
    	sb.append("1. Menú de clientes").append("\n");
    	sb.append("2. Menú de cajas").append("\n");
    	System.out.println(sb.toString());
    }
    
    public static void printClientMenu () {
    	StringBuilder sb = new StringBuilder ();
    	sb.append("Elija una opción").append("\n").append("\n");
    	sb.append("1. Agregar un nuevo cliente").append("\n");
    	sb.append("2. Eleminar un cliente").append("\n");
    	sb.append("3. Ver listas de clientes").append("\n");
    	sb.append("4. Buscar cliente por cuil").append("\n");;
    	sb.append("5. Cajas por cliente").append("\n");
    	System.out.println(sb.toString());
    }
    
    public static void printBoxMenu () {
    	StringBuilder sb = new StringBuilder ();
    	sb.append("Elija una opción").append("\n").append("\n");
    	sb.append("1. Agregar caja").append("\n");
    	sb.append("2. Eliminar caja").append("\n");
    	sb.append("3. Ver lista de cajas").append("\n");
    	sb.append("4. Buscar caja").append("\n");
    	System.out.println(sb.toString());
    }
}

