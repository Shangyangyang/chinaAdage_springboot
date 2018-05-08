package cn.ainannan.sys.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wx")
@PropertySource("classpath:wx.yml")
public class MyConfig {
	
	@Value("${AppID}")
	private String AppID;
	@Value("${AppSecret}")
	private String AppSecret;
	@Value("${url}")
	private String url;
	@Value("${userAllot}")
	private Integer userAllot;

	public String getAppID() {
		return AppID;
	}

	public void setAppID(String appID) {
		AppID = appID;
	}

	public String getAppSecret() {
		return AppSecret;
	}

	public void setAppSecret(String appSecret) {
		AppSecret = appSecret;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUserAllot() {
		return userAllot;
	}

	public void setUserAllot(Integer userAllot) {
		this.userAllot = userAllot;
	}

}
