package com.simon.nvwo.reflect;

import java.lang.reflect.Field;
import java.util.Date;

public class ReflectFieldTest {
	
	  public static void main(String[] args){    
		  
		   Student stu=new Student();
	       stu.setId(1L);
	       stu.setName("Josean");
	       stu.setNo("201403185203344");
	       stu.setCreatedate(new Date());
	       try
	      {
	          Field property1=stu.getClass().getDeclaredField("name");
	          System.out.println(property1);//private java.lang.String com.cx.test.Student.name
	          Field property3=stu.getClass().getField("nickname");
	          System.out.println(property3);//public java.lang.String com.cx.test.Student.nickname
	          //错误方法 getField系列方法只能获取公共字段
	          //Field property2=stu.getClass().getField("name");
	          //System.out.println(property2);
	          //会抛java.lang.NoSuchFieldException
	          
	          
	      } catch (SecurityException e)
	      {
	          
	          e.printStackTrace();
	      } catch (NoSuchFieldException e)
	      {
	          
	          e.printStackTrace();
	      }
	  }

}
