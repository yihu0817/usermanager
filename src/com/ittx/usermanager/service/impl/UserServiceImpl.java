package com.ittx.usermanager.service.impl;

import java.util.List;

import com.ittx.usermanager.dao.UserDao;
import com.ittx.usermanager.dao.impl.UserDaoImpl;
import com.ittx.usermanager.model.User;
import com.ittx.usermanager.service.UserService;
/**
 * 业务层 
 *
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void batchDelete(String userIds) {
		userDao.batchDelete(userIds);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public void addUser(String id, String name, String age, String sex ,String type) {
		
		if(type == null || !"modify".equals(type)){ //添加用户
			User user = new User(name, Integer.parseInt(age), Integer.parseInt(sex));
			userDao.addUser(user);
		}else{//修改用户
			User user = new User(Integer.parseInt(id),name, Integer.parseInt(age), Integer.parseInt(sex));
			userDao.updateUser(user);
		}
	}

}
