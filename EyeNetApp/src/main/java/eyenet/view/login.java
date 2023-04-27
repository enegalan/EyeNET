/*
 * Copyright (c) 2023.
 */

package eyenet.view;

import eyenet.controller.db.loginDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static eyenet.controller.gestorDB.session;

public class login extends JFrame implements ActionListener {
    private JLabel userLabel, passwordLabel, faqImage,logoImage,loginImage;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton,contact;

    private JPanel main,leftFAQ,leftLogo,leftContact,leftPanel,rightContent,rightPanel,imagePanel,loginPanel,loginContent;
    private ImageIcon faqIcon,logoIcon,loginIcon;
    private faq faqWeb = new faq();
    private dashboard dashboard = new dashboard();


    /*COLORS RGB*/
    private Color main_color = new Color(39,109,144);
    private Color first_color = new Color(206,207,201);
    private Color dark_color = new Color(10,49,67);
    private Color light_color = new Color(239,239,239);


    public login() throws IOException, FontFormatException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("EyeNet");
        this.setPreferredSize(new Dimension(1300, 800));
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setBackground(light_color);

        main = new JPanel(new BorderLayout());

        //PANEL IZQUIERDO
        //Crear el panel que tendrá el contenido del panel izquierdo y añadir al JFrame
        leftFAQ = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
        leftFAQ.setBackground(main_color);

        faqIcon = new ImageIcon("src/main/java/eyenet/view/images/faq.png");
        faqImage = new JLabel(faqIcon);
        leftFAQ.add(faqImage);

        //Crear el panel del Logo y añadir al contenido del panel izquierdo.
        leftLogo = new JPanel(new FlowLayout(FlowLayout.CENTER,40,0));
        leftLogo.setBackground(main_color);
        logoIcon = new ImageIcon("src/main/java/eyenet/view/images/logo.png");
        logoImage = new JLabel(logoIcon);
        leftLogo.add(logoImage,BorderLayout.CENTER);

        //Crear el panel de Contacto
        leftContact = new JPanel(new FlowLayout(FlowLayout.CENTER,0,100));
        leftContact.setBackground(main_color);
        contact = new JButton("Contact with us");
        leftContact.add(contact);



        //Crear el panel izquierdo
        leftPanel = new JPanel(new BorderLayout(0,50));
        leftPanel.setBackground(main_color);
        leftPanel.add(leftFAQ,BorderLayout.NORTH);
        leftPanel.add(leftLogo,BorderLayout.CENTER);
        leftPanel.add(leftContact,BorderLayout.SOUTH);
        main.add(leftPanel,BorderLayout.WEST);



        //PANEL DERECHO
        //Crear el panel que tendrá el contenido del panel derecho.
        rightContent = new JPanel(new FlowLayout(FlowLayout.CENTER,0,230));
        //rightContent.setBackground(dark_color);

        //Crear el panel derecho y añadir el panel del contenido.
        rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,50,0));
        rightPanel.add(rightContent);

        //Crear panel de imagen y añadir en el panel derecho.
        imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER,50,117));
        imagePanel.setBackground(first_color);
        rightContent.add(imagePanel);

        //Crear imagen y añadir en el panel de imagen.
        loginIcon = new ImageIcon("src/main/java/eyenet/view/images/login.png");
        loginImage = new JLabel(loginIcon);
        loginImage.setPreferredSize(new Dimension(100,100));
        imagePanel.add(loginImage);

        //Crear el panel para el formulario de login
        loginPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,60,75));
        loginPanel.setBackground(first_color);

        //Crear el panel que contendrá los elementos del formulario y añadirlo al panel del login
        loginContent = new JPanel();
        loginContent.setLayout(new GridLayout(3, 2, 0, 50));
        loginContent.setBackground(first_color);
        loginPanel.add(loginContent);

        //Crear elementos del formulario de login y añadirlos al panel del login
        userLabel = new JLabel("Usuario: ");
        userLabel.setHorizontalAlignment(SwingConstants.LEFT);
        loginContent.add(userLabel);

        userField = new JTextField(20);
        loginContent.add(userField);

        passwordLabel = new JLabel("Contraseña: ");
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        loginContent.add(passwordLabel);

        passwordField = new JPasswordField(20);
        loginContent.add(passwordField);


        loginContent.add(new JLabel(""));
        loginButton = new JButton("Login");

        loginContent.add(loginButton);

        //Añadir el panel del login al panel derecho
        rightContent.add(loginPanel);

        //Añadir el panel derecho al JFrame
        main.add(rightPanel,BorderLayout.EAST);

        //FUENTES
        File fontFile = new File("src/main/java/eyenet/view/fonts/rubik.ttf");
        Font main_font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        main_font = main_font.deriveFont(Font.PLAIN, 14);
        userLabel.setFont(main_font);
        passwordLabel.setFont(main_font);
        loginButton.setFont(main_font);
        contact.setFont(main_font);

        //COLOR DE FUENTES

        //LISTENERS
        login mainJFrame = this;
        MouseAdapter mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(faqImage.equals(e.getSource())){

                    main.removeAll();
                    main.setVisible(false);
                    main.add(faqWeb.getContentPane());
                    main.setVisible(true);
                }
                if(loginButton.equals(e.getSource())){
                    loginDB loginDB = null;
                    String url = null;
                    try {
                        url = readURL();
                        loginDB = new loginDB(main,userField.getText(), passwordField.getPassword(),url);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    loginDB.login();
                }
                if(e.getSource().equals(faqWeb.leftArrowPanel)){
                    System.out.println("s");
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                if (faqImage.equals(e.getSource())) {
                    faqImage.setCursor(cursor);
                }
                if(contact.equals(e.getSource())){
                    contact.setCursor(cursor);
                }
                if(loginButton.equals(e.getSource())){
                    loginButton.setCursor(cursor);
                }

            }
        };

        faqImage.addMouseListener(mouseListener);
        contact.addMouseListener(mouseListener);
        loginButton.addMouseListener(mouseListener);

        this.add(main);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        login login = new login();
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
    public String readURL() throws IOException {
        String[] url2 = null;
        StringBuilder content = new StringBuilder();
        BufferedReader lector = new BufferedReader(new FileReader("src/main/java/eyenet/config/config.txt"));
        String linea = "";
        while ((linea = lector.readLine()) != null) {
            content.append(linea);
            content.append("\n");
        }
        lector.close();
        url2 = content.toString().split("=");
        System.out.println(url2[1].toString());
        return url2[1].toString();

    }
}

