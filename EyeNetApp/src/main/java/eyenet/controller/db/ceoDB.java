/*
 * Copyright (c) 2023.
 */

package eyenet.controller.db;

import eyenet.controller.gestorDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ceoDB extends gestorDB {
    private Connection conexion;
    public ceoDB() throws IOException {
        this.conexion = connect();
    }
    public boolean isCeo(int id_langilea){
        boolean ceo = false;
        try{
            String query = "SELECT id_langilea from ceo where id_langilea = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1,id_langilea);
            ResultSet ceoSet = statement.executeQuery();
            while (ceoSet.next()){
                ceo = true;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return ceo;
    }

}
