package com.simon.nvwo.shiro.service;

import com.simon.nvwo.shiro.entity.Permission;

public interface PermissionService {
	
	public Permission createPermission(Permission permission);
	
	public void deletePermission(Long permissionId);

}
