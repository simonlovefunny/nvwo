1.Java三大特性
	封装  --可以隐藏代码的实现细节，可以对数据做检验
	继承--提高代码复用性，在原有类的基础上添加新的功能
	多态--对象定义时不指定引用，在程序运行时才知道它具体指向的引用
	
2.设计模式
	设计模式的原理都基于Java三大特性
	装饰器模式（decorator）用于在不想增加过多子类的情况下拓展基类的功能
	适配器模式（adapter）用于原有的类无法满足新的接口要求，而现有的类已经实现了部分功能，又不想改变现有的类时
	代理模式(proxy)为其他对象提供一个代理以控制对某个对象的访问。 代理类负责为委托类预处理消息，过滤消息并转发消息，以及进行消息被委托类执行后的后 续处理
	
3.JDBC
	基本的JDBC
	ORM规范JPA
	ORM框架Hibernate
	数据库连接池c3p0

4.JavaWeb
	
	Servlet
	
	JSP
kit：
	配置文件读取工具  com.simon.nvwo.kit.PropertiesUtil
	加密工具类  RSA  com.simon.nvwo.kit.RSAUtils
			MD   com.simon.nvwo.kit.MDUtils
			Base64 com.simon.nvwo.kit.Base64
			对称加密 com.simon.nvwo.kit.SymmetricEncryptUtils
			不对称加密 com.simon.nvwo.kit.AsymmetricEncryptionUtils
			综合加密工具 com.simon.nvwo.kit.CipherUtils
			