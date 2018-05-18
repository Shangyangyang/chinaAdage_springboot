package cn.ainannan.chinaAdage.adage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.chinaAdage.adage.bean.Adage;
import cn.ainannan.chinaAdage.adage.bean.BrowseRecord;
import cn.ainannan.chinaAdage.adage.bean.Collect;
import cn.ainannan.chinaAdage.adage.bean.SearchHistory;
import cn.ainannan.chinaAdage.adage.service.AdageService;
import cn.ainannan.chinaAdage.adage.service.BrowseRecordService;
import cn.ainannan.chinaAdage.adage.service.CollectService;
import cn.ainannan.chinaAdage.adage.service.SearchHistoryService;
import cn.ainannan.sys.user.bean.User;
import cn.ainannan.sys.user.service.UserService;
import cn.ainannan.utils.DateUtil;

@RestController
@RequestMapping(value="adage")
public class AdageController {
	@Autowired
	private AdageService adageService;
	@Autowired
	private UserService userService;
	@Autowired
	private BrowseRecordService browseRecordService;
	@Autowired
	private CollectService collectService;
	@Autowired
	private SearchHistoryService shService;
	
	/**
	 * 搜索模块，通过内容搜索。
	 * @param user
	 * @param content
	 * @return
	 */
	@RequestMapping("searchList")
	public ResultObject searchList(Adage adage){
		if(null == adage.getAdage() || "".equals(adage.getAdage().trim())) {
			return ResultGen.genFailResult("关键字不能为空！");
		}
		if(adage.getParam() == null || adage.getParam().getId() == null || "null".equals(adage.getParam().getId())) {
			return ResultGen.genFailResult("登录失败，请退出重新登录");
		}
		adage.setAdage(adage.getAdage().trim());
		// 搜索记录的保存
		shService.addHistory(new SearchHistory(adage.getAdage()));
		// 查询		
		adage.setInFlag("2"); 	// in
		List<Adage> adageList = adageService.findListByUser(adage);
		
		return ResultGen.genSuccessResult(adageList);
	}
	
	/**
	 * 我的模块，获取积分和收藏个数。
	 * @param user
	 * @return
	 */
	@RequestMapping("getUserCollectGoldCoin")
	public ResultObject getUserCollectGoldCoin(User user){
		// 获取积分
		user = userService.get(user);
		// 获取收藏数
		Collect collect = new Collect();
		collect.setUser(user);
		user.setCollect(collectService.findList(collect).size());
		
		return ResultGen.genSuccessResult(user);
	}
	
	/**
	 * 通过用户ID获取谚语，过滤已浏览过的。
	 * @param adage
	 * @return
	 */
	@RequestMapping("getByUser")
	public ResultObject getByUser(Adage adage){
		/*
		 * 逻辑梳理
		 * 通过用户ID获取谚语
		 * 首先获取用户的分配额，然后查询浏览记录表，看看今天是否还有额度
		 * 如果没有额度返回错误代码，并提示。
		 * 如果有额度，则查询谚语表，并且在查询的同时过滤掉已经浏览过的谚语。
		 */
		
		if(adage.getParam() == null || adage.getParam().getId() == null || "null".equals(adage.getParam().getId())) {
			return ResultGen.genFailResult("登录失败，请退出重新登录");
		}
		User curUser = userService.get(new User(adage.getParam().getId()));
		// 查询额度
		BrowseRecord br = new BrowseRecord();
		br.setUser(curUser);
		br.setCreateDateStart(DateUtil.getCurrDateFirst());
		
		int resultNum = browseRecordService.findList(br).size();
		// 超额的操作
		if(resultNum >= curUser.getAllocation()) return ResultGen.genFailResult("今日额度已经用完");
		
		adage.setInFlag("1"); 	// not in
		List<Adage> resultList = adageService.findListByUser(adage);
		
		// 没有未读的操作
		if(resultList.size() == 0) {
			return ResultGen.genFailResult("没有新的谚语了");
		}
		
		
		
		return ResultGen.genSuccessResult(resultList.get(0));
	}
	
	/**
	 * 浏览记录的保存操作
	 * @param br
	 * @return
	 */
	@RequestMapping("addBrowseRecord")
	public ResultObject addBrowseRecord(BrowseRecord br){
		browseRecordService.save(br);
		return ResultGen.genSuccessResult();
	}
	
	/**
	 * 收藏谚语的操作
	 * @param br
	 * @return
	 */
	@RequestMapping("addCollect")
	public ResultObject addCollect(Collect colect){
		List<Collect> collectList = collectService.findList(colect);
		if(collectList.size() > 0) return ResultGen.genFailResult("已收藏");
		collectService.save(colect);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("getCollectListByUser")
	public ResultObject getCollectListByUser(Collect collect){
		List<Collect> collectList = collectService.findList(collect);
		
		return ResultGen.genSuccessResult(collectList);
	}
	
	
	@RequestMapping("list")
	public ResultObject list(Adage adage){
		List<Adage> list = adageService.findList(adage);
		return ResultGen.genSuccessResult(list);
	}
	
	@RequestMapping("save")
	public ResultObject save(Adage adage){
		adageService.save(adage);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("delete")
	public ResultObject delete(Adage consumeOption){
		adageService.delete(consumeOption);
		return ResultGen.genSuccessResult();
	}
}
