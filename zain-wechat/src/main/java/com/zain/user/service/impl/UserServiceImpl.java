package com.zain.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zain.common.entity.ErrorResult;
import com.zain.common.entity.SuccessResult;
import com.zain.common.entity.SysResult;
import com.zain.user.dao.AccountDao;
import com.zain.user.dao.WechatDao;
import com.zain.user.entity.UserAccount;
import com.zain.user.entity.UserWechat;
import com.zain.user.service.UserService;


/**
 * 用户服务
 * 处理
 * @author zain
 * 16/10/27
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private WechatDao wechatDao;
    @Autowired
    private AccountDao accountDao;
    

    @Override
    public boolean isExist(UserWechat userWechat) {
        int quantity = wechatDao.selectCount(userWechat);
        if(quantity >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isExist(UserAccount userAccount) {
        int quantity = accountDao.selectCount(userAccount);
        if(quantity >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public SysResult add(UserWechat userWechat) {
        UserAccount userAccount = new UserAccount();
        userAccount.setOpenId(userWechat.getOpenId());
        
        if(isExist(userAccount)) { //如果账户存在
            //获取账户信息
            userAccount = this.queryOne(userAccount);
        } else { //如果账户不存在
            //新建账户
            this.add(userAccount);
        }
        
        userWechat.setUserId(userAccount.getUserId());
        userWechat.setCreated(new Date());
        wechatDao.insert(userWechat);
        
        return SuccessResult.ok();
    }

    @Override
    public SysResult add(UserAccount userAccount) {
        userAccount.setCreated(new Date());
        accountDao.insertSelective(userAccount);
        
        return SuccessResult.ok();
    }

    @Override
    public SysResult update(UserAccount userAccount) {
        Long userId = null;
        if(null == userAccount.getUserId()) {
            UserAccount temp = new UserAccount();
            temp.setOpenId(userAccount.getOpenId());
            List<UserAccount> list = accountDao.select(temp);
            if(null == list || 0 >= list.size()) {
                return ErrorResult.err();
            }
            userId = list.get(0).getUserId();
        }
        
        userAccount.setUserId(userId);
        accountDao.updateByPrimaryKeySelective(userAccount);
        
        return SuccessResult.ok();
    }

    @Override
    public UserAccount queryOne(UserAccount userAccount) {
        List<UserAccount> list = this.query(userAccount);
        if(null == list || 0 >= list.size()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<UserAccount> query(UserAccount userAccount) {
        List<UserAccount> list = accountDao.select(userAccount);
        return list;
    }

    @Override
    public UserWechat query(String openId) {
        return wechatDao.selectByPrimaryKey(openId);
    }

    @Override
    public boolean isRegister(String openId) {
        UserAccount userAccount = new UserAccount();
        userAccount.setOpenId(openId);
        List<UserAccount> list = accountDao.select(userAccount);
        if(null == list || 0 >= list.size()) {
            this.add(userAccount);
            return false;
        }
        
        if(list.get(0).getState() == UserAccount.REGISTERED) {
            return true;
        }
        
        return false;
    }

}
