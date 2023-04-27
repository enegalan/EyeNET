/*
 * Copyright (c) 2023.
 */

package eyenet.model;

import eyenet.controller.gestorDB;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

public class Langilea extends gestorDB {
    private int id_langilea;
    private int id_rol;
    private int id_user;
    private String izena;
    private String abizenak;
    private Date jaiotze_data;
    private String sexua;
    private double soldata;
    private String email;
    private Date kontratu_data;
    private String mota;
    private String username;
    private String password;
    public int getId_langilea() {
        return id_langilea;
    }

    public int getId_rol() {
        return id_rol;
    }

    public int getId_user() {
        return id_user;
    }

    public String getIzena() {
        return izena;
    }

    public String getAbizenak() {
        return abizenak;
    }

    public Date getJaiotze_data() {
        return jaiotze_data;
    }

    public String getSexua() {
        return sexua;
    }

    public double getSoldata() {
        return soldata;
    }

    public String getEmail() {
        return email;
    }

    public Date getKontratu_data() {
        return kontratu_data;
    }

    public String getMota() {
        return mota;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Langilea(int id_langilea, int id_rol, int id_user, String username, String password, String izena, String abizenak, Date jaiotze_data, String sexua, double soldata, String email, Date kontratu_data, String mota) throws IOException {
        super();
        this.id_langilea = id_langilea;
        this.id_rol = id_rol;
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.izena = izena;
        this.abizenak = abizenak;
        this.jaiotze_data = jaiotze_data;
        this.sexua = sexua;
        this.soldata = soldata;
        this.email = email;
        this.kontratu_data = kontratu_data;
        this.mota = mota;
    }

}
