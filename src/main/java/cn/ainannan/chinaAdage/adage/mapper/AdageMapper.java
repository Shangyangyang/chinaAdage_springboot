package cn.ainannan.chinaAdage.adage.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import cn.ainannan.base.dao.CrudDao;
import cn.ainannan.chinaAdage.adage.bean.Adage;

@Repository
public interface AdageMapper extends CrudDao<Adage>{
	/**
	 * 通过用户ID获取adage未浏览过的列表
	 * @param adage
	 * @return
	 */
	List<Adage> findListByUser(Adage adage);
}