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
	变量是对象特性propoerty
	函数是对象的方法method
	object.propoerty(method)
	

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