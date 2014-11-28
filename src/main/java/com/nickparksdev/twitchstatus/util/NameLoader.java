package com.nickparksdev.twitchstatus.util;

import com.nickparksdev.twitchstatus.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick Parks on 11/27/2014 at 3:33 PM.
 */
public class NameLoader {

    public static void getList() {
        Main.model.setRowCount(0);
        List<String> names = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("names.txt"))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                names.add(line);
                line = br.readLine();
            }
            System.out.print(names.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int x = 0;
        for (String s : names) {
            x++;
            boolean online = StreamStatus.isOnline(s);
            String onlineText;
            if (online) {
                onlineText = "Online!";
            } else {
                onlineText = "Offline!";
            }
            Object[] useMe = {s, onlineText};
            Main.model.addRow(useMe);
        }
    }
}
