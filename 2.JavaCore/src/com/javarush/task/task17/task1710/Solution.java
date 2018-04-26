package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.Integer.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat pattern1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Solution sol = new Solution();
        String[] s = args;
        int length = s.length;

        switch (s[0]) {
            case "-c": {
                try {
                    if (s[2].equals("м"))
                        allPeople.add(Person.createMale(s[1], pattern1.parse(s[3])));
                    else allPeople.add(Person.createFemale(s[1], pattern1.parse(s[3])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println(allPeople.size() - 1);
                break;
            }
            case "-u": {
                int index = parseInt(s[1]);
                try {
                    if (s[3].equals("м")) {
                        allPeople.set(index, Person.createMale(s[2], pattern1.parse(s[4])));
                    } else {
                        allPeople.set(index, Person.createFemale(s[2], pattern1.parse(s[4])));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "-d": {
                int index = parseInt(s[1]);
                Person p = Person.createMale(null, null);
                p.setSex(null);
                allPeople.set(index, p);
                break;

            }
            case "-i": {
                String out;
                int index = parseInt(s[1]);
                SimpleDateFormat pattern = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                if (allPeople.get(index).getSex() == Sex.MALE)
                    out = allPeople.get(index).getName() + " " + "м" + " " + pattern.format(allPeople.get(index).getBirthDay());
                else
                    out = allPeople.get(index).getName() + " " + "ж" + " " + pattern.format(allPeople.get(index).getBirthDay());
                System.out.println(out);
                break;
            }

        }

        //start here - начни тут
    }


}
