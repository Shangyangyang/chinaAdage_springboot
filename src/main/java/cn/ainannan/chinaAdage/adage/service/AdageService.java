package cn.ainannan.chinaAdage.adage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.chinaAdage.adage.bean.Adage;
import cn.ainannan.chinaAdage.adage.mapper.AdageMapper;

@Service
public class AdageService extends CrudService<AdageMapper, Adage> {

	/**
	 * 通过用户ID获取adage未浏览过的列表
	 * @param adage
	 * @return
	 */
	public List<Adage> findListByUser(Adage adage) {
		return dao.findListByUser(adage);
	}
}
