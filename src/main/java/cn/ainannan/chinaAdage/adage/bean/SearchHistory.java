package cn.ainannan.chinaAdage.adage.bean;

import org.springframework.stereotype.Component;

import cn.ainannan.base.bean.BaseBean;

@Component
public class SearchHistory extends BaseBean<SearchHistory> {
	private String content;
	private Integer count;
	private String state;

	public SearchHistory(String content) {
		super();
		this.content = content;
	}
	
	

	public SearchHistory() {
		super();
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
