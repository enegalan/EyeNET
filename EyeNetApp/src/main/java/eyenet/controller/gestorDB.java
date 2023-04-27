/*
 * Copyright (c) 2023.
 */

package eyenet.controller;


import eyenet.model.Session;
import oracle.jdbc.driver.OracleDriver;
//import oracle.jdbc.driver.OracleDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public abstract class gestorDB {
    private static Connection conexion;

    static {
        try {
            conexion = connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUrl() {
        return url;
    }

    private static String url;
    public static void setUrl(String url2){
        url = url2;
    }

    static {
        try {
            url = readURL();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Session session;

    protected gestorDB() throws IOException {
    }

    public static synchronized Connection connect() throws IOException {
        final String url="jdbc:oracle:thin:@10.14.0.70:1521:orcl";
        //final String url="jdbc:mysql://localhost:3306/test";
        //final String user = "root";
        final String user = "C##eneko";
        //final String pass = "";
        final String pass = "1";
        try{
            System.out.println("Connecting...");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new OracleDriver());
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conexion = DriverManager.getConnection(url,user,pass);
            System.out.println("Connection success");

        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conexion;
    }
    public void disconnect(){
        try{
            if(conexion != null){
                System.out.println("Disconnecting...");
                conexion.close();
            }
        }catch (SQLException ex){
            ex.getSQLState();
        }
    }
    public static Connection getConexion() {
        return conexion;
    }
    public static synchronized String readURL() throws IOException {
        String[] url2 = null;
        StringBuilder content = new StringBuilder();
        BufferedReader lector = new BufferedReader(new FileReader("src/main/java/eyenet/config/config.csv"));
        String linea = "";
        while ((linea = lector.readLine()) != null) {
            content.append(linea);
            content.append("\n");
        }
        lector.close();
        url2 = content.toString().split("=");
        System.out.println(url2[1].toString());
        return url2[1].toString();

    }
}