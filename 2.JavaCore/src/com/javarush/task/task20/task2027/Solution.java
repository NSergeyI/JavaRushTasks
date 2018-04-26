package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> list = new ArrayList<>();
        int finY = crossword.length;
        int finX = crossword[0].length;
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        for (int y = 0; y < crossword.length; y++)                      //Y
            for (int x = 0; x < crossword[y].length; x++)               //X
                for (int w = 0; w < words.length; w++) {
                    boolean flag = false;
                    if (words[w].charAt(0) == crossword[y][x]) {        //1 Сисвол слова
                        for (int dY = 0; dY < 3; dY++)                  //Направление по Y
                            for (int dX = 0; dX < 3; dX++) {            //Направление по X
                                int wIndex = 1;
                                int tempX = x + dx[dX];
                                int tempY = y + dy[dY];
                                if (!(tempX == -1 || tempX == finX || tempY == -1 || tempY == finY) && (words[w].charAt(wIndex) == crossword[tempY][tempX])) {
                                    flag = true;

                                    while (words[w].length() > wIndex+1) {
                                        tempX += dx[dX];
                                        tempY += dy[dY];
                                        wIndex++;
                                        if (!(tempX == -1 || tempX == finX || tempY == -1 || tempY == finY) && (words[w].charAt(wIndex) == crossword[tempY][tempX])) {
                                            flag = true;
                                        } else {
                                            flag = false;
                                            break;
                                        }
                                    }
                                if (flag) {
                                        Word word = new Word(words[w]);
                                        word.setStartPoint(x, y);
                                        word.setEndPoint(tempX, tempY);
                                        list.add(word);
                                        flag = false;
                                    }
                                }
                            }
                    }
                }
        return list;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

