/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Temperature extends JFrame {

    public Temperature() {
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(4, 1));
        JLabel label1 = new JLabel("Enter Celsius temperature ");
        add(label1, BorderLayout.NORTH);
        JTextField text = new JTextField();
        text.setPreferredSize(new Dimension(200, 30));
        add(text, BorderLayout.CENTER);
        JPanel jPanel = new JPanel(new GridLayout(1, 2));

        ButtonGroup bG = new ButtonGroup();
        JRadioButton rB1 = new JRadioButton("Fahrenheit ");
        JLabel label = new JLabel();
        rB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!text.getText().equals("")) {
                    double num = Double.parseDouble(text.getText());
                    double f = (num * 1.8) + 32;

                    label.setText(String.valueOf(f));

                }
            }
        });

        JRadioButton rB2 = new JRadioButton("Kelvin");
        rB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!text.getText().equals("")) {
                    double num = Double.parseDouble(text.getText());
                    double k  = num  + 273.15;

                    label.setText(String.valueOf(k));

                }
            }
        });
        bG.add(rB1);
        bG.add(rB2);
        jPanel.add(rB1);
        jPanel.add(rB2);
        add(jPanel);
        add(label);
        setVisible(true);

    }

    public static void main(String[] args) {
        Temperature m = new Temperature();
    }
}
