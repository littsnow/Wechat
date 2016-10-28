package com.zain.user.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import com.zain.common.entity.BaseEntity;

/**
 * 用户微信信息
 * @author zain
 * 16/10/27
 */
@Table(name = "user_wechat")
public class UserWechat extends BaseEntity {
    
    private Long userId;
    @Id
    private String openId;
    private String nickName;
    private String headImgUrl;
    
    public UserWechat() {}
    
    public UserWechat(String openId) {
        this(null, openId, null, null);
    }
    
    public UserWechat(Long userId, String openId, String nickName, String headImgUrl) {
        this.userId = userId;
        this.openId = openId;
        this.nickName = nickName;
        this.headImgUrl = headImgUrl;
    }

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
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getHeadImgUrl() {
        return headImgUrl;
    }
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
    
}
