package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String windows_1251_FileName = args[0];
        String utf_8_FileName = args[1];

        FileInputStream fis = new FileInputStream(windows_1251_FileName);
        FileOutputStream fos = new FileOutputStream(utf_8_FileName);

        byte[] bt_Windows = new byte[fis.available()];

        fis.read(bt_Windows);
        Charset windows = Charset.forName("Windows-1251");
        String s = new String(bt_Windows, windows);
        Charset utf8 = Charset.forName("UTF-8");
        bt_Windows = s.getBytes(utf8);
        fos.write(bt_Windows);

        fis.close();
        fos.close();
    }
}
