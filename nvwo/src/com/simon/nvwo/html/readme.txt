HTML
HyperText Markup Language

Ԫ��=��ʼ���+����+�������

idΪԪ�ر�ʶ����id��ҳ���б���Ψһ��name���Բ�Ψһ

http://validator.w3.org W3C��HTMLҳ���⹤��



<a href="" title=""></a>����Ԫ�� ����Ϊ�ɵ�� title��ǩΪ����ƶ����������ʾ��Ϣ

<a href="http://wickedlysmart.com/buzz/#Coffee"></a>  ֱ�Ӱѿ��԰�ҳ��ָ����Ӧ��idԪ����ʾ������

<a target="_blank"  href=""></a>  target="_blank" �ᵯ��һ���´��ڶ�������ת

ָ��target="coffee" ����������ָ��ͬһ���ֵ�target�������ͬһ�����ڴ򿪣�target="_blank"����ÿ�ζ�����һ���´���


·�����⣬����htmlʹ�õ�Ĭ��·���ǵ�ǰ�ļ��У����Է�����һ��Ŀ¼��
��Ҫ��url���../��ʾ������һ��Ŀ¼,��Ҫ���ؼ���Ŀ¼����Ӽ���../

Ƕ�� һ��Ԫ���з���һ��Ԫ�س�ΪǶ�ף������¶���˹���ޣ�

����˫��̥
<q></q> �����ã�ʹ��˫���Ű�������
<blockquote></blockquote> �����ã���ʹ��˫���ţ�����ʹ������ĸ�ʽ��ʾ����

void Ԫ��  �ڿ�ʼ��Ǻͽ������֮��û���κ����ݵ�Ԫ��
û��ʵ������
��<br> ����
��<img src=""  alt=""  width="" height="" > ��ʾͼ�� src��ǩΪͼ��Ķ�ȡ·��
 altΪͼ��δ����ȷ��ʾʱ����ʾ��Ϣ
 width��height���������ͼ��Ĵ�С����λΪ������
 
 



��Ԫ�� block
�� <ol>�б���ǰ�����ֱ�ʶ  ordered list <ul> �б���ǰ�С�����  unordered list

����Ԫ��inline

���б� <li>������б����<ol><ul>����  list items 
 �б�������԰����б�
 <li>  <ul> <li> </li></ul> </li>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

doctype ָ��ʹ�õ�html�汾

html ��ʾ����ҳ��ĵ�һ��Ԫ��

PUBLIC ��ʾHTML 4.01�ǹ������õ�

-//W3C//DTD HTML 4.01 Transitional//EN ��ʾ������ʹ��HTML4.01�汾�����HTML�����Ӣ�ı�д

http://www.w3.org/TR/html4/loose.dtd ��ʶ���HTMl���ĵ�url

HTML5ʹ������<!DOCTYPE html>��ʶ

 <meta charset=""> Ϊҳ��ָ�������ʽ

 CSS

 p��Ҫ�ı���ʽ��Ԫ��,����Ϊ���Ԫ��������ͬ����ʽ��ʹ�á������ָ�Ԫ��
 
 {} ������Ϊ��Ҫ������ʽ������
 p{ }
 
 cssʹ���ⲿxxx.css�ļ����ã�����ά��
 ���뷽�� <link type="text/css" rel="stylesheet" href="css/lounge.css">
     <link type="text/css" rel="stylesheet" href="lounge.css" 
	      media="screen and (min-width: 481px)">
	      
	      media ָ����css�ļ�Ӧ�õ��豸����
	      screen��ʾ����Ļ���豸
	      min-width: 481px ��Ļ��Ȳ�����481px
	      max-device-width ��Ļ�����
	      
	      
 ���Ե�css�ᱻ����Ԫ�ؼ̳У�����Ϊ��Ԫ�����õ�css�Ḳ�Ǽ��ɵ�css��ʽ

 
 �� class
 
 ��һ��Ԫ�ؼ���һ�����У�ֻ��Ҫ���class����
 <p class="xxx"></p>
 
 ��ѡ����
 Ԫ��p��xxx��
 p.xxx{
 
 }
 ѡ������Ԫ���е�xxx��
.xxx{

}

ѡ��div�е�h2
div h2{


}

һ��Ԫ�ؿ����ж����
<p class="xxx��xx��x"></p>


α��
linkδ����  visited �ѷ���  hover��ͣ  focus��ý��� active �  
����<a> 
α�����д��
a:link{}
a:visited{}
a:hover{}



id

cssѡ��id

#xxx{

}
p#xxx{

}
��ģ��
	
	���ڵ��⣺������-�ڱ߾ࣨ������������֮�������padding��-�߿�border��Χ�����ڱ߾�-��߾��Χ�ű߿�margin��
	
	�ڱ߾����߾಻��ָ����ʽ
	
	    background-image:    url(../images/background.gif);  //ָ������ͼƬ
    	background-repeat: no-repeat;		//����ͼƬ���ظ�
    	background-position: top left;		//����ͼƬ�������Ͻ�
    	
    	
    	div
    	��ҳ�滮��Ϊ�߼�����ʹ��<div>����ʹ��idΪ����
    	
    	
    	padding-top: 0px;
    	padding-right: 20px;        �൱�� padding:0px  	20px  30px 10px;
    	padding-bottom: 30px;
    	padding-left: 10px;
    	����marginҲ����
    	
    	span
����

body{
	
	font-family:xxx;  //��������
	font-size:12px;    //�����С
	color:silver:    //������ɫ
	font-weight:bold:  //�����ϸ
	text-decoration:underline; //Ϊ������Ӹ����� �»��� ����

}


���
	<table>���Ԫ��
	<tr>����һ��
	<th>���ͷ��һ����Ԫ��
	<td>����е�һ����Ԫ��
	

		
	
	