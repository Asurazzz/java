package com.ymj.code03_rmi;

/**
 * @Classname SayServiceImpl
 * @Description TODO
 * @Date 2021/6/10 10:30
 * @Created by yemingjie
 */
public class SayServiceImpl implements ISayService{
    @Override
    public String say(String name) throws Exception {
        System.out.println(name + " say : hello2");
        return name + " say : hello1";
    }
}
