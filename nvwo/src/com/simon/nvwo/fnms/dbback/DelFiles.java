package com.simon.nvwo.fnms.dbback;

import java.io.File;

public class DelFiles{
	
	
	public static boolean deleteFiles(String savePath){
		
		
		boolean flag=false;
		
		File file=new File(savePath);
		
		try{
			if(file.isFile()&&file.exists()){
				file.delete();
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		
		
		return flag;
		
	}

}
