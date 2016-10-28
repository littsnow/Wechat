package com.zain.weixin.service.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

/**
 * 用于处理菜单点击事件
 * @author zain
 * 16/10/27
 */
@Component
public class MenuViewHandler extends BaseHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) throws WxErrorException {
        // TODO Auto-generated method stub
        return null;
    }

}
