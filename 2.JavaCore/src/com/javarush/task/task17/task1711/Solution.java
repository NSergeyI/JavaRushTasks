package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.Integer.parseInt;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat pattern1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Solution sol = new Solution();
        String[] s = args;
        int length = s.length;

        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    try {
                        int k = length / 3;
                        for (int i = 0; i < k; i++) {
                            if (s[2 + i * 3].equals("м"))
                                allPeople.add(Person.createMale(s[1 + i * 3], pattern1.parse(s[3 + i * 3])));
                            else allPeople.add(Person.createFemale(s[1 + i * 3], pattern1.parse(s[3 + i * 3])));
                            System.out.println(allPeople.size() - 1);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            case "-u": {
                synchronized (allPeople) {
                    try {
                        int k = length / 4;
                        for (int i = 0; i < k; i++) {
                            int index = parseInt(s[1 + i * 4]);
                            if (s[3 + i * 4].equals("м")) {
                                allPeople.set(index, Person.createMale(s[2 + i * 4], pattern1.parse(s[4 + i * 4])));
                            } else {
                                allPeople.set(index, Person.createFemale(s[2 + i * 4], pattern1.parse(s[4 + i * 4])));
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            case "-d": {
                synchronized (allPeople) {
                    int k = length - 1;
                    for (int i = 0; i < k; i++) {

                        int index = parseInt(s[1 + i]);
                        Person p = Person.createMale(null, null);
                        p.setSex(null);
                        allPeople.set(index, p);
                    }
                    break;

                }
            }
            case "-i": {
                synchronized (allPeople) {
                    String out;
                    int k = length - 1;
                    for (int i = 0; i < k; i++) {
                        int index = parseInt(s[1 + i]);
                        SimpleDateFormat pattern = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        if (allPeople.get(index).getSex() == Sex.MALE)
                            out = allPeople.get(index).getName() + " " + "м" + " " + pattern.format(allPeople.get(index).getBirthDay());
                        else
                            out = allPeople.get(index).getName() + " " + "ж" + " " + pattern.format(allPeople.get(index).getBirthDay());
                        System.out.println(out);
                    }
                    break;
                }
            }

        }

        //start here - начни тутfor (String ss: args){
    }

}
