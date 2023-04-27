/*
 * Copyright (c) 2023.
 */

package eyenet.view.render;
import eyenet.model.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class HeaderRenderer extends DefaultTableCellRenderer {
    private final int[] arrowColumnIndexes;

    private final String tableName;
    private final JTable table;
    private Session session;
    public HeaderRenderer(int[] arrowColumnIndexes, String tableName, JTable table, Session session) {
        this.session = session;
        this.arrowColumnIndexes = arrowColumnIndexes;
        this.tableName = tableName;
        this.table = table;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setFont(new Font("eyenet/fonts/rubik.ttf", Font.PLAIN, 14));
        setForeground(new Color(33, 33, 33));
        setBackground(new Color(182, 182, 182)); // Fondo del encabezado
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(37, 23, 86))); // Borde inferior de 2px
        setHorizontalAlignment(JLabel.CENTER); // Alineación del texto centrado
        JTableHeader header = table.getTableHeader();
        setPreferredSize(new Dimension(header.getColumnModel().getColumn(column).getWidth(), 40)); // Altura del encabezado

        boolean isAscending = true;
        if (arrowColumnIndexes != null && arrowColumnIndexes.length > 0) {
            int modelColumnIndex = table.convertColumnIndexToModel(column);
            for (int arrowColumnIndex : arrowColumnIndexes) {
                if (modelColumnIndex == arrowColumnIndex) {
                    if (table.getRowSorter() != null) {
                        for (RowSorter.SortKey sortKey : table.getRowSorter().getSortKeys()) {
                            if (sortKey.getColumn() == modelColumnIndex) {
                                isAscending = sortKey.getSortOrder() == SortOrder.ASCENDING;
                                break;
                            }
                        }
                    }
                    // Agregar flecha en función del ordenamiento
                    if (isAscending) {
                        this.setText(value + " ▲");
                        if(this.tableName.equals("Info-Change")){
                            table.getColumnModel().getColumn(6).setCellRenderer(new ButtonEditor(table,tableName,session));
                            table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(table,tableName,session));
                        }
                        if(this.tableName.equals("Consults")){
                            table.getColumnModel().getColumn(7).setCellRenderer(new ButtonEditor(table,tableName,session));
                            table.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(table,tableName,session));
                        }
                    } else {
                        this.setText(value + " ▼");
                    }
                    return this;
                }
            }
        }
        this.setText(value.toString());
        return this;
    }
}
