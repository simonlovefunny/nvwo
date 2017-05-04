Shiro

配置文件 config/
测试登录验证 com.simon.nvwo.shiro.test.LoginLogoutTest


principal=username

credentials=password

Realm
	shiro从realm获取安全数据，SecurityManager验证用户身份（Authentication）时，需要从Realm获取对应的用户
	验证用户权限（Authorization）时，也需要	从Realm获取对应的角色验证用户是否能进行操作
	Realm可以看成DataSource,可以用ini配置文件配置 shiro-realm.ini
	Shiro默认提供了三个Realm
	
	org.apache.shiro.realm.text.IniRealm：  如shiro.ini
	[users]部分指定用户名/密码及其角色；
	[roles]部分指定角色即权限信息； 
	
	org.apache.shiro.realm.text.PropertiesRealm：可创建配置文件来使用Realm
	user.username=password,role1,role2指定用户名/密码及其角色；
	role.role1=permission1,permission2指定角色及权限信息；
	
	org.apache.shiro.realm.jdbc.JdbcRealm：如shiro-jdbc-realm.ini
	通过sql查询相应的信息，如“select password from users where username = ?”获取用户密码，
	“select password, password_salt from users where username = ?”获取用户密码及盐；
	“select role_name from user_roles where username = ?”获取用户角色；
	“select permission from roles_permissions where role_name = ?”获取角色对应的权限信息；
	也可以调用相应的api进行自定义sql

Authenticator
	验证用户账号，shiro的身份验证入口
	SecurityManage继承了Authenticator接口
	
Role 角色    com.simon.nvwo.shiro.test.LoginLogoutTest.testHasRole()
permission 资源	
Authorizer
	进行授权（访问控制），Shiro API中授权核心的入口点
	SecurityManager继承了Authorizer接口
	可以通过配置ini更改Authorizer实现
	com.simon.nvwo.shiro.test.AuthorizerTest

加密（账号，密码）
	Shiro提供了base64和16进制字符串编码/解码的API支持
	