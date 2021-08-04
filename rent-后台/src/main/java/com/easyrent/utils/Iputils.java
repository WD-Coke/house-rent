package com.easyrent.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Iputils {
    public static String getIp(){
        String ip = "";
        String chinaz = "http://ip.tool.chinaz.com/";

        String inputLine = "";
        String read = "";
        try {
            URL url = new URL(chinaz);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while ((read = in.readLine()) != null) {
                inputLine += read;
            }
//            System.out.println(inputLine);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Pattern p = Pattern.compile("class\\=\"fz24\">(.*?)\\<\\/dd>");
        Matcher m = p.matcher(inputLine);
        if (m.find()) {
            ip = m.group(1);
        }
        return ip;
    }
}
