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
import cn.ainannan.chinaAdage.adage.service.AdageService;
import cn.ainannan.chinaAdage.adage.service.BrowseRecordService;
import cn.ainannan.chinaAdage.adage.service.CollectService;
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
	public ResultObject addCollect(Collect coolect){
		collectService.save(coolect);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("list")
	public ResultObject list(Adage adage){
		List<Adage> list = adageService.findList(adage);
		return ResultGen.genSuccessResult(list);
	}
	
	@RequestMapping("save")
	public ResultObject save(Adage consumeOption){
		adageService.save(consumeOption);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("delete")
	public ResultObject delete(Adage consumeOption){
		adageService.delete(consumeOption);
		return ResultGen.genSuccessResult();
	}
}
