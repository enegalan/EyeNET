/*
 * Copyright (c) 2023.
 */

package eyenet.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class faq extends JFrame implements ActionListener {
    private JLabel leftArrowImage,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    public JPanel main,leftArrowPanel,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,leftPanel,rightContent,rightPanel,FAQPanel,questions;
    private ImageIcon leftArrowIcon;
    private JScrollPane scrollPane;


    /*COLORS RGB*/
    private static final Color main_color = new Color(39,109,144);
    private static final Color first_color = new Color(206,207,201);
    private static final Color dark_color = new Color(10,49,67);
    private static final Color light_color = new Color(239,239,239);


    public faq() throws IOException, FontFormatException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("EyeNet");
        this.setPreferredSize(new Dimension(1300, 800));
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setBackground(light_color);

        main = new JPanel(new BorderLayout());

        //PANEL IZQUIERDO
        //Crear el panel que tendrá el contenido del panel izquierdo y añadir al JFrame
        leftArrowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
        leftArrowPanel.setBackground(main_color);
        leftArrowIcon = new ImageIcon("src/eyenet/view/images/left_arrow.png");
        leftArrowImage = new JLabel(leftArrowIcon);
        leftArrowPanel.add(leftArrowImage);



        //Crear el panel izquierdo
        leftPanel = new JPanel(new BorderLayout(0,50));
        leftPanel.setBackground(main_color);
        leftPanel.add(leftArrowPanel,BorderLayout.NORTH);
        main.add(leftPanel,BorderLayout.WEST);



        //PANEL DERECHO
        //Crear el panel que tendrá el contenido del panel derecho.
        rightContent = new JPanel(new BorderLayout());
        rightContent.setBackground(first_color);


        //Crear el panel derecho y añadir el panel del contenido.
        rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,160,0));
        rightPanel.setBackground(light_color);



        //Crear el panel para el formulario de FAQ
        FAQPanel = new JPanel(new FlowLayout());



        //Crear el contenido del FAQ
        q1 = new JLabel("How does it work this application?");
        q2 = new JLabel("How can I contact with an administrator?");
        q3 = new JLabel("How can I contact with an administrator?");
        q4 = new JLabel("How can I contact with an administrator?");
        q5 = new JLabel("How can I contact with an administrator?");
        q6 = new JLabel("How can I contact with an administrator?");
        q7 = new JLabel("How can I contact with an administrator?");
        q8 = new JLabel("How can I contact with an administrator?");
        q9 = new JLabel("How can I contact with an administrator?");
        q10 = new JLabel("How can I contact with an administrator?");

        r1 = new JLabel("Answer: It is a facturing app.");
        r2 = new JLabel("Answer: This is an answer.");
        r3 = new JLabel("Answer: This is an answer.");
        r4 = new JLabel("Answer: This is an answer.");
        r5 = new JLabel("Answer: This is an answer.");
        r6 = new JLabel("Answer: This is an answer.");
        r7 = new JLabel("Answer: This is an answer.");
        r8 = new JLabel("Answer: This is an answer.");
        r9 = new JLabel("Answer: This is an answer.");
        r10 = new JLabel("Answer: This is an answer.");

        r1.setForeground(main_color);
        r2.setForeground(main_color);
        r3.setForeground(main_color);
        r4.setForeground(main_color);
        r5.setForeground(main_color);
        r6.setForeground(main_color);
        r7.setForeground(main_color);
        r8.setForeground(main_color);
        r9.setForeground(main_color);
        r10.setForeground(main_color);

        Border border = new EmptyBorder(20,10,10,10);

        questions = new JPanel();
        questions.setLayout(new BoxLayout(questions, BoxLayout.Y_AXIS));
        questions.setBackground(first_color);

        p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        p1.setBackground(first_color);
        q1.setBorder(border);
        r1.setBorder(border);
        p1.add(q1);
        p1.add(r1);

        p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
        p2.setBackground(first_color);
        q2.setBorder(border);
        r2.setBorder(border);
        p2.add(q2);
        p2.add(r2);

        p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
        p3.setBackground(first_color);
        q3.setBorder(border);
        r3.setBorder(border);
        p3.add(q3);
        p3.add(r3);

        p4 = new JPanel();
        p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
        p4.setBackground(first_color);
        q4.setBorder(border);
        r4.setBorder(border);
        p4.add(q4);
        p4.add(r4);

        p5 = new JPanel();
        p5.setLayout(new BoxLayout(p5,BoxLayout.Y_AXIS));
        p5.setBackground(first_color);
        q5.setBorder(border);
        r5.setBorder(border);
        p5.add(q5);
        p5.add(r5);

        p6 = new JPanel();
        p6.setLayout(new BoxLayout(p6,BoxLayout.Y_AXIS));
        p6.setBackground(first_color);
        q6.setBorder(border);
        r6.setBorder(border);
        p6.add(q6);
        p6.add(r6);

        p7 = new JPanel();
        p7.setLayout(new BoxLayout(p7,BoxLayout.Y_AXIS));
        p7.setBackground(first_color);
        q7.setBorder(border);
        r7.setBorder(border);
        p7.add(q7);
        p7.add(r7);

        p8 = new JPanel();
        p8.setLayout(new BoxLayout(p8,BoxLayout.Y_AXIS));
        p8.setBackground(first_color);
        q8.setBorder(border);
        r8.setBorder(border);
        p8.add(q8);
        p8.add(r8);

        p9 = new JPanel();
        p9.setLayout(new BoxLayout(p9,BoxLayout.Y_AXIS));
        p9.setBackground(first_color);
        q9.setBorder(border);
        r9.setBorder(border);
        p9.add(q9);
        p9.add(r9);

        p10 = new JPanel();
        p10.setLayout(new BoxLayout(p10,BoxLayout.Y_AXIS));
        p10.setBackground(first_color);
        q10.setBorder(border);
        r10.setBorder(border);
        p10.add(q10);
        p10.add(r10);

        questions.add(p1);
        questions.add(p2);
        questions.add(p3);
        questions.add(p4);
        questions.add(p5);
        questions.add(p6);
        questions.add(p7);
        questions.add(p8);
        questions.add(p9);
        questions.add(p10);

        //Crear el panel que contendrá los elementos del FAQ y añadirlo al panel del FAQ
        scrollPane = new JScrollPane(questions, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        scrollPane.setPreferredSize(new Dimension(800,700));
        scrollPane.setViewportView(questions);
        FAQPanel.add(scrollPane);

        //Añadir el panel del FAQ al panel derecho
        rightContent.add(FAQPanel);

        rightPanel.add(rightContent);

        //Añadir el panel derecho al JFrame
        main.add(rightPanel,BorderLayout.EAST);

        //FUENTES
        File fontFile = new File("src/main/java/eyenet/view/fonts/rubik.ttf");
        Font main_font = Font.createFont(Font.PLAIN, fontFile);
        main_font = main_font.deriveFont(Font.PLAIN,14);
        q1.setFont(main_font);
        q2.setFont(main_font);
        q3.setFont(main_font);
        q4.setFont(main_font);
        q5.setFont(main_font);
        q6.setFont(main_font);
        q7.setFont(main_font);
        q8.setFont(main_font);
        q9.setFont(main_font);
        q10.setFont(main_font);
        r1.setFont(main_font);
        r2.setFont(main_font);
        r3.setFont(main_font);
        r4.setFont(main_font);
        r5.setFont(main_font);
        r6.setFont(main_font);
        r7.setFont(main_font);
        r8.setFont(main_font);
        r9.setFont(main_font);
        r10.setFont(main_font);


        //COLOR DE FUENTES

        //LISTENERS
        faq mainJFrame = this;
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource().equals(leftArrowImage)){
                    login login = null;
                    try {
                        login = new login();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                    main.removeAll();
                    main.setVisible(false);
                    main.add(login.getContentPane());
                    main.setVisible(true);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                if (leftArrowImage.equals(e.getSource())) {
                    leftArrowImage.setCursor(cursor);
                }

            }
        };
        leftArrowImage.addMouseListener(mouseListener);
        this.add(main);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        faq faq = new faq();
        faq.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}

