package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;


        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            String[] sc = this.fileScanner.nextLine().split(" ");
            Date bd = simpleDateFormat.parse(sc[3] + " " + sc[4] + " " + sc[5]);
//                    GregorianCalendar(Integer.parseInt(sc[5]),Integer.parseInt(sc[4])-1,Integer.parseInt(sc[3])).getTime();
            Person person = new Person(sc[1], sc[2], sc[0], bd);
            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
