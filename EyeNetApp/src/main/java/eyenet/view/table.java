/*
 * Copyright (c) 2023.
 */

package eyenet.view;

import eyenet.controller.db.adminDB;
import eyenet.controller.db.loginDB;
import eyenet.controller.db.workerDB;
import eyenet.view.render.CellRenderer;
import eyenet.controller.db.tablesDB;
import eyenet.view.tools.tools;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.RowSorter;

public class table extends JFrame implements ActionListener {
    private JLabel barsImage,userImage,dashboardImage,dashboardText,layoutImage,layoutsText,modulesImage,modulesText, statisticsImage, statisticsText,databasesImage,databaseText, assignmentsImage,assignmentsText,settingsImage,settingsText,languageImage,languageText,darkModeImage,darkModeText,logOutImage,logOutText,toolsText, toolsImage;
    private JLabel tableNameText,searchText,totalEntriesText,totalEntriesNum;
    private JPanel leftPanelContent,right4Panelcontent, right4Panel, right3Panelcontent, right3Panel, right2Panel, right2Panelcontent, right1Panelcontent,rightContent,rightPanel,main, leftPanel,header,leftHeader,leftHeaderContent,rightHeader,rightHeaderContent,link1Panel,link1PanelContent,link2Panel,link2PanelContent,link3Panel,link3PanelContent,link4Panel,link4PanelContent,link5Panel,link5PanelContent,link6Panel,link6PanelContent,link7Panel,link7PanelContent,right1Panel;
    private JPanel centerPanel,centerPanelContent,mainPanel,northTablePanel,tableFieldsPanel,centerTablePanel,tablePanel,topTablePanel,tableButtonsPanel,searchPanel,bottomTablePanel,centralTablePanel,backPanel;
    private ImageIcon settingIcon,languageIcon,darkModeIcon,logOutImageIcon,barsIcon,userIcon,dashboardIcon,layoutsIcon,modulesIcon, statisticsIcon,databasesIcon, assignmentsIcon, toolsIcon;
    private JButton copyButton,xmlButton,orderByButton,sortOrderButton,backButton;
    private JSeparator tablePanelSeparator;
    private JTextField searchField;
    private String[] columns;
    private Object[][] data;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane mainScroll,scrollTablePanel;
    private tablesDB tablesDB;
    private TableRowSorter<TableModel> sorter;
    private ArrayList<RowSorter.SortKey> sortKeys;
    private int[] arrowColumnIndexes;
    /*COLORS RGB*/
    private static final Color main_color = new Color(39,109,144);
    private static final Color blue_color = new Color(60, 123, 143);
    private static final Color first_color = new Color(206,207,201);
    private static final Color dark_color = new Color(10,49,67);
    private static final Color light_color = new Color(239,239,239);

