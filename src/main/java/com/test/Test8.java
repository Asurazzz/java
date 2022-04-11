package com.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yemingjie.
 * @date 2022/3/14.
 * @time 19:00.
 */
public class Test8 {
    public static void main(String[] args) {
        String name = "aa,bb,cc";
        List<String> collect = Arrays.stream(name.split(",")).collect(Collectors.toList());

        Map<Long, String> map = new HashMap<>();
        map.put(1L, "aa");
        map.put(2L, "dd");
//        for (String s : collect) {
//            for (Map.Entry<Long, String> m : map.entrySet()) {
//                if (s.equals(m.getValue())) {
//                    System.out.println(m.getKey());
//                }
//            }
//        }
        List<String> result = new ArrayList<>();
        result.add("aa");
        result.add("dd");
        result = handle11(collect, result);
        System.out.println(result);



    }

    private static List<String> handle11(List<String> collect, List<String> result) {
        List<String> aaa = new ArrayList<>();
        for (String s : collect) {
            for (String a : result) {
                if (s.equals(a)) {
                    aaa.add(a);
                }
            }
        }
        return aaa;
    }
}
