package com.zain.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zain.common.controller.BaseController;
import com.zain.common.entity.SuccessResult;
import com.zain.common.entity.SysResult;

/**
 * 页面调试
 * @author zain
 * 16/10/28
 */
@RequestMapping("/test")
@Controller
public class TestController extends BaseController {
    
    
    @RequestMapping("/{page}.html")
    public String Test(@PathVariable("page") String page) {
        return page;
    }

}
