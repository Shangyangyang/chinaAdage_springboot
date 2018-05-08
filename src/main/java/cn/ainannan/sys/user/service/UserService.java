package cn.ainannan.sys.user.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.sys.user.bean.User;
import cn.ainannan.sys.user.mapper.UserMapper;

@Service
public class UserService extends CrudService<UserMapper, User> {
	/**
	 * 根据wx_id获取用户
	 * @param user
	 * @return
	 */
	public User getByWxId(User user) {
		return dao.getByWxId(user);
	}
}
