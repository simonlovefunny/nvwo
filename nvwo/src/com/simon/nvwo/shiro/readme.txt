Shiro

�����ļ� config/
���Ե�¼��֤ com.simon.nvwo.shiro.test.LoginLogoutTest


principal=username

credentials=password

Realm
	shiro��realm��ȡ��ȫ���ݣ�SecurityManager��֤�û���ݣ�Authentication��ʱ����Ҫ��Realm��ȡ��Ӧ���û�
	��֤�û�Ȩ�ޣ�Authorization��ʱ��Ҳ��Ҫ	��Realm��ȡ��Ӧ�Ľ�ɫ��֤�û��Ƿ��ܽ��в���
	Realm���Կ���DataSource,������ini�����ļ����� shiro-realm.ini
	ShiroĬ���ṩ������Realm
	
	org.apache.shiro.realm.text.IniRealm��  ��shiro.ini
	[users]����ָ���û���/���뼰���ɫ��
	[roles]����ָ����ɫ��Ȩ����Ϣ�� 
	
	org.apache.shiro.realm.text.PropertiesRealm���ɴ��������ļ���ʹ��Realm
	user.username=password,role1,role2ָ���û���/���뼰���ɫ��
	role.role1=permission1,permission2ָ����ɫ��Ȩ����Ϣ��
	
	org.apache.shiro.realm.jdbc.JdbcRealm����shiro-jdbc-realm.ini
	ͨ��sql��ѯ��Ӧ����Ϣ���硰select password from users where username = ?����ȡ�û����룬
	��select password, password_salt from users where username = ?����ȡ�û����뼰�Σ�
	��select role_name from user_roles where username = ?����ȡ�û���ɫ��
	��select permission from roles_permissions where role_name = ?����ȡ��ɫ��Ӧ��Ȩ����Ϣ��
	Ҳ���Ե�����Ӧ��api�����Զ���sql

Authenticator
	��֤�û��˺ţ�shiro�������֤���
	SecurityManage�̳���Authenticator�ӿ�
	
Role ��ɫ    com.simon.nvwo.shiro.test.LoginLogoutTest.testHasRole()
permission ��Դ	
Authorizer
	������Ȩ�����ʿ��ƣ���Shiro API����Ȩ���ĵ���ڵ�
	SecurityManager�̳���Authorizer�ӿ�
	����ͨ������ini����Authorizerʵ��
	com.simon.nvwo.shiro.test.AuthorizerTest

���ܣ��˺ţ����룩
	Shiro�ṩ��base64��16�����ַ�������/�����API֧��
	