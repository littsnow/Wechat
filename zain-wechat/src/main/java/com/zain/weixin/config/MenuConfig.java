package com.zain.weixin.config;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;

/**
 * Created by FirenzesEagle on 2016/6/1 0001.
 * Email:liumingbo2008@gmail.com
 */
public class MenuConfig {

    /**
     * 定义菜单结构
     *
     * @return
     */
    protected static WxMenu getMenu() {

        MainConfig mainConfig = new MainConfig();
        WxMpService wxMpService = mainConfig.wxMpService();
        WxMenu menu = new WxMenu();
        
        //一级菜单
        WxMenuButton button1 = new WxMenuButton();
        WxMenuButton button2 = new WxMenuButton();
        WxMenuButton button3 = new WxMenuButton();
        
        button1.setName("主演");
        button2.setName("剧组");
        button3.setName("其他");
        
        
        //二级菜单
        WxMenuButton button11 = new WxMenuButton();
        WxMenuButton button12 = new WxMenuButton();
        WxMenuButton button13 = new WxMenuButton();
        WxMenuButton button21 = new WxMenuButton();
        WxMenuButton button22 = new WxMenuButton();
        WxMenuButton button23 = new WxMenuButton();
        
        
        button11.setName("人才库");
        button11.setType(WxConsts.BUTTON_VIEW);
        button11.setUrl(wxMpService.oauth2buildAuthorizationUrl("", "snsapi_base", ""));
        
        button12.setName("作品展");
        button12.setType(WxConsts.BUTTON_VIEW);
        button12.setUrl(wxMpService.oauth2buildAuthorizationUrl("", "snsapi_base", ""));
        
        button13.setName("招募令");
        button13.setType(WxConsts.BUTTON_VIEW);
        button13.setUrl(wxMpService.oauth2buildAuthorizationUrl("", "snsapi_base", ""));
        
        
        button21.setName("我的订单");
        button21.setType(WxConsts.BUTTON_VIEW);
        button21.setUrl(wxMpService.oauth2buildAuthorizationUrl("", "snsapi_base", ""));

        button22.setType(WxConsts.BUTTON_VIEW);
        button22.setName("收入统计");
        button22.setUrl(wxMpService.oauth2buildAuthorizationUrl("", "snsapi_base", ""));

        button23.setType(WxConsts.BUTTON_VIEW);
        button23.setName("发布商品");
        button23.setUrl(wxMpService.oauth2buildAuthorizationUrl("", "snsapi_base", ""));

        WxMenuButton button24 = new WxMenuButton();
        button24.setType(WxConsts.BUTTON_VIEW);
        button24.setName("商品管理");
        button24.setUrl(wxMpService.oauth2buildAuthorizationUrl("", "snsapi_base", ""));

        button2.getSubButtons().add(button21);
        button2.getSubButtons().add(button22);
        button2.getSubButtons().add(button23);
        button2.getSubButtons().add(button24);

        

        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);

        return menu;
    }

    /**
     * 运行此main函数即可生成公众号自定义菜单
     *
     * @param args
     */
    public static void main(String[] args) {
        MainConfig mainConfig = new MainConfig();
        WxMpService wxMpService = mainConfig.wxMpService();
        try {
            wxMpService.getMenuService().menuCreate(getMenu());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

}
