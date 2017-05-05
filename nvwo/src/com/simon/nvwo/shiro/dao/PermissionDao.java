package com.simon.nvwo.shiro.dao;

import com.simon.nvwo.shiro.entity.Permission;

public interface PermissionDao {
	

	public Permission createPermission(Permission permission);
	
	public void  deletePermission(Long permissionId);

}
