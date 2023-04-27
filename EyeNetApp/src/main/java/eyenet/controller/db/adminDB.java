/*
 * Copyright (c) 2023.
 */

package eyenet.controller.db;

import eyenet.controller.gestorDB;
import eyenet.model.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class adminDB extends gestorDB {
    private Connection conexion;

    public adminDB() throws IOException {
        this.conexion = connect();
    }

    public List<InfoRequest> listInfoChangeRequest() {

        List<InfoRequest> infoChangeRequests = new ArrayList<>();
        try {
            String query = "SELECT * FROM info_eskaerak where mota = 'info aldaketa'";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet infoChangeSet = statement.executeQuery();
            while (infoChangeSet.next()) {
                InfoRequest infoChangeRequest = new InfoRequest(infoChangeSet.getInt("id_eskaera"), infoChangeSet.getInt("id_langilea"), infoChangeSet.getInt("id_admin"), infoChangeSet.getString("mezua"), infoChangeSet.getDate("data"), infoChangeSet.getString("erantzuna"), infoChangeSet.getString("aldaketa"), infoChangeSet.getString("egoera"), infoChangeSet.getString("mota"));
                infoChangeRequests.add(infoChangeRequest);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return infoChangeRequests;
    }

    public List<InfoRequest> listConsultRequest() {
        List<InfoRequest> consultRequests = new ArrayList<>();
        try {
            String query = "SELECT * FROM info_eskaerak where mota = 'kontsulta'";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet infoChangeSet = statement.executeQuery();
            while (infoChangeSet.next()) {
                System.out.println("asdasdasdasd");
                InfoRequest consultRequest = new InfoRequest(infoChangeSet.getInt("id_eskaera"), infoChangeSet.getInt("id_langilea"), infoChangeSet.getInt("id_admin"), infoChangeSet.getString("mezua"), infoChangeSet.getDate("data"), infoChangeSet.getString("erantzuna"), infoChangeSet.getString("aldaketa"), infoChangeSet.getString("egoera"), infoChangeSet.getString("mota"));
                consultRequests.add(consultRequest);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return consultRequests;
    }

    public List<Langilea> listWorkers() {
        List<Langilea> workers = new ArrayList<>();
        try {
            String query = "SELECT * from langileak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet workerSet = statement.executeQuery();
            while (workerSet.next()) {
                Langilea worker = new Langilea(workerSet.getInt("id_langilea"), workerSet.getInt("id_rol"), workerSet.getInt("id_user"), workerSet.getString("username"), workerSet.getString("password"), workerSet.getString("izena"), workerSet.getString("abizenak"), workerSet.getDate("jaiotze_data"), workerSet.getString("sexua"), workerSet.getDouble("soldata"), workerSet.getString("email"), workerSet.getDate("kontratu_data"), workerSet.getString("mota"));
                workers.add(worker);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return workers;
    }


    public List<Langilea> listWorkersQuery(String kontsulta) {
        List<Langilea> workers = new ArrayList<>();
        try {
            String query = "SELECT * from langileak where id_langilea like ? or username like ? or mota like ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, "%" + kontsulta + "%");
            statement.setString(2, "%" + kontsulta + "%");
            statement.setString(3, "%" + kontsulta + "%");
            ResultSet workerSet = statement.executeQuery();
            while (workerSet.next()) {
                Langilea worker = new Langilea(workerSet.getInt("id_langilea"), workerSet.getInt("id_rol"), workerSet.getInt("id_user"), workerSet.getString("username"), workerSet.getString("password"), workerSet.getString("izena"), workerSet.getString("abizenak"), workerSet.getDate("jaiotze_data"), workerSet.getString("sexua"), workerSet.getDouble("soldata"), workerSet.getString("email"), workerSet.getDate("kontratu_data"), workerSet.getString("mota"));
                workers.add(worker);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return workers;
    }

    public List<Perms> listPerms() {
        List<Perms> perms = new ArrayList<>();
        try {
            String query = "SELECT * FROM r_izan_f";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet permSet = statement.executeQuery();
            while (permSet.next()) {
                Perms perm = new Perms(permSet.getInt("id_funtzioa"), permSet.getInt("id_rol"));
                perms.add(perm);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return perms;
    }


    public Object[][] listInfoChangeRequestToTable() {
        List<InfoRequest> infoChangeRequests = listInfoChangeRequest();
        Object[][] infoChangeRequestsObject = new Object[infoChangeRequests.size()][7];
        for (int i = 0; i < infoChangeRequestsObject.length; i++) {
            infoChangeRequestsObject[i][0] = infoChangeRequests.get(i).getId_eskaera();
            infoChangeRequestsObject[i][1] = infoChangeRequests.get(i).getWorkerUsername();
            infoChangeRequestsObject[i][2] = infoChangeRequests.get(i).getAdminUsername();
            infoChangeRequestsObject[i][3] = infoChangeRequests.get(i).getData();
            infoChangeRequestsObject[i][4] = infoChangeRequests.get(i).getAldaketa();
            infoChangeRequestsObject[i][5] = infoChangeRequests.get(i).getEgoera();
            infoChangeRequestsObject[i][6] = ""; // NO HACE FALTA PONER NADA, EL BUTTON EDITOR YA LO EDITA POSTERIORMENTE
        }
        return infoChangeRequestsObject;
    }

    public Object[][] listConsultRequestToTable() {
        List<InfoRequest> consultRequests = listConsultRequest();
        Object[][] consultRequestsObject = new Object[consultRequests.size()][8];
        for (int i = 0; i < consultRequestsObject.length; i++) {
            consultRequestsObject[i][0] = consultRequests.get(i).getId_eskaera();
            consultRequestsObject[i][1] = consultRequests.get(i).getWorkerUsername();
            consultRequestsObject[i][2] = consultRequests.get(i).getAdminUsername();
            consultRequestsObject[i][3] = consultRequests.get(i).getData();
            consultRequestsObject[i][4] = consultRequests.get(i).getMezua();
            consultRequestsObject[i][5] = consultRequests.get(i).getErantzuna();
            consultRequestsObject[i][6] = consultRequests.get(i).getEgoera();
            consultRequestsObject[i][7] = ""; // NO HACE FALTA PONER NADA, EL BUTTON EDITOR YA LO EDITA POSTERIORMENTE
        }
        return consultRequestsObject;
    }

    public Object[][] listWorkersRolesToTable() {
        List<Langilea> workers = listWorkers();

        Object[][] workersObject = new Object[workers.size()][4];

        for (int i = 0; i < workersObject.length; i++) {

            workersObject[i][0] = workers.get(i).getId_langilea();
            workersObject[i][1] = workers.get(i).getUsername();
            workersObject[i][2] = workers.get(i).getMota();
            workersObject[i][3] = ""; // ESTO LO GESTIONA BUTTON EDITOR
        }
        return workersObject;
    }

    public Object[][] listWorkersRolesQueryToTable(String query) {
        List<Langilea> workers = listWorkersQuery(query);

        Object[][] workersObject = new Object[workers.size()][4];

        for (int i = 0; i < workersObject.length; i++) {

            workersObject[i][0] = workers.get(i).getId_langilea();
            workersObject[i][1] = workers.get(i).getUsername();
            workersObject[i][2] = workers.get(i).getMota();
            workersObject[i][3] = ""; // ESTO LO GESTIONA BUTTON EDITOR
        }
        return workersObject;
    }

    public Object[][] listPermsToTable() {
        List<Perms> perms = listPerms();

        Object[][] permsObject = new Object[perms.size()][4];
        for (int i = 0; i < permsObject.length; i++) {

            permsObject[i][0] = perms.get(i).getId_funtzioa();
            permsObject[i][1] = perms.get(i).getId_rol();
            permsObject[i][2] = perms.get(i).getRolName();
            permsObject[i][3] = perms.get(i).getFunctionName();
        }
        return permsObject;
    }

    public void acceptInfoChange(Object workerUsernameObject, Object changesObject, Object orderIDobject) {
        String username = workerUsernameObject.toString();
        String changes = changesObject.toString();
        int orderID = (int) orderIDobject;

        String[] parts = changes.split(",");

        try {
            String query1 = "UPDATE langileak set izena = ?, abizenak = ?, jaiotze_data = ?, sexua = ?, username = ?, password = ?, email = ? where username like ?";
            PreparedStatement statement1 = connect().prepareStatement(query1);
            statement1.setString(1, parts[1]);
            statement1.setString(2, parts[2]);
            statement1.setString(3, parts[3]);
            statement1.setString(4, parts[4]);
            statement1.setString(5, parts[5]);
            statement1.setString(6, parts[6]);
            statement1.setString(7, parts[7]);
            statement1.setString(8, parts[5]);
            statement1.executeUpdate();

            String query2 = "UPDATE erabiltzailea set username = ?, password = ? where username like ?";
            PreparedStatement statement2 = connect().prepareStatement(query2);
            statement2.setString(1, parts[5]);
            statement2.setString(2, parts[6]);
            statement2.executeUpdate();


            String infoChangeQuery = "UPDATE info_eskaerak set egoera = 'itxia' where id_eskaera = ?";
            PreparedStatement statement = connect().prepareStatement(infoChangeQuery);
            statement.setInt(1, orderID);
            statement.executeUpdate();
            statement.close();
            statement1.close();
            statement2.close();


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void declineRequest(Object orderIDObject) {
        try {
            int orderID = (int) orderIDObject;
            String query = "UPDATE info_eskaerak set egoera = 'itxia' where id_eskaera = ?";
            PreparedStatement statement = connect().prepareStatement(query);
            statement.setInt(1, orderID);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void answerConsult(int adminID, String answer, Object orderIDobject) {
        int orderID = (int) orderIDobject;

        try {

            String consultQuery = "UPDATE info_eskaerak set egoera = 'itxia', id_admin = ?, erantzuna = ? where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(consultQuery);
            statement.setInt(1, adminID);
            statement.setString(2, answer);
            statement.setInt(3, orderID);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void changeWorkerRole(Object idUserObj, String newRole) {
        int idUser = (int) idUserObj;
        int newIdRole = getRolId(newRole);
        try {
            String query = "UPDATE langileak SET mota = ?, id_rol = ? where id_langilea = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, newRole);
            statement.setInt(2, newIdRole);
            statement.setInt(3, idUser);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String[] getAllFunctionNames() {
        ArrayList<String> names = new ArrayList<>();
        try {
            String query = "SELECT izena from funtzionalitateak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet functionSet = statement.executeQuery();
            while (functionSet.next()) {
                names.add(functionSet.getString("izena"));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return names.toArray(new String[0]); // Convertir ArrayList a arreglo String[]
    }

    public boolean checkAddPermAvailability(String rolName, String functionName) {
        boolean availability = true;
        int idRol = getRolId(rolName);
        int idFunction = this.getFunctionID(functionName);
        try {
            String query = "SELECT * FROM r_izan_f where id_funtzioa = ? and id_rol = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idFunction);
            statement.setInt(2, idRol);
            ResultSet availableSet = statement.executeQuery();
            while (availableSet.next()) {
                availability = false;
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return availability;
    }

    public boolean checkRemovePermAvailability(String rolName, String functionName) {
        boolean availability = false;
        int idRol = getRolId(rolName);

        int idFunction = this.getFunctionID(functionName);
        try {
            String query = "SELECT * FROM r_izan_f where id_funtzioa = ? and id_rol = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idFunction);
            statement.setInt(2, idRol);
            ResultSet availableSet = statement.executeQuery();
            while (availableSet.next()) {
                availability = true;
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return availability;
    }

    public int getFunctionID(String functionName) {
        int id = 0;
        try {
            String query = "SELECT id_funtzioa from funtzionalitateak where izena like ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, functionName);
            ResultSet idSet = statement.executeQuery();
            while (idSet.next()) {
                id = idSet.getInt("id_funtzioa");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public int getRolId(String rolName) {
        int idRol = 0;
        switch (rolName) {
            case "langile arrunta":
                idRol = 1;
                break;
            case "giza baliabidea":
                idRol = 2;
                break;
            case "admin":
                idRol = 3;
                break;
            case "ceo":
                idRol = 4;
                break;
        }
        return idRol;
    }

    public void addFunctionToRole(String rolName, String functionName) {
        try {
            int idRol = getRolId(rolName);
            int idFunction = getFunctionID(functionName);
            String query = "INSERT INTO r_izan_f VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idRol);
            statement.setInt(2, idFunction);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void removeFunctionToRole(String rolName, String functionName) {
        try {
            int idRol = getRolId(rolName);
            int idFunction = getFunctionID(functionName);
            String query = "DELETE FROM r_izan_f WHERE id_rol = ? and id_funtzioa = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idRol);
            statement.setInt(2, idFunction);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createWorker(String iz, String ab, Date jai, String sex, float sol, String ema, String usname, Date kontratu_data, int rolId) {
        try {
            String query = "INSERT INTO Langilea (password, izena, abizenak,jaiotze_data,sexua,soldata,email,username,kontratu_data) VALUES ('porDefecto',?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(2, iz);
            statement.setString(3, ab);
            statement.setDate(4, jai);
            statement.setString(5, sex);
            statement.setFloat(6, sol);
            statement.setString(7, ema);
            statement.setString(8, usname);
            statement.setDate(9,kontratu_data);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
