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

public class Eskaera extends gestorDB {
    private int id_eskaera;
    private int id_bezeroa;
    private int id_langilea;
    private int id_faktura;
    private Date date;
    private Date arriveDate;
    private double price;
    private double discount;
    private double finalPrice;
    private String address;
    private boolean online;
    private String payMethod;
    private String creditNumber;
    private String status;
    private String clientName;
    private String workerName;

    public Eskaera(int id_eskaera, int id_bezeroa, int id_langilea, int id_faktura, Date date, Date arriveDate, double price, double discount, double finalPrice, String address, boolean online, String payMethod, String creditNumber, String status) throws IOException {
        super();
        this.id_eskaera = id_eskaera;
        this.id_bezeroa = id_bezeroa;
        this.id_langilea = id_langilea;
        this.id_faktura = id_faktura;
        this.date = date;
        this.arriveDate = arriveDate;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.address = address;
        this.online = online;
        this.payMethod = payMethod;
        this.creditNumber = creditNumber;
        this.status = status;
        this.setNames();

    }

    public void setNames(){
        try{
            String query = "SELECT izena from bezeroak where id_bezeroa = ?";
            PreparedStatement statement = connect().prepareStatement(query);
            statement.setInt(1,this.id_bezeroa);
            ResultSet clientNameSet = statement.executeQuery();
            while (clientNameSet.next()){
                this.clientName = clientNameSet.getString("izena");
            }

            String query2 = "SELECT izena from langileak where id_langilea = ?";
            PreparedStatement statement2 = connect().prepareStatement(query2);
            statement2.setInt(1,this.id_langilea);
            ResultSet workerNameSet = statement2.executeQuery();
            while (workerNameSet.next()){
                this.workerName = workerNameSet.getString("izena");
            }
            statement.close();
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

    public int getId_bezeroa() {
        return id_bezeroa;
    }

    public int getId_langilea() {
        return id_langilea;
    }

    public int getId_faktura() {
        return id_faktura;
    }

    public Date getDate() {
        return date;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public String getAddress() {
        return address;
    }

    public boolean isOnline() {
        return online;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getClientName() {
        return clientName;
    }
    public String getWorkerName() {
        return workerName;
    }

}
