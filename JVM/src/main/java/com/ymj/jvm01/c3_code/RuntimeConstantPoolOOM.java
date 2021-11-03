package com.ymj.jvm01.c3_code;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname RuntimeConstantPoolOOM
 * @Description TODO
 * @Date 2021/8/12 17:12
 * @Created by yemingjie
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // VM Args： -XX:PermSize=6M -XX:MaxPermSize=6M

        // 使用Set保持着常量池引用， 避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
