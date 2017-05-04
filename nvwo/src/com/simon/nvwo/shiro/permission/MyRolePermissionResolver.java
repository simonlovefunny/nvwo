package com.simon.nvwo.shiro.permission;

import java.util.Arrays;
import java.util.Collection;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

//����Role�ַ����������õ�Ȩ�޼���
public class MyRolePermissionResolver implements RolePermissionResolver {  
	
	//Realm�Ľ�ɫ��role1�Ļ�������menu.*Ȩ��
    @Override  
    public Collection<Permission> resolvePermissionsInRole(String roleString) {  
        if("role1".equals(roleString)) {  
            return Arrays.asList((Permission)new WildcardPermission("menu:*"));  
        }  
        return null;  
    }
}
