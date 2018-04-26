package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
//        fileName = reader.readLine();
        fileName = "/home/winnie/JavaRush/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2207/1";
        BufferedReader filereader = new BufferedReader(new FileReader(fileName));

        reader.close();
        String out = "";
        while (filereader.ready()) {
            out += " " + filereader.readLine();
        }
        filereader.close();
        String[] spl = out.split(" ");
        for (int i = 0; i < spl.length; i++) {
            StringBuilder s1 = new StringBuilder(spl[i]);
            s1.reverse();
            for (int j = i + 1; j < spl.length; j++) {
                if (s1.toString().equals(spl[j])){
                    Pair check = new Pair(spl[j],spl[i]);
                    if (!result.contains(check))
                        result.add(check);

                }
            }
        }
        for (Pair pair : result) {
            System.out.println(pair);
            System.out.println(pair.first);
            System.out.println(pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String  second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
