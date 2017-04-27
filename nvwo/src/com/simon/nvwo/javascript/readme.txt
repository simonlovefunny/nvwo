JavaScript

	JavaScript是解释性语言，在网页上发生某个事件（event）时，JavaScript才开始运行
	
	JavaScript用于交互，将静态页面


导入JavaScript文件
<script type="text/javascript" src="js/cookie.js"></script>


函数function

内置函数
	prompt()
	如果用户单击提示框的取消按钮，则返回 null。如果用户单击确认按钮，则返回输入字段当前显示的文本
	var name=prompt("Please enter your name","hello") 默认显示hello
	
	var 
	onchange()
	onchange 事件会在域的内容改变时发生
	
	isNaN()
	isNaN() 函数用于检查其参数是否是非数字值
	
	.toFixed(2) 四舍五入到小数点后两位
	
	定时器 timer
	单次定时器由用户点击触发，间隔定时器自己工作，和用户行为无关
	单次定时器var timerId=setTimeout("Time code",Time delay);  时间单位为毫秒millisecond
	间隔定时器var timerId=setInterval("Time code",Time delay); 时间单位为毫秒millisecond	
	setTimeout("document.getElementById('rockImg').src='images/rock.png'", 2000);
	可以用clearInterval(timerId)清除定时器
	
自定义函数
	
	变量名称name即为函数名称
	var name=function doit(){
	
	}

回调函数

onload onclick

var initSeat=function(){}

widow.onload=initSeat;  //相当于调用了对应的函数


数据存储
	
	Javascript在浏览器重新载入或者关闭时会摧毁所有的变量
	
	JavaScript有三种基本数据类型data-type
	text boolean number
	
	变量 JavaScript的变量值不需要赋予类型，它能自己调节
	var + variablename + ;  为新变量命名，变量一开始为空
	
	var + variablename + = + Initial value + ;为变量赋初始值
	
	常量
	
	const + constant name + = +constant name + ; 创建常量
	
	parseInt() parseFloat()将字符串转换为整数 浮点数
	
	cookie 用于持久化JavaScript变量 cookie存储于硬盘上
	
	
	
对象

	常用对象
		window
		document(DOM)
		
	对象拥有变量和函数，其都是对象成员（object member）
	对象使用构造函数用于对象初始化，使用构造函数创建对象时，使用new 运算符
	变量是对象特性propoerty
	函数是对象的方法method
	object.propoerty(method)
	
	
	对象原型object prototype
	使用prototype将使方法为类所有，好处是其他实例使用的都是这个类的方法，不会给每个实例创建方法，节省内存
	
	类特性class property
	只有单一份，可供类的所有实例访问
	
	
	拓展类的prototype对象
	String.prototype.doit=function(){
	
	}
	
DOM Document Object Model  
	DOM树就是一个html文件的结构模型
	
	innerHTML对于所有元素中的内容提供了访问管道，取得元素的所有内容，包括标签
	document对象代表网页本身
	document.body是网页里能被看到的部分，也就是<body></body>元素的内容
	
	//可以切换元素的style
	document.getElementById("name").className="";
	
	改变节点文本的三个步骤：
	1.移除所有子节点 removeChild()
	2.创建新内容文本createTextNode()
	3.新创建的文本附加在结点上
	
	var node=document.getElementById("name");
	while(node.firstChild)
		node.removeChild(node.firstChild);
		node.appendChild(document.createTextNode("ok,maybe you are alone."));
	
	
策略
	decision包存放决策相关的javascriptdemo
	实现一个关于火柴人的小故事，每页都有两个选项（两个按钮）导向不同结果
	
	选择、决策
	if/else
	switch case break
	
	重复
	for 初始化 检验重复条件 动作 更新
	for( Init ; Test ; Update ;)
	Action;

表单
	form表示表单，每个表单元素和辅助信息，都通过form的数组表示法访问，如
	<form>
	<input id="name">
	</form>
	
	form["name"]表示name表单域的值


