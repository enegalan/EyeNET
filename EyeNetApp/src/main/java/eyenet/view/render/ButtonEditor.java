/*
 * Copyright (c) 2023.
 */

package eyenet.view.render;

import eyenet.controller.db.adminDB;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import eyenet.controller.db.adminDB;
import eyenet.controller.db.workerDB;
import eyenet.model.Erabiltzailea;
import eyenet.model.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;

import static eyenet.controller.gestorDB.session;
import static java.lang.Math.round;

public class ButtonEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private final JButton[] buttons;
    private int selectedRow;
    private int selectedColumn;
    private adminDB adminDB;

    {
        try {
            adminDB = new adminDB();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JTable table;
    private DefaultTableModel model;
    private String tableName;
    private Session session;
    private JComboBox<String> comboBox;

    public ButtonEditor(JTable mainTable, String tableName, Session session) {
        this.session = session;
        this.table=mainTable;
        this.model = (DefaultTableModel) this.table.getModel();
        this.buttons = new JButton[3];
        this.tableName = tableName;

    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return getButtonPanel(row);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.selectedRow = row;
        this.selectedColumn = column;
        this.table = table;
        return getButtonPanel(row);
    }

    private JPanel getButtonPanel(int row) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        this.buttons[1] = new JButton(new ImageIcon("src/main/java/eyenet/view/images/decline.png"));

        if(this.tableName.equals("Consults")){
            Object egoeraObject = model.getValueAt(row, 6);
            String egoera = egoeraObject.toString();
            this.buttons[0] = new JButton(new ImageIcon("src/main/java/eyenet/view/images/email.png"));

            if (egoera.equals("irekia")) {
                panel.add(this.buttons[0]);
                panel.add(this.buttons[1]);
            }
        }
        if(this.tableName.equals("Info-Change")){
            Object egoeraObject = model.getValueAt(row, 5);
            String egoera = egoeraObject.toString();
            this.buttons[0] = new JButton(new ImageIcon("src/main/java/eyenet/view/images/accept.png"));
            if (egoera.equals("irekia")) {
                panel.add(this.buttons[0]);
                panel.add(this.buttons[1]);
            }
        }
        /*if (this.tableName.equals("Rols")){
            String[] roles = {"langile arrunta","giza baliabidea","admin","ceo"};
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (String role : roles){
                model.addElement(role);
            }
            JComboBox<String> comboBox = new JComboBox<>(model);
            comboBox.setEditable(false);
            comboBox.requestFocus();
            panel.add(comboBox);
            comboBox.addActionListener(this);
        }*/
        if(this.tableName.equals("Internal Orders") || this.tableName.equals("Bills")){
            this.buttons[0] = new JButton(new ImageIcon("src/main/java/eyenet/view/images/eye.png"));
            panel.add(this.buttons[0]);
        }
        if(this.tableName.equals("External Orders")){

                Object workerObject = model.getValueAt(row, 2);
                String workerName = (String)workerObject;
                if(workerName == null){
                    this.buttons[0] = new JButton(new ImageIcon("src/main/java/eyenet/view/images/accept.png"));
                    panel.add(this.buttons[0]);
                }else{
                    this.buttons[0] = new JButton(new ImageIcon("src/main/java/eyenet/view/images/eye.png"));
                    panel.add(this.buttons[0]);
                }

        }
        if (this.tableName.equals("Products IntOrder")){

            JSpinner spinnerNumber = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
            panel.add(spinnerNumber);
            spinnerNumber.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int stock = (int)model.getValueAt(selectedRow,5);
                    if(stock > 0 && stock >= (int)spinnerNumber.getModel().getValue()) {
                        double price = (double)model.getValueAt(selectedRow,4);
                        double total = round(price * (int)spinnerNumber.getModel().getValue());
                        model.setValueAt(total,selectedRow,7);
                    }else{
                        spinnerNumber.getModel().setValue(stock);
                        JOptionPane.showMessageDialog(null,"You exceeded the actual stock!");

                    }
                }
            });
        }

        if(this.tableName.equals("Consults") || this.tableName.equals("Info-Change") || this.tableName.equals("Internal Orders") || this.tableName.equals("External Orders") || this.tableName.equals("Bills")) {

            /*buttons[0].addActionListener(this);
            buttons[0].setBackground(new Color(255, 255, 255));
            buttons[1].addActionListener(this);
            buttons[1].setBackground(new Color(255, 255, 255));*/

            for (JButton button: buttons){
                if(button != null){
                    button.addActionListener(this);
                    button.setBackground(new Color(255,255,255));
                }

            }

        }

        return panel;


    }

    public Object getCellEditorValue() {
        return null;
    }

    public void actionPerformed(ActionEvent e) {
        if(this.tableName.equals("Info-Change")){
            if(e.getSource().equals(this.buttons[0])){
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to apply this change?");
                if (option == JOptionPane.YES_OPTION) {
                    Object orderID = model.getValueAt(selectedRow,0);
                    Object workerUsername = model.getValueAt(selectedRow,1);
                    Object changes = model.getValueAt(selectedRow,4);

                    adminDB.acceptInfoChange(workerUsername,changes,orderID);
                } else {
                    fireEditingCanceled();
                }
            }else{
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to decline this change?");
                if (option == JOptionPane.YES_OPTION) {
                    Object orderID = model.getValueAt(selectedRow,0);
                    adminDB.declineRequest(orderID);
                } else {
                    fireEditingCanceled();
                }
            }

        }
        if(this.tableName.equals("Consults")){
            if(e.getSource().equals(this.buttons[0])){
                String answer = JOptionPane.showInputDialog(null,"Write an answer:");
                if (answer != null){


                    Erabiltzailea user = session.getUser();
                    int id = user.getId_user();
                    Object orderID = model.getValueAt(selectedRow, 0);
                    adminDB.answerConsult(id,answer,orderID);
                }else{
                    fireEditingCanceled();
                }
            }
            else{
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to close this consult?");
                if (option == JOptionPane.YES_OPTION) {
                    Object orderID = model.getValueAt(selectedRow,0);
                    adminDB.declineRequest(orderID);
                } else {
                    fireEditingCanceled();
                }
            }

        }

        if(this.tableName.equals("Internal Orders")){
            int orderID = (int)model.getValueAt(selectedRow,0);
            JFrame internalOrderFrame = new JFrame("EyeNet | Internal Order Products");
            internalOrderFrame.setSize(900,705);
            internalOrderFrame.setLocationRelativeTo(null);
            internalOrderFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            internalOrderFrame.setVisible(true);
            internalOrderFrame.setResizable(false);

            JPanel internalOrdersProductsTablePanel = new JPanel();

            workerDB workerDB = null;
            try {
                workerDB = new workerDB();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            String[] internalOrdersColumns = new String[]{"id_eskaera", "ProductName", "ProviderName", "Amount"};
            DefaultTableModel internalOrdersTableModel = new DefaultTableModel(internalOrdersColumns, 0);
            Object[][] internalOrdersData = workerDB.listBeEdukiPToTable(orderID); // LE PASAMOS ID_ESKAERA
            for(int i = 0; i < internalOrdersData.length;i++){
                internalOrdersTableModel.addRow(internalOrdersData[i]);
            }
            JTable internalOrdersTable = new JTable(internalOrdersTableModel);

            //ESTILO PARA LA TABLA
            CellRenderer infoChangeRenderer = new CellRenderer(null,"Internal Order Products", internalOrdersTable);
            internalOrdersTable.getTableHeader().setDefaultRenderer(infoChangeRenderer);

            JScrollPane scrollinternalOrdersTablePanel = new JScrollPane(internalOrdersTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollinternalOrdersTablePanel.getVerticalScrollBar().setUnitIncrement(30);
            internalOrdersProductsTablePanel.add(scrollinternalOrdersTablePanel);

            internalOrderFrame.add(internalOrdersProductsTablePanel);

        }
        if(this.tableName.equals("External Orders")){
            Object workerObject = model.getValueAt(selectedRow, 2);
            String workerName = (String)workerObject;
            int orderID = (int)model.getValueAt(selectedRow,0);
            if(workerName == null){
                int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to start ordering process?");
                if(option == JOptionPane.YES_OPTION){
                    workerDB workerDB = null;
                    try {
                        workerDB = new workerDB();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    workerDB.acceptExternalOrder(orderID,session.getUser().getId_user());
                }else {fireEditingCanceled();}
            }else{
                JFrame externalOrderFrame = new JFrame("EyeNet | External Order Products");
                externalOrderFrame.setSize(900,705);
                externalOrderFrame.setLocationRelativeTo(null);
                externalOrderFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                externalOrderFrame.setVisible(true);
                externalOrderFrame.setResizable(false);

                JPanel externalOrdersProductsTablePanel = new JPanel();

                workerDB workerDB = null;
                try {
                    workerDB = new workerDB();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                String[] externalOrdersColumns = new String[]{"id_eskaera", "ProductName", "ProviderName", "Amount"};
                DefaultTableModel externalOrdersTableModel = new DefaultTableModel(externalOrdersColumns, 0);
                Object[][] externalOrdersData = workerDB.listEEdukiPToTable(orderID); // LE PASAMOS ID_ESKAERA
                for(int i = 0; i < externalOrdersData.length;i++){
                    externalOrdersTableModel.addRow(externalOrdersData[i]);
                }
                JTable externalOrdersTable = new JTable(externalOrdersTableModel);

                //ESTILO PARA LA TABLA
                CellRenderer ExternalRenderer = new CellRenderer(null,"External Order Products", externalOrdersTable);
                externalOrdersTable.getTableHeader().setDefaultRenderer(ExternalRenderer);

                JScrollPane scrollinternalOrdersTablePanel = new JScrollPane(externalOrdersTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollinternalOrdersTablePanel.getVerticalScrollBar().setUnitIncrement(30);
                externalOrdersProductsTablePanel.add(scrollinternalOrdersTablePanel);

                externalOrderFrame.add(externalOrdersProductsTablePanel);
            }
        }
        if(this.tableName.equals("Bills")){
            workerDB workerDB = null;
            try {
                workerDB = new workerDB();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Object billID = model.getValueAt(selectedRow,0);
            int orderID = workerDB.getOrderID((int)billID);
            JFrame billsFrame = new JFrame("EyeNet | Bill Information");
            billsFrame.setSize(900,705);
            billsFrame.setLocationRelativeTo(null);
            billsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            billsFrame.setVisible(true);
            billsFrame.setResizable(false);

            JPanel mainBillPanel = new JPanel();
            mainBillPanel.setLayout(new BoxLayout(mainBillPanel,BoxLayout.Y_AXIS));

            JPanel billInfoPanel = new JPanel();
            JPanel billInfoPanelContent = new JPanel(new GridLayout(6,2,30,15));

            JLabel id_eskaeraText = new JLabel("Order ID:");
            JTextField id_eskaeraTextField = new JTextField();
            id_eskaeraTextField.setEnabled(false);
            String orderIDString = String.valueOf(orderID);
            id_eskaeraTextField.setText(orderIDString);

            JLabel statusText = new JLabel("Status:");
            JTextField statusTextField = new JTextField();
            statusTextField.setEnabled(false);
            String statusString = workerDB.getEgoera(orderID);
            statusTextField.setText(statusString);

            JLabel clientText = new JLabel("Client:");
            JTextField clientTextField = new JTextField();
            clientTextField.setEnabled(false);
            String clientString = workerDB.getClientUsername(orderID);
            clientTextField.setText(clientString);

            JLabel workerText = new JLabel("Worker:");
            JTextField workerTextField = new JTextField();
            workerTextField.setEnabled(false);
            String workerString = workerDB.getWorkerUsername(orderID);
            workerTextField.setText(workerString);

            JLabel arriveDateText = new JLabel("Arrive date:");
            JTextField arriveDateTextField = new JTextField();
            arriveDateTextField.setEnabled(false);
            String arriveDateString = workerDB.getArriveDate(orderID);
            arriveDateTextField.setText(arriveDateString);

            JLabel firstPriceText = new JLabel("First price:");
            JTextField firstPriceTextField = new JTextField();
            firstPriceTextField.setEnabled(false);
            String firstPriceString = workerDB.getFirstPrice(orderID);
            firstPriceTextField.setText(firstPriceString);

            JLabel discountText = new JLabel("Discount:");
            JTextField discountTextField = new JTextField();
            discountTextField.setEnabled(false);
            String discountString = workerDB.getDiscount(orderID);
            discountTextField.setText(discountString);

            JLabel finalPriceText = new JLabel("Final price:");
            JTextField finalPriceTextField = new JTextField();
            finalPriceTextField.setEnabled(false);
            String finalPriceString = workerDB.getFinalPrice(orderID);
            finalPriceTextField.setText(finalPriceString);

            JLabel addressText = new JLabel("Address:");
            JTextField addressTextField = new JTextField();
            addressTextField.setEnabled(false);
            String addressString = workerDB.getAddress(orderID);
            addressTextField.setText(addressString);

            JLabel onlineText = new JLabel("Online:");
            JTextField onlineTextField = new JTextField();
            onlineTextField.setEnabled(false);
            String onlineString = workerDB.getOnline(orderID);
            onlineTextField.setText(onlineString);

            JLabel paymentText = new JLabel("Payment method:");
            JTextField paymentTextField = new JTextField();
            paymentTextField.setEnabled(false);
            String paymentString = workerDB.getPaymentMethod(orderID);
            paymentTextField.setText(paymentString);

            JLabel creditNumberText = new JLabel("Credit number:");
            JTextField creditNumberTextField = new JTextField();
            creditNumberTextField.setEnabled(false);
            String creditString = workerDB.getCreditNumber(orderID);
            creditNumberTextField.setText(creditString);


            billInfoPanelContent.add(id_eskaeraText);
            billInfoPanelContent.add(id_eskaeraTextField);
            billInfoPanelContent.add(statusText);
            billInfoPanelContent.add(statusTextField);
            billInfoPanelContent.add(clientText);
            billInfoPanelContent.add(clientTextField);
            billInfoPanelContent.add(workerText);
            billInfoPanelContent.add(workerTextField);
            billInfoPanelContent.add(arriveDateText);
            billInfoPanelContent.add(arriveDateTextField);
            billInfoPanelContent.add(firstPriceText);
            billInfoPanelContent.add(firstPriceTextField);
            billInfoPanelContent.add(discountText);
            billInfoPanelContent.add(discountTextField);
            billInfoPanelContent.add(finalPriceText);
            billInfoPanelContent.add(finalPriceTextField);
            billInfoPanelContent.add(addressText);
            billInfoPanelContent.add(addressTextField);
            billInfoPanelContent.add(onlineText);
            billInfoPanelContent.add(onlineTextField);
            billInfoPanelContent.add(paymentText);
            billInfoPanelContent.add(paymentTextField);
            billInfoPanelContent.add(creditNumberText);
            billInfoPanelContent.add(creditNumberTextField);

            billInfoPanel.add(billInfoPanelContent);


            JPanel billProductsTablePanel = new JPanel();

            String[] billColumns = new String[]{"id_produktua", "ProductName", "ProviderName", "Amount"};
            DefaultTableModel billTableModel = new DefaultTableModel(billColumns, 0);
            Object[][] billData = workerDB.listEEdukiPToTable(orderID); // LE PASAMOS ID_ESKAERA
            for(int i = 0; i < billData.length;i++){
                billTableModel.addRow(billData[i]);
            }
            JTable billTable = new JTable(billTableModel);

            //ESTILO PARA LA TABLA
            CellRenderer billRenderer = new CellRenderer(null,"Bill Information", billTable);
            billTable.getTableHeader().setDefaultRenderer(billRenderer);

            JScrollPane scrollBillTablePanel = new JScrollPane(billTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollBillTablePanel.getVerticalScrollBar().setUnitIncrement(30);
            billProductsTablePanel.add(scrollBillTablePanel);

            mainBillPanel.add(billInfoPanel);
            mainBillPanel.add(billProductsTablePanel);

            billsFrame.add(mainBillPanel);

        }

    }


}