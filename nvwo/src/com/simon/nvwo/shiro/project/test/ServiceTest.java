package com.simon.nvwo.shiro.project.test;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTest extends BaseTest{
	
	  @Test
	  public void testUserRolePermissionRelation() {

	        //zhang
	        Set<String> roles = userService.findRoles(u1.getUsername());
	        Assert.assertEquals(1, roles.size());
	        Assert.assertTrue(roles.contains(r1.getRole()));

	        Set<String> permissions = userService.findPermissions(u1.getUsername());
	        Assert.assertEquals(3, permissions.size());
	        Assert.assertTrue(permissions.contains(p3.getPermission()));

	        //li
	        roles = userService.findRoles(u2.getUsername());
	        Assert.assertEquals(0, roles.size());
	        permissions = userService.findPermissions(u2.getUsername());
	        Assert.assertEquals(0, permissions.size());


	        //��� admin-menu:update����
	        roleService.uncorrelationPermissions(r1.getId(), p3.getId());
	        permissions = userService.findPermissions(u1.getUsername());
	        Assert.assertEquals(2, permissions.size());
	        Assert.assertFalse(permissions.contains(p3.getPermission()));


	        //ɾ��һ��permission
	        permissionService.deletePermission(p2.getId());
	        permissions = userService.findPermissions(u1.getUsername());
	        Assert.assertEquals(1, permissions.size());

	        //��� zhang-admin����
	        userService.uncorrelationRoles(u1.getId(), r1.getId());
	        roles = userService.findRoles(u1.getUsername());
	        Assert.assertEquals(0, roles.size());


	}
}
