package com.ittx.usermanager.dao;

import java.util.List;

import com.ittx.usermanager.model.User;

public interface UserDao {
	public void addUser(User user); 
	public List<User> getAllUser();
	public void batchDelete(String userIds);
	public User getUserById(int id);
	public void updateUser(User user);
}
