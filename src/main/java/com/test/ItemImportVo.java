package com.test;

import java.io.Serializable;

/**
 * @author yemingjie.
 * @date 2022/5/18.
 * @time 08:29.
 */
public class ItemImportVo implements Serializable {

    /**
     * 简称
     */
    private String shortTitle;

    /**
     * 重量
     */
    private String weight;

    /**
     * 市场
     */
    private String shichang;
    /**
     * 档口
     */
    private String dangkou;
    /**
     * 成本chengben
     */
    private String chengben;
    /**
     * 规格名称
     */
    private String skuName;
    /**
     * 规格别名
     */
    private String skuAlias;
    /**
     * 规格id
     */
    private Long skuId;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuAlias() {
        return skuAlias;
    }

    public void setSkuAlias(String skuAlias) {
        this.skuAlias = skuAlias;
    }

    public String getShichang() {
        return shichang;
    }

    public void setShichang(String shichang) {
        this.shichang = shichang;
    }

    public String getDangkou() {
        return dangkou;
    }

    public void setDangkou(String dangkou) {
        this.dangkou = dangkou;
    }

    public String getChengben() {
        return chengben;
    }

    public void setChengben(String chengben) {
        this.chengben = chengben;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
