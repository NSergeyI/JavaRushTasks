package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        String url = "";
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        try{
            url = read.readLine();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     //   ArrayList<String> mst = new ArrayList<String>();
//        int dcount = 0;
//        int scount = 0;
//        String par = "";
//        boolean flag = false;
//        char sim;

        url = url.substring(url.indexOf('?')+1);

       String[] mst = url.split("&");

//        System.out.println(url);
        /*for(int i = 0;i < (url.length() - 1); i++){
            sim = url.charAt(i);
            if (sim == '?'){
                flag = true;
            }
            if (sim == '='){
                flag = false;
                mst.add(par);
                par = "";
            }
            if (flag && sim != '?'){
                par += sim;
            }

        }*/
        int eq;
//        Double[] dobj;
//        String[] sobj;
        ArrayList<Double> dobj = new ArrayList<Double>();
        ArrayList<String> sobj = new ArrayList<String>();
        for (int i = 0; i < (mst.length); i++) {
            eq = mst[i].indexOf("=");
            if (eq != -1){
                if (mst[i].contains("obj")){

                    try{
                        dobj.add(Double.parseDouble(mst[i].substring(eq+1)));
                    }catch (Exception ex){
                        sobj.add(mst[i].substring(eq+1));
                    }

                }
                mst[i] = mst[i].substring(0,eq);
            }
            System.out.println(mst[i]);
        }
        if (dobj.size() != 0){
            for (int i = 0;i<dobj.size();i++){
              alert(dobj.get(i));
            }
        }
        if (sobj.size() != 0){
            for (int i = 0;i<sobj.size();i++){
                alert(sobj.get(i));
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
