/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class File1 extends JFrame {

    String text = "";
    String path = "";

    public File1() {
        JLabel p = new JLabel();
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scroll = new JScrollPane(textArea);
        setLayout(new BorderLayout(4, 4));

        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenuItem item1 = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (path.equals("")) {
                    System.out.println("test");
                    JFileChooser file = new JFileChooser();
                    int x = file.showSaveDialog(null);
                    if (x == JFileChooser.APPROVE_OPTION) {
                        String content = textArea.getText();
                        File fi = file.getSelectedFile();
                        try {
                            FileWriter fw = new FileWriter(fi.getPath());
                            PrintWriter pw = new PrintWriter(fw);
                            pw.write(textArea.getText());
                            pw.flush();
                            pw.close();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                } else {
                    
                    File f = new File(path);

                    try {
                        FileWriter fw = new FileWriter(f);
                        PrintWriter pw = new PrintWriter(fw);
                        pw.write(textArea.getText());
                        pw.flush();
                        pw.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                }
            }

        });
        JMenuItem item2 = new JMenuItem("Colse");
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");

            }
        });
        JMenuItem item3 = new JMenuItem("Exit");
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenuItem item4 = new JMenuItem("Font");
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object s;
                s = JOptionPane.showInputDialog(
                        null,
                        "Message",
                        "Title",
                        JOptionPane.WARNING_MESSAGE,
                        null, //icon object
                        new String[]{"12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32"}, //list  items
                        "Blue" //defalut selected item in the list
                );

                textArea.setFont(new Font("Monaco", Font.PLAIN, Integer.parseInt((String) s)));

            }
        });
        JMenuItem item5 = new JMenuItem("Color");
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Color initialcolor = Color.RED;
                Color color = JColorChooser.showDialog(File1.this, "Select a color", initialcolor);

                textArea.setForeground(color);

            }
        });
        menu1.add(item1);
        menu1.add(save);
        menu1.add(item2);
        menu1.add(item3);

        menu2.add(item4);
        menu2.add(item5);
        menuBar.add(menu1);
        menuBar.add(menu2);

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser file = new JFileChooser();
                    file.showOpenDialog(File1.this);

                    java.io.File selectFile = file.getSelectedFile();
                    path = selectFile.getPath();
                    Scanner scanner = new Scanner(selectFile);

                    while (scanner.hasNextLine()) {
                        text += scanner.nextLine() + "\n";
                    }

                    textArea.setText(text);

                } catch (Exception ev) {

                }
            }
        });

        add(menuBar);
        add(scroll);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        File1 m = new File1();
    }
}
