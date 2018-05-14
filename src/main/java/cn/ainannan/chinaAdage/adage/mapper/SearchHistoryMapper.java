package cn.ainannan.chinaAdage.adage.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ainannan.base.dao.CrudDao;
import cn.ainannan.chinaAdage.adage.bean.SearchHistory;

@Repository
public interface SearchHistoryMapper extends CrudDao<SearchHistory>{
	List<SearchHistory> findListToSeven(SearchHistory sh);
}