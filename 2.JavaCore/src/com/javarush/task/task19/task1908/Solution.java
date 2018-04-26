package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1;
        String fileName2;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
//        fileName1 ="/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/1";
//        fileName2 ="/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/2";
        reader.close();
        String out = "";
        FileReader fileReader = new FileReader(fileName1);
        BufferedReader fileBufReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedWriter fileBufWriter = new BufferedWriter(fileWriter);
        while (fileBufReader.ready()){
            String string = fileBufReader.readLine();
            String[] strMass = string.split(" ");
            for (String s : strMass){
                try{
                out =out + Integer.parseInt(s) + " ";
                }
                catch (NumberFormatException e){
                }
            }
        }
        fileBufReader.close();
        fileReader.close();
        fileBufWriter.write(out);
        fileBufWriter.close();
        fileWriter.close();
    }
}
