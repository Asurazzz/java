package com.ymj.code03_rmi;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Classname CustomMain
 * @Description TODO
 * @Date 2021/6/10 10:50
 * @Created by yemingjie
 */
public class CustomMain {
    public static void main(String[] args) throws Exception{
        // 注册中心
        Registry registry = LocateRegistry.getRegistry(999);
        // 发现服务
        ISayService sayService = (ISayService) registry.lookup("sayService");
        // 调起服务
        String name = sayService.say("小轩");
        System.out.println(name + " say: hello");
    }
}
