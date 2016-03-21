package com.core;

public class WxConsts {
    
    public static String appID = "wxca4549f0da3cb54f";
    
    public static String appsecret = "d4624c36b6795d1d99dcf0547af5443d";

    //用户同意授权，获取code（code只能使用一次，5分钟未使用自动过期。）
    public static String wxUrlForCode = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    
    //通过code换取网页授权access_token（如果作用域是snsapi_base，则同时获取到openid,snsapi_base式网页授权流程也到此为止）
    public static String wxUrlForToken = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    
    //刷新access_token
    public static String wxUrlRefreshToken = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
    
    //拉取用户信息（需scope为snsapi_userinfo)
    public static String wxUrlForUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    
    //检查授权凭证（access_token)是否有效
    public static String wxUrlForCheckToken = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
    
}
