package com.ymj.code07_optional;

import java.util.Optional;

/**
 * @Classname OptionalDemo
 * @Description
 *
 * Optional.of：创建一个Optional实例
 *
 * Optional.empty：创建一个空的Optional实例
 *
 * Optional.ofNullable：若t不为null，创建optional实例，否者创建一个空实例
 *
 * isPresent：判断是否包含值
 *
 * orElse(T t)：如果对象包含值，则返回该值，否则返回t
 *
 * orElseGet(Supplier s)：如果调用对象包含值，返回该值，否则返回S获取的值
 *
 * map(Function f)：如果有值对其处理，返回处理后的Optional，否则返回Optional.empty()
 *
 * flatMap(Function mapper)：与map类似，要求返回值必须是Optional
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


