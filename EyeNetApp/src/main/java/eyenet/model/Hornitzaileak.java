package eyenet.model;

import eyenet.controller.gestorDB;

import java.io.IOException;

public class Hornitzaileak extends gestorDB {
    private int id_hornitzailea;
    private String izena;
    private String helbidea;
    private String kontaktua;

    public Hornitzaileak(String izena, String helbidea, String kontaktua) throws IOException {
        super();
        this.izena = izena;
        this.helbidea = helbidea;
        this.kontaktua = kontaktua;
    }

    public int getId_hornitzailea() {
        return id_hornitzailea;
    }

    public String getIzena() {
        return izena;
    }

    public String getHelbidea() {
        return helbidea;
    }

    public String getKontaktua() {
        return kontaktua;
    }

    public void setId_hornitzailea(int id_hornitzailea) {
        this.id_hornitzailea = id_hornitzailea;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }

    public void setKontaktua(String kontaktua) {
        this.kontaktua = kontaktua;
    }
}



