package com.simon.nvwo.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;


public class BitAndWildPermissionResolver implements PermissionResolver {  
	//判断权限字符串是否以“+”开头（初始化为BitPermission），或者其他的初始化为WildcardPermission
    @Override  
    public Permission resolvePermission(String permissionString) {  
        if(permissionString.startsWith("+")) {  
            return new BitPermission(permissionString);  
        }  
        return new WildcardPermission(permissionString);  
    }  
} 
