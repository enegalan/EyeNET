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
import java.util.List;

public class Erabiltzailea extends gestorDB {
    private int id_user;
    private String username;
    private String password;
    private String role;

    public Erabiltzailea(int id, String username, String password) throws IOException {
        super();
        this.id_user = id;
        this.password = password;
        this.username = username;
        this.setCurrentRole();
    }
    public int getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void setCurrentRole(){
        try{
            String query = "SELECT mota from langileak where id_user like ?";
            PreparedStatement statement = connect().prepareStatement(query);
            statement.setInt(1,this.id_user);
            ResultSet motaSet = statement.executeQuery();
            while (motaSet.next()){
                this.role = motaSet.getString("mota");
            }
            statement.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getRole() {
        return role;
    }

}
