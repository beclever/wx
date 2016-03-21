package com.core;

import javax.servlet.http.HttpServletRequest;

import me.chanjar.weixin.common.exception.WxErrorException;
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
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
