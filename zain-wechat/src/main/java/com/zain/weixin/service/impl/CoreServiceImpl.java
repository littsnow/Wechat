package com.zain.weixin.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zain.weixin.service.CoreService;
import com.zain.weixin.service.handler.EndHandler;
import com.zain.weixin.service.handler.FollowHandler;
import com.zain.weixin.service.handler.MenuClickHandler;
import com.zain.weixin.service.handler.MenuViewHandler;
import com.zain.weixin.service.handler.MsgHandler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Service
public class CoreServiceImpl implements CoreService {

    @Autowired
    protected WxMpService wxMpService;

    private WxMpMessageRouter router;

    @Autowired
    private FollowHandler followHandler;
    @Autowired
    private MsgHandler msgHandler;
    @Autowired
    private EndHandler endHandler;
    @Autowired
    private MenuClickHandler menuClickHandler;
    @Autowired
    private MenuViewHandler menuViewHandler;
    
    protected Logger logger = LoggerFactory.getLogger(getClass());
    

    @PostConstruct
    public void init() {
        this.refreshRouter();
    }

    /**
     * 配置消息的路由器
     */
    @Override
    public void refreshRouter() {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(this.wxMpService);
        
        // 处理拦截转发
        // 1.关注事件
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.EVT_SUBSCRIBE).handler(this.followHandler)
            .end();
        
        // 2.点击事件1
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.EVT_VIEW).handler(this.menuViewHandler)
            .end();
        // 2.点击事件2
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.EVT_CLICK).handler(this.menuClickHandler)
            .end();
        // 2.消息事件
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_TEXT).handler(this.msgHandler)
            .end();
        
        // end.默认,转发消息给客服人员
        newRouter.rule().async(false).handler(this.endHandler).end();
        
        this.router = newRouter;
    }

    @Override
    public WxMpXmlOutMessage route(WxMpXmlMessage inMessage) {
        try {
            return this.router.route(inMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    @Override
    public WxMpUser getUserInfo(String openid, String lang) {
        WxMpUser wxMpUser = null;
        try {
            wxMpUser = this.wxMpService.getUserService().userInfo(openid, lang);
        } catch (WxErrorException e) {
            this.logger.error(e.getError().toString());
        }
        return wxMpUser;
    }


}
