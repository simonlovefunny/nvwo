JPA
	--对应配置文件-persistence.xml(配置有数据库连接)
	--实体类com.simon.nvwo.jpa.Customer
	
	---JPA基本注解
		@Entity 标识类为实体类，可以不使用@Table注释，直接生成和类名一样的表
		
		@Table	映射表名
		
		//Id和Column加到getter方法上
		@Id 映射主键
		
		@Generatedvalue 生成主键策略  默认使用Auto 对应于Mysql就是自增
		
		
		@Column 映射表的列，当需要表的列名和属性名不一致时使用
		
		@Basic 默认注解
		
	---功能注解
	
	@Transient 表示不需要映射
	
	@Temporal 精确指定类型，TimeStamp
	
	---API
	
	EntityManager
			--remove() 删除
			--find() 查找
			--persist()	持久化
			--getReference() 代理持久化
			--merge 保存或更新
			--flush()强制发送数据库语句，同步内存和数据库
			--clear()断开所有的实体连接，有未持久化的对象会被撤销
	
	
	---映射关系
			
		