package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<Character> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String openTeg = args[0];
            String closeTeg = "/" + args[0];
            int countOfSubTeg = 0;
            int ch;
            while (fileReader.ready()) {
                ch = fileReader.read();
                if( ch != 13 ) arrayList.add((char)ch);
            }

            ArrayList<Integer> startOfSubString = new ArrayList<>();
            ArrayList<Integer> endOfSubString = new ArrayList<>();
            int i=0;
            int y=0;



            while ((i=findOpenTeg(y, openTeg.toCharArray())) >0 ) {
                y=i+openTeg.length() +1;
                startOfSubString.add(i);
            }
            i=0;
            y=0;
            while ((i=findCloseTeg(y, closeTeg.toCharArray())) >0 ) {
                y=i+closeTeg.length() +2;
                endOfSubString.add(y);
            }

            i=0;
            y=1;
            boolean cond = true;
            int countOfSubString=0;
            boolean sub = false;
            while (cond) {


                while (endOfSubString.get(i) > startOfSubString.get(y)) {
                    countOfSubString++;
                    y++;
                }

                if (!sub) {
                    for(int index=startOfSubString.get(i); index < endOfSubString.get(i+countOfSubString); index++){
                        System.out.print(arrayList.get(index));
                    }
                    sub=true;
                } else {
                    for(int index=startOfSubString.get(i); index < endOfSubString.get(i-countOfSubString); index++){
                        System.out.print(arrayList.get(index));
                    }
                    countOfSubString--;
                    if(countOfSubString == 0) sub =false;
                }

                System.out.println();
                if (y + 1 < endOfSubString.size()) {
                    i = i+1;
                    y = i+1;

                }
                else {
                    i++;
                    for(int index=startOfSubString.get(i); index < endOfSubString.get(i); index++){
                        System.out.print(arrayList.get(index));
                    }
                    cond = false;
                }

            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int findOpenTeg(int startOfSearching, char[] teg) {
        if (startOfSearching < arrayList.size()) {
            boolean find = false;
            int j=0;
            int returnNumber = 0;
            for(int i=startOfSearching; i<arrayList.size(); i++){

                if(arrayList.get(i) == teg[j] && arrayList.get(i-1) != '/') {
                    j++;
                }
                if(j == teg.length) {
                    find = true;
                    returnNumber = i;
                    break;
                }
            }
            if(find) return returnNumber-teg.length;
        }
        return -1;
    }

    public static int findCloseTeg(int startOfSearching, char[] teg) {
        if (startOfSearching < arrayList.size()) {
            boolean find = false;
            int j=0;
            int returnNumber = 0;
            for(int i=startOfSearching; i<arrayList.size(); i++){

                if(arrayList.get(i) == teg[j]) {
                    j++;
                }
                if(j == teg.length) {
                    find = true;
                    returnNumber = i;
                    break;
                }
            }
            if(find) return returnNumber-teg.length;
        }
        return -1;
    }
}

/*// старый вариант
 while (bufferedReader.ready()){
         char ch = (char) bufferedReader.read();
         if(ch == '<') {

         bufferedReader.read(fileArray);
         for(int i=0; i<fileArray.length; i++){
        temp = temp + fileArray[i];
        }
        //System.out.println(temp);
        if(temp.equals(teg)) {
        temp = "<" + temp;
        while (bufferedReader.ready()){
        ch = (char) bufferedReader.read();
        if(ch != '/') temp = temp + ch;
        else {
        temp = temp + ch;
        bufferedReader.read(fileArray);
        for(int i=0; i<fileArray.length; i++){
        temp1 = temp1 + fileArray[i];
        }
        if(temp1.equals(teg)){
        temp = temp + temp1 + ">";
        System.out.println(temp);
        }
        }
        }
        }
        }
        }*/

/*
            while ((i=findTeg(i, openTeg.toCharArray())) > 0){
                    startOfSubString.add(i-openTeg.length()+1);
                    }
                    System.out.println(startOfSubString);

                    for (int k=0; k<startOfSubString.size(); k++) {
        for(int j=startOfSubString.get(k); j<arrayList.size(); j++){
        System.out.print(arrayList.get(j));
        }
        System.out.println();
        }*/
