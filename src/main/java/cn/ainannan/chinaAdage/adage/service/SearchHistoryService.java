package cn.ainannan.chinaAdage.adage.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.chinaAdage.adage.bean.SearchHistory;
import cn.ainannan.chinaAdage.adage.mapper.SearchHistoryMapper;

@Service
public class SearchHistoryService extends CrudService<SearchHistoryMapper, SearchHistory> {
}
