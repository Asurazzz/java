package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author yemingjie.
 * @date 2022/4/11.
 * @time 10:22.
 */
public class Test10 {
    public static void main(String[] args) {
        List<User> userSet = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("aa");
        userSet.add(user);
        user = new User();
        user.setId(2L);
        user.setName("bb");
        userSet.add(user);
        user = new User();
        user.setId(3L);
        user.setName("aa");
        userSet.add(user);

        List<User> list = userSet.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingLong(User::getId))), ArrayList::new));

        System.out.println(list);

    }
}
