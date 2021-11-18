package com.ymj.test;

import org.openjdk.jol.info.ClassLayout;

/**
 * -> Run/Debug Configurations / VM options填-XX:+UseCompressedOops开启指针压缩并运行程序；
 */
public class CountSimpleObjectSize {
    static int[] arr = {0, 1, 2, 4};

    public static void main(String[] args) {
        CountSimpleObjectSize test1 = new CountSimpleObjectSize();
        // 开启指针压缩时，
        // 32B = 8B (Mark Word) + 4B (类型指针) + 4B (数组长度) + 4*3B (实例数据) + 4B (对齐填充)
        // 关闭指针压缩时，
        // 40B = 8B (Mark Word) + 8B (类型指针) + 4B (数组长度) +  4B (对齐填充) + 4*3B (实例数据) + 4B (对齐填充)
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
        // 8+4+4+12+4=32
    }
}
