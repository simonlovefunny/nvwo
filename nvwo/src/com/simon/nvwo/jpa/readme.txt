JPA
	--��Ӧ�����ļ�-persistence.xml(���������ݿ�����)
	--ʵ����com.simon.nvwo.jpa.Customer
	
	---JPA����ע��
		@Entity ��ʶ��Ϊʵ���࣬���Բ�ʹ��@Tableע�ͣ�ֱ�����ɺ�����һ���ı�
		
		@Table	ӳ�����
		
		//Id��Column�ӵ�getter������
		@Id ӳ������
		
		@Generatedvalue ������������  Ĭ��ʹ��Auto ��Ӧ��Mysql��������
		
		
		@Column ӳ�����У�����Ҫ�����������������һ��ʱʹ��
		
		@Basic Ĭ��ע��
		
	---����ע��
	
	@Transient ��ʾ����Ҫӳ��
	
	@Temporal ��ȷָ�����ͣ�TimeStamp
	
	---API
	
	EntityManager
			--remove() ɾ��
			--find() ����
			--persist()	�־û�
			--getReference() ����־û�
			--merge ��������
			--flush()ǿ�Ʒ������ݿ���䣬ͬ���ڴ�����ݿ�
			--clear()�Ͽ����е�ʵ�����ӣ���δ�־û��Ķ���ᱻ����
	
	
	---ӳ���ϵ
			
		