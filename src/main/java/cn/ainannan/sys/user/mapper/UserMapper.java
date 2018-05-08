package cn.ainannan.sys.user.mapper;

import org.springframework.stereotype.Repository;
import cn.ainannan.base.dao.CrudDao;
import cn.ainannan.sys.user.bean.User;

@Repository
public interface UserMapper extends CrudDao<User>{
	User getByWxId(User user);	// 通过wx_id获取user。
}