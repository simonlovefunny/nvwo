package com.simon.nvwo.shiro.dao;

import java.util.Set;

import com.simon.nvwo.shiro.entity.Permission;
import com.simon.nvwo.shiro.entity.Role;
import com.simon.nvwo.shiro.entity.User;

public interface UserDao {
	
	public User createUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(Long userId);
	
	public void correlationRoles(Long userId,Long...roleIds);
	
	public void uncorrelationRoles(Long userId,Long...roleIds);
	
	User findOne(Long userId);
	
	User findByUsername(String username);
	
	Set<String> findRoles(String username);
	
	Set<String> findPermissions(String permission);

}
