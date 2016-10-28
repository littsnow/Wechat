package com.zain.user.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zain.common.entity.BaseEntity;

/**
 * 用户账户信息
 * @author zain
 * 16/10/27
 */
@Table(name = "user_account")
public class UserAccount extends BaseEntity {
    
    public static final int UN_REGISTER = 0;
    public static final int REGISTERED = 1;
    public static final int DESTROYED = 2;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId; //用户id
    private String openId; //微信号id
    private String account; //账户名
    private String password; //密码
    private Integer state; //账户状态 0 未注册 1 已注册 2 销毁
    
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    
}
