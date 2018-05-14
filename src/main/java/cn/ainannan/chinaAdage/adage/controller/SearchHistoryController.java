package cn.ainannan.chinaAdage.adage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.chinaAdage.adage.bean.SearchHistory;
import cn.ainannan.chinaAdage.adage.service.SearchHistoryService;

@RestController
@RequestMapping(value="searchHistory")
public class SearchHistoryController {
	
	@Autowired
	private SearchHistoryService shService;
	
	@RequestMapping("getHotList")
	public ResultObject getHotList(SearchHistory sh){
		
		return ResultGen.genSuccessResult(shService.findListToSeven(sh));
	}
	
	@RequestMapping("saveSearchHistory")
	public ResultObject saveSearchHistory(SearchHistory sh){
		sh.setContent(sh.getContent().trim());
		List<SearchHistory> shList = shService.findList(sh);
		if(shList.size() > 0) {
			sh = shList.get(0);
		} else {
			sh.setCount(0);
		}
		
		sh.setCount(sh.getCount() + 1);
		
		shService.save(sh);
		
		return ResultGen.genSuccessResult();
	}
}
