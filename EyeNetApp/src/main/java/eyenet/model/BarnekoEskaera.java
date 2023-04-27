/*
 * Copyright (c) 2023.
 */

package eyenet.model;

import eyenet.controller.gestorDB;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BarnekoEskaera extends gestorDB {
    private int id_eskaera;
    private int id_langilea;
    private String workerName;
    private Date date;
    private double totalPrice;
    public BarnekoEskaera(int id_eskaera, int id_langilea, Date date, double totalPrice) throws IOException {
        super();
        this.id_eskaera = id_eskaera;
        this.id_langilea = id_langilea;
        this.date = date;
        this.totalPrice = totalPrice;
        this.setWorkerName();
    }

    public int getId_eskaera() {
        return id_eskaera;
    }

    public int getId_langilea() {
        return id_langilea;
    }

    public String getWorkerName() {
        return workerName;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setWorkerName(){
        try{
            String query = "SELECT izena from langileak where id_langilea = ?";
            PreparedStatement statement = connect().prepareStatement(query);
            statement.setInt(1,this.id_langilea);
            ResultSet workerNameSet = statement.executeQuery();
            while (workerNameSet.next()){
                this.workerName = workerNameSet.getString("izena");
            }
            statement.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
