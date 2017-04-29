package com.grailsbrains.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManage {
	
	private static String url = "jdbc:mysql://localhost:3306/purchase_order";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "root";
    private static Connection con;
    
    //creating static method for connection
    public static Connection getConnection() throws InstantiationException, IllegalAccessException {
    	//loading a driver
        try {
            Class.forName(driverName).newInstance();
            System.out.println("driver loaded");
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
           ex.getMessage();
            System.out.println("Driver not found. " + ex.getMessage()); 
        }
        return con;
    }
}
