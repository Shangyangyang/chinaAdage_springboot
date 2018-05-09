package cn.ainannan.chinaAdage.adage.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

import cn.ainannan.base.bean.BaseBean;
import cn.ainannan.sys.user.bean.User;

@Component
public class Collect extends BaseBean<Collect> {
	private Adage adage;
	private User user;
	private Date createDateStart;
	private Date createDateEnd;

	public Adage getAdage() {
		return adage;
	}

	public void setAdage(Adage adage) {
		this.adage = adage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(Date createDateStart) {
		this.createDateStart = createDateStart;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}
}
