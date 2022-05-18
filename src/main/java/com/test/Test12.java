package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yemingjie.
 * @date 2022/4/22.
 * @time 14:30.
 */
public class Test12 {
    public static void main(String[] args) {
        List<CjdfDistributorManage> daoList = new ArrayList<>();
        CjdfDistributorManage manage = new CjdfDistributorManage();

        manage.setDistributorId(12L);
        manage.setDistributorName("a");
        manage.setCreateTime(new Date());
        manage.setModifyTime(new Date());
        manage.setSupplierId(13L);
        manage.setEnableStatus(1);
        manage.setBindStatus(2);
        daoList.add(manage);
        manage = new CjdfDistributorManage();
        manage.setDistributorId(13L);
        manage.setDistributorName("b");
        manage.setCreateTime(new Date());
        manage.setModifyTime(new Date());
        manage.setSupplierId(13L);
        manage.setEnableStatus(1);
        manage.setBindStatus(2);
        daoList.add(manage);

        List<CjdfDistributorManage> taobaoList = new ArrayList<>();
        manage = new CjdfDistributorManage();
        manage.setDistributorId(13L);
        manage.setDistributorName("c");
        manage.setCreateTime(new Date());
        manage.setModifyTime(new Date());
        manage.setSupplierId(13L);
        manage.setEnableStatus(1);
        manage.setBindStatus(2);
        taobaoList.add(manage);


       // 过滤出相同的
        List<CjdfDistributorManage> collect = daoList.stream().parallel().filter(dao ->
                taobaoList.stream().allMatch(
                        taobao -> !dao.getDistributorId().equals(taobao.getDistributorId())
                )).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(daoList);
        System.out.println(taobaoList);














    }


    public void compareList(List<CjdfDistributorManage> daoList, List<CjdfDistributorManage> taobaoList) {

    }
}
