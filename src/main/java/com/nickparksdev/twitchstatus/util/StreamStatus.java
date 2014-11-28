package com.nickparksdev.twitchstatus.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Nick Parks on 11/27/2014 at 2:51 PM.
 */
public class StreamStatus {

    public static boolean isOnline(String twitchName) {
        String URLString = "https://api.twitch.tv/kraken/streams/" + twitchName;
        boolean isLive = false;
        try {
            URL url = new URL(URLString);
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if(inputLine.contains("viewers")){
                    isLive = true;
                    break;
                }
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isLive;
    }
}
