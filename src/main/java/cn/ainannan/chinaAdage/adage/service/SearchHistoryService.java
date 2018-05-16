package cn.ainannan.chinaAdage.adage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.chinaAdage.adage.bean.SearchHistory;
import cn.ainannan.chinaAdage.adage.mapper.SearchHistoryMapper;

@Service
public class SearchHistoryService extends CrudService<SearchHistoryMapper, SearchHistory> {
	public List<SearchHistory> findListToSeven(SearchHistory sh){
		return dao.findListToSeven(sh);
	}
	
	/**
	 * 添加搜索记录
	 * @param sh
	 */
	public void addHistory(SearchHistory sh) {
		sh.setContent(sh.getContent());
		List<SearchHistory> shList = this.findList(sh);
		if(shList.size() > 0) {
			sh = shList.get(0);
		} else {
			sh.setCount(0);
			sh.setState("0");
		}
		
		sh.setCount(sh.getCount() + 1);
		
		this.save(sh);
	}
}
