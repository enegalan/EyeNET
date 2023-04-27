/*
 * Copyright (c) 2023.
 */

package eyenet.view.render;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

import static eyenet.controller.gestorDB.session;

public class CellRenderer extends DefaultTableCellRenderer {
    private int[] arrowColumnIndexes; // Índices de las columnas en las que se mostrará una flecha
    private final Color colorSelected = new Color(77, 171, 199); // Fondo de fila seleccionada
    private final Color colorEven = new Color(141, 39, 39); // Fondo de fila par
    private final Color colorOdd = new Color(37, 23, 86); // Fondo de fila impar
    private String tableName;
    private JTable table;
    public CellRenderer(int[] arrowColumnIndexes, String tableName, JTable table) {
        super();
        this.arrowColumnIndexes = arrowColumnIndexes;
        this.tableName = tableName;
        this.table = table;

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        table.setBorder(BorderFactory.createLineBorder(new Color(224, 224, 224)));
        table.setGridColor(new Color(224, 224, 224)); // Color de borde de celda
        table.setRowHeight(48); // Altura de fila
        table.setSelectionBackground(new Color(238, 238, 238));
        table.setBorder(new EmptyBorder(0,0,0,80));
        table.setPreferredScrollableViewportSize(new Dimension(850, 600));
        this.setFont(new Font("eyenet/fonts/rubik.ttf",Font.PLAIN,14));
        this.setForeground(new Color(33, 33, 33));

        if (isSelected) {
            this.setBackground(table.getSelectionBackground());
        } else {
            if (row % 2 == 0) {
                this.setBackground(new Color(141, 39, 39)); // Fondo de fila par
            } else {
                this.setBackground(new Color(221, 221, 221)); // Fondo de fila impar
            }
        }

        //ESTABLECER WIDTH DE LAS COLUMNAS
        if(this.tableName.equals("Workers")){
            table.getColumnModel().getColumn(0).setWidth(90);
            table.getColumnModel().getColumn(0).setMinWidth(90);

            table.getColumnModel().getColumn(1).setWidth(70);
            table.getColumnModel().getColumn(1).setMinWidth(70);

            table.getColumnModel().getColumn(2).setWidth(50);
            table.getColumnModel().getColumn(2).setMinWidth(50);

            table.getColumnModel().getColumn(3).setWidth(40);
            table.getColumnModel().getColumn(3).setMinWidth(40);

            table.getColumnModel().getColumn(4).setWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(100);

            table.getColumnModel().getColumn(5).setWidth(40);
            table.getColumnModel().getColumn(5).setMinWidth(40);

            table.getColumnModel().getColumn(6).setWidth(80);
            table.getColumnModel().getColumn(6).setMinWidth(80);

            table.getColumnModel().getColumn(7).setWidth(80);
            table.getColumnModel().getColumn(7).setMinWidth(80);

            table.getColumnModel().getColumn(8).setWidth(100);
            table.getColumnModel().getColumn(8).setMinWidth(100);

            table.getColumnModel().getColumn(9).setWidth(90);
            table.getColumnModel().getColumn(9).setMinWidth(90);
        }
        if(this.tableName.equals("Products")){
            table.getColumnModel().getColumn(0).setWidth(120);
            table.getColumnModel().getColumn(0).setMinWidth(120);

            table.getColumnModel().getColumn(1).setWidth(120);
            table.getColumnModel().getColumn(1).setMinWidth(120);

            table.getColumnModel().getColumn(2).setWidth(80);
            table.getColumnModel().getColumn(2).setMinWidth(80);

            table.getColumnModel().getColumn(3).setWidth(150);
            table.getColumnModel().getColumn(3).setMinWidth(150);

            table.getColumnModel().getColumn(4).setWidth(80);
            table.getColumnModel().getColumn(4).setMinWidth(80);

            table.getColumnModel().getColumn(5).setWidth(80);
            table.getColumnModel().getColumn(5).setMinWidth(80);
        }
        if(this.tableName.equals("Payrolls")){
            table.getColumnModel().getColumn(0).setWidth(90);
            table.getColumnModel().getColumn(0).setMinWidth(90);

            table.getColumnModel().getColumn(1).setWidth(70);
            table.getColumnModel().getColumn(1).setMinWidth(70);

            table.getColumnModel().getColumn(2).setWidth(125);
            table.getColumnModel().getColumn(2).setMinWidth(125);

            table.getColumnModel().getColumn(3).setWidth(40);
            table.getColumnModel().getColumn(3).setMinWidth(40);

            table.getColumnModel().getColumn(4).setWidth(60);
            table.getColumnModel().getColumn(4).setMinWidth(60);

            table.getColumnModel().getColumn(5).setWidth(40);
            table.getColumnModel().getColumn(5).setMinWidth(40);

            table.getColumnModel().getColumn(6).setWidth(90);
            table.getColumnModel().getColumn(6).setMinWidth(90);

            table.getColumnModel().getColumn(7).setWidth(80);
            table.getColumnModel().getColumn(7).setMinWidth(80);

            table.getColumnModel().getColumn(8).setWidth(60);
            table.getColumnModel().getColumn(8).setMinWidth(60);

            table.getColumnModel().getColumn(9).setWidth(100);
            table.getColumnModel().getColumn(9).setMinWidth(100);

            table.getColumnModel().getColumn(10).setWidth(100);
            table.getColumnModel().getColumn(10).setMinWidth(100);
        }
        if(this.tableName.equals("Info-Change")){
            table.getColumnModel().getColumn(0).setWidth(70);
            table.getColumnModel().getColumn(0).setMinWidth(70);

            table.getColumnModel().getColumn(1).setWidth(120);
            table.getColumnModel().getColumn(1).setMinWidth(120);

            table.getColumnModel().getColumn(2).setWidth(120);
            table.getColumnModel().getColumn(2).setMinWidth(120);

            table.getColumnModel().getColumn(3).setWidth(100);
            table.getColumnModel().getColumn(3).setMinWidth(100);

            table.getColumnModel().getColumn(4).setWidth(140);
            table.getColumnModel().getColumn(4).setMinWidth(140);

            table.getColumnModel().getColumn(5).setWidth(90);
            table.getColumnModel().getColumn(5).setMinWidth(90);

            table.getColumnModel().getColumn(6).setWidth(90);
            table.getColumnModel().getColumn(6).setMinWidth(90);
        }
        if(this.tableName.equals("Consults")){
            table.getColumnModel().getColumn(0).setWidth(70);
            table.getColumnModel().getColumn(0).setMinWidth(70);

            table.getColumnModel().getColumn(1).setWidth(120);
            table.getColumnModel().getColumn(1).setMinWidth(120);

            table.getColumnModel().getColumn(2).setWidth(120);
            table.getColumnModel().getColumn(2).setMinWidth(120);

            table.getColumnModel().getColumn(3).setWidth(80);
            table.getColumnModel().getColumn(3).setMinWidth(80);

            table.getColumnModel().getColumn(4).setWidth(110);
            table.getColumnModel().getColumn(4).setMinWidth(110);

            table.getColumnModel().getColumn(5).setWidth(110);
            table.getColumnModel().getColumn(5).setMinWidth(110);

            table.getColumnModel().getColumn(6).setWidth(60);
            table.getColumnModel().getColumn(6).setMinWidth(60);

            table.getColumnModel().getColumn(7).setWidth(90);
            table.getColumnModel().getColumn(7).setMinWidth(90);
        }
        if(this.tableName.equals("Messages")){
            table.getColumnModel().getColumn(0).setWidth(70);
            table.getColumnModel().getColumn(0).setMinWidth(70);

            table.getColumnModel().getColumn(1).setWidth(70);
            table.getColumnModel().getColumn(1).setMinWidth(70);

            table.getColumnModel().getColumn(2).setWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(100);

            table.getColumnModel().getColumn(3).setWidth(100);
            table.getColumnModel().getColumn(3).setMinWidth(100);

            table.getColumnModel().getColumn(4).setWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(100);

            table.getColumnModel().getColumn(5).setWidth(90);
            table.getColumnModel().getColumn(5).setMinWidth(90);
        }
        if(this.tableName.equals("Internal Orders")){
            table.getColumnModel().getColumn(0).setWidth(90);
            table.getColumnModel().getColumn(0).setMinWidth(90);

            table.getColumnModel().getColumn(1).setWidth(110);
            table.getColumnModel().getColumn(1).setMinWidth(110);

            table.getColumnModel().getColumn(2).setWidth(120);
            table.getColumnModel().getColumn(2).setMinWidth(120);

            table.getColumnModel().getColumn(3).setWidth(120);
            table.getColumnModel().getColumn(3).setMinWidth(120);

            table.getColumnModel().getColumn(4).setWidth(80);
            table.getColumnModel().getColumn(4).setMinWidth(80);
            table.getColumnModel().getColumn(4).setMaxWidth(80);

        }
        if(this.tableName.equals("Internal Order Products")){
            table.getColumnModel().getColumn(0).setWidth(90);
            table.getColumnModel().getColumn(0).setMinWidth(90);

            table.getColumnModel().getColumn(1).setWidth(110);
            table.getColumnModel().getColumn(1).setMinWidth(110);

            table.getColumnModel().getColumn(2).setWidth(120);
            table.getColumnModel().getColumn(2).setMinWidth(120);

            table.getColumnModel().getColumn(3).setWidth(120);
            table.getColumnModel().getColumn(3).setMinWidth(120);

        }



        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new HeaderRenderer(arrowColumnIndexes,this.tableName,this.table,session));

        this.setText(value.toString());

        return this;
    }
}