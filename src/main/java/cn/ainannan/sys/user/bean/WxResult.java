package cn.ainannan.sys.user.bean;

public class WxResult {
	private String session_key; // 会话标志，默认5分钟时长，5分钟后需要重新获取
	private Integer expires_in; // 会话时长
	private String openid; // 用户唯一标识
	private String errcode; // 错误代码
	private String errmsg; // 错误消息

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "WxResult [session_key=" + session_key + ", expires_in=" + expires_in + ", openid=" + openid
				+ ", errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}

}
