package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
    private static ArrayList<String> data = new ArrayList<>();
    private static HashSet<Pair> resultUnicue = new HashSet<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = null;
        BufferedReader fileBufReader = null;
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
        for (int i = 0; i < size; i++) {
            Pair pair = new Pair(data.get(i));
            for (int k = i + 1; k < size; k++) {
                if (pair.checkAndAddSecond(data.get(k))) {
                    resultUnicue.add(pair);
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Pair pair:resultUnicue){
            result.add(pair);
            stringBuilder.append(pair).append("\n");
        }
        System.out.println(stringBuilder);

    }

    public static class Pair {
        String first;
        String firstRevers;
        String second;

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

        public Pair() {
        }

        public Pair(String first) {
            this.first = first;
            StringBuffer stringBuffer = new StringBuffer(first);
            firstRevers = stringBuffer.reverse().toString();
        }

        public boolean checkAndAddSecond(String curent) {
            boolean result = false;
            if (firstRevers.equals(curent)) {
                result = true;
                second = curent;
            }
            return result;
        }
    }

}
