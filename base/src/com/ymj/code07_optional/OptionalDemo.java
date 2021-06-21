package com.ymj.code07_optional;

import java.util.Optional;

/**
 * @Classname OptionalDemo
 * @Description TODO
 * @Date 2021/6/21 10:08
 * @Created by yemingjie
 */
public class OptionalDemo {
    public static void main(String[] args) {

        Optional<Member> optional = getMemberByIdFromDB();
        optional.ifPresent(mem -> {
            System.out.println("会员名称是：" + mem.getName());
        });
    }


    public static Optional<Member> getMemberByIdFromDB() {
        boolean hasName = true;
        if (hasName) {
            return Optional.of(new Member("干天慈雨"));
        }
        return Optional.empty();
    }
}


