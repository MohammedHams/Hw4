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
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class List extends JFrame {

    //JPanel jP;
    public List() {

        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        String arr[] = {"Black", "Blue", "Red",
            "White", "Gre\"en", "Yellow", "Purple", "Gray", "Orange", "Pink", "Brown"};
        DefaultListModel<String> dif = new DefaultListModel();
        JList<String> list = new JList(arr);

        JScrollPane sL = new JScrollPane(list);
        sL.setPreferredSize(new Dimension(100, 120));
        add(sL);

        JList<String> list2 = new JList();

        JScrollPane sL2 = new JScrollPane(list2);
        sL2.setPreferredSize(new Dimension(100, 120));

        JButton btn = new JButton("Copy>>>");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<String> li = new ArrayList();
                try {
                    li = (ArrayList<String>) list.getSelectedValuesList();
                  
                    for (int i = 0; i < li.size(); i++) {
                        dif.add(i, li.get(i));
                        
                    }
                    list2.setModel(dif);
                } catch (Exception ev) {
                    JOptionPane.showMessageDialog(null, "No item selections", null, JOptionPane.WARNING_MESSAGE);
                }

                

            }
        });
        add(btn);
        add(sL2);

        setLayout(new FlowLayout());

        setVisible(true);
    }

    public static void main(String[] args) {
        List list = new List();
    }

}
