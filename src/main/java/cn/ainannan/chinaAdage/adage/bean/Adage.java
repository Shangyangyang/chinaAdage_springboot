package cn.ainannan.chinaAdage.adage.bean;

import org.springframework.stereotype.Component;

import cn.ainannan.base.bean.BaseBean;
import cn.ainannan.sys.user.bean.User;

@Component
public class Adage extends BaseBean<Adage> {
	private String adage;
	private String outline;
	private String detail;
	private String types;
	private String season;
	private Integer upvote;
	private Integer downvote;
	private User param;

	public String getAdage() {
		return adage;
	}

	public void setAdage(String adage) {
		this.adage = adage;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public User getParam() {
		return param;
	}

	public void setParam(User param) {
		this.param = param;
	}

	public Integer getUpvote() {
		return upvote;
	}

	public void setUpvote(Integer upvote) {
		this.upvote = upvote;
	}

	public Integer getDownvote() {
		return downvote;
	}

	public void setDownvote(Integer downvote) {
		this.downvote = downvote;
	}

}
