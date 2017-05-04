package com.simon.nvwo.shiro.permission;

import java.util.Arrays;
import java.util.Collection;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

//根据Role字符串来解析得到权限集合
public class MyRolePermissionResolver implements RolePermissionResolver {  
	
	//Realm的角色是role1的话，给其menu.*权限
    @Override  
    public Collection<Permission> resolvePermissionsInRole(String roleString) {  
        if("role1".equals(roleString)) {  
            return Arrays.asList((Permission)new WildcardPermission("menu:*"));  
        }  
        return null;  
    }
}
