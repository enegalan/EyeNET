/*
 * Copyright (c) 2023.
 */

package eyenet.view.tools;

import eyenet.controller.db.adminDB;
import eyenet.controller.db.loginDB;
import eyenet.view.*;
import eyenet.view.render.ButtonEditor;
import eyenet.view.render.CellRenderer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import static eyenet.controller.gestorDB.session;

public class adminArea extends JFrame implements ActionListener {
    private JLabel barsImage,userImage,dashboardImage,dashboardText,layoutImage,layoutsText,modulesImage,modulesText, statisticsImage, statisticsText,databasesImage,databaseText, assignmentsImage,assignmentsText,settingsImage,settingsText,languageImage,languageText,darkModeImage,darkModeText,logOutImage,logOutText, toolsImage, toolsText;
    private JPanel leftPanelContent,right4Panelcontent, right4Panel, right3Panelcontent, right3Panel, right2Panel, right2Panelcontent, right1Panelcontent,rightContent,rightPanel,main, leftPanel,header,leftHeader,leftHeaderContent,rightHeader,rightHeaderContent,link1Panel,link1PanelContent,link2Panel,link2PanelContent,link3Panel,link3PanelContent,link4Panel,link4PanelContent,link5Panel,link5PanelContent,link6Panel,link6PanelContent,link7Panel, link7PanelContent, right1Panel;
    private JPanel centerPanel,centerPanelContent,centerPanelGroup;
    private ImageIcon settingIcon,languageIcon,darkModeIcon,logOutImageIcon,barsIcon,userIcon,dashboardIcon,layoutsIcon,modulesIcon, statisticsIcon,databasesIcon, assignmentsIcon, toolsIcon;
    /*COLORS RGB*/
    private static final Color main_color = new Color(39,109,144);
    private static final Color blue_color = new Color(60, 123, 143);
    private static final Color first_color = new Color(206,207,201);
    private static final Color dark_color = new Color(10,49,67);
    private static final Color light_color = new Color(239,239,239);


