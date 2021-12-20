package com.ymj.code03_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Classname ServiceMain
 * @Description TODO
 * @Date 2021/6/10 10:31
 * @Created by yemingjie
 */
public class ServiceMain {

    public static void main(String[] args) throws RemoteException {
        // 实例化要暴露给远程的方法/接口
        com.ymj.code03_rmi.ISayService impl = new com.ymj.code03_rmi.SayServiceImpl();
        // 开启本地服务
        com.ymj.code03_rmi.ISayService sayService = (com.ymj.code03_rmi.ISayService) UnicastRemoteObject.exportObject(impl, 666);
        // 服务注册中心
        Registry registry = LocateRegistry.createRegistry(999);
        // 注册服务
        registry.rebind("sayService", sayService);

    }
}
