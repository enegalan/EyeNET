package eyenet.view.render;

import eyenet.controller.db.adminDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JComboBoxEditor extends DefaultCellEditor implements ActionListener {
    private JComboBox<String> comboBox;
    private DefaultTableModel model;
    private JTable table;
    private int selectedRow;
    private int selectedColumn;
    private adminDB adminDB = new adminDB();

    public JComboBoxEditor(String[] items) throws IOException {
        super(new JComboBox<String>(items));
        comboBox = (JComboBox<String>) getComponent();

    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        comboBox.setSelectedItem(value);
        comboBox.showPopup(); // mostrar el JComboBox automáticamente
        return comboBox;
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.selectedColumn = column;
        this.selectedRow = row;
        this.model = (DefaultTableModel) table.getModel();
        this.table = table;
        // Seleccionar el elemento correspondiente en el JComboBox
        comboBox.setSelectedItem(value);
        comboBox.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(comboBox); // agregar el JComboBox al panel contenedor

        return panel;
    }

    public Object getCellEditorValue() {
        // Devolver el elemento seleccionado en el JComboBox
        return comboBox.getSelectedItem();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(comboBox)){
            int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to change role?");
            if(option == JOptionPane.YES_OPTION){
                String newRol = (String)comboBox.getModel().getSelectedItem();
                Object idUserObj = model.getValueAt(selectedRow,0);
                adminDB.changeWorkerRole(idUserObj,newRol);
            }else {
                fireEditingCanceled();
            }
        }
    }
}