动态数据	ajax
	
	xml+Ajax+Dom紧密调和
	Ajax以请求 request 和响应 response 为核心
	
	自定义AjaxRequest
	
	XMLHttpRequest 用于发起Ajax请求和响应
	
	属性
	readyState
	0 	Uninitialized 	初始化状态。XMLHttpRequest 对象已创建或已被 abort() 方法重置。
	1 	Open 	open() 方法已调用，但是 send() 方法未调用。请求还没有被发送。
	2 	Sent 	Send() 方法已调用，HTTP 请求已发送到 Web 服务器。未接收到响应。
	3 	Receiving 	所有响应头部都已经接收到。响应体开始接收但未完成。
	4 	Loaded 	HTTP 响应已经完全接收。
	
	responseText
	目前为止为服务器接收到的响应体（不包括头部），格式为纯文本字符串，或者如果还没有接收到数据的话，就是空字符串
	
	responseXML
	服务器返回的相应数据，格式为xml节点树构成的对象
	status
	由服务器返回的 HTTP 状态代码,如 200 表示成功，而 404 表示 "Not Found" 错误
	
	statusText
	由服务器返回的 HTTP 状态说明
	
	onreadystatechange
	每次 readyState 属性改变的时候调用的事件句柄函数。当 readyState 为 3 时，它也可能调用多次。
	
	
	方法
	abort()

	取消当前响应，关闭连接并且结束任何未决的网络活动。
	
	这个方法把 XMLHttpRequest 对象重置为 readyState 为 0 的状态，并且取消所有未决的网络活动。例如，如果请求用了太长时间，而且响应不再必要的时候，可以调用这个方法。
	getAllResponseHeaders()
	
	把 HTTP 响应头部作为未解析的字符串返回。
	
	如果 readyState 小于 3，这个方法返回 null。否则，它返回服务器发送的所有 HTTP 响应的头部。头部作为单个的字符串返回，一行一个头部。每行用换行符 "\r\n" 隔开。
	getResponseHeader()
	
	返回指定的 HTTP 响应头部的值。其参数是要返回的 HTTP 响应头部的名称。可以使用任何大小写来制定这个头部名字，和响应头部的比较是不区分大小写的。
	
	该方法的返回值是指定的 HTTP 响应头部的值，如果没有接收到这个头部或者 readyState 小于 3 则为空字符串。如果接收到多个有指定名称的头部，这个头部的值被连接起来并返回，使用逗号和空格分隔开各个头部的值。
	open()
	
	初始化 HTTP 请求参数，例如 URL 和 HTTP 方法，但是并不发送请求。
	send()
	
	发送 HTTP 请求，使用传递给 open() 方法的参数，以及传递给该方法的可选请求体。
	setRequestHeader()
	
	向一个打开但未发送的请求设置或添加一个 HTTP 请求。
	
正则表达式  http://deerchao.net/tutorials/regex/regex.htm
	
	/^\d{5}$/  
	JavaScript正则表达式通过 '/'开始和结束
	*   任意数量的不换行字符
	. 	匹配除换行符以外的任意字符
	\w 	匹配字母或数字或下划线或汉字
	\s 	匹配任意的空白符
	\d 	匹配数字
	\b 	匹配单词的开始或结束
	^ 	匹配字符串的开始
	$ 	匹配字符串的结束
	* 	重复零次或更多次
	+ 	重复一次或更多次
	? 	重复零次或一次
	{n} 	重复n次
	{n,} 	重复n次或更多次
	{n,m} 	重复n到m次
	\W 	匹配任意不是字母，数字，下划线，汉字的字符
	\S 	匹配任意不是空白符的字符
	\D 	匹配任意非数字的字符
	\B 	匹配不是单词开头或结束的位置
	[^x] 	匹配除了x以外的任意字符
	[^aeiou] 	匹配除了aeiou这几个字母以外的任意字符