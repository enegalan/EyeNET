/*
 * Copyright (c) 2023.
 */

package eyenet.model;

import eyenet.controller.gestorDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produktua extends gestorDB {
    private int id_produktua;
    private int id_hornitzailea;
    private String providerName;
    private String izena;
    private String deskribapena;
    private double prezioa;
    private int stock;
    public Produktua(int id_produktua, int id_hornitzailea, String izena, String deskribapena, double prezioa, int stock) throws IOException {
        super();
        this.id_produktua = id_produktua;
        this.id_hornitzailea = id_hornitzailea;
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.prezioa = prezioa;
        this.stock = stock;
        this.setProviderName();
    }
    public int getId_produktua() {
        return id_produktua;
    }

    public int getId_hornitzailea() {
        return id_hornitzailea;
    }

    public String getIzena() {
        return izena;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public double getPrezioa() {
        return prezioa;
    }

    public int getStock() {
        return stock;
    }
    public void setProviderName(){
        try{
            String query = "SELECT izena from hornitzaileak where id_hornitzailea = ?";
            PreparedStatement statement = connect().prepareStatement(query);
            statement.setInt(1,this.id_hornitzailea);
            ResultSet providerNameSet = statement.executeQuery();
            while (providerNameSet.next()){
                this.providerName = providerNameSet.getString("izena");
            }
            statement.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getProviderName(){
        return this.providerName;
    }
}