    public adminArea() throws IOException, FontFormatException {
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
        rightPanel.setBackground(light_color);
        //Crear el panel que tendrá el contenido del panel derecho.
        rightContent = new JPanel();
        rightContent.setLayout(new BoxLayout(rightContent, BoxLayout.Y_AXIS));

        rightContent.setBackground(dark_color);
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
        centerPanel.setBorder(new EmptyBorder(20,0,0,0));
        centerPanelGroup = new JPanel();
        centerPanelGroup.setBackground(first_color);
        centerPanelGroup.setBorder(new EmptyBorder(10,100,100,100));


        //CONTENIDO DEL PANEL CENTRAL
        centerPanelContent = new JPanel();
        centerPanelContent.setLayout(new BoxLayout(centerPanelContent, BoxLayout.Y_AXIS));

        JPanel adminAreaTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        adminAreaTextPanel.setBackground(first_color);
        JLabel adminAreaText = new JLabel("Admin Area");
        adminAreaText.setBackground(first_color);
        adminAreaTextPanel.add(adminAreaText);
        adminAreaTextPanel.setBorder(new EmptyBorder(0,0,20,0));
        centerPanelContent.add(adminAreaTextPanel);

        JPanel rolAndPermsPanel = new JPanel();
        rolAndPermsPanel.setLayout(new BoxLayout(rolAndPermsPanel, BoxLayout.Y_AXIS));
        rolAndPermsPanel.setBackground(first_color);
        JPanel rolAndPermsTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rolAndPermsTextPanel.setBackground(first_color);
        rolAndPermsTextPanel.setBorder(new EmptyBorder(0,0,10,0));
        JLabel rolAndPermsText = new JLabel("Rol and Permissions -");
        rolAndPermsTextPanel.add(rolAndPermsText);
        JPanel rolAndPermsPanelsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,60,0));
        rolAndPermsPanelsPanel.setBackground(first_color);

        JPanel rolPanel = new JPanel();
        rolPanel.setBackground(first_color);
        rolPanel.setLayout(new BoxLayout(rolPanel,BoxLayout.Y_AXIS));
        JPanel rolImagePanel = new JPanel();
        rolImagePanel.setBorder(new EmptyBorder(5,60,5,60));
        rolImagePanel.setBackground(new Color(161, 161, 161));
        ImageIcon rolIcon = new ImageIcon("src/main/java/eyenet/view/images/tools/rol.png");
        JLabel rolImage = new JLabel(rolIcon);
        rolImagePanel.add(rolImage);
        JPanel rolTextPanel = new JPanel();
        rolTextPanel.setBorder(new EmptyBorder(5,0,5,0));
        JLabel rolText = new JLabel("Rols");
        rolTextPanel.add(rolText);
        rolPanel.add(rolImagePanel);
        rolPanel.add(rolTextPanel);

        JPanel permsPanel = new JPanel();
        permsPanel.setLayout(new BoxLayout(permsPanel,BoxLayout.Y_AXIS));
        JPanel permsImagePanel = new JPanel();
        permsImagePanel.setBorder(new EmptyBorder(5,60,5,60));
        permsImagePanel.setBackground(new Color(161, 161, 161));
        ImageIcon permsIcon = new ImageIcon("src/main/java/eyenet/view/images/tools/perms.png");
        JLabel permsImage = new JLabel(permsIcon);
        permsImagePanel.add(permsImage);
        JPanel permsTextPanel = new JPanel();
        permsTextPanel.setBorder(new EmptyBorder(5,0,5,0));
        JLabel permsText = new JLabel("Permissions");
        permsTextPanel.add(permsText);
        permsPanel.add(permsImagePanel);
        permsPanel.add(permsTextPanel);

        rolAndPermsPanelsPanel.add(rolPanel);
        rolAndPermsPanelsPanel.add(permsPanel);

        rolAndPermsPanel.add(rolAndPermsTextPanel);
        rolAndPermsPanel.add(rolAndPermsPanelsPanel);

        centerPanelContent.add(rolAndPermsPanel);
        //INFO-CHANGE PANEL
        JPanel infoChangePanel = new JPanel();
        infoChangePanel.setLayout(new BoxLayout(infoChangePanel, BoxLayout.Y_AXIS));
        infoChangePanel.setBackground(first_color);
        JPanel infoChangeTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoChangeTextPanel.setBackground(first_color);
        infoChangeTextPanel.setBorder(new EmptyBorder(0,0,10,0));
        JLabel infoChangeText = new JLabel("Info-change requests -");
        infoChangeTextPanel.add(infoChangeText);

        JPanel infoChangeTablePanel = new JPanel();

        adminDB adminDB = new adminDB();

        String[] infoChangeColumns = new String[]{"id_eskaera", "WorkerUsername", "AdminUsername", "Data", "Changes", "Status", "Actions"};
        DefaultTableModel infoChangeTableModel = new DefaultTableModel(infoChangeColumns, 0);
        Object[][] infoChangeData = adminDB.listInfoChangeRequestToTable();
        for(int i = 0; i < infoChangeData.length;i++){
            infoChangeTableModel.addRow(infoChangeData[i]);
        }
        JTable infoChangeTable = new JTable(infoChangeTableModel);
        infoChangeTable.getColumnModel().getColumn(6).setCellRenderer(new ButtonEditor(infoChangeTable,"Info-Change",session));
        infoChangeTable.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(infoChangeTable,"Info-Change",session));

        //ESTILO PARA LA TABLA
        CellRenderer infoChangeRenderer = new CellRenderer(null,"Info-Change", infoChangeTable);
        infoChangeTable.getTableHeader().setDefaultRenderer(infoChangeRenderer);

        JScrollPane scrollInfoChangeTablePanel = new JScrollPane(infoChangeTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollInfoChangeTablePanel.getVerticalScrollBar().setUnitIncrement(30);
        infoChangeTablePanel.add(scrollInfoChangeTablePanel);

        infoChangePanel.add(infoChangeTextPanel);
        infoChangePanel.add(infoChangeTablePanel);

        centerPanelContent.add(infoChangePanel);

        //CONSULTS PANEL
        JPanel consultsPanel = new JPanel();
        consultsPanel.setLayout(new BoxLayout(consultsPanel, BoxLayout.Y_AXIS));
        consultsPanel.setBackground(first_color);
        JPanel consultsTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        consultsTextPanel.setBackground(first_color);
        consultsTextPanel.setBorder(new EmptyBorder(20,0,10,0));
        JLabel consultsText = new JLabel("Consults -");
        consultsTextPanel.add(consultsText);

        JPanel consultsTablePanel = new JPanel();

        String[] consultsColumns = new String[]{"id_eskaera", "WorkerUsername", "AdminUsername", "Data", "Message", "Answer", "Status", "Actions"};
        DefaultTableModel consultsTableModel = new DefaultTableModel(consultsColumns, 0);
        Object[][] consultsData = adminDB.listConsultRequestToTable();
        for(int i = 0; i < consultsData.length;i++){
            consultsTableModel.addRow(consultsData[i]);
        }
        JTable consultsTable = new JTable(consultsTableModel);
        consultsTable.getColumnModel().getColumn(7).setCellRenderer(new ButtonEditor(consultsTable,"Consults",session));
        consultsTable.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(consultsTable,"Consults",session));


        //ESTILO PARA LA TABLA
        CellRenderer consultsRenderer = new CellRenderer(null,"Consults", consultsTable);
        consultsTable.getTableHeader().setDefaultRenderer(consultsRenderer);

        JScrollPane scrollConsultsTablePanel = new JScrollPane(consultsTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollConsultsTablePanel.getVerticalScrollBar().setUnitIncrement(30);
        consultsTablePanel.add(scrollConsultsTablePanel);

        consultsPanel.add(consultsTextPanel);
        consultsPanel.add(consultsTablePanel);

        centerPanelContent.add(infoChangePanel);
        centerPanelContent.add(consultsPanel);

        centerPanelGroup.add(centerPanelContent);

        centerPanel.add(centerPanelGroup);

        JScrollPane mainScroll = new JScrollPane(centerPanel);
        mainScroll.getVerticalScrollBar().setUnitIncrement(30);

        main.add(mainScroll,BorderLayout.CENTER);


        //FUENTES
        File fontFile = new File("src/main/java/eyenet/view/fonts/rubik.ttf");
        Font main_font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        main_font = main_font.deriveFont(Font.PLAIN, 14);
        dashboardText.setFont(main_font);
        layoutsText.setFont(main_font);
        modulesText.setFont(main_font);
        statisticsText.setFont(main_font);
        databaseText.setFont(main_font);
        assignmentsText.setFont(main_font);

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
        adminArea mainJFrame = this;

        MouseListener mouseListener = new MouseAdapter() {
            boolean opened = false;
            boolean opened1 = false;
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource().equals(link1Panel)){
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
                if(e.getSource().equals(link2Panel)){
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
                if(e.getSource().equals(link3Panel)){
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
                if(link7Panel.equals(e.getSource())){
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
                if (barsImage.equals(e.getSource())){
                    if (!opened){
                        main.setVisible(false);
                        main.add(leftPanel,BorderLayout.WEST);
                        main.setVisible(true);
                        opened = true;
                        repaint();
                        revalidate();

                        centerPanel.setBorder(new EmptyBorder(20,0,0,0)); // 1
                        if(opened1){
                            centerPanel.setBorder(new EmptyBorder(20,45,0,50)); // 2
                        }

                    }
                    else{
                        main.setVisible(false);
                        main.remove(leftPanel);
                        main.setVisible(true);
                        opened = false;
                        repaint();
                        revalidate();
                        centerPanel.setBorder(new EmptyBorder(20,80,0,80)); // 4
                        if(opened1){
                            centerPanel.setBorder(new EmptyBorder(20,80,0,35)); // 3
                        }
                    }
                }

                if (userImage.equals(e.getSource())){
                    if (!opened1){
                        main.setVisible(false);
                        main.add(rightPanel,BorderLayout.EAST);
                        main.setVisible(true);
                        opened1 = true;
                        repaint();
                        revalidate();

                        centerPanel.setBorder(new EmptyBorder(20,80,0,35)); // 3
                        if(opened){
                            centerPanel.setBorder(new EmptyBorder(20,45,0,50)); // 2
                        }
                    }
                    else {
                        main.setVisible(false);
                        main.remove(rightPanel);
                        main.setVisible(true);
                        opened1 = false;
                        repaint();
                        revalidate();

                        centerPanel.setBorder(new EmptyBorder(20,80,0,80)); // 4
                        if(opened){
                            centerPanel.setBorder(new EmptyBorder(20,30,0,300)); // 1
                        }
                    }
                }
                if (right4Panelcontent.equals(e.getSource())){

                    try {
                        loginDB loginDB = new loginDB(main);
                        loginDB.logout();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                if(e.getSource().equals(link5Panel)){
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
                if(e.getSource().equals(rolPanel)){
                    rols rols = null;
                    try {
                        rols = new rols();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(rols.getContentPane());
                    main.setVisible(true);
                }
                if(e.getSource().equals(permsPanel)){
                    perms perms = null;
                    try {
                        perms = new perms();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(perms.getContentPane());
                    main.setVisible(true);
                }
                if(right1Panelcontent.equals(e.getSource())){
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
                if(e.getSource().equals(rolPanel)){
                    rolImagePanel.setBackground(new Color(161, 161, 161));
                }
                if(e.getSource().equals(permsPanel)){
                    permsImagePanel.setBackground(new Color(161, 161, 161));
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
                if(e.getSource().equals(rolPanel)){
                    rolPanel.setCursor(cursor);
                    rolImagePanel.setBackground(new Color(126, 126, 126));
                }
                if(e.getSource().equals(permsPanel)){
                    permsPanel.setCursor(cursor);
                    permsImagePanel.setBackground(new Color(126, 126, 126));
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
        rolPanel.addMouseListener(mouseListener);
        permsPanel.addMouseListener(mouseListener);



        this.add(main);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        adminArea tools = new adminArea();
        tools.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}

