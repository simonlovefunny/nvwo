JDBC编程步骤
1.load the Driver
 	1.Class.forName()|       //获得驱动类的对象
 	2.实例化时向DrividerManager注册，不需显式的调用DriverManager.registerDriver
 
2.Connect to the database
	1.DriverManager.getConnection()

3.Execute the SQL
	1.Connection.createStatement()
	2.Statement.executeQuery()
	3.Statement.executeUpdate()
4.Retrieve the result data
	1.循环取得结果 while(rs.next())
5.show the result
	1.将数据库的各种类型数据转换为Java类型（getXXX)方法
6.Close
  close the resultset / close the statement/ close the connection
  
7.PreparedStatement 继承Statement 预定义语句 动态sql操作
@see com.simon.nvwo.jdbc.DbTest.insert(int id, int age, String name, String password)

8.CallableStatement 继承PreparedStatement，提供调用存储过程的能力
@see 
创建及调用存储过程
-- create procedure all_customers() select * from user_info;
-- call all_customers();
