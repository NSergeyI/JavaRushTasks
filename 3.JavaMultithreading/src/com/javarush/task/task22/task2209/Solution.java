package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = null;
        BufferedReader fileBufReader = null;
        List<String> data = new ArrayList<>();
        try {
            fileReader = new FileReader(reader.readLine());
            fileBufReader = new BufferedReader(fileReader);
            while (fileBufReader.ready()) {
                String[] currentArray = fileBufReader.readLine().split(" ");
                for (String current : currentArray) {
                    data.add(current);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                fileBufReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        int size = data.size();
        String[] dataArray = data.toArray(new String[size]);

        StringBuilder result = getLine(dataArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if (words.length == 0) return result;
        List<String> out = new ArrayList<>();
        List<String> in = new ArrayList<>();
        for(int i=1;i<words.length;i++){
            in.add(words[i]);}
        out.add(words[0]);
        out = sort(in,out);
        for(String current:out){
            result.append(current).append(" ");
        }
        result.setLength(result.length()-1);
        return result;
    }

    private static List<String> sort(List<String> in, List<String> out) {
        int check = in.size();
        for (int i=0;i<in.size();i++){
            char startOut = getStart(out.get(0));
            char endOut = getEnd(out.get(out.size()-1));
            char startIn = getStart(in.get(i));
            char endIn = getEnd(in.get(i));
            if (endOut==startIn||Character.toUpperCase(endOut)==startIn||endOut==Character.toUpperCase(startIn)){
                out.add(in.get(i));
                in.remove(i);
                i--;
            } else {
                if (startOut==endIn||Character.toUpperCase(startOut)==endIn||startOut==Character.toUpperCase(endIn)){
                    out.add(0,in.get(i));
                    in.remove(i);
                    i--;
                }
            }
        }
        if (in.isEmpty()||check==in.size()){
            return out;
        }
        out = sort(in,out);
        return out;
    }

    private static char getEnd(String s) {
        int end =s.length();
        return s.charAt(end-1);
    }

    private static char getStart(String s) {
        return s.charAt(0);
    }

}
