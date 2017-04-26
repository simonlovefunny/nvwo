
Java安全组成
	
	Java.security
		--消息摘要
	Java.crypto
		--消息安全摘要，消息认证（鉴别）码
	Java.net.ssl
		--安全套接字
	
	第三方Java扩展
		--Bouncy Castle
			支持方式：1).配置 2).调用
			
		--Apache
		
		--Base64、二进制、十六进制、字符集编码
		
		--URL编码/解码
		
		
	JCA Java Cryptography Architecture
		
	
	JCE	Java Cryptography Extension
		支持DES AES RSA
		
	JSSE Java Secure Socket Extension
		基于SSL的加密功能，主要用于网络传输
		
	JAAS Java Authentication and Authentication Service
	
	-加密算法 
	 对称加密 单钥密码（私钥密码） 加密密钥与解密密钥相同
	 
	    --DES Data Encryption Standard 数据加密标准
	    
	    --3DES 三重DES 
	    
	    --AES Advanced Encryption Standard 高级加密标准
	    
	    --PBE Password Based Encryption 基于口令加密,需要搭配SHA、DES、MD5、AES实现
	    
	    
	 非对称加密 双钥或公钥密码  加密密钥与私钥不同，密钥分为公钥和私钥
	 	
	 	--密钥交换算法DH   Diffie-Hellman
	 	
	 	--RSA算法
	 	
	 	--ElGamal算法
	--Base64算法 
		
	--消息摘要算法
			MD Message digest
			
			SHA secure Hash Algorithm
			
			MAC message Authentication Code
		
		
		
	-散列函数 哈希 hash 验证数据完整性  
	
		--消息摘要算法 MD5
		
		--SHA--安全散列算法
		
		--MAC--消息认证码算法
	 
	--数字签名
	

	
	--OSI安全体系（Open System Interconnection）
		
		
	
		
		
	-密码协议
	
		柯克霍夫原则——数据安全基于秘钥而不是算法保密。系统的安全取决于密钥，对密钥保密，对算法公开。——现代密码学设计的基本原则
		
	