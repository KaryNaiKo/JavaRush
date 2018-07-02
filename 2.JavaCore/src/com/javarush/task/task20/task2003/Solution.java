package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();


    public void fillInPropertiesMap() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        FileInputStream fis = new FileInputStream(fileName);

        load(fis);
        fis.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        for(Map.Entry<String, String> pair : properties.entrySet())  {
            p.setProperty(pair.getKey(), pair.getValue());
        }
        p.store(outputStream, "=");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод


        Properties p = new Properties();
        p.load(inputStream);

        Enumeration enuKeys = p.keys();
        while (enuKeys.hasMoreElements()) {
            String key = (String) enuKeys.nextElement();
            String value = p.getProperty(key);

            properties.put(key, value);
        }
        //System.out.println(properties);
    }

    public static void main(String[] args) throws Exception{
        //new Solution().fillInPropertiesMap();
    }
}
