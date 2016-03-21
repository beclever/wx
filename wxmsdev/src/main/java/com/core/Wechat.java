package com.core;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;




public class Wechat {
    
    private WxMpInMemoryConfigStorage config;
    
    private static Wechat instance;

    WxMpService wxService;
    
    // 用户的openid在下面地址获得 
    // https://mp.weixin.qq.com/debug/cgi-bin/apiinfo?t=index&type=用户管理&form=获取关注者列表接口%20/user/get 
    /*String openid = "...";
    WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(openid).content("Hello World").build();
    wxService.customMessageSend(message);*/
    
    private Wechat(){
        config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxca4549f0da3cb54f"); // 设置微信公众号的appid
        config.setSecret("d4624c36b6795d1d99dcf0547af5443d"); // 设置微信公众号的app corpSecret
        config.setToken("zBpFLS3auP7Shww1acEl"); // 设置微信公众号的token
        config.setAesKey("QidEZr2uKDUMpMmBGMxkvZPkRVfbIpjWrlTKJKz2MXC"); // 设置微信公众号的EncodingAESKey
        
    }
    
    public static Wechat getInstance() {
        if (instance == null) {
            instance = new Wechat();
        }
        return instance;
    }

    public WxMpInMemoryConfigStorage getWxMpInMemoryConfigStorage() {
        return this.config;
    }
    
    public WxMpService getWxMpService() {
        wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(getWxMpInMemoryConfigStorage());
        return wxService;
    }
	/*private WxMpInMemoryConfigStorage wxCpConfigStorage;
	private WxCpService wxCpService;
	private WxCpMessageRouter wxCpMessageRouter;
	private static Wechat instance;

	private Wechat() {
		wxCpConfigStorage = new WxCpInMemoryConfigStorage();
		wxCpConfigStorage.setCorpId(PropUtils.get("corpId"));
		wxCpConfigStorage.setCorpSecret(PropUtils.get("corpSecret"));
		wxCpConfigStorage.setAesKey(PropUtils.get("aesKey"));
		wxCpConfigStorage.setToken(PropUtils.get("token"));
		
	}

	public static Wechat getInstance() {
		if (instance == null) {
			instance = new Wechat();
		}
		return instance;
	}

	public WxCpInMemoryConfigStorage getWxCpInMemoryConfigStorage() {
		return this.wxCpConfigStorage;
	}

	public WxCpService getWxCpService() {
		wxCpService = new WxCpServiceImpl();
		wxCpService.setWxCpConfigStorage(getWxCpInMemoryConfigStorage());
		return wxCpService;
	}

	public WxCpMessageRouter getWxCpMessageRouter() {
	    wxCpMessageRouter = new WxCpMessageRouter(getWxCpService());
	    wxCpMessageRouter.rule().async(false) // 拦截所有消息,可支持多种规则,非异步
				.handler(new WechatMessageHandle()).end();
		return wxCpMessageRouter;
	}*/
}
