package com.test;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yemingjie.
 * @date 2022/3/3.
 * @time 20:52.
 */
public class DistributorManagerVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 分销商ID
     */
    private Long distributorId;

    /**
     * 申请绑定时间
     */
    private Date applyTime;

    /**
     * 1：申请中 2：绑定成功 3：绑定失败
     */
    private Integer bindStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(Integer bindStatus) {
        this.bindStatus = bindStatus;
    }
}

