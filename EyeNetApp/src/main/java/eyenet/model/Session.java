/*
 * Copyright (c) 2023.
 */

package eyenet.model;

import eyenet.controller.gestorDB;

import java.io.IOException;
import java.time.chrono.Era;

public class Session extends gestorDB {
    private Erabiltzailea user;
    private static Session session;
    public Session(Erabiltzailea user) throws IOException {
        super();
        this.user = user;
    }

    public Erabiltzailea getUser() {
        return user;
    }
    public static Session getSession() {
        return session;
    }



}
