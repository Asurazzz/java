package com.ymj.study01.code03;

public class Base
{
    public void methodOne()
    {
        System.out.print("A");
        methodTwo();
    }

    public void methodTwo()
    {
        System.out.print("B");
    }

    public static void main(String[] args) {
        Base b = new Derived();
        b.methodOne();
    }
}

class Derived extends Base
{
    @Override
    public void methodOne()
    {
        super.methodOne();
        System.out.print("C");
    }

    @Override
    public void methodTwo()
    {
        //super.methodTwo();
        System.out.print("D");
    }
}