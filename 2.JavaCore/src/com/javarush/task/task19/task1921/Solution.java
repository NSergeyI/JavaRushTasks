package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String strIn;
        String strName = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy");

        while (bufferedReader.ready()) {
            strIn = bufferedReader.readLine();
            String[] strM = strIn.split(" ");
            for (int i = 0; i < strM.length - 3; i++) {
                strName = strName + strM[i] + " ";
            }
            StringBuilder stringBuilder = new StringBuilder(strName);
            stringBuilder = stringBuilder.deleteCharAt(stringBuilder.length()-1);
            strName = stringBuilder.toString();
            Date date = simpleDateFormat.parse(strM[strM.length - 3] + "/" + strM[strM.length - 2] + "/" + strM[strM.length - 1]);
//            System.out.println(date);
            Person p = new Person(strName, date);
            PEOPLE.add(p);
            strName = "";
        }
        bufferedReader.close();

//        for (Person p : PEOPLE)
//            System.out.println(p.getName() + " " + p.getBirthday());
    }
}

