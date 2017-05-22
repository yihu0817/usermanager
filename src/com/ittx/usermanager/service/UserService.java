package com.ittx.usermanager.service;

import java.util.List;

import com.ittx.usermanager.model.User;

public interface UserService {
	public void addUser(String id,String name,String age,String sex,String type);  //添加用户
	public List<User> getAllUser();  //获取用户列表
	public void batchDelete(String userIds);
	public User getUserById(int id);
}
