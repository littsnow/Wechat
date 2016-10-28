package com.zain.weixin.service;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

public interface CoreService {

    /**
     * 更新消息路由器
     */
    public void refreshRouter();
    
    /**
     * 路由消息
     *
     * @param inMessage
     * @return
     */
    public WxMpXmlOutMessage route(WxMpXmlMessage inMessage);

    
    /**
     * 通过WxMpXmlMessage中的 fromUser
     * 即openid获得基本用户信息
     *
     * @param openid
     * @param lang
     * @return
     */
    public WxMpUser getUserInfo(String fromUser, String string);

}
