package com.simon.nvwo.shiro.service;

import com.simon.nvwo.shiro.dao.PermissionDao;
import com.simon.nvwo.shiro.dao.PermissionDaoImpl;
import com.simon.nvwo.shiro.entity.Permission;

public class PermissionServiceImpl implements PermissionService{
	
	PermissionDao permissionDao=new PermissionDaoImpl();
	
	@Override
	public Permission createPermission(Permission permission) {
			
		return permissionDao.createPermission(permission);
	}

	@Override
	public void deletePermission(Long permissionId) {
		
		permissionDao.deletePermission(permissionId);
		
	}
	
	

}
