/*
 * Copyright (c) 2023.
 */

package eyenet.controller.db;

import eyenet.controller.gestorDB;
import eyenet.model.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class workerDB extends gestorDB {
    private Connection conexion;

    public workerDB() throws IOException {
        this.conexion = connect();
    }

    public List<InfoRequest> listConsultRequest() {
        List<InfoRequest> consultRequests = new ArrayList<>();
        int idWorker = session.getUser().getId_user();
        try {
            String query = "SELECT * FROM info_eskaerak where mota = 'kontsulta' and id_langilea = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idWorker);
            ResultSet infoChangeSet = statement.executeQuery();
            while (infoChangeSet.next()) {
                InfoRequest consultRequest = new InfoRequest(infoChangeSet.getInt("id_eskaera"), infoChangeSet.getInt("id_langilea"), infoChangeSet.getInt("id_admin"), infoChangeSet.getString("mezua"), infoChangeSet.getDate("data"), infoChangeSet.getString("erantzuna"), infoChangeSet.getString("aldaketa"), infoChangeSet.getString("egoera"), infoChangeSet.getString("mota"));
                consultRequests.add(consultRequest);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return consultRequests;
    }

    public List<BarnekoEskaera> listInternalOrders() {
        List<BarnekoEskaera> internalOrders = new ArrayList<>();
        try {
            String query = "SELECT * FROM barneko_eskaerak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet internalOrderSet = statement.executeQuery();
            while (internalOrderSet.next()) {
                BarnekoEskaera internalOrder = new BarnekoEskaera(internalOrderSet.getInt("id_eskaera"), internalOrderSet.getInt("id_langilea"), internalOrderSet.getDate("data"), internalOrderSet.getDouble("prezio_totala"));
                internalOrders.add(internalOrder);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return internalOrders;
    }

    public List<Be_eduki_p> listBeEdukiP(int id_eskaera) {
        List<Be_eduki_p> beEdukiPList = new ArrayList<>();
        try {
            String query = "SELECT * FROM be_eduki_p where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet beEdukiPSet = statement.executeQuery();
            while (beEdukiPSet.next()) {
                Be_eduki_p beEdukiP = new Be_eduki_p(id_eskaera, beEdukiPSet.getInt("id_produktua"), beEdukiPSet.getInt("id_hornitzailea"), beEdukiPSet.getInt("kopurua"));
                beEdukiPList.add(beEdukiP);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return beEdukiPList;
    }

    public List<E_eduki_p> listEEdukiP(int id_eskaera) {
        List<E_eduki_p> eEdukiPList = new ArrayList<>();
        try {
            String query = "SELECT * FROM e_eduki_p where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet eEdukiPSet = statement.executeQuery();
            while (eEdukiPSet.next()) {
                E_eduki_p eEdukiP = new E_eduki_p(id_eskaera, eEdukiPSet.getInt("id_produktua"), eEdukiPSet.getInt("id_hornitzailea"), eEdukiPSet.getInt("kopurua"));
                eEdukiPList.add(eEdukiP);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return eEdukiPList;
    }

    public List<Produktua> listProducts() {
        List<Produktua> produktuak = new ArrayList<>();
        try {
            String query = "SELECT * from produktuak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet productSet = statement.executeQuery();
            while (productSet.next()) {
                Produktua produktua = new Produktua(productSet.getInt("id_produktua"), productSet.getInt("id_hornitzailea"), productSet.getString("izena"), productSet.getString("deskribapena"), productSet.getDouble("prezioa"), productSet.getInt("stock"));
                produktuak.add(produktua);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return produktuak;
    }

    public List<Produktua> listProductsQuery(String kontsulta) {
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
            while (productSet.next()) {
                Produktua produktua = new Produktua(productSet.getInt("id_produktua"), productSet.getInt("id_hornitzailea"), productSet.getString("izena"), productSet.getString("deskribapena"), productSet.getDouble("prezioa"), productSet.getInt("stock"));
                produktuak.add(produktua);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return produktuak;
    }

    public List<Eskaera> listOrders() {
        List<Eskaera> orders = new ArrayList<>();
        try {
            String query = "SELECT * from eskaerak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet ordersSet = statement.executeQuery();
            while (ordersSet.next()) {
                Eskaera order = new Eskaera(ordersSet.getInt("id_eskaera"), ordersSet.getInt("id_bezeroa"), ordersSet.getInt("id_langilea"), ordersSet.getInt("id_faktura"), ordersSet.getDate("data"), ordersSet.getDate("iriste_data"), ordersSet.getDouble("prezioa"), ordersSet.getDouble("deskontua"), ordersSet.getDouble("prezio_final"), ordersSet.getString("helbidea"), ordersSet.getBoolean("online_"), ordersSet.getString("ordainketa"), ordersSet.getString("kreditu_zenbakia"), ordersSet.getString("egoera"));
                orders.add(order);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return orders;
    }

    public List<Hornitzaileak> listProviders() {
        List<Hornitzaileak> providers = new ArrayList<>();
        try {
            String query = "SELECT * from hornitzaileak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet providersSet = statement.executeQuery();
            while (providersSet.next()) {
                Hornitzaileak provider = new Hornitzaileak(providersSet.getString("izena"), providersSet.getString("helbidea"), providersSet.getString("kontaktua"));
                ;
                providers.add(provider);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return providers;
    }

    public List<Bill> listBills() {
        List<Bill> bills = new ArrayList<>();
        try {
            String query = "SELECT * from fakturak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet ordersSet = statement.executeQuery();
            while (ordersSet.next()) {
                Bill bill = new Bill(ordersSet.getInt("id_faktura"), ordersSet.getDate("data"), ordersSet.getDouble("totala"));
                bills.add(bill);
            }
            statement.close();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return bills;
    }

    public Langilea listWorker(int id_user) {
        Langilea worker = null;
        try {
            String query = "Select * from langileak where id_user= ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_user);
            ResultSet workerSet = statement.executeQuery();
            while (workerSet.next()) {
                worker = new Langilea(workerSet.getInt("id_langilea"), workerSet.getInt("id_rol"), workerSet.getInt("id_user"), workerSet.getString("username"), workerSet.getString("password"), workerSet.getString("izena"), workerSet.getString("abizenak"), workerSet.getDate("jaiotze_data"), workerSet.getString("sexua"), workerSet.getDouble("soldata"), workerSet.getString("email"), workerSet.getDate("kontratu_data"), workerSet.getString("mota"));
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());

        }
        return worker;
    }

    public Object[][] listBillsToTable() {
        List<Bill> bills = listBills();


        Object[][] ordersObject = new Object[bills.size()][4];


        for (int i = 0; i < ordersObject.length; i++) {
            ordersObject[i][0] = bills.get(i).getId_faktura();
            ordersObject[i][1] = bills.get(i).getData();
            ordersObject[i][2] = bills.get(i).getTotal();
            ordersObject[i][3] = "";
        }
        return ordersObject;
    }

    public Object[][] listOrdersToTable() {
        List<Eskaera> orders = listOrders();


        Object[][] ordersObject = new Object[orders.size()][6];


        for (int i = 0; i < ordersObject.length; i++) {
            ordersObject[i][0] = orders.get(i).getId_eskaera();
            ordersObject[i][1] = orders.get(i).getClientName();
            ordersObject[i][2] = orders.get(i).getWorkerName();
            ordersObject[i][3] = orders.get(i).getDate();
            ordersObject[i][4] = orders.get(i).getFinalPrice();
            ordersObject[i][5] = "";
        }
        return ordersObject;
    }

    public Object[][] listProductsToTable() {
        List<Produktua> produktuak = listProducts();


        Object[][] workersObject = new Object[produktuak.size()][8];


        for (int i = 0; i < workersObject.length; i++) {
            workersObject[i][0] = produktuak.get(i).getId_produktua();
            workersObject[i][1] = produktuak.get(i).getProviderName();
            workersObject[i][2] = produktuak.get(i).getIzena();
            workersObject[i][3] = produktuak.get(i).getDeskribapena();
            workersObject[i][4] = produktuak.get(i).getPrezioa();
            workersObject[i][5] = produktuak.get(i).getStock();
            workersObject[i][6] = "";
            workersObject[i][7] = 0.0;
        }
        return workersObject;
    }

    public Object[][] listProductsQueryToTable(String query) {
        List<Produktua> produktuak = listProductsQuery(query);


        Object[][] workersObject = new Object[produktuak.size()][6];

        for (int i = 0; i < workersObject.length; i++) {
            workersObject[i][0] = produktuak.get(i).getId_produktua();
            workersObject[i][1] = produktuak.get(i).getProviderName();
            workersObject[i][2] = produktuak.get(i).getIzena();
            workersObject[i][3] = produktuak.get(i).getDeskribapena();
            workersObject[i][4] = produktuak.get(i).getPrezioa();
            workersObject[i][5] = produktuak.get(i).getStock();
        }
        return workersObject;
    }

    public Object[][] listBeEdukiPToTable(int id_eskaera) {
        List<Be_eduki_p> beEdukiPList = listBeEdukiP(id_eskaera);
        Object[][] beEdukiPObject = new Object[beEdukiPList.size()][4];
        for (int i = 0; i < beEdukiPObject.length; i++) {
            beEdukiPObject[i][0] = beEdukiPList.get(i).getId_eskaera();
            beEdukiPObject[i][1] = beEdukiPList.get(i).getProductName();
            beEdukiPObject[i][2] = beEdukiPList.get(i).getProviderName();
            beEdukiPObject[i][3] = beEdukiPList.get(i).getKopurua();
        }
        return beEdukiPObject;
    }

    public Object[][] listEEdukiPToTable(int id_eskaera) {
        List<E_eduki_p> eEdukiPList = listEEdukiP(id_eskaera);
        Object[][] eEdukiPObject = new Object[eEdukiPList.size()][4];
        for (int i = 0; i < eEdukiPObject.length; i++) {
            eEdukiPObject[i][0] = eEdukiPList.get(i).getId_produktua();
            eEdukiPObject[i][1] = eEdukiPList.get(i).getProductName();
            eEdukiPObject[i][2] = eEdukiPList.get(i).getProviderName();
            eEdukiPObject[i][3] = eEdukiPList.get(i).getKopurua();
        }
        return eEdukiPObject;
    }

    public Object[][] listInternalOrdersToTable() {
        List<BarnekoEskaera> internalOrders = listInternalOrders();
        Object[][] internalOrdersObject = new Object[internalOrders.size()][5];
        for (int i = 0; i < internalOrdersObject.length; i++) {
            internalOrdersObject[i][0] = internalOrders.get(i).getId_eskaera();
            internalOrdersObject[i][1] = internalOrders.get(i).getWorkerName();
            internalOrdersObject[i][2] = internalOrders.get(i).getDate();
            internalOrdersObject[i][3] = internalOrders.get(i).getTotalPrice();
            internalOrdersObject[i][4] = ""; // BUTTON EDITOR LO GESTIONA
        }
        return internalOrdersObject;
    }

    public Object[][] listConsultRequestToTable() {
        List<InfoRequest> consultRequests = listConsultRequest();
        Object[][] consultRequestsObject = new Object[consultRequests.size()][6];
        for (int i = 0; i < consultRequestsObject.length; i++) {
            consultRequestsObject[i][0] = consultRequests.get(i).getId_eskaera();
            consultRequestsObject[i][1] = consultRequests.get(i).getData();
            consultRequestsObject[i][2] = consultRequests.get(i).getMezua();
            consultRequestsObject[i][3] = consultRequests.get(i).getErantzuna();
            consultRequestsObject[i][4] = consultRequests.get(i).getAdminUsername();
            consultRequestsObject[i][5] = consultRequests.get(i).getEgoera();
        }
        return consultRequestsObject;
    }

    public Object[][] listProvidersToTable() {
        List<Hornitzaileak> providers = listProviders();
        Object[][] providersObject = new Object[providers.size()][4];
        for (int i = 0; i < providersObject.length; i++) {
            providersObject[i][0] = providers.get(i).getId_hornitzailea();
            providersObject[i][1] = providers.get(i).getIzena();
            providersObject[i][2] = providers.get(i).getHelbidea();
            providersObject[i][3] = providers.get(i).getKontaktua();
        }
        return providersObject;
    }

    public void createConsult(String message) {
        java.util.Date fechaActual = new java.util.Date();
        java.sql.Date actualDate = new java.sql.Date(fechaActual.getTime());
        try {
            String query = "INSERT INTO info_eskaerak (id_langilea, mezua, data, egoera, mota) VALUES (?,?,?,'irekia','kontsulta')";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, session.getUser().getId_user());
            statement.setString(2, message);
            statement.setDate(3, actualDate);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createProduct(int idProvider,String iz, String des, float pr, int sto) {
        try {
            String query = "INSERT INTO produktuak (id_hornitzailea, izena, deskribapena, prezioa,stock) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idProvider);
            statement.setString(2, iz);
            statement.setString(3, des);
            statement.setFloat(4, pr);
            statement.setInt(5, sto);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createInternalOrder(JTable orderProducts) {

        double totalOrderPrice = 0.0;
        int amount = 0;
        int productID = 0;
        int providerID = 0;

        for (int i = 0; i < orderProducts.getRowCount(); i++) {
            if ((double) orderProducts.getModel().getValueAt(i, 7) > 0) {
                totalOrderPrice = (double) orderProducts.getModel().getValueAt(i, 7) + totalOrderPrice;
            }
        }

        int option = JOptionPane.showConfirmDialog(null, "The total price is " + totalOrderPrice);

        if (option == JOptionPane.YES_OPTION) {
            java.util.Date fechaActual = new java.util.Date();
            java.sql.Date actualDate = new java.sql.Date(fechaActual.getTime());
            int workerID = session.getUser().getId_user();

            try {
                String query = "INSERT INTO barneko_eskaerak (id_langilea, data, prezio_totala) VALUES (?,?,?)";
                PreparedStatement statement = conexion.prepareStatement(query);
                statement.setInt(1, workerID);
                statement.setDate(2, actualDate);
                statement.setDouble(3, totalOrderPrice);
                statement.execute();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            int orderID = this.getLastOrderID();
            for (int i = 0; i < orderProducts.getRowCount(); i++) {
                if ((double) orderProducts.getModel().getValueAt(i, 7) > 0) {
                    productID = (int) orderProducts.getModel().getValueAt(i, 0);
                    providerID = this.getProviderID((String) orderProducts.getModel().getValueAt(i, 1));
                    amount = (int) ((double) orderProducts.getModel().getValueAt(i, 7) / (double) orderProducts.getModel().getValueAt(i, 4));
                    try {
                        String query = "INSERT INTO be_eduki_p (id_eskaera, id_produktua, id_hornitzailea, kopurua) VALUES (?,?,?,?)";
                        PreparedStatement statement = conexion.prepareStatement(query);
                        statement.setInt(1, orderID);
                        statement.setInt(2, productID);
                        statement.setInt(3, providerID);
                        statement.setInt(4, amount);
                        statement.execute();

                        int stock = (int) orderProducts.getModel().getValueAt(i, 5);
                        int newStock = stock - amount;
                        String query2 = "UPDATE produktuak SET stock = ? WHERE id_produktua = ? and id_hornitzailea = ?";
                        PreparedStatement statement2 = conexion.prepareStatement(query2);
                        statement2.setInt(1, newStock);
                        statement2.setInt(2, productID);
                        statement2.setInt(3, providerID);
                        statement2.executeUpdate();

                        statement.close();
                        statement2.close();


                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
    }

    public void acceptExternalOrder(int orderID, int workerUserID) {
        int workerID = this.getWorkerID(workerUserID);
        try {
            String query = "UPDATE eskaerak SET id_langilea = ? where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, workerID);
            statement.setInt(2, orderID);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getLastOrderID() {
        int orderID = 0;
        try {
            String query = "SELECT MAX(id_eskaera) from barneko_eskaerak";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet orderIDState = statement.executeQuery();
            while (orderIDState.next()) {
                orderID = orderIDState.getInt(1);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return orderID;
    }

    public int getOrderID(int billID) {
        int orderID = 0;
        try {
            String query = "SELECT id_eskaera from eskaerak where id_faktura = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, billID);
            ResultSet orderIDSet = statement.executeQuery();
            while (orderIDSet.next()) {
                orderID = orderIDSet.getInt("id_eskaera");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return orderID;
    }

    public int getProviderID(String name) {
        int providerID = 0;
        try {
            String query = "SELECT id_hornitzailea from hornitzaileak where izena like ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, name);
            ResultSet providerIDSet = statement.executeQuery();
            while (providerIDSet.next()) {
                providerID = providerIDSet.getInt(1);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return providerID;
    }

    public int getWorkerID(int userID) {
        int workerID = 0;
        try {
            String query = "SELECT id_langilea from langileak where id_user = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet workerIDSet = statement.executeQuery();
            while (workerIDSet.next()) {
                workerID = workerIDSet.getInt("id_langilea");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return workerID;
    }

    public String getEgoera(int id_eskaera) {
        String egoera = null;
        try {
            String query = "SELECT egoera from eskaerak where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet egoeraSet = statement.executeQuery();
            while (egoeraSet.next()) {
                egoera = egoeraSet.getString("egoera");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return egoera;
    }

    public String getClientUsername(int orderID) {
        String username = null;
        try {
            String query = "SELECT username from bezeroak where id_bezeroa in (SELECT id_bezeroa from eskaerak where id_eskaera = ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, orderID);
            ResultSet usernameSet = statement.executeQuery();
            while (usernameSet.next()) {
                username = usernameSet.getString("username");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return username;
    }

    public String getWorkerRole(int id_langilea) {
        String role = null;
        try {
            String query = "Select mota from langileak where id_langilea = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_langilea);
            ResultSet roleSet = statement.executeQuery();
            while (roleSet.next()) {
                role = roleSet.getString("mota");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return role;
    }

    public String getWorkerUsername(int orderID) {
        String username = null;
        try {
            String query = "SELECT username from langileak where id_langilea in (SELECT id_langilea from eskaerak where id_eskaera = ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, orderID);
            ResultSet usernameSet = statement.executeQuery();
            while (usernameSet.next()) {
                username = usernameSet.getString("username");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return username;
    }

    public String getArriveDate(int id_eskaera) {
        String arriveDate = null;
        try {
            String query = "SELECT iriste_data from eskaerak where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet arriveDateSet = statement.executeQuery();
            while (arriveDateSet.next()) {
                if (arriveDateSet.getDate("iriste_data") != null) {
                    arriveDate = arriveDateSet.getDate("iriste_data").toString();
                } else {
                    arriveDate = "";
                }
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return arriveDate;
    }

    public String getFirstPrice(int id_eskaera) {
        String fPrice = null;
        try {
            String query = "SELECT prezioa from eskaerak where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet fPriceSet = statement.executeQuery();
            while (fPriceSet.next()) {
                fPrice = String.valueOf(fPriceSet.getDouble("prezioa"));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return fPrice;
    }

    public String getDiscount(int id_eskaera) {
        String discount = null;
        try {
            String query = "SELECT deskontua from eskaerak where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet discountSet = statement.executeQuery();
            while (discountSet.next()) {
                discount = String.valueOf(discountSet.getDouble("deskontua"));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return discount;
    }

    public String getFinalPrice(int id_eskaera) {
        String fPrice = null;
        try {
            String query = "SELECT prezio_final from eskaerak where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet fPriceSet = statement.executeQuery();
            while (fPriceSet.next()) {
                fPrice = String.valueOf(fPriceSet.getDouble("prezio_final"));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return fPrice;
    }

    public String getAddress(int id_eskaera) {
        String address = null;
        try {
            String query = "SELECT helbidea from eskaerak where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet addressSet = statement.executeQuery();
            while (addressSet.next()) {
                address = addressSet.getString("helbidea");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return address;
    }

    public String getOnline(int id_eskaera) {
        String online = null;
        try {
            String query = "SELECT online_ from eskaerak where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet onlineSet = statement.executeQuery();
            while (onlineSet.next()) {
                online = String.valueOf(onlineSet.getBoolean("online_"));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return online;
    }

    public String getPaymentMethod(int id_eskaera) {
        String payment = null;
        try {
            String query = "SELECT ordainketa from eskaerak where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet paymentSet = statement.executeQuery();
            while (paymentSet.next()) {
                payment = String.valueOf(paymentSet.getString("ordainketa"));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return payment;
    }

    public String getCreditNumber(int id_eskaera) {
        String credit = null;
        try {
            String query = "SELECT kreditu_zenbakia from eskaerak where id_eskaera = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_eskaera);
            ResultSet creditSet = statement.executeQuery();
            while (creditSet.next()) {
                credit = String.valueOf(creditSet.getString("kreditu_zenbakia"));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return credit;
    }

    public void safeRequest(ArrayList<String>aldaketak){
        try{

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <aldaketak.size() ; i++) {

                if(i<aldaketak.size()-1){
                    sb.append(aldaketak.get(i)+",");
                }else{
                    sb.append(aldaketak.get(i));
                }
            }

            String jsonString= sb.toString();
            System.out.println(jsonString);

            int workerID = session.getUser().getId_user();
            java.util.Date fechaActual = new java.util.Date();
            java.sql.Date actualDate = new java.sql.Date(fechaActual.getTime());

            System.out.println(workerID);
            System.out.println(actualDate);

            String query1= "insert into info_eskaerak (id_langilea, data, aldaketa, egoera, mota) VALUES (?,?,?,'irekia','info aldaketa')";
            PreparedStatement statement = getConexion().prepareStatement(query1);
            statement.setInt(1,workerID);
            statement.setDate(2,actualDate);
            statement.setString(3,jsonString);
            statement.execute();

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

    }




    public void createProvider(String izena, String helbidea, String kontaktua) {
        try {
            String query = "INSERT INTO hornitzaileak (izena, helbidea, kontaktua) VALUES (?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, izena);
            statement.setString(2, helbidea);
            statement.setString(3, kontaktua);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public int getIdProvider(String izena){
        int idProvider=0;
        try{
            String query ="Select id_hornitzailea from hornitzaileak where izena like ?";
            PreparedStatement statement=conexion.prepareStatement(query);
            statement.setString(1,izena);
            ResultSet id_provider_set= statement.executeQuery();
            while(id_provider_set.next()){
                idProvider= id_provider_set.getInt(1);



            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idProvider;
    }
}

