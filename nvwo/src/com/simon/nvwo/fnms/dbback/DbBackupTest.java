package com.simon.nvwo.fnms.dbback;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

public class DbBackupTest{

	/**
	  * Java代码实现MySQL数据库导�?
	  *
	  * @author GaoHuanjie
	  * @param hostIP MySQL数据库所在服务器地址IP
	  * @param userName 进入数据库所�?要的用户�?
	  * @param password 进入数据库所�?要的密码
	  * @param savePath 数据库导出文件保存路�?
	  * @param fileName 数据库导出文件文件名
	  * @param databaseName 要导出的数据库名
	  * @param port 数据库使用的端口
	  * @return 返回true表示导出成功，否则返回false�?
	  */
	
	/*String hostIP, String userName, String password, String savePath, String fileName, String databaseName*/
	 
	public static boolean exportDatabaseTool() throws InterruptedException {
	  

	  DbBackupTest  dt=new DbBackupTest();
	  Properties pros=getPprVue("DbBackup.properties");
	  String hostIP=pros.getProperty("hostIP");
	  String port=pros.getProperty("port");
	  String userName=pros.getProperty("userName");
      String password=pros.getProperty("password"); 
      String savePath=pros.getProperty("savePath");
      String fileName=dt.getcurrentTime()+".sql";
      String databaseName=pros.getProperty("databaseName");
      
      File saveFile = new File(savePath);
	  if (!saveFile.exists()) {// 如果目录不存�?
	   saveFile.mkdirs();// 创建文件�?
	  }
	  //�?查savepath后面是否有\
	  if(!savePath.endsWith(File.separator)){
	   savePath = savePath + File.separator;
	  }
	 
	  PrintWriter printWriter = null;
	  BufferedReader bufferedReader = null;
	  
	  try {		  
	   printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
	   Process process = Runtime.getRuntime().exec(" mysqldump -h" + hostIP + " -p"+port+" -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName);
	   InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
	   bufferedReader = new BufferedReader(inputStreamReader);
	            String line;
	            while((line = bufferedReader.readLine())!= null){
	             printWriter.println(line);
	            }
	            printWriter.flush();
	   if(process.waitFor() == 0){//0 表示线程正常终止�?
	    return true;
	   }
	  }catch (IOException e) {
	   e.printStackTrace();
	  } finally {
	   try {
	    if (bufferedReader != null) {
	     bufferedReader.close();
	    }
	    if (printWriter != null) {
	     printWriter.close();
	    }
	   } catch (IOException e) {
	    e.printStackTrace();
	   }
	  }
	  return false;
	 }
	 
	 
	public  String getcurrentTime(){
		  //获取当前准确时间 yyyyMMddHHmmss   yyyy-MM-dd HH:mm:ss
		
			String year=new SimpleDateFormat("yyyy")
			.format(Calendar.getInstance().getTime());
	        String month=new SimpleDateFormat("MM")
	        		.format(Calendar.getInstance().getTime());
	        String day=new SimpleDateFormat("dd")
	        		.format(Calendar.getInstance().getTime());
	        String hour=new SimpleDateFormat("HH")
	        		.format(Calendar.getInstance().getTime());
	        String minute=new SimpleDateFormat("mm")
	        		.format(Calendar.getInstance().getTime());
	        String second=new SimpleDateFormat("ss")
	        		.format(Calendar.getInstance().getTime());
	        
	        String currentTime=year+month+day+hour+minute+second;
	        return currentTime;
	}
	 
	 
	 /*
	  * 读取配置文件方法
	  */
	 public static Properties getPprVue(String properName) {

		      InputStream inputStream = DbBackupTest.class.getClassLoader()

		            .getResourceAsStream(properName);

		      Properties p = new Properties();

		      try {

		         p.load(inputStream);

		         inputStream.close();

		      } catch (IOException e) {

		         e.printStackTrace();

		      }

		      return p;
		   }
	 
	   
/*	   public static void main(String[] args) {
		  try{
			  if(exportDatabaseTool()){
				  System.out.println("数据库备份成功！！！");
			  }else {
				  System.out.println("数据库备份失败！！！");
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	}*/
/*	 public static void main(String[] args){
	  try {
	   if (exportDatabaseTool("127.0.0.1", "root", "root", "G:/backupDatabase", "2016-04-22.sql", "fnmsdb0415")) {
	    System.out.println("数据库成功备份！！！");
	   } else {
	    System.out.println("数据库备份失败！！！");
	   }
	  } catch (InterruptedException e) {
	   e.printStackTrace();
	  }
	 }*/
//public static void main(String[] args){
//   Process p;
//	try {
//		p = Runtime.getRuntime().exec("cmd /c mysqldump -h127.0.0.1 -P3306 -uroot -proot  fnmsdb0415 >F:ccc.sql");
//		p.waitFor();
//		int ret = p.exitValue();  
//	    System.out.println(ret);  
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}    
//  
//}
}
