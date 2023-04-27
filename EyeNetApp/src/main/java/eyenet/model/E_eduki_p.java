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

// BARNEKO ESKAERAK EDUKI PRODUKTUAK
public class E_eduki_p extends gestorDB {
    private int id_eskaera;
    private int id_produktua;
    private String productName;
    private int id_hornitzailea;
    private String providerName;
    private int kopurua;
    public E_eduki_p(int id_eskaera, int id_produktua, int id_hornitzailea, int kopurua) throws IOException {
        super();
        this.id_eskaera = id_eskaera;
        this.id_produktua = id_produktua;
        this.id_hornitzailea = id_hornitzailea;
        this.kopurua = kopurua;
        this.setNames();
    }
    public void setNames(){
        try {
            String query1 = "SELECT izena FROM produktuak WHERE id_produktua = ?";
            PreparedStatement statement1 = connect().prepareStatement(query1);
            statement1.setInt(1,this.id_produktua);
            ResultSet productNameSet = statement1.executeQuery();
            while (productNameSet.next()){
                this.productName = productNameSet.getString("izena");
            }

            String query2 = "SELECT izena FROM hornitzaileak WHERE id_hornitzailea = ?";
            PreparedStatement statement2 = connect().prepareStatement(query2);
            statement2.setInt(1,this.id_hornitzailea);
            ResultSet providerNameSet = statement2.executeQuery();
            while (providerNameSet.next()){
                this.providerName = providerNameSet.getString("izena");
            }

            statement1.close();
            statement2.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int getId_eskaera() {
        return id_eskaera;
    }

    public int getId_produktua() {
        return id_produktua;
    }

    public String getProductName() {
        return productName;
    }

    public int getId_hornitzailea() {
        return id_hornitzailea;
    }

    public String getProviderName() {
        return providerName;
    }

    public int getKopurua() {
        return kopurua;
    }

}
