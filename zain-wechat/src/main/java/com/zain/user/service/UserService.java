package com.zain.user.service;

import java.util.List;

import com.zain.common.entity.SysResult;
import com.zain.user.entity.UserAccount;
import com.zain.user.entity.UserWechat;

/**
 * 用户接口
 * @author zain
 * 16/10/27
 */
public interface UserService {

    /**
     * 检查用户是否存在
     * 根据微信
     * @param userWechat
     * @return
     */
    public boolean isExist(UserWechat userWechat);
    
    /**
     * 检查用户是否存在
     * 根据账户
     * @param userAccount
     * @return
     */
    public boolean isExist(UserAccount userAccount);

    /**
     * 新增用户
     * 根据微信
     * @param userWechat
     */
    public SysResult add(UserWechat userWechat);
    
    /**
     * 新增用户
     * 根据账户
     * @param userAccount
     */
    public SysResult add(UserAccount userAccount);
    
    /**
     * 更新用户
     * 根据账户
     * @param userAccount
     */
    public SysResult update(UserAccount userAccount);
    
    /**
     * 获取用户
     * 根据账户
     * @param userAccount
     */
    public List<UserAccount> query(UserAccount userAccount);
    
    /**
     * 获取一个用户
     * 根据账户
     * @param userAccount
     */
    public UserAccount queryOne(UserAccount userAccount);

    /**
     * 获取一个用户-微信
     * 根据openId
     * @param openId
     * @return
     */
    public UserWechat query(String openId);

    /**
     * 是否注册过
     * 根据openId
     * @param openId
     * @return
     */
    public boolean isRegister(String openId);

}
