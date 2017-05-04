package com.simon.nvwo.shiro.permission;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.Permission;

//使用字符串表示权限：+资源字符串+权限位+实例ID 通过+分隔
//0 表示所有权限；1 新增（二进制：0001）、2 修改（二进制：0010）、
//4 删除（二进制：0100）、8 查看（二进制：1000）
//+user+10 表示对资源user拥有修改权限
public class BitPermission implements Permission{
	//资源
	private String resource;  
	//权限
    private int permission;  
    //实例id
    private String instanceId;
    
    /**
     * 
    * <p>Title:BitPermission构造器 </p>
    * <p>Description: 使用权限字符串构造BitPermission</p>
    * @param permissionString 权限字符串
     */
    public BitPermission(String permissionString){
    	
    	// +需要转义 \\+
    	String[] array=permissionString.split("\\+");

		
		if(array.length>1){
			
			//array[0]为""
			resource=array[1];			
		}
		
		  if(StringUtils.isEmpty(resource)) {  
	            resource = "*";  
	        }  
	        if(array.length > 2) {  
	            permission = Integer.valueOf(array[2]);  
	        }  
	        if(array.length > 3) {  
	            instanceId = array[3];  
	        }  
	        if(StringUtils.isEmpty(instanceId)) {  
	            instanceId = "*";  
	        }  
    }
    //判断权限是否匹配
	@Override
	public boolean implies(Permission permission) {
		
		//判断permission是否是BitPermission的实例
		if(!(permission instanceof BitPermission)){
			return false;
		}
		
		BitPermission other = (BitPermission) permission;  
		
        if(!("*".equals(this.resource) || this.resource.equals(other.resource))) {  
            return false;  
        }  
        if(!(this.permission ==0 || (this.permission & other.permission) != 0)) {  
            return false;  
        }  
        if(!("*".equals(this.instanceId) || this.instanceId.equals(other.instanceId))) {  
            return false;  
        }  
        return true;  
    	
	}
	


}
