JavaScript

	JavaScript�ǽ��������ԣ�����ҳ�Ϸ���ĳ���¼���event��ʱ��JavaScript�ſ�ʼ����
	
	JavaScript���ڽ���������̬ҳ��


����JavaScript�ļ�
<script type="text/javascript" src="js/cookie.js"></script>


����function

���ú���
	prompt()
	����û�������ʾ���ȡ����ť���򷵻� null������û�����ȷ�ϰ�ť���򷵻������ֶε�ǰ��ʾ���ı�
	var name=prompt("Please enter your name","hello") Ĭ����ʾhello
	
	var 
	onchange()
	onchange �¼�����������ݸı�ʱ����
	
	isNaN()
	isNaN() �������ڼ��������Ƿ��Ƿ�����ֵ
	
	.toFixed(2) �������뵽С�������λ
	
	��ʱ�� timer
	���ζ�ʱ�����û���������������ʱ���Լ����������û���Ϊ�޹�
	���ζ�ʱ��var timerId=setTimeout("Time code",Time delay);  ʱ�䵥λΪ����millisecond
	�����ʱ��var timerId=setInterval("Time code",Time delay); ʱ�䵥λΪ����millisecond	
	setTimeout("document.getElementById('rockImg').src='images/rock.png'", 2000);
	������clearInterval(timerId)�����ʱ��
	
�Զ��庯��
	
	��������name��Ϊ��������
	var name=function doit(){
	
	}

�ص�����

onload onclick

var initSeat=function(){}

widow.onload=initSeat;  //�൱�ڵ����˶�Ӧ�ĺ���


���ݴ洢
	
	Javascript�����������������߹ر�ʱ��ݻ����еı���
	
	JavaScript�����ֻ�����������data-type
	text boolean number
	
	���� JavaScript�ı���ֵ����Ҫ�������ͣ������Լ�����
	var + variablename + ;  Ϊ�±�������������һ��ʼΪ��
	
	var + variablename + = + Initial value + ;Ϊ��������ʼֵ
	
	����
	
	const + constant name + = +constant name + ; ��������
	
	parseInt() parseFloat()���ַ���ת��Ϊ���� ������
	
	cookie ���ڳ־û�JavaScript���� cookie�洢��Ӳ����
	
	
	
����

	���ö���
		window
		document(DOM)
		
	����ӵ�б����ͺ������䶼�Ƕ����Ա��object member��
	����ʹ�ù��캯�����ڶ����ʼ����ʹ�ù��캯����������ʱ��ʹ��new �����
	�����Ƕ�������propoerty
	�����Ƕ���ķ���method
	object.propoerty(method)
	
	
	����ԭ��object prototype
	ʹ��prototype��ʹ����Ϊ�����У��ô�������ʵ��ʹ�õĶ��������ķ����������ÿ��ʵ��������������ʡ�ڴ�
	
	������class property
	ֻ�е�һ�ݣ��ɹ��������ʵ������
	
	
	��չ���prototype����
	String.prototype.doit=function(){
	
	}
	
DOM Document Object Model  
	DOM������һ��html�ļ��Ľṹģ��
	
	innerHTML��������Ԫ���е������ṩ�˷��ʹܵ���ȡ��Ԫ�ص��������ݣ�������ǩ
	document���������ҳ����
	document.body����ҳ���ܱ������Ĳ��֣�Ҳ����<body></body>Ԫ�ص�����
	
	//�����л�Ԫ�ص�style
	document.getElementById("name").className="";
	
	�ı�ڵ��ı����������裺
	1.�Ƴ������ӽڵ� removeChild()
	2.�����������ı�createTextNode()
	3.�´������ı������ڽ����
	
	var node=document.getElementById("name");
	while(node.firstChild)
		node.removeChild(node.firstChild);
		node.appendChild(document.createTextNode("ok,maybe you are alone."));
	
	
����
	decision����ž�����ص�javascriptdemo
	ʵ��һ�����ڻ���˵�С���£�ÿҳ��������ѡ�������ť������ͬ���
	
	ѡ�񡢾���
	if/else
	switch case break
	
	�ظ�
	for ��ʼ�� �����ظ����� ���� ����
	for( Init ; Test ; Update ;)
	Action;

��
	form��ʾ����ÿ����Ԫ�غ͸�����Ϣ����ͨ��form�������ʾ�����ʣ���
	<form>
	<input id="name">
	</form>
	
	form["name"]��ʾname�����ֵ


