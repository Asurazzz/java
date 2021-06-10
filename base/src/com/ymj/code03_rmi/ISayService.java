package com.ymj.code03_rmi;

import java.rmi.Remote;

/**
 * @Classname ISayService
 * @Description TODO
 * @Date 2021/6/10 10:29
 * @Created by yemingjie
 */
public interface ISayService extends Remote {
    String say(String name) throws Exception;
}
