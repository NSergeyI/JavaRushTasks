package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/1", null);
//            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user = new User();
            user.setFirstName("Иван");
            user.setLastName("Смирнов");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println("Проверка" + loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            //implement this method - реализуйте этот метод
            if (this.users.size() != 0) {
                for (User user : this.users) {
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(user.getBirthDate().getTime());
                    writer.println(user.isMale());
                    writer.println(user.getCountry());

                    /*System.out.println(user.getFirstName());
                    System.out.println(user.getLastName());
                    System.out.println(user.getBirthDate().getTime());
                    System.out.println(user.isMale());
                    System.out.println(user.getCountry());*/
                }
                writer.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));


               while (reader.ready()) {
                   User user = new User();
                   user.setFirstName(reader.readLine());
                   user.setLastName(reader.readLine());
                   user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                   if (reader.readLine().equals("true"))
                       user.setMale(true);
                   else
                       user.setMale(false);
                   switch (reader.readLine()) {
                       case "UKRAINE": {
                           user.setCountry(User.Country.UKRAINE);
                           break;
                       }
                       case "RUSSIA": {
                           user.setCountry(User.Country.RUSSIA);
                           break;
                       }
                       case "OTHER": {
                           user.setCountry(User.Country.OTHER);
                           break;
                       }
                   }
                   this.users.add(user);
                   /*System.out.println(user.getFirstName());
                   System.out.println(user.getLastName());
                   System.out.println(user.getBirthDate().getTime());
                   System.out.println(user.isMale());
                   System.out.println(user.getCountry());*/
               }
               reader.close();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
