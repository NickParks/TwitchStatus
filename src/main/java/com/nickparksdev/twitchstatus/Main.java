package com.nickparksdev.twitchstatus;

import com.nickparksdev.twitchstatus.listeners.ClickListener;
import com.nickparksdev.twitchstatus.listeners.EnterListener;
import com.nickparksdev.twitchstatus.util.NameLoader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

/**
 * Created by Nick Parks on 11/27/2014 at 2:50 PM.
 */
public class Main {
    //Variables
    private static JFrame jFrame;
    private static JPanel jPanel;

    public static JTextField jTextField;
    public static JLabel jLabel;
    public static JButton jButton;
    public static DefaultTableModel model;
    public static JTable table;

    public static void main(String[] args){
        //Load jFrame
        checkFile();

        jFrame = new JFrame("Twitch Status Viewer");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 400);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());

        //Load everything else to prevent null
        jLabel = new JLabel();
        jButton = new JButton("Add");
        jTextField = new JTextField(10);
        jPanel = new JPanel();
        loadTable();
        //For pressing enter/pushing button
        jButton.addActionListener(new EnterListener());
        jTextField.addActionListener(new EnterListener());
        //Add content
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.add(jLabel);
        //Finish
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    private static void loadTable(){
        //String[] columns = {"Name", "Status"};
        model = new DefaultTableModel(0, 0);
        model.addColumn("Name");
        model.addColumn("Status");
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(250,  250));
        table.setFillsViewportHeight(true);
        table.addMouseListener(new ClickListener());
        NameLoader.getList();
        //Add scrollpane
        JScrollPane scrollPane = new JScrollPane(table);
        jFrame.add(scrollPane);
    }

    private static void checkFile(){
        File file = new File("names.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
