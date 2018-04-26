package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.HashSet;

/*
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;
//        boolean b;
//        b =Double.compare(solution1.aDouble, aDouble) != 0;
//        System.out.println("1 "+b);
        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;

//        b =anInt != solution1.anInt;
//        System.out.println("2 "+b);
        if (anInt != solution1.anInt) return false;

//        b=date != null ? !date.equals(solution1.date) : solution1.date == null;
//        System.out.println("3 "+b);
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;

//        b=solution != null ? !solution.equals(solution1.solution) : solution1.solution != null;
//        System.out.println("4 "+b);
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;

//        b=string != null ? !string.equals(solution1.string) : solution1.string != null;
//        System.out.println("5 "+b);
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Solution sol1 = new Solution(1, "sdf", 2.3, new Date(123), null);
        Solution sol2 = new Solution(1, "sdf", 2.3, new Date(123), null);
        Solution sol3 = new Solution(0, null, 0, null, null);
        System.out.println(sol1.hashCode());
        System.out.println(sol2.hashCode());
        System.out.println(sol1.equals(sol2));
        HashSet<Solution> set = new HashSet<>();
        set.add(sol1);
        set.add(sol3);
        System.out.println(set.contains(sol2) + "--");
    }
}
