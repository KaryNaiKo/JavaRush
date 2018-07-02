package com.javarush.task.task40.task4011;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

/* 
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
        URL url = new URL("https://www.google.com.ua/images/srpr/logo11w.png");
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, new File("c:/google.png").toPath());
    }

    public static void decodeURLString(String s)  {
        try {
            URL url = new URL(s);
            System.out.println("Protocol - " + url.getProtocol());
            System.out.println("Authority - " + url.getAuthority());
            System.out.println("File - " + url.getFile());
            System.out.println("Host - " + url.getHost());
            System.out.println("Path - " + url.getPath());
            System.out.println("Port - " + url.getPort());
            System.out.println("DefPort - " + url.getDefaultPort());
            System.out.println("Query - " + url.getQuery());
            System.out.println("Ref - " + url.getRef());
        } catch (MalformedURLException e) {
            System.out.format("Parameter %s is not a valid URL.", s);
        }
    }
}
