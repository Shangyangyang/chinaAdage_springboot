package cn.ainannan.sys.user.bean;

import java.util.Date;
import org.springframework.stereotype.Component;
import cn.ainannan.base.bean.BaseBean;

@Component
public class User extends BaseBean<User> {

	private String wxId;
	private String name;
	private Integer allocation;	// 分配额度
	private Integer goldCoin;	// 积分
	private Integer level;		// 等级
	private Integer collect;	// 收藏数
	private String state;
	private Date lastLogin;
	
	
	public Integer getGoldCoin() {
		return goldCoin;
	}

	public void setGoldCoin(Integer goldCoin) {
		this.goldCoin = goldCoin;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getCollect() {
		return collect;
	}

	public void setCollect(Integer collect) {
		this.collect = collect;
	}

	public User() {
		super();
	}

	public User(String id) {
		super(id);
	}

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String toString() {
		return this.getId();
	}

	public Integer getAllocation() {
		return allocation;
	}

	public void setAllocation(Integer allocation) {
		this.allocation = allocation;
	}

}
