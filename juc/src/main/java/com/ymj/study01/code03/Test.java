package com.ymj.study01.code03;

public class Test {

    public static void main(String[] args) {
        String s = noPassById("");
        System.out.println(s);
    }

    public static String noPassByName(String str) {
        if (str.length() == 2) {
            return str.substring(0, 1) + "*";
        } else if (str.length() == 3) {
            return str.substring(0,1) + "*" + str.substring(2,3);
        } else if (str.length() > 3) {
            return str.substring(0, 1) + "*" + "*" + str.substring(3);
        } else {
            return "*";
        }
    }


    private static String noPassById(String str) {
        if (str == null) {
            return "***";
        }
        if (str.length() <= 4) {
            return "***" + str;
        }
        return "***" + str.substring(str.length() - 4);
    }
}

