package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yemingjie.
 * @date 2022/3/28.
 * @time 19:21.
 */
public class Test9 {
    public static void main(String[] args) {
        String s = "上海市普贤区，上海市静安区，上海市静安1区,上海市，上海市，杭州市，南京市，常州市，无锡市，常州市,常州市";
        String[] split = s.split(",|，");
        List<String> collect = Arrays.asList(split).stream().distinct().collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : collect) {
            stringBuilder.append(s1).append(",");
        }
//        String s1 = stringBuilder.toString();
//        s1 = s1.substring(0, s1.length() - 1);
        String s1 = stringBuilder.substring(0, stringBuilder.length() - 1);
        System.out.println(s1);
    }
}
