package com.ymj.jvm01.c3_code;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname HeapOOM
 * @Description TODO
 * @Date 2021/8/12 16:12
 * @Created by yemingjie
 */
public class HeapOOM {
    // 设置JVM参数最大堆和最小堆：-Xms20m -Xmx20m
    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> oomObjectList = new ArrayList<>();
        while (true) {
            oomObjectList.add(new OOMObject());
        }
    }
}
