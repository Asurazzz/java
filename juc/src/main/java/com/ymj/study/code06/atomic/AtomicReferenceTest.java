package com.ymj.study.code06.atomic;


import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Classname AtomicReferenceTest
 * @Description TODO
 * @Date 2021/7/9 15:46
 * @Created by yemingjie
 */
public class AtomicReferenceTest {
    public static void main(String[] args) {
        //包装的原子对象
        AtomicReference<User> userRef = new AtomicReference<User>();
        //待包装的 User 对象
        User user = new User("1", "张三");
        //为原子对象设置值
        userRef.set(user);
        System.out.println(" userRef is:" + userRef.get());
        //要使用 CAS 替换的 User 对象
        User updateUser = new User("2", "李四");
        //使用 CAS 替换
        boolean success = userRef.compareAndSet(user, updateUser);
        System.out.println(" cas result is:" + success);
        System.out.println(" after cas,userRef is:" + userRef.get());
    }
}

class User implements Serializable {
    //用户 ID
    String uid;
    //昵称
    String nickName;
    //年龄
    public volatile int age;

    public User(String uid, String nickName) {
        this.uid = uid;
        this.nickName = nickName;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "uid='" + getUid() + '\'' +
                ", nickName='" + getNickName() + '\''+
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

