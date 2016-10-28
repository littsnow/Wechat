package com.zain.common.entity;

import java.util.Date;

/**
 * 实体基类
 * @author zain
 * 16/10/27
 */
public abstract class BaseEntity {
    private Date created; //创建时间
    private Date updated; //修改时间
    
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
