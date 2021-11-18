package com.ymj;

public class Test {
    public static void main(String[] args) {
        String num = "1";
        String num2 = new String("1");
        System.out.println(num == num2);
        System.out.println(num);
    }

    private static void changeNum(String num) {
        num = "2";
    }
}

class Product {
    private int num;
    private String proName;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
