package com.simon.aliyun.phonebelong;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.simon.aliyun.phonebelong.util.HttpUtils;
import com.simon.nvwo.excel.ExcelLogs;
import com.simon.nvwo.excel.ExcelUtil;
import com.simon.nvwo.kit.StringUtils;
import com.simon.nvwo.test.DTO;
import com.simon.nvwo.test.Mobile;

public class MobileUtil {
	
    //API域名
    private final static String HOST = "http://ali-mobile.showapi.com";
    //APPCODE
    private final static String APP_CODE="18e06bc4f27041d4b5d93aec6c54ba48";
    
    public static void main(String[] args) {
	    String path = "/6-1";
	    String method = "GET";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + APP_CODE);
	    Map<String, String> querys = new HashMap<String, String>();
	    
    	//测试excle写入写出
    	
    	
    	InputStream file = null;
		try {
			file = new FileInputStream("c:\\Users\\昭毅\\Desktop\\test\\345.xls");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	List<Mobile> mobiles=(List<Mobile>) ExcelUtil.importExcel(Mobile.class,file , "yyyy/MM/dd HH:mm:ss", new ExcelLogs(),0);
 	
		Iterator<Mobile> iterator=mobiles.iterator();

		List<Mobile> list=new ArrayList<Mobile>();
		
		
		while(iterator.hasNext()){
			
			String phone=iterator.next().getPhone();
			querys.put("num", phone);
		    try {

		    	HttpResponse response = HttpUtils.doGet(HOST, path, method, headers, querys);
		    	//获取response的body
		    	Mobile mobile=new Mobile();
		    	
		    	//转化json为Mobile对象
		    	JSONObject temp=new JSONObject();
		    	temp=JSON.parseObject(EntityUtils.toString(response.getEntity()));
		    	
		    	//null判断和处理
		    	if(StringUtils.notNull(temp.get("showapi_res_body").toString() ) ){
		    		
		    		//解析Json数组
			    	JSONObject json=(JSONObject) temp.get("showapi_res_body");
			    	
			    	DTO dto=JSON.toJavaObject(json, DTO.class);
			    	//0为成功，其他失败。失败时不扣点数
			    	String ret_code=dto.getRet_code();
			    	
			    	if(ret_code !=null && ("0").equals(ret_code)){
			    		
				    	mobile.setPhone(phone);
				    	mobile.setProvince(dto.getProv());
				    	mobile.setCity(dto.getCity());
			    	}else{
			    		mobile.setPhone(phone);
				    	mobile.setProvince("0");
				    	mobile.setCity("0");
			    		
			    	}
		    		
		    	}else{
		    		
		    		mobile.setPhone(phone);
			    	mobile.setProvince("0");
			    	mobile.setCity("0");
		    	}
		    	
		    	
		    	list.add(mobile);
		    	
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }

			querys.remove("num");
		}
		
	    try {
			String[] excelheaders = {"手机号","省份","城市"};
			File f=new File("c:\\Users\\昭毅\\Desktop\\test\\543.xls");
		    OutputStream out =new FileOutputStream(f);
		        
		    ExcelUtil.exportExcel(excelheaders, list, out);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    

}
