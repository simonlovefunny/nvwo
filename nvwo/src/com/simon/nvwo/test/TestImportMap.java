
package com.simon.nvwo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import com.simon.nvwo.excel.ExcelLogs;
import com.simon.nvwo.excel.ExcelUtil;

/**
 * The <code>TestImportMap</code>	
 * 
 */
public class TestImportMap {
  @SuppressWarnings("rawtypes")
  public static void main(String[] args) throws FileNotFoundException {
    File f=new File("/Users/SagerasWang/Desktop/test.xls");
    InputStream inputStream= new FileInputStream(f);
    
    ExcelLogs logs =new ExcelLogs();
    Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs , 0);
    
    for(Map m : importExcel){
      System.out.println(m);
    }
  }
}
