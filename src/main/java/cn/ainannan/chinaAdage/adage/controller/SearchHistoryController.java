package cn.ainannan.chinaAdage.adage.controller;

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
}
