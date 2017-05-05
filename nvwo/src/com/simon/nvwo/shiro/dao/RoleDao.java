package com.simon.nvwo.shiro.dao;

import com.simon.nvwo.shiro.entity.Role;

public interface RoleDao {
	
	public Role createRole(Role role);
	
	public void deleteRole(Long roleId);
	
	public void correlationPermissions(Long roleId,Long...permissionIds);
	
	public void uncorrelationPermissions(Long roleId,Long...PermissionIds);

}
