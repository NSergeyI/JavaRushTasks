package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        List<String> lines1 = new ArrayList<>();
        List<String> lines2 = new ArrayList<>();
        while (file1.ready()) lines1.add(file1.readLine());
        file1.close();
        while (file2.ready()) lines2.add(file2.readLine());
        file2.close();
        int i = 0;
        boolean notWorking = false;
        while (!notWorking) {
//            System.out.println("-------------------");
            notWorking = true;
            if (i < lines2.size()&&i<lines1.size()) {
                if (lines1.get(i).equals(lines2.get(i))) {
                    lines.add(new LineItem(Type.SAME, lines1.get(i)));
                    notWorking = false;
//                    System.out.println(1);
                }
            }
            if (notWorking && i + 1 < lines2.size()) {
                if (lines1.get(i).equals(lines2.get(i + 1))) {
                    lines.add(new LineItem(Type.ADDED, lines2.get(i)));
                    lines1.add(i, "zero");
                    notWorking = false;
//                    System.out.println(2);
                }
            }
            if (notWorking && i + 1 < lines1.size()) {
                if (lines1.get(i + 1).equals(lines2.get(i))) {
                    lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                    lines2.add(i, "zero");
                    notWorking = false;
//                    System.out.println(3);
                }
            }
            if (notWorking && i + 1 == lines1.size() && i + 1 > lines2.size()) {
                lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                lines2.add(i, "zero");
//                notWorking = false;
//                System.out.println(4);
            }
            if (notWorking && i + 1 == lines2.size() && i + 1 > lines1.size()) {
                lines.add(new LineItem(Type.ADDED, lines2.get(i)));
                lines1.add(i, "zero");
//                notWorking = false;
//                System.out.println(5);
            }
            i++;
/*
            Решил задачу. В последнем блоке проверки проверял если в итоге под конец
            lines1 у меня окажется длинее на 1 элемент, чем lines2 и соответственно при
            положительном результате в lines добавлял элемент REMOVED. А вот обратную ситуацию,
            когда lines2 окажется на 1 элемент длинее чем lines1 не проверял. Добавил это дело и проверка прошла.
*/
//            System.out.println(i);
        }
//       for (LineItem item : lines) {
//            System.out.println(item.type + " " + item.line);
//        }
//        for (int j = 0; j < lines1.size(); j++) {
//            System.out.println(lines1.get(j) + " " + lines2.get(j));
//        }
    }


   /*     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1;
        String file2;
        file1 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/1";
        file2 = "/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/2";
//        file1 = reader.readLine();
//        file2 = reader.readLine();
        reader.close();

        FileReader fileReader1 = new FileReader(file1);
        FileReader fileReader2 = new FileReader(file2);
//        BufferedReader bufferedReaderFile1 = new BufferedReader(fileReader1);
//        BufferedReader bufferedReaderFile2 = new BufferedReader(fileReader2);

        ArrayList<String> alfile1 = new ArrayList<>();
        ArrayList<String> alfile2 = new ArrayList<>();
        String out = "";

        while (fileReader1.ready()) {
            int c = fileReader1.read();
            while (c != 10) {
                out = out + (char) c;
                System.out.println(c +"  " + (char) c);
                c = fileReader1.read();
            }
            out = out + "\n";
            alfile1.add(out);
            out = "";
        }
        fileReader1.close();
        while (fileReader2.ready()) {
            int c = fileReader2.read();
            while (c != 10) {
                out = out + (char) c;
                c = fileReader2.read();
            }
            out = out + "\n";
            alfile2.add(out);
            out = "";
        }
        fileReader2.close();

        *//*while (bufferedReaderFile1.ready())
            alfile1.add(bufferedReaderFile1.readLine());
        fileReader1.close();
        bufferedReaderFile1.close();
        while (bufferedReaderFile2.ready())
            alfile2.add(bufferedReaderFile2.readLine());
        fileReader2.close();
        bufferedReaderFile2.close();
        *//*

        int i1 = 0;
        int i2 = i1;
        String s1 = StrFile(alfile1, i1);
        String s2 = StrFile(alfile2, i2);
        while (s1 != null || s2 != null) {
//            System.out.println(i1 + "  " + i2);

            if (Eq(s1, s2)) {
                lines.add(new LineItem(Type.SAME, s1));
                i1++;
                i2++;
            } else {
                if (Eq(s1, StrFile(alfile2, i2 + 1))) {
                    lines.add(new LineItem(Type.ADDED, s2));
                    i2++;
                } else {
                    if (Eq((s2), StrFile(alfile1, i1 + 1))) {
                        lines.add(new LineItem(Type.REMOVED, s1));
                        i1++;
                    }
                }
            }

            s1 = StrFile(alfile1, i1);
            s2 = StrFile(alfile2, i2);
        }





*//*        String stringFile1;
        String stringFile12;
        String stringFile2;
        String stringFile22;*//*

   *//*     stringFile1 = bufferedReaderFile1.readLine();
        stringFile12 = bufferedReaderFile1.readLine();
        stringFile2 = bufferedReaderFile2.readLine();
        stringFile22 = bufferedReaderFile2.readLine();
        while (stringFile1 != null || stringFile2 != null) {
            if (stringFile1.equals(stringFile2)) {
                lines.add(new LineItem(Type.SAME, stringFile1));
                stringFile1 = stringFile12;
                stringFile2 = stringFile22;
                if (bufferedReaderFile1.ready())
                    stringFile12 = bufferedReaderFile1.readLine();
                else stringFile12 = null;
                if (bufferedReaderFile2.ready())
                    stringFile22 = bufferedReaderFile2.readLine();
                else stringFile22 = null;
            } else {
                if (stringFile1 == null) {
                    lines.add(new LineItem(Type.ADDED, stringFile2));
                    stringFile2 = stringFile22;
                } else {
                    if (stringFile2 == null) {
                        lines.add(new LineItem(Type.REMOVED, stringFile1));
                        stringFile1 = stringFile12;
                    } else {


                        if (stringFile1.equals(stringFile22)) {
                            lines.add(new LineItem(Type.ADDED, stringFile2));
                            stringFile2 = stringFile22;
                            if (bufferedReaderFile2.ready())
                                stringFile22 = bufferedReaderFile2.readLine();
                            else stringFile22 = null;
                        } else {
                            if (stringFile12.equals(stringFile2)) {
                                lines.add(new LineItem(Type.REMOVED, stringFile1));
                                stringFile1 = stringFile12;
                                if (bufferedReaderFile1.ready())
                                    stringFile12 = bufferedReaderFile1.readLine();
                                else stringFile12 = null;

                            }
                        }
                    }
                }
            }

        }*//*


      *//*  bufferedReaderFile1.close();
        bufferedReaderFile2.close();
        fileReader1.close();
        fileReader2.close();*//*
    *//*    for (LineItem lt : lines) {
            System.out.println(lt.type + " : " + lt.line);
        }
        System.out.println("stringFile1  " + s1);
        System.out.println("stringFile12  " + s2);
*//*

    }*/

   /* private static String StrFile(ArrayList alfile, int i) {

        try {
            return (String) alfile.get(i);

        } catch (Exception e) {
            return null;
        }
    }

    private static boolean Eq(String s1, String s2) {
        if (s1 == null)
            return true;
        else if (s2 == null)
            return false;
        else
            return s1.equals(s2);
    }*/


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
