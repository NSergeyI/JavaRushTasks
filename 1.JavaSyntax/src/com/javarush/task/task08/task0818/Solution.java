package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Иванов", 1000);
        map.put("Иванов2", 400);
        map.put("Иванов3", 2000);
        map.put("Иванов4", 300);
        map.put("Иванов5", 5000);
        map.put("Иванов6", 500);
        map.put("Иванов7", 400);
        map.put("Иванов8", 2000);
        map.put("Иванов9", 10000);
        map.put("Иванов10", 100000);
        return map;  //напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            int salary = iterator.next().getValue();
            if (salary < 500) {
                iterator.remove();
            }
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {
     /*   HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
*/
    }
}