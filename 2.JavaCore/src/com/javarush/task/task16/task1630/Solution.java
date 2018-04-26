package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        private ArrayList<String> outFile = new ArrayList<String>();

        private String filName;

        @Override
        public void setFileName(String fullFileName) {
            this.filName = fullFileName;
        }

        @Override
        public String getFileContent() {
            String result = "";
            for (String s: this.outFile){
                result = result + s + " ";
            }

            return result;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(this.filName));
                String s;
                while ((s = reader.readLine()) != null)
                    this.outFile.add(s);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
