package com.zain.weixin.service.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zain.user.entity.UserWechat;
import com.zain.user.service.UserService;
import com.zain.weixin.service.CoreService;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Component
public class MsgHandler extends BaseHandler{

    @Autowired
    protected CoreService coreService;
    @Autowired
    private UserService userService;
    
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) throws WxErrorException {
        
        WxMpUser wxMpUser = coreService.getUserInfo(wxMessage.getFromUser(), "zh_CN");
        
        // 1.获取用户-微信信息
        UserWechat userWechat = userService.query(wxMpUser.getOpenId());
        
        
        return WxMpXmlOutMessage
                .TEXT()
                .toUser(wxMpUser.getOpenId())
                .fromUser(wxMessage.getToUser())
                .content("你好旅行者!" + "\r\n" + userWechat.getNickName())
                .build();
    }

}
