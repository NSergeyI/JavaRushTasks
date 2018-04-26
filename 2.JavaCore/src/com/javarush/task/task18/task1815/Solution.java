package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {

        private ATableInterface inter;

        public TableInterfaceWrapper(ATableInterface inter) {
            this.inter = inter;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            inter.setModel(rows);
        }

        @Override
        public String getHeaderText() {

            return inter.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            inter.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}