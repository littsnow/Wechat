package com.zain.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zain.common.entity.ErrorResult;
import com.zain.common.entity.SuccessResult;
import com.zain.common.entity.SysResult;
import com.zain.user.entity.UserAccount;
import com.zain.user.service.UserService;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

@RequestMapping("/web")
@Controller
public class LoginController {
    
    @Autowired
    UserService userService;
    @Autowired
    protected WxMpService wxMpService;
    
	@RequestMapping("/{htmlName}.html")
	public String login(@PathVariable("htmlName") String htmlName, HttpServletResponse response, @RequestParam(value = "code") String code) {
	    
        WxMpOAuth2AccessToken accessToken = null;
        try {
            accessToken = this.wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            return "login";
        }
	    
        String openId = accessToken.getOpenId();
        
        response.addCookie(new Cookie("openId", openId));
        
	    //判断用户是否注册过
	    boolean isRegister = userService.isRegister(openId);
	    
	    if(!isRegister) { //未注册
	        return "login";
	    }
	    
		return htmlName;
	}
	
	@ResponseBody
	@RequestMapping("/register.do")
	public SysResult register(String account, String password, HttpServletRequest request) {
	    String openId = "";
	    UserAccount userAccount = new UserAccount();
	    userAccount.setAccount(account);
	    
	    //判断用户是否存在
        boolean isExist = userService.isExist(userAccount);
        
        if(isExist) { //存在
            return ErrorResult.err();
        }
        
        for(Cookie cookie : request.getCookies()) {
            if("openId".equals(cookie.getName())) {
                openId = cookie.getValue();
                break;
            }
        }
        
        if(null == openId) {
            return ErrorResult.err();
        }
        
        userAccount.setPassword(password);
        userAccount.setOpenId(openId);
        userAccount.setState(1);
        userService.update(userAccount);
	    
	    return SuccessResult.ok();
	}
	
}
