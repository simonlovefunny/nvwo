JDBC��̲���
1.load the Driver
 	1.Class.forName()|       //���������Ķ���
 	2.ʵ����ʱ��DrividerManagerע�ᣬ������ʽ�ĵ���DriverManager.registerDriver
 
2.Connect to the database
	1.DriverManager.getConnection()

3.Execute the SQL
	1.Connection.createStatement()
	2.Statement.executeQuery()
	3.Statement.executeUpdate()
4.Retrieve the result data
	1.ѭ��ȡ�ý�� while(rs.next())
5.show the result
	1.�����ݿ�ĸ�����������ת��ΪJava���ͣ�getXXX)����
6.Close
  close the resultset / close the statement/ close the connection
  
7.PreparedStatement �̳�Statement Ԥ������� ��̬sql����
@see com.simon.nvwo.jdbc.DbTest.insert(int id, int age, String name, String password)

8.CallableStatement �̳�PreparedStatement���ṩ���ô洢���̵�����
@see 
���������ô洢����
-- create procedure all_customers() select * from user_info;
-- call all_customers();
