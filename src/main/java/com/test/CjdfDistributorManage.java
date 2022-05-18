package com.test;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yemingjie.
 * @date 2022/3/3.
 * @time 20:50.
 */
public class CjdfDistributorManage implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 逻辑删除 1：可用 0 不可用
     */
    private Integer enableStatus;
    /**
     * 供应商平台ID
     */
    private Long supplierId;
    /**
     * 分销商平台ID
     */
    private Long distributorId;
    /**
     * 分销商平台名称
     */
    private String distributorName;
    /**
     * 绑定状态 1：申请中 2：绑定成功 3：绑定失败
     */
    private Integer bindStatus;


    /**
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return createTime 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modifyTime 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return enableStatus 逻辑删除 1：可用 0 不可用
     */
    public Integer getEnableStatus() {
        return enableStatus;
    }

    /**
     * @param enableStatus 逻辑删除 1：可用 0 不可用
     */
    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    /**
     * @return supplierId 供应商平台ID
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId 供应商平台ID
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return distributorId 分销商平台ID
     */
    public Long getDistributorId() {
        return distributorId;
    }

    /**
     * @param distributorId 分销商平台ID
     */
    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    /**
     * @return distributorName 分销商平台名称
     */
    public String getDistributorName() {
        return distributorName;
    }

    /**
     * @param distributorName 分销商平台名称
     */
    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    /**
     * @return bindStatus 绑定状态 1：申请中 2：绑定成功 3：绑定失败
     */
    public Integer getBindStatus() {
        return bindStatus;
    }

    /**
     * @param bindStatus 绑定状态 1：申请中 2：绑定成功 3：绑定失败
     */
    public void setBindStatus(Integer bindStatus) {
        this.bindStatus = bindStatus;
    }


}
