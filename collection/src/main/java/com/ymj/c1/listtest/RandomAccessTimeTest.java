package com.ymj.c1.listtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList 使用 for 循环遍历优于迭代器遍历 LinkedList 使用 迭代器遍历优于 for 循环遍历
 * 根据以上结论便可利用 RandomAccess 在遍历前进行判断，根据 List 的不同子类选择不同的遍历方式， 提升算法性能。
 */
public class RandomAccessTimeTest {

    //使用for循环遍历
    public static long traverseByLoop(List list){
        long startTime = System.currentTimeMillis();
        for (int i = 0;i < list.size();i++){
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }
    //使用迭代器遍历
    public static long traverseByIterator(List list){
        Iterator iterator = list.iterator();
        long startTime = System.currentTimeMillis();
        while (iterator.hasNext()){
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }

    public static void main(String[] args) {
        //加入数据
        List<String> arrayList = new ArrayList<>();
        for (int i = 0;i < 300000;i++){
            arrayList.add("" + i);
        }

        long loopTime = RandomAccessTimeTest.traverseByLoop(arrayList);// 快
        long iteratorTime = RandomAccessTimeTest.traverseByIterator(arrayList);// 慢
        System.out.println("ArrayList:");
        System.out.println("for循环遍历时间:" + loopTime);
        System.out.println("迭代器遍历时间:" + iteratorTime);

        List<String> linkedList = new LinkedList<>();
        //加入数据
        for (int i = 0;i < 300000;i++){
            linkedList.add("" + i);
        }
        loopTime = RandomAccessTimeTest.traverseByLoop(linkedList);//慢
        iteratorTime = RandomAccessTimeTest.traverseByIterator(linkedList);// 快
        System.out.println("LinkedList:");
        System.out.println("for循环遍历时间:" + loopTime);
        System.out.println("迭代器遍历时间:" + iteratorTime);

    }

}