    private String tableName;
    public table(String tableName) throws IOException, FontFormatException {
        this.tableName = tableName;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("EyeNet");
        this.setPreferredSize(new Dimension(1300, 800));
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setBackground(light_color);

        main = new JPanel(new BorderLayout());

        //HEADER
        header = new JPanel(new BorderLayout());
        header.setBackground(main_color);
        main.add(header,BorderLayout.NORTH);

        leftHeader = new JPanel();
        leftHeader.setBorder(new EmptyBorder(10,15,10,0));
        leftHeader.setBackground(main_color);
        leftHeaderContent = new JPanel();
        leftHeaderContent.setBackground(main_color);
        barsIcon = new ImageIcon("src/main/java/eyenet/view/images/bars.png");
        barsImage = new JLabel(barsIcon);
        leftHeaderContent.add(barsImage);
        leftHeader.add(leftHeaderContent);
        header.add(leftHeader,BorderLayout.WEST);

        rightHeader = new JPanel();
        rightHeader.setBorder(new EmptyBorder(10,0,10,15));
        rightHeader.setBackground(main_color);
        rightHeaderContent = new JPanel();
        rightHeaderContent.setBackground(main_color);
        userIcon = new ImageIcon("src/main/java/eyenet/view/images/user.png");
        userImage = new JLabel(userIcon);
        rightHeaderContent.add(userImage);
        rightHeader.add(rightHeaderContent);
        header.add(rightHeader,BorderLayout.EAST);


        //PANEL IZQUIERDO

        //Crear el panel izquierdo
        leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        leftPanel.setBackground(main_color);

        leftPanelContent = new JPanel();
        leftPanelContent.setLayout(new BoxLayout(leftPanelContent, BoxLayout.Y_AXIS));
        leftPanelContent.setBackground(blue_color);

        link1Panel = new JPanel();
        link1Panel.setLayout(new BoxLayout(link1Panel, BoxLayout.Y_AXIS));
        link1Panel.setBackground(blue_color);
        link1PanelContent = new JPanel();
        link1PanelContent.setBackground(blue_color);
        link1PanelContent.setBorder(new EmptyBorder(10,30,10,120));
        dashboardIcon = new ImageIcon ("src/main/java/eyenet/view/images/dashboard.png");
        dashboardImage = new JLabel(dashboardIcon);
        dashboardText = new JLabel("Dashboard");
        link1PanelContent.add(dashboardImage);
        link1PanelContent.add(dashboardText);
        link1Panel.add(link1PanelContent);
        link1Panel.add(new JSeparator());

        link2Panel = new JPanel();
        link2Panel.setLayout(new BoxLayout(link2Panel, BoxLayout.Y_AXIS));
        link2Panel.setBackground(blue_color);
        link2PanelContent = new JPanel();
        link2PanelContent.setBackground(blue_color);
        link2PanelContent.setBorder(new EmptyBorder(10,16,10,120));
        layoutsIcon = new ImageIcon("src/main/java/eyenet/view/images/layouts.png");
        layoutImage = new JLabel(layoutsIcon);
        layoutsText = new JLabel("Layouts");
        link2PanelContent.add(layoutImage);
        link2PanelContent.add(layoutsText);
        link2Panel.add(link2PanelContent);
        link2Panel.add(new JSeparator());

        link3Panel = new JPanel();
        link3Panel.setLayout(new BoxLayout(link3Panel, BoxLayout.Y_AXIS));
        link3Panel.setBackground(blue_color);
        link3PanelContent = new JPanel();
        link3PanelContent.setBackground(blue_color);
        link3PanelContent.setBorder(new EmptyBorder(10,18,10,120));
        modulesIcon = new ImageIcon("src/main/java/eyenet/view/images/modules.png");
        modulesImage = new JLabel(modulesIcon);
        modulesText = new JLabel("Modules");
        link3PanelContent.add(modulesImage);
        link3PanelContent.add(modulesText);
        link3Panel.add(link3PanelContent);
        link3Panel.add(new JSeparator());

        link4Panel = new JPanel();
        link4Panel.setLayout(new BoxLayout(link4Panel, BoxLayout.Y_AXIS));
        link4Panel.setBackground(blue_color);
        link4PanelContent = new JPanel();
        link4PanelContent.setBackground(blue_color);
        link4PanelContent.setBorder(new EmptyBorder(10,25,10,120));
        statisticsIcon = new ImageIcon("src/main/java/eyenet/view/images/stats.png");
        statisticsImage = new JLabel(statisticsIcon);
        statisticsText = new JLabel("Statistics");
        link4PanelContent.add(statisticsImage);
        link4PanelContent.add(statisticsText);
        link4Panel.add(link4PanelContent);
        link4Panel.add(new JSeparator());

        link5Panel = new JPanel();
        link5Panel.setLayout(new BoxLayout(link5Panel, BoxLayout.Y_AXIS));
        link5Panel.setBackground(blue_color);
        link5PanelContent = new JPanel();
        link5PanelContent.setBackground(blue_color);
        link5PanelContent.setBorder(new EmptyBorder(10,-20,10,70));
        databasesIcon = new ImageIcon("src/main/java/eyenet/view/images/database.png");
        databasesImage = new JLabel(databasesIcon);
        databaseText = new JLabel("Databases");
        link5PanelContent.add(databasesImage);
        link5PanelContent.add(databaseText);
        link5Panel.add(link5PanelContent);
        link5Panel.add(new JSeparator());


        link6Panel = new JPanel();
        link6Panel.setLayout(new BoxLayout(link6Panel, BoxLayout.Y_AXIS));
        link6Panel.setBackground(blue_color);
        link6PanelContent = new JPanel();
        link6PanelContent.setBackground(blue_color);
        link6PanelContent.setBorder(new EmptyBorder(10,36,10,120));
        assignmentsIcon = new ImageIcon("src/main/java/eyenet/view/images/assigments.png");
        assignmentsImage = new JLabel(assignmentsIcon);
        assignmentsText = new JLabel("Assigments");
        link6PanelContent.add(assignmentsImage);
        link6PanelContent.add(assignmentsText);
        link6Panel.add(link6PanelContent);
        link6Panel.add(new JSeparator());

        link7Panel = new JPanel();
        link7Panel.setLayout(new BoxLayout(link7Panel, BoxLayout.Y_AXIS));
        link7Panel.setBackground(blue_color);
        link7PanelContent = new JPanel();
        link7PanelContent.setBackground(blue_color);
        link7PanelContent.setBorder(new EmptyBorder(10,0,10,120));
        toolsIcon = new ImageIcon("src/main/java/eyenet/view/images/tools.png");
        toolsImage = new JLabel(toolsIcon);
        toolsText = new JLabel("Tools");
        link7PanelContent.add(toolsImage);
        link7PanelContent.add(toolsText);
        link7Panel.add(link7PanelContent);
        link7Panel.add(new JSeparator());



        leftPanelContent.add(link1Panel);
        leftPanelContent.add(link2Panel);
        leftPanelContent.add(link3Panel);
        leftPanelContent.add(link4Panel);
        leftPanelContent.add(link5Panel);
        leftPanelContent.add(link6Panel);
        leftPanelContent.add(link6Panel);
        leftPanelContent.add(link7Panel);

        leftPanel.add(leftPanelContent);


        //PANEL USUARIO
        //Crear el panel derecho y añadir el panel del contenido.
        rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        //Crear el panel que tendrá el contenido del panel derecho.
        rightContent = new JPanel();
        rightContent.setLayout(new BoxLayout(rightContent, BoxLayout.Y_AXIS));

        right1Panel = new JPanel();
        right1Panel.setLayout(new BoxLayout(right1Panel, BoxLayout.Y_AXIS));
        right1Panel.setBackground(blue_color);
        right1Panelcontent =new JPanel();
        right1Panelcontent.setBorder(new EmptyBorder(10,18,10,120));
        right1Panelcontent.setBackground(blue_color);
        settingIcon = new ImageIcon("src/main/java/eyenet/view/images/settings.png");
        settingsImage = new JLabel(settingIcon);
        settingsText = new JLabel("Settings");
        right1Panelcontent.add(settingsImage);
        right1Panelcontent.add(settingsText);
        right1Panel.add(right1Panelcontent);
        right1Panel.add(new JSeparator());

        right2Panel = new JPanel();
        right2Panel.setLayout(new BoxLayout(right2Panel, BoxLayout.Y_AXIS));
        right2Panel.setBackground(blue_color);
        right2Panelcontent =new JPanel();
        right2Panelcontent.setBorder(new EmptyBorder(10,31,10,120));
        right2Panelcontent.setBackground(blue_color);
        languageIcon = new ImageIcon("src/main/java/eyenet/view/images/language.png");
        languageImage = new JLabel(languageIcon);
        languageText = new JLabel("Language");
        right2Panelcontent.add(languageImage);
        right2Panelcontent.add(languageText);
        right2Panel.add(right2Panelcontent);
        right2Panel.add(new JSeparator());


        right3Panel = new JPanel();
        right3Panel.setLayout(new BoxLayout(right3Panel, BoxLayout.Y_AXIS));
        right3Panel.setBackground(blue_color);
        right3Panelcontent =new JPanel();
        right3Panelcontent.setBorder(new EmptyBorder(10,36,10,120));
        right3Panelcontent.setBackground(blue_color);
        darkModeIcon = new ImageIcon("src/main/java/eyenet/view/images/darkmode.png");
        darkModeImage = new JLabel(darkModeIcon);
        darkModeText = new JLabel("Dark mode");
        right3Panelcontent.add(darkModeImage);
        right3Panelcontent.add(darkModeText);
        right3Panel.add(right3Panelcontent);
        right3Panel.add(new JSeparator());


        right4Panel = new JPanel();
        right4Panel.setLayout(new BoxLayout(right4Panel, BoxLayout.Y_AXIS));
        right4Panel.setBackground(blue_color);
        right4Panelcontent=new JPanel();
        right4Panelcontent.setBorder(new EmptyBorder(10,15,10,120));
        right4Panelcontent.setBackground(blue_color);
        logOutImageIcon = new ImageIcon("src/main/java/eyenet/view/images/logout.png");
        logOutImage = new JLabel(logOutImageIcon);
        logOutText = new JLabel("Logout");
        right4Panelcontent.add(logOutImage);
        right4Panelcontent.add(logOutText);
        right4Panel.add(right4Panelcontent);
        right4Panel.add(new JSeparator());


        rightContent.add(right1Panel);
        rightContent.add(right2Panel);
        rightContent.add(right3Panel);
        rightContent.add(right4Panel);



        rightPanel.add(rightContent);

        //PANEL CENTRAL
        centerPanel = new JPanel();
        centerPanel.setBackground(light_color);
        centerPanelContent = new JPanel(new BorderLayout(20,20));
        centerPanelContent.setBackground(light_color);
        centerPanel.setBorder(new EmptyBorder(20,0,0,0));


        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(first_color);
        mainPanel.setBorder(new EmptyBorder(0,10,250,10));

        //PANEL NORTE
        northTablePanel = new JPanel();
        northTablePanel.setBackground(first_color);
        northTablePanel.setLayout(new BoxLayout(northTablePanel,BoxLayout.Y_AXIS));
        northTablePanel.setBorder(new EmptyBorder(0,30,0,0));

        tableNameText = new JLabel("Table name");
        tableNameText.setBorder(new EmptyBorder(40,0,0,700));
        tableNameText.setHorizontalAlignment(SwingConstants.LEFT);
        northTablePanel.add(tableNameText);

        this.tableNameText.setText(tableName);

        tableFieldsPanel = new JPanel(new GridLayout(0,1,5,0));
        tableFieldsPanel.setBackground(first_color);

        northTablePanel.add(tableNameText);
        northTablePanel.add(tableFieldsPanel);

        //PANEL CENTRAL

        centerTablePanel = new JPanel();
        tablePanelSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        tablePanelSeparator.setForeground(light_color);
        tablePanelSeparator.setPreferredSize(new Dimension(700,20));
        centerTablePanel.setBackground(first_color);
        centerTablePanel.add(tablePanelSeparator);

        //PANEL SUR

        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(first_color);

        //PARTE DE ARRIBA
        topTablePanel = new JPanel(new FlowLayout());
        topTablePanel.setBackground(first_color);

        tableButtonsPanel = new JPanel(new FlowLayout());
        tableButtonsPanel.setBackground(first_color);
        copyButton = new JButton("Copy");
        //xmlButton = new JButton("XML");

        tableButtonsPanel.add(copyButton);
        //tableButtonsPanel.add(xmlButton);

        searchPanel = new JPanel(new FlowLayout());
        searchPanel.setBackground(first_color);
        searchText = new JLabel("Search: ");
        searchField = new JTextField(15);
        searchPanel.add(searchText);
        searchPanel.add(searchField);

        topTablePanel.add(tableButtonsPanel);
        topTablePanel.add(searchPanel);

        //PARTE DE ABAJO
        bottomTablePanel = new JPanel(new FlowLayout());
        totalEntriesText = new JLabel("Total entries: ");
        totalEntriesNum = new JLabel("0");

        bottomTablePanel.add(totalEntriesText);
        bottomTablePanel.add(totalEntriesNum);

        //PARTE CENTRAL (LA TABLA)
        centralTablePanel = new JPanel();

        tablesDB = new tablesDB();
        //PONER LAS FLECHAS EN LOS CAMPOS DE LAS COLUMNAS
        if(this.tableName.equals("Workers")){
            arrowColumnIndexes = new int[]{0, 4, 6, 8, 9};
            columns = new String[]{"id_langilea","Username","Name","Surname","Birthdate", "Sex","Salary","Email","ContractDate","Role"};
            tableModel = new DefaultTableModel(columns,0);
            data = tablesDB.listWorkersToTable();
            for(int i = 0; i < data.length;i++){
                tableModel.addRow(data[i]);
            }
        }
        if(this.tableName.equals("Products")){
            arrowColumnIndexes = new int[]{0, 1, 2, 4, 5};
            columns = new String[]{"id_produktua", "ProviderName", "Name","Description","Price","Stock"};
            tableModel = new DefaultTableModel(columns,0);
            data = tablesDB.listProductsToTable();
            for(int i = 0; i < data.length;i++){
                tableModel.addRow(data[i]);
            }
        }
        if(this.tableName.equals("Payrolls")){
            arrowColumnIndexes = new int[]{0, 1, 2, 4, 6, 7, 9,10};
            columns = new String[]{"id_nomina", "Worker", "HumanResource","Days","Date","PFEZ","SldtGordin","SldtGarbi","Account","EznbsteOrdu","ExtraHours"};
            tableModel = new DefaultTableModel(columns,0);
            data = tablesDB.listPayrollsToTable();
            for(int i = 0; i < data.length;i++){
                tableModel.addRow(data[i]);
            }
        }

        table = new JTable(tableModel);

        sorter = new TableRowSorter<TableModel>(tableModel);
        table.setRowSorter(sorter);
        sortKeys = new ArrayList<>();
        sorter.setSortKeys(sortKeys);


        for (int i = 1; i<tableModel.getColumnCount();i++){
            sorter.setSortable(i,false);
        }

        for (int i = 0; i < arrowColumnIndexes.length;i++){
            sorter.setSortable(arrowColumnIndexes[i],true);
        }
        sorter.setSortsOnUpdates(true); // Ordena automáticamente la tabla después de una modificación
        //COMPARADOR PERSONALIZADO PARA EL SORTER
        Comparator<Object> intComparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer id1 = Integer.valueOf(o1.toString());
                Integer id2 = Integer.valueOf(o2.toString());
                // Comparar los valores y devolver el resultado adecuado para el orden deseado
                return id1.compareTo(id2);
            }
        };
        sorter.setComparator(0,intComparator);
        //ESTILO PARA LA TABLA
        CellRenderer renderer = new CellRenderer(arrowColumnIndexes, tableName, table);
        table.getTableHeader().setDefaultRenderer(renderer);



        //QUERIES EN EL SEARCH FIELD
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            tablesDB tablesDB = new tablesDB();
            @Override
            public void insertUpdate(DocumentEvent e) {

                if(tableName.equals("Workers")){
                    data = tablesDB.listWorkersQueryToTable(searchField.getText());
                }
                if(tableName.equals("Products")){
                    data = tablesDB.listProductsQueryToTable(searchField.getText());
                }
                if(tableName.equals("Payrolls")){
                    data = tablesDB.listPayrollsQueryToTable(searchField.getText());
                }
                tableModel.setRowCount(0);
                tablesDB.refreshTableData(data, tableModel, table);

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(tableName.equals("Workers")){
                    data = tablesDB.listWorkersQueryToTable(searchField.getText());
                }
                if(tableName.equals("Products")){
                    data = tablesDB.listProductsQueryToTable(searchField.getText());
                }
                if(tableName.equals("Payrolls")){
                    data = tablesDB.listPayrollsQueryToTable(searchField.getText());
                }
                tableModel.setRowCount(0);
                tablesDB.refreshTableData(data, tableModel, table);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        //ESTABLECER EL COUNT DE ROWS EN EL TOTAL ENTRIES
        totalEntriesNum.setText(String.valueOf(table.getRowCount()));
        scrollTablePanel = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTablePanel.getVerticalScrollBar().setUnitIncrement(30);
        centralTablePanel.add(scrollTablePanel);

        //FIELDS PARA EDITAR LOS CAMPOS
        JTextField[] fieldInputs = new JTextField[table.getColumnCount()];
        for (int i = 0; i < table.getColumnCount();i++){
            if(!table.getModel().getColumnName(i).substring(0,2).equals("id")){
                JPanel tableField = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
                tableField.setBackground(first_color);
                JLabel tableFieldText = new JLabel(table.getModel().getColumnName(i).substring(0,1).toUpperCase() + (table.getModel().getColumnName(i).substring(1)));
                fieldInputs[i] = new JTextField(10);
                tableField.add(tableFieldText);
                tableField.add(fieldInputs[i]);
                tableFieldsPanel.add(tableField);
            }
        }

        JPanel insertDataPanel = new JPanel();
        insertDataPanel.setBackground(first_color);
        JButton insertData = new JButton("Insert data");
        insertDataPanel.add(insertData);

        tableFieldsPanel.add(insertDataPanel);
        tableFieldsPanel.setBorder(new EmptyBorder(0,0,0,0));


        tablePanel.add(topTablePanel,BorderLayout.NORTH);
        tablePanel.add(centralTablePanel,BorderLayout.CENTER);
        tablePanel.add(bottomTablePanel,BorderLayout.SOUTH);

        mainPanel.add(centerTablePanel,BorderLayout.CENTER);
        mainPanel.add(northTablePanel,BorderLayout.NORTH);
        mainPanel.add(tablePanel,BorderLayout.SOUTH);

        centerPanelContent.add(mainPanel,BorderLayout.SOUTH);

        centerPanel.add(centerPanelContent, BorderLayout.CENTER);

        backButton = new JButton("Back");
        backPanel = new JPanel(new BorderLayout());
        backPanel.add(backButton,BorderLayout.WEST);
        centerPanelContent.add(backPanel);

        mainScroll = new JScrollPane(centerPanel);
        mainScroll.getVerticalScrollBar().setUnitIncrement(30);

        main.add(mainScroll,BorderLayout.CENTER);


        //FUENTES
        File fontFile = new File("src/main/java/eyenet/view/fonts/rubik.ttf");
        Font main_font = Font.createFont(Font.PLAIN, fontFile);
        main_font = main_font.deriveFont(Font.PLAIN,14);
        dashboardText.setFont(main_font);
        layoutsText.setFont(main_font);
        modulesText.setFont(main_font);
        statisticsText.setFont(main_font);
        databaseText.setFont(main_font);
        assignmentsText.setFont(main_font);
        toolsText.setFont(main_font);

        settingsText.setFont(main_font);
        languageText.setFont(main_font);
        darkModeText.setFont(main_font);
        logOutText.setFont(main_font);

        //COLOR DE FUENTES
        dashboardText.setForeground(light_color);
        layoutsText.setForeground(light_color);
        modulesText.setForeground(light_color);
        statisticsText.setForeground(light_color);
        databaseText.setForeground(light_color);
        assignmentsText.setForeground(light_color);
        toolsText.setForeground(light_color);

        settingsText.setForeground(light_color);
        languageText.setForeground(light_color);
        darkModeText.setForeground(light_color);
        logOutText.setForeground(light_color);


        //LISTENERS
        table mainJFrame = this;

        MouseListener mouseListener = new MouseAdapter() {
            boolean opened = false;
            boolean opened1 = false;
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource().equals(link1Panel)) {
                    dashboard dashboard = null;
                    try {
                        dashboard = new dashboard();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(dashboard.getContentPane());
                    main.setVisible(true);
                }
                if (right1Panelcontent.equals(e.getSource())) {
                    userProfile userProfile = null;
                    try {
                        userProfile = new userProfile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(userProfile.getContentPane());
                    main.setVisible(true);
                }
                if (e.getSource().equals(link2Panel)) {
                    layouts layouts = null;
                    try {
                        layouts = new layouts();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(layouts.getContentPane());
                    main.setVisible(true);
                }
                if (e.getSource().equals(link3Panel)) {
                    modules modules = null;
                    try {
                        modules = new modules();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(modules.getContentPane());
                    main.setVisible(true);
                }
                if (e.getSource().equals(link5Panel)) {
                    databases databases = null;
                    try {
                        databases = new databases();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(databases.getContentPane());
                    main.setVisible(true);
                }
                if (link7Panel.equals(e.getSource())) {
                    tools tools = null;
                    try {
                        tools = new tools();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(tools.getContentPane());
                    main.setVisible(true);
                }
                if (barsImage.equals(e.getSource())) {
                    if (!opened) {
                        main.setVisible(false);
                        main.add(leftPanel, BorderLayout.WEST);
                        main.setVisible(true);
                        opened = true;
                        repaint();
                        revalidate();

                        centerPanel.setBorder(new EmptyBorder(20, 0, 0, 50)); // 1
                        if (opened1) {
                            centerPanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // 2
                        }

                    } else {
                        main.setVisible(false);
                        main.remove(leftPanel);
                        main.setVisible(true);
                        opened = false;
                        repaint();
                        revalidate();
                        centerPanel.setBorder(new EmptyBorder(20, 180, 0, 170)); // 4
                        if (opened1) {
                            centerPanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // 3
                        }
                    }
                }

                if (userImage.equals(e.getSource())) {
                    if (!opened1) {
                        main.setVisible(false);
                        main.add(rightPanel, BorderLayout.EAST);
                        main.setVisible(true);
                        opened1 = true;
                        repaint();
                        revalidate();

                        centerPanel.setBorder(new EmptyBorder(20, 60, 0, 0)); // 3
                        if (opened) {
                            centerPanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // 2
                        }
                    } else {
                        main.setVisible(false);
                        main.remove(rightPanel);
                        main.setVisible(true);
                        opened1 = false;
                        repaint();
                        revalidate();

                        centerPanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // 4
                        if (opened) {
                            centerPanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // 1
                        }
                    }
                }
                if (right4Panelcontent.equals(e.getSource())) {

                    try {
                        loginDB loginDB = new loginDB(main);
                        loginDB.logout();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                if (backButton.equals(e.getSource())) {
                    databases databases = null;
                    try {
                        databases = new databases();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(databases.getContentPane());
                    main.setVisible(true);
                }
                if (copyButton.equals(e.getSource())) {
                    if (table.getSelectedRow() != -1 && table.getSelectedColumn() != -1) {
                        System.out.println(table.getSelectedRow());
                        int[] rows = table.getSelectedRows();
                        int[] columns = table.getSelectedColumns();
                        Object values = null;
                        String data = "";
                        for (int i = rows.length - 1; i >= 0; i--) {
                            for (int j = columns.length - 1; j >= 0; j--) {
                                values = table.getValueAt(rows[i], columns[j]);
                                data = values.toString() + data;
                            }
                        }

                        StringSelection selection = new StringSelection(data);
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
                        JOptionPane.showMessageDialog(null, "Data Copied", "Succesfull", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No data found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (insertData.equals(e.getSource()) && tableName.equals("Products")) {
                    workerDB worker = null;
                    try {
                        workerDB worker1 = new workerDB();
                        worker1.createProduct(worker1.getIdProvider(fieldInputs[1].getText()), fieldInputs[2].getText(), fieldInputs[3].getText(), Float.valueOf(fieldInputs[4].getText()), Integer.valueOf(fieldInputs[5].getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (insertData.equals(e.getSource()) && tableName.equals("Workers")) {
                    adminDB admin = null;
                    try {
                        adminDB admin2 = new adminDB();
                        admin.createWorker(fieldInputs[1].getText(),fieldInputs[2].getText(), Date.valueOf(fieldInputs[3].getText()),fieldInputs[4].getText(), Float.valueOf(fieldInputs[5].getText()),fieldInputs[6].getText(),fieldInputs[7].getText(), Date.valueOf(fieldInputs[8].getText()), admin2.getRolId(fieldInputs[9].getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }


            @Override
            public void mouseExited(MouseEvent e) {
                // Establece el color de fondo original cuando el ratón sale
                if(e.getSource().equals(link1Panel)){
                    link1PanelContent.setBackground(blue_color);
                }

                if(e.getSource().equals(link2Panel)){
                    link2PanelContent.setBackground(blue_color);
                }
                if(e.getSource().equals(link3Panel)){
                    link3PanelContent.setBackground(blue_color);
                }
                if(e.getSource().equals(link4Panel)){
                    link4PanelContent.setBackground(blue_color);
                }
                if(e.getSource().equals(link5Panel)){
                    link5PanelContent.setBackground(blue_color);
                }
                if(e.getSource().equals(link6Panel)){
                    link6PanelContent.setBackground(blue_color);
                }
                if(e.getSource().equals(link7Panel)){
                    link7PanelContent.setBackground(blue_color);
                }
                if(e.getSource().equals(right1Panelcontent)){
                    right1Panelcontent.setBackground(blue_color);
                }
                if(e.getSource().equals(right2Panelcontent)){
                    right2Panelcontent.setBackground(blue_color);
                }
                if(e.getSource().equals(right3Panelcontent)){
                    right3Panelcontent.setBackground(blue_color);
                }
                if(e.getSource().equals(right4Panelcontent)){
                    right4Panelcontent.setBackground(blue_color);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                if(e.getSource().equals(barsImage)){
                    barsImage.setCursor(cursor);
                }
                if(e.getSource().equals(userImage)){
                    userImage.setCursor(cursor);
                }
                if(e.getSource().equals(link1Panel)){
                    link1Panel.setCursor(cursor);
                    link1PanelContent.setBackground(dark_color);
                }

                if(e.getSource().equals(link2Panel)){
                    link2Panel.setCursor(cursor);
                    link2PanelContent.setBackground(dark_color);
                    link1Panel.setBackground(dark_color);
                }
                if(e.getSource().equals(link3Panel)){
                    link3Panel.setCursor(cursor);
                    link3PanelContent.setBackground(dark_color);
                    link2Panel.setBackground(dark_color);
                }
                if(e.getSource().equals(link4Panel)){
                    link4Panel.setCursor(cursor);
                    link4PanelContent.setBackground(dark_color);
                    link3Panel.setBackground(dark_color);
                }
                if(e.getSource().equals(link5Panel)){
                    link5Panel.setCursor(cursor);
                    link5PanelContent.setBackground(dark_color);
                    link4Panel.setBackground(dark_color);
                }
                if(e.getSource().equals(link6Panel)){
                    link6Panel.setCursor(cursor);
                    link6PanelContent.setBackground(dark_color);
                    link5Panel.setBackground(dark_color);
                }
                if(e.getSource().equals(link7Panel)){
                    link7Panel.setCursor(cursor);
                    link7PanelContent.setBackground(dark_color);
                    link6Panel.setBackground(dark_color);
                }
                if(e.getSource().equals(right1Panelcontent)){
                    right1Panel.setCursor(cursor);
                    right1Panelcontent.setBackground(dark_color);
                }
                if(e.getSource().equals(right2Panelcontent)){
                    right2Panel.setCursor(cursor);
                    right2Panelcontent.setBackground(dark_color);
                }
                if(e.getSource().equals(right3Panelcontent)) {
                    right3Panel.setCursor(cursor);
                    right3Panelcontent.setBackground(dark_color);
                }
                if(e.getSource().equals(right4Panelcontent)) {
                    right4Panel.setCursor(cursor);
                    right4Panelcontent.setBackground(dark_color);
                }

            }
        };
        barsImage.addMouseListener(mouseListener);
        userImage.addMouseListener(mouseListener);
        link1Panel.addMouseListener(mouseListener);
        link2Panel.addMouseListener(mouseListener);
        link3Panel.addMouseListener(mouseListener);
        link4Panel.addMouseListener(mouseListener);
        link5Panel.addMouseListener(mouseListener);
        link6Panel.addMouseListener(mouseListener);
        link7Panel.addMouseListener(mouseListener);
        right1Panelcontent.addMouseListener(mouseListener);
        right2Panelcontent.addMouseListener(mouseListener);
        right3Panelcontent.addMouseListener(mouseListener);
        right4Panelcontent.addMouseListener(mouseListener);
        backButton.addMouseListener(mouseListener);
        copyButton.addMouseListener(mouseListener);
        insertData.addMouseListener(mouseListener);



        this.add(main);
        this.pack();
        this.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}