��̬����	ajax
	
	xml+Ajax+Dom���ܵ���
	Ajax������ request ����Ӧ response Ϊ����
	
	�Զ���AjaxRequest
	
	XMLHttpRequest ���ڷ���Ajax�������Ӧ
	
	����
	readyState
	0 	Uninitialized 	��ʼ��״̬��XMLHttpRequest �����Ѵ������ѱ� abort() �������á�
	1 	Open 	open() �����ѵ��ã����� send() ����δ���á�����û�б����͡�
	2 	Sent 	Send() �����ѵ��ã�HTTP �����ѷ��͵� Web ��������δ���յ���Ӧ��
	3 	Receiving 	������Ӧͷ�����Ѿ����յ�����Ӧ�忪ʼ���յ�δ��ɡ�
	4 	Loaded 	HTTP ��Ӧ�Ѿ���ȫ���ա�
	
	responseText
	ĿǰΪֹΪ���������յ�����Ӧ�壨������ͷ��������ʽΪ���ı��ַ��������������û�н��յ����ݵĻ������ǿ��ַ���
	
	responseXML
	���������ص���Ӧ���ݣ���ʽΪxml�ڵ������ɵĶ���
	status
	�ɷ��������ص� HTTP ״̬����,�� 200 ��ʾ�ɹ����� 404 ��ʾ "Not Found" ����
	
	statusText
	�ɷ��������ص� HTTP ״̬˵��
	
	onreadystatechange
	ÿ�� readyState ���Ըı��ʱ����õ��¼������������ readyState Ϊ 3 ʱ����Ҳ���ܵ��ö�Ρ�
	
	
	����
	abort()

	ȡ����ǰ��Ӧ���ر����Ӳ��ҽ����κ�δ����������
	
	��������� XMLHttpRequest ��������Ϊ readyState Ϊ 0 ��״̬������ȡ������δ�������������磬�����������̫��ʱ�䣬������Ӧ���ٱ�Ҫ��ʱ�򣬿��Ե������������
	getAllResponseHeaders()
	
	�� HTTP ��Ӧͷ����Ϊδ�������ַ������ء�
	
	��� readyState С�� 3������������� null�����������ط��������͵����� HTTP ��Ӧ��ͷ����ͷ����Ϊ�������ַ������أ�һ��һ��ͷ����ÿ���û��з� "\r\n" ������
	getResponseHeader()
	
	����ָ���� HTTP ��Ӧͷ����ֵ���������Ҫ���ص� HTTP ��Ӧͷ�������ơ�����ʹ���κδ�Сд���ƶ����ͷ�����֣�����Ӧͷ���ıȽ��ǲ����ִ�Сд�ġ�
	
	�÷����ķ���ֵ��ָ���� HTTP ��Ӧͷ����ֵ�����û�н��յ����ͷ������ readyState С�� 3 ��Ϊ���ַ�����������յ������ָ�����Ƶ�ͷ�������ͷ����ֵ���������������أ�ʹ�ö��źͿո�ָ�������ͷ����ֵ��
	open()
	
	��ʼ�� HTTP ������������� URL �� HTTP ���������ǲ�����������
	send()
	
	���� HTTP ����ʹ�ô��ݸ� open() �����Ĳ������Լ����ݸ��÷����Ŀ�ѡ�����塣
	setRequestHeader()
	
	��һ���򿪵�δ���͵��������û����һ�� HTTP ����
	
������ʽ  http://deerchao.net/tutorials/regex/regex.htm
	
	/^\d{5}$/  
	JavaScript������ʽͨ�� '/'��ʼ�ͽ���
	*   ���������Ĳ������ַ�
	. 	ƥ������з�����������ַ�
	\w 	ƥ����ĸ�����ֻ��»��߻���
	\s 	ƥ������Ŀհ׷�
	\d 	ƥ������
	\b 	ƥ�䵥�ʵĿ�ʼ�����
	^ 	ƥ���ַ����Ŀ�ʼ
	$ 	ƥ���ַ����Ľ���
	* 	�ظ���λ�����
	+ 	�ظ�һ�λ�����
	? 	�ظ���λ�һ��
	{n} 	�ظ�n��
	{n,} 	�ظ�n�λ�����
	{n,m} 	�ظ�n��m��
	\W 	ƥ�����ⲻ����ĸ�����֣��»��ߣ����ֵ��ַ�
	\S 	ƥ�����ⲻ�ǿհ׷����ַ�
	\D 	ƥ����������ֵ��ַ�
	\B 	ƥ�䲻�ǵ��ʿ�ͷ�������λ��
	[^x] 	ƥ�����x����������ַ�
	[^aeiou] 	ƥ�����aeiou�⼸����ĸ����������ַ