package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yemingjie.
 * @date 2022/3/3.
 * @time 20:53.
 */
public class Test {
    public static void main(String[] args) {
        List<CjdfDistributorManage> alist =  new ArrayList<>();
        CjdfDistributorManage cjdfDistributorManage = new CjdfDistributorManage();
        cjdfDistributorManage.setId(1L);
        cjdfDistributorManage.setBindStatus(1);
        cjdfDistributorManage.setDistributorId(1L);
        alist.add(cjdfDistributorManage);
        cjdfDistributorManage = new CjdfDistributorManage();
        cjdfDistributorManage.setId(2L);
        cjdfDistributorManage.setBindStatus(2);
        cjdfDistributorManage.setDistributorId(2L);
        alist.add(cjdfDistributorManage);
        cjdfDistributorManage = new CjdfDistributorManage();
        cjdfDistributorManage.setId(3L);
        cjdfDistributorManage.setBindStatus(3);
        cjdfDistributorManage.setDistributorId(3L);
        alist.add(cjdfDistributorManage);
        List<DistributorManagerVo> distributorManagerVos = toDistributorManageResponseVos(alist);
        System.out.println(distributorManagerVos);

    }

    private static List<DistributorManagerVo> toDistributorManageResponseVos(List<CjdfDistributorManage> lists) {
        List<DistributorManagerVo> voList = new ArrayList<>();
        //if (CollectionUtils.isNotEmpty(lists)) {
            voList = lists.stream().map(item -> {
                DistributorManagerVo vo = new DistributorManagerVo();
                vo.setId(item.getId());
                vo.setDistributorId(item.getDistributorId());
                vo.setApplyTime(item.getCreateTime());
                vo.setBindStatus(item.getBindStatus());
                return vo;
            }).collect(Collectors.toList());
        //}
        return voList;
    }
}
