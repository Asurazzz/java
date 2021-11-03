package com.ymj.jvm02.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class TestMetaspace {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
                if ("run".equals(method.getName())) {
                    System.out.println("启动汽车之前，先进行检查...");
                    return method.invoke(o, objects);
                } else {
                    return method.invoke(o, objects);
                }
            });

            Car car = (Car) enhancer.create();
            car.run();
        }

    }


    static class Car {
        public void run() {
            System.out.println("汽车启动，开始行驶....");
        }
    }
}
