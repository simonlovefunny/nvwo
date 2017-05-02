/**
 * @author SargerasWang
 */
package com.simon.nvwo.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simon.nvwo.excel.ExcelUtil;

/**
 * The <code>TestExportMap</code>	
 * 
 * @author SargerasWang
 * Created at 2014��9��21�� ����4:38:42
 */
public class TestExportMap {
  public static void main(String[] args) throws IOException {
    List<Map<String,Object>> list = new ArrayList<>();
    Map<String,Object> map =new HashMap<String, Object>();
    map.put("name", "����");
    map.put("age", 24);
    Map<String,Object> map2 =new HashMap<String, Object>();
    map2.put("name", "sargeras");
    map2.put("age", 100);
    list.add(map);
    list.add(map2);
    
    File f= new File("/Users/SagerasWang/Desktop/test.xls");
    OutputStream out = new FileOutputStream(f);
    ExcelUtil.exportExcel(new String[]{"name","age"},list, out );
    out.close();
  }
}
