package com.simon.nvwo.kit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {
	
	public static boolean isMobile(String str) {   
		if(str.length() == 0){
			return false;
		}
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // ��֤�ֻ���    
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }  
}
