package com.nickparksdev.twitchstatus.listeners;

import com.nickparksdev.twitchstatus.Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Nick Parks on 11/27/2014 at 7:01 PM.
 */
public class ClickListener implements MouseListener{

    //Credit for methods: http://stackoverflow.com/a/10967469

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = Main.table.rowAtPoint(e.getPoint());
        int col = 0;
        String URL = "http://twitch.tv/" + Main.table.getModel().getValueAt(row, col).toString();
        try {
            URL url = new URL(URL);
            openWebpage(url);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
