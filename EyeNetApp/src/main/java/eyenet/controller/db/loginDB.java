/*
 * Copyright (c) 2023.
 */

package eyenet.controller.db;

import eyenet.controller.gestorDB;
import eyenet.model.Erabiltzailea;
import eyenet.model.Session;
import eyenet.view.dashboard;
import eyenet.view.login;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDB extends gestorDB {
    private Connection conexion;
    private String username, password;
    private JPanel mainPanel;
    public loginDB() throws IOException {
        super();
        try {
            this.conexion = connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public loginDB(JPanel mainPanel, String username, char[] password, String url) throws IOException {
        super();
        try {
            setUrl(url);
            this.conexion = connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.username = username;
        this.password = new String(password);
        this.mainPanel = mainPanel;
    }
    public loginDB(JPanel mainPanel) throws IOException {
        super();
        this.mainPanel = mainPanel;
    }

    public void login(){
        try{
            String query = "SELECT * FROM erabiltzaileak WHERE username = ? AND password = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, this.username);
            statement.setString(2, this.password);
            ResultSet userSet = statement.executeQuery();
            if (userSet.next()) {
                System.out.println("Login success!");
                Erabiltzailea user = new Erabiltzailea(userSet.getInt("id_user"),userSet.getString("username"),userSet.getString("password"));
                session = new Session(user);
                System.out.println("Session username: " + session.getUser().getUsername());
                mainPanel.removeAll();
                mainPanel.setVisible(false);
                dashboard dashboard = new dashboard();
                mainPanel.add(dashboard.getContentPane());
                mainPanel.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"Wrong username or password","Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }
    public void logout() throws IOException, FontFormatException {
        this.username = null;
        this.password = null;
        session = null;

        login login = new login();
        mainPanel.removeAll();
        mainPanel.setVisible(false);
        mainPanel.add(login.getContentPane());
        mainPanel.setVisible(true);
    }

}
