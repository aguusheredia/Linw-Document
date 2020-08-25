package com.Linw.LinwDocument;

import java.sql.Connection;

import com.Linw.LinwDocument.Service.DBConnection;

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
        	
        }catch (Exception e) {
        	System.out.println(e);
        }
    }
}

