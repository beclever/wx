package com.core;

import javax.servlet.http.HttpServletRequest;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Application {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/wx")
    String wxTest(HttpServletRequest request){
        //Wechat.getInstance().getWxMpService();
        String code = request.getParameter("code");
        if(StringUtils.isEmpty(code)){
            return "code empty";
        }else{
            try {
                WxMpOAuth2AccessToken wxMpOAuth2AccessToken = Wechat.getInstance().getWxMpService().oauth2getAccessToken(code);
                System.out.println("wxMpOAuth2AccessToken:" + wxMpOAuth2AccessToken.toString());
                WxMpUser wxMpUser = Wechat.getInstance().getWxMpService().oauth2getUserInfo(wxMpOAuth2AccessToken, null);
                return wxMpUser.toString();
            } catch (WxErrorException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "code: "+ code;
            
        }
    }
    
    /**
     * 测试号
     * @Title: mpTest
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     */
    @RequestMapping("/mp")
    String mpTest(){
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxca4549f0da3cb54f"); // 设置微信公众号的appid
        config.setSecret("d4624c36b6795d1d99dcf0547af5443d"); // 设置微信公众号的app corpSecret
        config.setToken("..."); // 设置微信公众号的token
        config.setAesKey("..."); // 设置微信公众号的EncodingAESKey

        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);

        // 用户的openid在下面地址获得 
        // https://mp.weixin.qq.com/debug/cgi-bin/apiinfo?t=index&type=用户管理&form=获取关注者列表接口%20/user/get 
        String openid = "oYDxWsxrOT7YRZRJ0yR1Zy7fW2B4";//GraddyWang
        WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(openid).content("Hello World").build();
        try {
            wxService.customMessageSend(message);
        } catch (WxErrorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "mp";
    }
    //获取access token: https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
    
    /**
     * 银通服务号
     * @Title: mpTest
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     */
    @RequestMapping("/yt")
    String ytTest(){
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxfb1296b5748efb49"); // 设置微信公众号的appid
        config.setSecret("761f68f0e1d1819836430e56dd0cf8b3"); // 设置微信公众号的app corpSecret
        config.setToken("grgrache"); // 设置微信公众号的token
        config.setAesKey("QYCq1LoudRrtXSQMwgTD4ZplwDtl6fJZ67mSaKDNjHZ"); // 设置微信公众号的EncodingAESKey

        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);

        // 用户的openid在下面地址获得 
        // https://mp.weixin.qq.com/debug/cgi-bin/apiinfo?t=index&type=用户管理&form=获取关注者列表接口%20/user/get 
        String openid = "olv2Vt6fW1_jUKP09G7slxL3dyic";//GraddyWang
        WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(openid).content("Hello World").build();
        try {
            wxService.customMessageSend(message);
        } catch (WxErrorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "mp";
    }
    
    /**
     * 
     * @Title: kfTest
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     */
    @RequestMapping("/kf")
    String kfTest() {
        
        
        return "kf";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
