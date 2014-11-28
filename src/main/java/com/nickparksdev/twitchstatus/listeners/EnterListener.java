package com.nickparksdev.twitchstatus.listeners;

import com.nickparksdev.twitchstatus.Main;
import com.nickparksdev.twitchstatus.util.NameLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nick Parks on 11/27/2014 at 3:22 PM.
 */
public class EnterListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = Main.jTextField.getText();
        if(input.equals("") || input.equals(" ")){
            return;
        }
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("names.txt", true)))) {
            out.println(input);
        } catch (IOException ex) {
            //exception handling left as an exercise for the reader
        }
        NameLoader.getList();
    }
}
