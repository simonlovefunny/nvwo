session生成验证码

	原理：
	
	在请求页面，生成一个验证码图片，生成后，将该图片中的字符串存入session中
	请求页面，定义文本区域，用于输入验证码
	
	在验证servelt中，获取session和输入的验证码
	
	