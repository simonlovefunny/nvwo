HTML
HyperText Markup Language

元素=开始标记+内容+结束标记

id为元素标识符，id在页面中必须唯一，name可以不唯一

http://validator.w3.org W3C的HTML页面检测工具



<a href="" title=""></a>链接元素 内容为可点击 title标签为鼠标移动到上面的提示信息

<a href="http://wickedlysmart.com/buzz/#Coffee"></a>  直接把可以把页面指到对应的id元素显示的内容

<a target="_blank"  href=""></a>  target="_blank" 会弹出一个新窗口而不是跳转

指定target="coffee" 如果多个链接指向同一名字的target，则会在同一个窗口打开，target="_blank"则是每次都创建一个新窗口


路径问题，由于html使用的默认路径是当前文件夹，所以返回上一级目录，
需要在url添加../表示返回上一级目录,需要返回几级目录就添加几个../

嵌套 一个元素中放另一个元素称为嵌套（想象下俄罗斯套娃）

引用双胞胎
<q></q> 短引用，使用双引号包裹内容
<blockquote></blockquote> 长引用，不使用双引号，而是使用特殊的格式显示内容

void 元素  在开始标记和结束标记之间没有任何内容的元素
没有实际内容
·<br> 换行
·<img src=""  alt=""  width="" height="" > 显示图像 src标签为图像的读取路径
 alt为图像未能正确显示时的提示信息
 width和height告诉浏览器图像的大小，单位为像素数
 
 



块元素 block
· <ol>列表项前有数字标识  ordered list <ul> 列表项前有“·”  unordered list

内联元素inline

·列表 <li>具体的列表项，被<ol><ul>包裹  list items 
 列表里面可以包含列表
 <li>  <ul> <li> </li></ul> </li>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

doctype 指明使用的html版本

html 表示这是页面的第一个元素

PUBLIC 表示HTML 4.01是公共可用的

-//W3C//DTD HTML 4.01 Transitional//EN 表示我们在使用HTML4.01版本，这个HTML标记用英文编写

http://www.w3.org/TR/html4/loose.dtd 标识这个HTMl的文档url

HTML5使用灵活的<!DOCTYPE html>标识

 <meta charset=""> 为页面指定编码格式

 CSS

 p想要改变样式的元素,可以为多个元素设置相同的样式，使用“，”分隔元素
 
 {} 括号里为想要设置样式的属性
 p{ }
 
 css使用外部xxx.css文件设置，便于维护
 引入方法 <link type="text/css" rel="stylesheet" href="css/lounge.css">
     <link type="text/css" rel="stylesheet" href="lounge.css" 
	      media="screen and (min-width: 481px)">
	      
	      media 指定了css文件应用的设备类型
	      screen表示有屏幕的设备
	      min-width: 481px 屏幕宽度不超过481px
	      max-device-width 屏幕最大宽度
	      
	      
 属性的css会被其子元素继承，但是为子元素设置的css会覆盖集成的css样式

 
 类 class
 
 将一个元素加入一个类中，只需要添加class属性
 <p class="xxx"></p>
 
 类选择器
 元素p的xxx类
 p.xxx{
 
 }
 选中所有元素中的xxx类
.xxx{

}

选中div中的h2
div h2{


}

一个元素可以有多个类
<p class="xxx，xx，x"></p>


伪类
link未访问  visited 已访问  hover悬停  focus获得焦点 active 活动  
对于<a> 
伪类可以写成
a:link{}
a:visited{}
a:hover{}



id

css选择id

#xxx{

}
p#xxx{

}
盒模型
	
	从内到外：内容区-内边距（内容区到盒子之间的区域padding）-边框（border）围绕着内边距-外边距包围着边框（margin）
	
	内边距和外边距不能指定样式
	
	    background-image:    url(../images/background.gif);  //指定背景图片
    	background-repeat: no-repeat;		//背景图片不重复
    	background-position: top left;		//背景图片用于左上角
    	
    	
    	div
    	将页面划分为逻辑区，使用<div>包裹使用id为其标记
    	
    	
    	padding-top: 0px;
    	padding-right: 20px;        相当于 padding:0px  	20px  30px 10px;
    	padding-bottom: 30px;
    	padding-left: 10px;
    	对于margin也适用
    	
    	span
字体

body{
	
	font-family:xxx;  //控制字体
	font-size:12px;    //字体大小
	color:silver:    //字体颜色
	font-weight:bold:  //字体粗细
	text-decoration:underline; //为字体添加更多风格 下划线 横线

}


表格
	<table>表格元素
	<tr>表格的一行
	<th>表格头的一个单元格
	<td>表格中的一个单元格
	

		
	
	