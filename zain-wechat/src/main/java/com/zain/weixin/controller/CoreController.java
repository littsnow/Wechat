package com.zain.weixin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zain.common.controller.BaseController;
import com.zain.weixin.service.CoreService;

import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

/**
 * 微信核心类
 * @author zain
 * 16/10/25
 */
@RequestMapping("/weixin")
@Controller
public class CoreController extends BaseController {
    
    @Autowired
    protected WxMpService wxMpService;
    protected WxMpMessageRouter wxMpMessageRouter;
    @Autowired
    protected CoreService coreService;
    
    @RequestMapping("/core.html")
    public void wechatCore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求参数
        String signature = request.getParameter("signature");
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");
        
        //设置响应
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        
        if (!this.wxMpService.checkSignature(timestamp, nonce, signature)) {
            // 消息签名不正确，说明不是公众平台发过来的消息
            try {
                response.getWriter().println("非法请求");
            } catch (IOException e) {
                logger.error("response write error", e);
            }
            
            return;
        }
        
        String echoStr = request.getParameter("echostr");
        if (StringUtils.isNotBlank(echoStr)) {
            // 说明是一个仅仅用来验证的请求，回显echostr
            String echoStrOut = String.copyValueOf(echoStr.toCharArray());
            try {
                response.getWriter().println(echoStrOut);
            } catch (IOException e) {
                logger.error("response write error", e);
            }
            return;
        }
        
        String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type"))
                ? "raw"
                : request.getParameter("encrypt_type");

        if ("raw".equals(encryptType)) {
                // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
            WxMpXmlOutMessage outMessage = this.coreService.route(inMessage);
            if(null == outMessage) {
                return;
            }
            response.getWriter().write(outMessage.toXml());
            
            return;
        }
        
        return;
    }
    
    
    
    
}
