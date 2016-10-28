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
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 处理关注事件
 * @author zain
 * 16/10/27
 */
@Component
public class FollowHandler extends BaseHandler {

    @Autowired
    protected CoreService coreService;
    
    @Autowired
    private UserService userService;
    
    /**
     * 处理关注事件
     */
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) throws WxErrorException {
        
        WxMpUser wxMpUser = coreService.getUserInfo(wxMessage.getFromUser(), "zh_CN");
        UserWechat userWechat = new UserWechat(wxMpUser.getOpenId());
        
        /*List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("openId", wxMpUser.getOpenId()));
        params.add(new BasicNameValuePair("nickname", wxMpUser.getNickname()));
        params.add(new BasicNameValuePair("headImgUrl", wxMpUser.getHeadImgUrl()));*/

        //TODO(user) 在这里可以进行用户关注时对业务系统的相关操作（比如新增用户）
        
        //检查用户-微信是否存在
        boolean isExist = userService.isExist(userWechat);
        
        if(!isExist) { //如果用户不存在
            //新增用户
            userWechat.setNickName(wxMpUser.getNickname());
            userWechat.setHeadImgUrl(wxMpUser.getHeadImgUrl());;
            userService.add(userWechat);
        } 
        
        WxMpXmlOutTextMessage msg = WxMpXmlOutMessage.TEXT()
            .content("尊敬的" + wxMpUser.getNickname() + "，您好！"+ "\r\n" +"欢迎关注演员公会！")
            .fromUser(wxMessage.getToUser())
            .toUser(wxMpUser.getOpenId())
            .build();
        
        logger.debug("FollowOne: " + wxMpUser.getNickname());
        
        return msg;
    }

}
