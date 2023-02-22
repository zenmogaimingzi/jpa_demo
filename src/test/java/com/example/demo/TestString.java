package com.example.demo;

import java.util.HashSet;

public class TestString {


    private static String  str = "qweee";


    public static void main(String[] args) {

        char[] chars = str.toCharArray();

        StringBuffer stringBuffer = new StringBuffer();
        for (char aChar : chars) {
            stringBuffer.insert(0,aChar);
        }

        System.out.println(stringBuffer.toString());



    }



}
