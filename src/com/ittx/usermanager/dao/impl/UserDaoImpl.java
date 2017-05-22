package com.ittx.usermanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ittx.usermanager.dao.UserDao;
import com.ittx.usermanager.model.User;
import com.ittx.usermanager.util.ConnectDB;

public class UserDaoImpl extends ConnectDB implements UserDao{

	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO user (name,age,sex)VALUES(?,?,?)";
		Connection	connection = getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setInt(3, user.getSex());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null)
					ps.close();
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<User> getAllUser() {
		String sql = "SELECT * FROM user";
		Connection connection = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> userLists = new ArrayList<User>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int sex = rs.getInt("sex");
				User user = new User(id,name,age,sex);
				userLists.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null)
					ps.close();
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return userLists;
	}

	/**
	 * "10,11,21"
	 */
	@Override
	public void batchDelete(String userIds) {
		String  sql  =  "delete from user where id in("+userIds+")"; 
		System.out.println(sql);
		Connection	connection = getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null)
					ps.close();
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public User getUserById(int ids) {
		String sql = "SELECT * FROM user where id = ?";
		Connection connection = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ids);
			rs = ps.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int sex = rs.getInt("sex");
				user = new User(id,name,age,sex);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null)
					ps.close();
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return user;
	}
	
	public static void main(String[] args){
		UserDao userDao = new UserDaoImpl();
		User user = new User(38,"李四",24,1);
		userDao.updateUser(user);
		
		System.out.println(userDao.getUserById(38));
	}

	@Override
	public void updateUser(User user) {
		String sql = "UPDATE user SET name = ? ,age = ?, sex = ? WHERE id = ?";
		Connection	connection = getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setInt(3, user.getSex());
			ps.setInt(4, user.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null)
					ps.close();
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
