package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("/home/winnie/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/1");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(solution.stream);
        objectOutputStream.writeObject(solution);
        solution.stream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(solution.fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Solution solution1 = (Solution) objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();
        System.out.println(solution.equals(solution1));
        solution.stream.close();
        solution1.stream.close();
    }
}
