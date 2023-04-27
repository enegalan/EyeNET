/*
 * Copyright (c) 2023.
 */

package eyenet.view.tools;

import eyenet.controller.db.loginDB;
import eyenet.view.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class tools extends JFrame implements ActionListener {
    private JLabel barsImage,userImage,dashboardImage,dashboardText,layoutImage,layoutsText,modulesImage,modulesText, statisticsImage, statisticsText,databasesImage,databaseText, assignmentsImage,assignmentsText,settingsImage,settingsText,languageImage,languageText,darkModeImage,darkModeText,logOutImage,logOutText, toolsImage, toolsText;
    private JLabel titleText,adminAreaText,adminImage,workerAreaText,workerImage,humanResourcesAreaText,humanResourcesImage;
    private JPanel leftPanelContent,right4Panelcontent, right4Panel, right3Panelcontent, right3Panel, right2Panel, right2Panelcontent, right1Panelcontent,rightContent,rightPanel,main, leftPanel,header,leftHeader,leftHeaderContent,rightHeader,rightHeaderContent,link1Panel,link1PanelContent,link2Panel,link2PanelContent,link3Panel,link3PanelContent,link4Panel,link4PanelContent,link5Panel,link5PanelContent,link6Panel,link6PanelContent,link7Panel, link7PanelContent, right1Panel;
    private JPanel centerPanel,centerPanelContent,centerPanelGroup,titlePanel,areasPanel,adminAreaPanel,adminAreaPanelContent,adminAreaPanelSeparator,workerAreaPanel, workerAreaPanelContent, workerAreaPanelSeparator, humanResourcesAreaPanel, humanResourcesAreaPanelContent;
    private ImageIcon settingIcon,languageIcon,darkModeIcon,logOutImageIcon,barsIcon,userIcon,dashboardIcon,layoutsIcon,modulesIcon, statisticsIcon,databasesIcon, assignmentsIcon, toolsIcon;
    private ImageIcon adminIcon,workerIcon,humanResourcesIcon;
    private JSeparator adminSeparator,workerSeparator;
    /*COLORS RGB*/
    private static final Color main_color = new Color(39,109,144);
    private static final Color blue_color = new Color(60, 123, 143);
    private static final Color first_color = new Color(206,207,201);
    private static final Color dark_color = new Color(10,49,67);
    private static final Color light_color = new Color(239,239,239);


    public tools() throws IOException, FontFormatException {
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

        titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(new EmptyBorder(25,0,40,0));
        titlePanel.setBackground(first_color);
        titleText = new JLabel("Tools");
        titlePanel.add(titleText);

        areasPanel = new JPanel(new GridLayout(1,3));
        areasPanel.setBackground(dark_color);

        adminAreaPanel = new JPanel();
        adminAreaPanel.setLayout(new BoxLayout(adminAreaPanel, BoxLayout.X_AXIS));
        adminAreaPanel.setBorder(new EmptyBorder(0,60,0,0));
        adminAreaPanel.setBackground(light_color);
        adminAreaPanelContent = new JPanel();
        adminAreaPanelContent.setBorder(new EmptyBorder(0,0,0,40));
        adminAreaPanelContent.setLayout(new BoxLayout(adminAreaPanelContent,BoxLayout.Y_AXIS));
        adminAreaText = new JLabel("Admin Area");
        adminAreaText.setBorder(new EmptyBorder(0,0,30,0));
        adminIcon = new ImageIcon("src/main/java/eyenet/view/images/tools/admin.png");
        adminImage = new JLabel(adminIcon);
        adminAreaPanelContent.add(adminAreaText);
        adminAreaPanelContent.add(adminImage);

        adminAreaPanelSeparator = new JPanel();
        adminAreaPanelSeparator.setLayout(new BoxLayout(adminAreaPanelSeparator, BoxLayout.Y_AXIS));
        adminSeparator = new JSeparator(SwingConstants.VERTICAL);
        adminSeparator.setPreferredSize(new Dimension(1,250));
        adminSeparator.setForeground(first_color);
        adminAreaPanelSeparator.add(adminSeparator);

        adminAreaPanel.add(adminAreaPanelContent);
        adminAreaPanel.add(adminAreaPanelSeparator);

        //WORKER AREA
        workerAreaPanel = new JPanel();
        workerAreaPanel.setLayout(new BoxLayout(workerAreaPanel, BoxLayout.X_AXIS));
        workerAreaPanel.setBorder(new EmptyBorder(0,55,0,0));
        workerAreaPanel.setBackground(light_color);
        workerAreaPanelContent = new JPanel();
        workerAreaPanelContent.setBorder(new EmptyBorder(0,0,0,45));
        workerAreaPanelContent.setLayout(new BoxLayout(workerAreaPanelContent,BoxLayout.Y_AXIS));
        workerAreaText = new JLabel("Worker Area");
        workerAreaText.setBorder(new EmptyBorder(0,0,30,0));
        workerIcon = new ImageIcon("src/main/java/eyenet/view/images/tools/workers.png");
        workerImage = new JLabel(workerIcon);
        workerAreaPanelContent.add(workerAreaText);
        workerAreaPanelContent.add(workerImage);

        workerAreaPanelSeparator = new JPanel();
        workerAreaPanelSeparator.setLayout(new BoxLayout(workerAreaPanelSeparator, BoxLayout.Y_AXIS));
        workerSeparator = new JSeparator(SwingConstants.VERTICAL);
        workerSeparator.setPreferredSize(new Dimension(1,250));
        workerSeparator.setForeground(first_color);
        workerAreaPanelSeparator.add(workerSeparator);

        workerAreaPanel.add(workerAreaPanelContent);
        workerAreaPanel.add(workerAreaPanelSeparator);

        //HUMAN RESOURCES AREA
        humanResourcesAreaPanel = new JPanel();
        humanResourcesAreaPanel.setLayout(new BoxLayout(humanResourcesAreaPanel, BoxLayout.X_AXIS));
        humanResourcesAreaPanel.setBorder(new EmptyBorder(0,50,0,0));
        humanResourcesAreaPanel.setBackground(light_color);
        humanResourcesAreaPanelContent = new JPanel();
        humanResourcesAreaPanelContent.setLayout(new BoxLayout(humanResourcesAreaPanelContent,BoxLayout.Y_AXIS));
        humanResourcesAreaText = new JLabel("Human Resources Area");
        humanResourcesAreaText.setBorder(new EmptyBorder(0,0,30,0));
        humanResourcesIcon = new ImageIcon("src/main/java/eyenet/view/images/tools/human_resources.png");
        humanResourcesImage = new JLabel(humanResourcesIcon);
        humanResourcesAreaPanelContent.add(humanResourcesAreaText);
        humanResourcesAreaPanelContent.add(humanResourcesImage);

        humanResourcesAreaPanel.add(humanResourcesAreaPanelContent);


        areasPanel.add(adminAreaPanel);
        areasPanel.add(workerAreaPanel);
        areasPanel.add(humanResourcesAreaPanel);

        centerPanelContent.add(titlePanel,BorderLayout.NORTH);
        centerPanelContent.add(areasPanel,BorderLayout.CENTER);

        centerPanelGroup.add(centerPanelContent);

        centerPanel.add(centerPanelGroup);


        main.add(centerPanel,BorderLayout.CENTER);


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
        tools mainJFrame = this;

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
                if (barsImage.equals(e.getSource())){
                    if (!opened){
                        main.setVisible(false);
                        main.add(leftPanel,BorderLayout.WEST);
                        main.setVisible(true);
                        opened = true;
                        repaint();
                        revalidate();

                        centerPanel.setBorder(new EmptyBorder(20,30,0,300)); // 1
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
                        centerPanel.setBorder(new EmptyBorder(20,300,0,300)); // 4
                        if(opened1){
                            centerPanel.setBorder(new EmptyBorder(20,300,0,35)); // 3
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

                        centerPanel.setBorder(new EmptyBorder(20,300,0,35)); // 3
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

                        centerPanel.setBorder(new EmptyBorder(20,300,0,300)); // 4
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
                if(e.getSource().equals(adminAreaPanel)){
                    adminArea adminArea = null;
                    try {
                        adminArea = new adminArea();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(adminArea.getContentPane());
                    main.setVisible(true);
                }
                if(e.getSource().equals(workerAreaPanel)){
                    workerArea workerArea = null;
                    try {
                        workerArea = new workerArea();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.setVisible(false);
                    main.removeAll();
                    main.add(workerArea.getContentPane());
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
                if(e.getSource().equals(adminAreaPanel)){
                    adminAreaPanel.setBackground(light_color);
                    adminAreaPanelContent.setBackground(light_color);
                }
                if(e.getSource().equals(workerAreaPanel)){
                    workerAreaPanel.setBackground(light_color);
                    workerAreaPanelContent.setBackground(light_color);
                }
                if(e.getSource().equals(humanResourcesAreaPanel)){
                    humanResourcesAreaPanel.setBackground(light_color);
                    humanResourcesAreaPanelContent.setBackground(light_color);
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
                if(e.getSource().equals(adminAreaPanel)){
                    adminAreaPanel.setCursor(cursor);
                    adminAreaPanel.setBackground(new Color(187, 187, 187));
                    adminAreaPanelContent.setBackground(new Color(187, 187, 187));
                }
                if(e.getSource().equals(workerAreaPanel)){
                    workerAreaPanel.setCursor(cursor);
                    workerAreaPanel.setBackground(new Color(187, 187, 187));
                    workerAreaPanelContent.setBackground(new Color(187, 187, 187));
                }
                if(e.getSource().equals(humanResourcesAreaPanel)){
                    humanResourcesAreaPanel.setCursor(cursor);
                    humanResourcesAreaPanel.setBackground(new Color(187, 187, 187));
                    humanResourcesAreaPanelContent.setBackground(new Color(187, 187, 187));
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
        adminAreaPanel.addMouseListener(mouseListener);
        workerAreaPanel.addMouseListener(mouseListener);
        humanResourcesAreaPanel.addMouseListener(mouseListener);


        this.add(main);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        tools tools = new tools();
        tools.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}

