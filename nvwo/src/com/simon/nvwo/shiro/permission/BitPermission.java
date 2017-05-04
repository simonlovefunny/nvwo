package com.simon.nvwo.shiro.permission;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.Permission;

//ʹ���ַ�����ʾȨ�ޣ�+��Դ�ַ���+Ȩ��λ+ʵ��ID ͨ��+�ָ�
//0 ��ʾ����Ȩ�ޣ�1 �����������ƣ�0001����2 �޸ģ������ƣ�0010����
//4 ɾ���������ƣ�0100����8 �鿴�������ƣ�1000��
//+user+10 ��ʾ����Դuserӵ���޸�Ȩ��
public class BitPermission implements Permission{
	//��Դ
	private String resource;  
	//Ȩ��
    private int permission;  
    //ʵ��id
    private String instanceId;
    
    /**
     * 
    * <p>Title:BitPermission������ </p>
    * <p>Description: ʹ��Ȩ���ַ�������BitPermission</p>
    * @param permissionString Ȩ���ַ���
     */
    public BitPermission(String permissionString){
    	
    	// +��Ҫת�� \\+
    	String[] array=permissionString.split("\\+");

		
		if(array.length>1){
			
			//array[0]Ϊ""
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
    //�ж�Ȩ���Ƿ�ƥ��
	@Override
	public boolean implies(Permission permission) {
		
		//�ж�permission�Ƿ���BitPermission��ʵ��
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
