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

public class Perms extends gestorDB {
    private int id_funtzioa;
    private int id_rol;
    private String functionName;
    private String rolName;
    public Perms(int id_funtzioa, int id_rol) throws IOException {
        super();
        this.id_funtzioa = id_funtzioa;
        this.id_rol = id_rol;
        this.setNames();
    }
    public void setNames(){
        try{
            String query = "SELECT izena from funtzionalitateak where id_funtzioa = ?";
            PreparedStatement statement = connect().prepareStatement(query);
            statement.setInt(1,this.id_funtzioa);
            ResultSet nameFunctionSet = statement.executeQuery();
            while (nameFunctionSet.next()){
                this.functionName = nameFunctionSet.getString("izena");
            }
            statement.close();

            switch (id_rol){
                case 1:
                    rolName = "langile arrunta";
                    break;
                case 2:
                    rolName = "giza baliabidea";
                    break;
                case 3:
                    rolName = "admin";
                    break;
            }

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int getId_funtzioa() {
        return id_funtzioa;
    }

    public int getId_rol() {
        return id_rol;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getRolName() {
        return rolName;
    }
}
