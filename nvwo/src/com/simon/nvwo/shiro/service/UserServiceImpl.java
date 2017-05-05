package com.simon.nvwo.shiro.service;

import java.util.Set;

import com.simon.nvwo.shiro.dao.UserDao;
import com.simon.nvwo.shiro.dao.UserDaoImpl;
import com.simon.nvwo.shiro.entity.User;

public class UserServiceImpl implements UserService{
	
	UserDao userDao=new UserDaoImpl();
	
	private PasswordHelper passwordHelper = new PasswordHelper();
	@Override
	public User createUser(User user) {
		
		return userDao.createUser(user);
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
		
	}

	@Override
	public void correlationRoles(Long userId, Long... roleIds) {
		
		userDao.correlationRoles(userId, roleIds);
	}

	@Override
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		
		userDao.uncorrelationRoles(userId, roleIds);
	}

	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

	@Override
	public Set<String> findRoles(String username) {
		
		return userDao.findRoles(username);
	}

	@Override
	public Set<String> findPermissions(String username) {
		
		return userDao.findPermissions(username);
	}

	@Override
	public void updateUser(User user) {
		
		userDao.updateUser(user);	
	}

}
