package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == null) return false;

        if (!(n instanceof Solution)) return false;

        if (this == n) return true;

        Solution s = (Solution) n;

        return (((first == s.first)||(first != null && first.equals(s.first)))&&((last==s.last)||(last!=null&&last.equals(s.last))));
    }

    @Override
        public int hashCode() {
        int result = 31 + (first == null ? 0 : first.hashCode());
        return 31 * result + (last == null ? 0 : last.hashCode());
//        return first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(null, null));
        s.add(new Solution("avb", null));
        s.add(new Solution(null, "bkv"));
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution(null, null)));
        System.out.println(s.contains(new Solution("avb", null)));
        System.out.println(s.contains(new Solution(null, "bkv")));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
