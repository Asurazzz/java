package com.ymj.code07_optional;

/**
 * @Classname WithoutOptionalDemo
 * @Description TODO
 * @Date 2021/6/21 10:05
 * @Created by yemingjie
 */
public class WithoutOptionalDemo {

    public static void main(String[] args) {
        Member member = getMemberByIdFromDB();
        if (member != null) {
            System.out.println(member.getName());
        }
    }


    public static Member getMemberByIdFromDB() {
        // 当前 ID 的会员不存在
        return null;
    }
}

class Member{
    private String name;

    public Member() {}

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
