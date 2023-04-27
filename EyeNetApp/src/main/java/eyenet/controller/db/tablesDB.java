/*
 * Copyright (c) 2023.
 */

package eyenet.controller.db;

import eyenet.controller.gestorDB;
import eyenet.model.Langilea;
import eyenet.model.Nomina;
import eyenet.model.Produktua;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tablesDB extends gestorDB {
    private Connection conexion;
    public tablesDB() throws IOException {
        this.conexion = connect();
    }
    public List<Langilea> listWorkers(){
        List<Langilea> workers = new ArrayList<>();
        try {
            String query = "SELECT * from langileak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet workerSet = statement.executeQuery();
            while(workerSet.next()){
                Langilea worker = new Langilea(workerSet.getInt("id_langilea"),workerSet.getInt("id_rol"),workerSet.getInt("id_user"),workerSet.getString("username"),workerSet.getString("password"),workerSet.getString("izena"),workerSet.getString("abizenak"),workerSet.getDate("jaiotze_data"),workerSet.getString("sexua"),workerSet.getDouble("soldata"),workerSet.getString("email"),workerSet.getDate("kontratu_data"),workerSet.getString("mota"));
                workers.add(worker);
            }
        }catch (SQLException | IOException ex){
            System.out.println(ex.getMessage());
        }
        return workers;
    }
    public List<Produktua> listProducts(){
        List<Produktua> produktuak = new ArrayList<>();
        try {
            String query = "SELECT * from produktuak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet productSet = statement.executeQuery();
            while(productSet.next()){
                Produktua produktua = new Produktua(productSet.getInt("id_produktua"),productSet.getInt("id_hornitzailea"),productSet.getString("izena"),productSet.getString("deskribapena"),productSet.getDouble("prezioa"),productSet.getInt("stock"));
                produktuak.add(produktua);
            }
        }catch (SQLException | IOException ex){
            System.out.println(ex.getMessage());
        }
        return produktuak;
    }
    public List<Produktua> listProductsQuery(String kontsulta){
        List<Produktua> produktuak = new ArrayList<>();
        try {
            String query = "SELECT * from produktuak where id_produktua like ? or id_hornitzailea like ? or izena like ? or deskribapena like ? or prezioa like ? or stock like ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, "%" + kontsulta + "%");
            statement.setString(2, "%" + kontsulta + "%");
            statement.setString(3, "%" + kontsulta + "%");
            statement.setString(4, "%" + kontsulta + "%");
            statement.setString(5, "%" + kontsulta + "%");
            statement.setString(6, "%" + kontsulta + "%");
            ResultSet productSet = statement.executeQuery();
            while(productSet.next()){
                Produktua produktua = new Produktua(productSet.getInt("id_produktua"),productSet.getInt("id_hornitzailea"),productSet.getString("izena"),productSet.getString("deskribapena"),productSet.getDouble("prezioa"),productSet.getInt("stock"));
                produktuak.add(produktua);
            }
        }catch (SQLException | IOException ex){
            System.out.println(ex.getMessage());
        }
        return produktuak;
    }
    public List<Nomina> listPayrolls(){
        List<Nomina> payrolls = new ArrayList<>();
        try {
            String query = "SELECT * from nominak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet payrollSet = statement.executeQuery();
            while(payrollSet.next()){
                Nomina payroll = new Nomina(payrollSet.getInt("id_nomina"),payrollSet.getInt("id_langilea"),payrollSet.getInt("id_giza"),payrollSet.getInt("egun_kopurua"),payrollSet.getDate("data"),payrollSet.getInt("PFEZ"),payrollSet.getDouble("soldata_gordina"),payrollSet.getDouble("soldata_garbia"),payrollSet.getString("banku_kontua"),payrollSet.getInt("ezinbesteko_orduak"),payrollSet.getInt("ordu_extrak"));
                payrolls.add(payroll);
            }
        }catch (SQLException | IOException ex){
            System.out.println(ex.getMessage());
        }
        return payrolls;
    }
    public List<Nomina> listPayrollsQuery(String kontsulta){
        List<Nomina> payrolls = new ArrayList<>();
        try {
            String query = "SELECT * from nominak where id_nomina like ? or id_langilea like ? or id_giza like ? or egun_kopurua like ? or data like ? or PFEZ like ? or soldata_gordina like ? or soldata_garbia like ? or banku_kontua like ? or ezinbesteko_orduak like ? or ordu_extrak like ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, "%" + kontsulta + "%");
            statement.setString(2, "%" + kontsulta + "%");
            statement.setString(3, "%" + kontsulta + "%");
            statement.setString(4, "%" + kontsulta + "%");
            statement.setString(5, "%" + kontsulta + "%");
            statement.setString(6, "%" + kontsulta + "%");
            statement.setString(7, "%" + kontsulta + "%");
            statement.setString(8, "%" + kontsulta + "%");
            statement.setString(9, "%" + kontsulta + "%");
            statement.setString(10, "%" + kontsulta + "%");
            statement.setString(11, "%" + kontsulta + "%");
            ResultSet payrollSet = statement.executeQuery();
            while(payrollSet.next()){
                Nomina payroll = new Nomina(payrollSet.getInt("id_nomina"),payrollSet.getInt("id_langilea"),payrollSet.getInt("id_giza"),payrollSet.getInt("egun_kopurua"),payrollSet.getDate("data"),payrollSet.getInt("PFEZ"),payrollSet.getDouble("soldata_gordina"),payrollSet.getDouble("soldata_garbia"),payrollSet.getString("banku_kontua"),payrollSet.getInt("ezinbesteko_orduak"),payrollSet.getInt("ordu_extrak"));
                payrolls.add(payroll);
            }
        }catch (SQLException | IOException ex){
            System.out.println(ex.getMessage());
        }
        return payrolls;
    }
    public List<Langilea> listWorkersQuery(String kontsulta){
        List<Langilea> workers = new ArrayList<>();
        try {
            String query = "SELECT * from langileak where id_langilea like ? or id_rol like ? or id_user like ? or username like ? or izena like ? or abizenak like ? or jaiotze_data like ? or sexua like ? or soldata like ? or email like ? or kontratu_data like ? or mota like ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, "%" + kontsulta + "%");
            statement.setString(2, "%" + kontsulta + "%");
            statement.setString(3, "%" + kontsulta + "%");
            statement.setString(4, "%" + kontsulta + "%");
            statement.setString(5, "%" + kontsulta + "%");
            statement.setString(6, "%" + kontsulta + "%");
            statement.setString(7, "%" + kontsulta + "%");
            statement.setString(8, "%" + kontsulta + "%");
            statement.setString(9, "%" + kontsulta + "%");
            statement.setString(10, "%" + kontsulta + "%");
            statement.setString(11, "%" + kontsulta + "%");
            statement.setString(12, "%" + kontsulta + "%");
            ResultSet workerSet = statement.executeQuery();
            while(workerSet.next()){
                Langilea worker = new Langilea(workerSet.getInt("id_langilea"),workerSet.getInt("id_rol"),workerSet.getInt("id_user"),workerSet.getString("username"),workerSet.getString("password"),workerSet.getString("izena"),workerSet.getString("abizenak"),workerSet.getDate("jaiotze_data"),workerSet.getString("sexua"),workerSet.getDouble("soldata"),workerSet.getString("email"),workerSet.getDate("kontratu_data"),workerSet.getString("mota"));
                workers.add(worker);
            }
        }catch (SQLException | IOException ex){
            System.out.println(ex.getMessage());
        }
        return workers;
    }
    public Object[][] listWorkersToTable(){
        List<Langilea> workers = listWorkers();

        Object[][] workersObject = new Object[workers.size()][10];

        for (int i = 0; i < workersObject.length; i++){
            workersObject[i][0] = workers.get(i).getId_langilea();
            workersObject[i][1] = workers.get(i).getUsername();
            workersObject[i][2] = workers.get(i).getIzena();
            workersObject[i][3] = workers.get(i).getAbizenak();
            workersObject[i][4] = workers.get(i).getJaiotze_data();
            workersObject[i][5] = workers.get(i).getSexua();
            workersObject[i][6] = workers.get(i).getSoldata();
            workersObject[i][7] = workers.get(i).getEmail();
            workersObject[i][8] = workers.get(i).getKontratu_data();
            workersObject[i][9] = workers.get(i).getMota();
        }
        return workersObject;
    }
    public Object[][] listProductsToTable(){
        List<Produktua> produktuak = listProducts();


        Object[][] workersObject = new Object[produktuak.size()][6];

        for (int i = 0; i < workersObject.length; i++){
            workersObject[i][0] = produktuak.get(i).getId_produktua();
            workersObject[i][1] = produktuak.get(i).getProviderName();
            workersObject[i][2] = produktuak.get(i).getIzena();
            workersObject[i][3] = produktuak.get(i).getDeskribapena();
            workersObject[i][4] = produktuak.get(i).getPrezioa();
            workersObject[i][5] = produktuak.get(i).getStock();
        }
        return workersObject;
    }

    public Object[][] listProductsQueryToTable(String query){
        List<Produktua> produktuak = listProductsQuery(query);


        Object[][] workersObject = new Object[produktuak.size()][6];

        for (int i = 0; i < workersObject.length; i++){
            workersObject[i][0] = produktuak.get(i).getId_produktua();
            workersObject[i][1] = produktuak.get(i).getProviderName();
            workersObject[i][2] = produktuak.get(i).getIzena();
            workersObject[i][3] = produktuak.get(i).getDeskribapena();
            workersObject[i][4] = produktuak.get(i).getPrezioa();
            workersObject[i][5] = produktuak.get(i).getStock();
        }
        return workersObject;
    }
    public Object[][] listPayrollsToTable(){
        List<Nomina> payrolls = listPayrolls();


        Object[][] payrollsObject = new Object[payrolls.size()][11];

        for (int i = 0; i < payrollsObject.length; i++){
            payrollsObject[i][0] = payrolls.get(i).getId_nomina();
            payrollsObject[i][1] = payrolls.get(i).getWorkerName();
            payrollsObject[i][2] = payrolls.get(i).getHumanRscName();
            payrollsObject[i][3] = payrolls.get(i).getEgun_kopurua();
            payrollsObject[i][4] = payrolls.get(i).getData();
            payrollsObject[i][5] = payrolls.get(i).getPFEZ();
            payrollsObject[i][6] = payrolls.get(i).getSoldata_gordina();
            payrollsObject[i][7] = payrolls.get(i).getSoldata_garbia();
            payrollsObject[i][8] = payrolls.get(i).getBanku_kontua();
            payrollsObject[i][9] = payrolls.get(i).getEzinbesteko_orduak();
            payrollsObject[i][10] = payrolls.get(i).getOrdu_extrak();
        }
        return payrollsObject;
    }
    public Object[][] listPayrollsQueryToTable(String query){
        List<Nomina> payrolls = listPayrollsQuery(query);


        Object[][] payrollsObject = new Object[payrolls.size()][11];

        for (int i = 0; i < payrollsObject.length; i++){
            payrollsObject[i][0] = payrolls.get(i).getId_nomina();
            payrollsObject[i][1] = payrolls.get(i).getWorkerName();
            payrollsObject[i][2] = payrolls.get(i).getHumanRscName();
            payrollsObject[i][3] = payrolls.get(i).getEgun_kopurua();
            payrollsObject[i][4] = payrolls.get(i).getData();
            payrollsObject[i][5] = payrolls.get(i).getPFEZ();
            payrollsObject[i][6] = payrolls.get(i).getSoldata_gordina();
            payrollsObject[i][7] = payrolls.get(i).getSoldata_garbia();
            payrollsObject[i][8] = payrolls.get(i).getBanku_kontua();
            payrollsObject[i][9] = payrolls.get(i).getEzinbesteko_orduak();
            payrollsObject[i][10] = payrolls.get(i).getOrdu_extrak();
        }
        return payrollsObject;
    }
    public Object[][] listWorkersQueryToTable(String query){
        List<Langilea> workers = listWorkersQuery(query);


        Object[][] workersObject = new Object[workers.size()][10];

        for (int i = 0; i < workersObject.length; i++){
            workersObject[i][0] = workers.get(i).getId_langilea();
            workersObject[i][1] = workers.get(i).getUsername();
            workersObject[i][2] = workers.get(i).getIzena();
            workersObject[i][3] = workers.get(i).getAbizenak();
            workersObject[i][4] = workers.get(i).getJaiotze_data();
            workersObject[i][5] = workers.get(i).getSexua();
            workersObject[i][6] = workers.get(i).getSoldata();
            workersObject[i][7] = workers.get(i).getEmail();
            workersObject[i][8] = workers.get(i).getKontratu_data();
            workersObject[i][9] = workers.get(i).getMota();
        }
        return workersObject;
    }
    public String[] getColumns(String table){
        String[] columns = null;
        try{
            String query = "SELECT * FROM `" + table + "`";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet columnSet = statement.executeQuery();
            ResultSetMetaData metaData = columnSet.getMetaData();
            int count = metaData.getColumnCount();
            columns = new String[count];
            for (int i = 0; i < count; i++) {
                columns[i] = metaData.getColumnName(i + 1);
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return columns;
    }
    public void refreshTableData(Object[][] data, DefaultTableModel tableModel, JTable table) {
        for(int i = 0; i < data.length; i++) {
            tableModel.addRow(data[i]);
        }
        // Refrescar la vista de la tabla
        table.repaint();
    }
}
