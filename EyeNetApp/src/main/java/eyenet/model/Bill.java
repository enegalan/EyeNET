/*
 * Copyright (c) 2023.
 */

package eyenet.model;

import eyenet.controller.gestorDB;

import java.io.IOException;
import java.sql.Date;

public class Bill extends gestorDB {
    private int id_faktura;
    private Date data;
    private double total;
    public Bill(int id_faktura, Date data, double total) throws IOException {
        super();
        this.id_faktura = id_faktura;
        this.data = data;
        this.total = total;
    }
    public int getId_faktura() {
        return id_faktura;
    }

    public Date getData() {
        return data;
    }

    public double getTotal() {
        return total;
    }

}
