/*
 * Copyright (c) 2023.
 */

package eyenet.model;

import eyenet.controller.gestorDB;

import java.io.IOException;
import java.sql.*;

public class Nomina extends gestorDB {
    private int id_nomina;
    private int id_langilea;
    private int id_giza;
    private String workerName;
    private String humanRscName;
    private int egun_kopurua;
    private Date data;
    private int PFEZ;
    private double soldata_gordina;
    private double soldata_garbia;
    private String banku_kontua;
    private int ezinbesteko_orduak;
    private int ordu_extrak;
    public Nomina( int id_nomina, int id_langilea, int id_giza, int egun_kopurua, Date data, int PFEZ, double soldata_gordina, double soldata_garbia, String banku_kontua, int ezinbesteko_orduak, int ordu_extrak) throws IOException {
        super();
        this.id_nomina = id_nomina;
        this.id_langilea = id_langilea;
        this.id_giza = id_giza;
        this.egun_kopurua = egun_kopurua;
        this.data = data;
        this.PFEZ = PFEZ;
        this.soldata_gordina = soldata_gordina;
        this.soldata_garbia = soldata_garbia;
        this.banku_kontua = banku_kontua;
        this.ezinbesteko_orduak = ezinbesteko_orduak;
        this.ordu_extrak = ordu_extrak;
        this.setNames();
    }

    public int getId_nomina() {
        return id_nomina;
    }

    public int getId_langilea() {
        return id_langilea;
    }

    public int getId_giza() {
        return id_giza;
    }

    public int getEgun_kopurua() {
        return egun_kopurua;
    }

    public Date getData() {
        return data;
    }

    public int getPFEZ() {
        return PFEZ;
    }

    public double getSoldata_gordina() {
        return soldata_gordina;
    }

    public double getSoldata_garbia() {
        return soldata_garbia;
    }

    public String getBanku_kontua() {
        return banku_kontua;
    }

    public int getEzinbesteko_orduak() {
        return ezinbesteko_orduak;
    }

    public int getOrdu_extrak() {
        return ordu_extrak;
    }
    public void setNames(){
        try{
            String query1 = "SELECT izena FROM langileak where id_langilea = ?";
            PreparedStatement statement1 = connect().prepareStatement(query1);
            statement1.setInt(1,this.id_langilea);
            ResultSet workerNameSet = statement1.executeQuery();
            while (workerNameSet.next()){
                this.workerName = workerNameSet.getString("izena");
            }


            String query2 = "SELECT izena from langileak where id_langilea = ?";
            PreparedStatement statement2 = connect().prepareStatement(query2);
            statement2.setInt(1,this.id_giza);
            ResultSet humanRscSet = statement2.executeQuery();
            while (humanRscSet.next()){
                this.humanRscName = humanRscSet.getString("izena");
            }
            statement1.close();
            statement2.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getWorkerName() {
        return workerName;
    }

    public String getHumanRscName() {
        return humanRscName;
    }

}
