package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yemingjie.
 * @date 2022/4/21.
 * @time 10:37.
 */
public class Test11{
    public static void main(String[] args){
        List<User> list = new ArrayList<>();
        //定义三个用户对象
        User user1 = new User();
        user1.setUsername("huxiansen");
        user1.setPassword("123456");
        User user2 = new User();
        user2.setUsername("同步未完成");
        user2.setPassword("123456");
        User user3 = new User();
        user3.setUsername("huxiansen");
        user3.setPassword("123456");
        //添加用户到集合中
        list.add(user1);
        list.add(user2);
        list.add(user3);

        boolean b = list.stream().allMatch(user -> "123456".equals(user.getPassword()));
        System.out.println(b);

        //在集合中查询用户名为huxiansen的集合
        List<User> userList = list.stream().filter(user -> !"同步未完成".equals(user.getUsername())).collect(Collectors.toList());
        //在集合中查询出第一个用户密码为123456的用户
        Optional<User> user = list.stream().filter(userTemp -> "123456".equals(userTemp.getPassword())).findFirst();

        System.out.println(userList);
        System.out.println(user);

        List<User> alist = new ArrayList<>();
        System.out.println(alist.get(0).getPassword());

        String collect = list.stream().map(user11 -> user11.getUsername()).collect(Collectors.joining(","));
        System.out.println(collect);
//        for (int i = 0; i < 24; i++) {
//            String fkId = String.valueOf(i);
//            for (int j = 0; j < 100; j++) {
//                String table = String.valueOf(j);
//                System.out.println(fkId + "_" + table);
//            }
//        }
    }
}

