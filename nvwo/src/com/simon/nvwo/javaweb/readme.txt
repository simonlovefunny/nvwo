�Ự�ͻỰ״̬

	�Ự���� 
	
		--session
			��ʶ sessionID	
			
			����sessionID����ʹ��cookie��JSESSIONID���־û�cookie��
			
			����session����ʹ��URL��дʵ��session׷�٣��ڲ�����cookie��������б��ֺ�web��������ͨ��
			
			
			session������
			
			1).��ʾ�Ự����״̬
			SessionID:<%= session.getId()%>		
			IsNew:<%=session.isNew() %>
			CreatedTime:<%=session.getCreationTime() %>
			LastAccessedTime:<%=session.getLastAccessedTime() %>
	
			
			2.)�����ҳ�������
			
			request.getSession().setAttribute("books", books);
			session.getAttribute("books");
			
			session��������
				
				1). Ĭ�������, ��һ�η���һ�� WEB Ӧ�õ�һ�� JSP ҳ��ʱ, ��ҳ�涼������һ������������������ Session ����. 
					��Ϊ page ָ���� session ����Ĭ��Ϊ true

				2). ���� session ���Ը�Ϊ false, JSP ҳ�治��Ҫ��һ����һ�� Session ����͵�ǰ�� JSP ҳ�������
				��������һ�η��ʵ�ǰ WEB Ӧ�õ� JSP ҳ��ʱ, �Ͳ��ᴴ��һ�� Session ����. 

				3). ����һ�� Session ����: �� page ָ���� session ����Ϊ false �� �� Servlet �п���ͨ������ API ��ȡ Session ����. 

				request.getSession(flag): �� flag Ϊ true, ��һ���᷵��һ�� HttpSession ����, ����Ѿ��к͵�ǰ JSP ҳ������� HttpSession
				����, ֱ�ӷ���; ���û��, �򴴽�һ���µķ���. flag Ϊ false: ���й�����, �򷵻�; ��û��, �򷵻� null

				request.getSession(): �൱�� request.getSession(true);
			
				4). Session ���������: 

				��. ֱ�ӵ��� HttpSession �� invalidate()
				��. HttpSession ��������ʱ��. 

				> �������ʱЧ: getMaxInactiveInterval() ��λ����
				> �������ʱЧ: setMaxInactiveInterval(int interval)
				> ������ web.xml �ļ������� Session �����ʱЧ, ��λ�Ƿ���. 


				��. ж�ص�ǰ WEB Ӧ��. 
				ע��: �ر�������������� Session!
			
		--cookie
			Cookie���Ʋ��õ����ڿͻ��˱���HTTP״̬��Ϣ�ķ���
			
			Cookie�������������WEB��������ĳ����Դʱ����WEB��������HTTP��Ӧͷ�и������������С�ı��ļ�
			
			һ��web�����������ĳ��cookie���Ժ�ÿ�η��ʷ�����ʱ������������ͷ�н����cookie�ش���������
			
			�ײ�ʵ��ԭ��
			web��������http��Ӧ��Ϣ�����set-cookie��Ӧͷ�����͸�������������ͨ����http������Ϣ�����cookie����ͷ�ֶν�cookie
			�ش���������
			
			һ��cookieֻ�ܱ�ʶһ����Ϣ��������ӵ��һ����ʾ����Ϣ�����ƣ�NAME����ֵ��VALURE��
			
			Ĭ���ǻỰ�����cookie���־û�cookie��Ҫ����maxAge��������Ϊ0������ɾ����cookie
			
			cookie���÷�Χ����ǰĿ¼�͵�ǰĿ¼����Ŀ¼
			
			cookieʵ��һ��ʱ�����Զ���¼�������û������룩
			cookie.jsp
			
			cookie��ʾ����������¼
			books.jsp
			book.jsp
			
				
		
		
