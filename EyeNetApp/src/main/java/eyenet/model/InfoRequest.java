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
import java.util.Date;

public class InfoRequest extends gestorDB {
    private int id_eskaera;
    private int id_langilea;
    private int id_admin;
    private String mezua;
    private Date data;
    private String erantzuna;
    private String aldaketa;
    private String egoera;
    private String mota;
    public InfoRequest(int id_eskaera, int id_langilea, int id_admin, String mezua, Date data, String erantzuna, String aldaketa, String egoera, String mota) throws IOException {
        super();
        this.id_eskaera = id_eskaera;
        this.id_langilea = id_langilea;
        this.id_admin = id_admin;
        this.mezua = mezua;
        this.data = data;
        this.erantzuna = erantzuna;
        this.aldaketa = aldaketa;
        this.egoera = egoera;
        this.mota = mota;
    }
    public int getId_eskaera() {
        return id_eskaera;
    }

    public int getId_langilea() {
        return id_langilea;
    }

    public int getId_admin() {
        return id_admin;
    }

    public String getMezua() {
        return mezua;
    }

    public Date getData() {
        return data;
    }

    public String getErantzuna() {
        return erantzuna;
    }

    public String getAldaketa() {
        return aldaketa;
    }

    public String getEgoera() {
        return egoera;
    }

    public String getMota() {
        return mota;
    }
    public String getWorkerUsername(){
        String username = null;
        try{
            String query = "SELECT username from langileak where id_langilea in (SELECT id_langilea from info_eskaerak where id_eskaera = ?)";
            PreparedStatement statement = connect().prepareStatement(query);
            statement.setInt(1,this.id_eskaera);
            ResultSet workerUsernameSet = statement.executeQuery();
            while (workerUsernameSet.next()){
                username = workerUsernameSet.getString("username");
            }
            statement.close();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return username;
    }
    public String getAdminUsername(){
        String username = null;
        try{
            String query = "SELECT username from langileak where id_langilea in (SELECT id_admin from info_eskaerak where id_eskaera = ?)";
            PreparedStatement statement = connect().prepareStatement(query);
            statement.setInt(1,this.id_eskaera);
            ResultSet workerUsernameSet = statement.executeQuery();
            while (workerUsernameSet.next()){
                username = workerUsernameSet.getString("username");
            }
            statement.close();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return username;
    }
}
