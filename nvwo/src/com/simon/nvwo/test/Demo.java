/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.simon.nvwo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.simon.aliyun.phonebelong.Client;
import com.simon.aliyun.phonebelong.Request;
import com.simon.aliyun.phonebelong.Response;
import com.simon.aliyun.phonebelong.constant.Constants;
import com.simon.aliyun.phonebelong.constant.ContentType;
import com.simon.aliyun.phonebelong.constant.HttpHeader;
import com.simon.aliyun.phonebelong.constant.HttpSchema;
import com.simon.aliyun.phonebelong.enums.Method;
import com.simon.aliyun.phonebelong.util.HttpUtils;
import com.simon.aliyun.phonebelong.util.MessageDigestUtil;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����ʾ��
 * ���滻APP_KEY,APP_SECRET,HOST,CUSTOM_HEADERS_TO_SIGN_PREFIXΪ��ʵ����
 */
public class Demo {
    //APP KEY
    private final static String APP_KEY = "app_key";
    // APP��Կ
    private final static String APP_SECRET = "APP_SECRET";
    //API����
    private final static String HOST = "api.aaaa.com";
    //�Զ������ǩ��Headerǰ׺����ѡ,Ĭ��ֻ��"X-Ca-"��ͷ�Ĳ��뵽Headerǩ����
    private final static List<String> CUSTOM_HEADERS_TO_SIGN_PREFIX = new ArrayList<String>();
    
    
    public static void main(String[] args) {
	    String host = "http://ali-mobile.showapi.com";
	    String path = "/6-1";
	    String method = "GET";
	    String appcode = "18e06bc4f27041d4b5d93aec6c54ba48";
	    Map<String, String> headers = new HashMap<String, String>();
	    //�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("num", "18825073880");


	    try {
	    	/**
	    	* ��Ҫ��ʾ����:
	    	* HttpUtils���
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* ����
	    	*
	    	* ��Ӧ�����������
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	//System.out.println(response.toString());
	    	//��ȡresponse��body
	    	Mobile mobile=new Mobile();
	    	
	    	//ת��jsonΪMobile����
	    	JSONObject temp=new JSONObject();
	    	temp=JSON.parseObject(EntityUtils.toString(response.getEntity()));
	    	//����Json����
	    	JSONObject json=(JSONObject) temp.get("showapi_res_body");
	    	
	    	DTO dto=JSON.toJavaObject(json, DTO.class);
	    	
	    	System.out.println(dto.toString());
	    	

	    	//System.out.println(mobile);
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
    /**
     * HTTP GET
     *
     * @throws Exception
     */
    public static void get() throws Exception {
        //����path
        String path = "/get";

        Map<String, String> headers = new HashMap<String, String>();
        //���������������Response������������
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "application/json");
        headers.put("a-header1", "header1Value");
        
        CUSTOM_HEADERS_TO_SIGN_PREFIX.clear();
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header1");

        
        Request request = new Request(Method.GET, HttpSchema.HTTP + HOST, path, APP_KEY, APP_SECRET, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);
        
        //�����query
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("a-query1", "query1Value");
        request.setQuerys(querys);
        	
        //���÷����
        Response response = Client.execute(request);
        
        System.out.println(JSON.toJSONString(response));
        
        
    }
    
    
    
    /**
     * HTTP POST ��
     *
     * @throws Exception
     */
    public void postForm() throws Exception {
        //����path
        String path = "/postform";

        Map<String, String> headers = new HashMap<String, String>();
        //���������������Response������������
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "application/json");
        headers.put("a-header1", "header1Value");
        headers.put("b-header2", "header2Value");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.clear();
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header1");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header2");

        Request request = new Request(Method.POST_FORM, HttpSchema.HTTP + HOST, path, APP_KEY, APP_SECRET, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);
        
        //�����query
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("a-query1", "query1Value");
        querys.put("b-query2", "query2Value");
        request.setQuerys(querys);
        
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("a-body1", "body1Value");
        bodys.put("b-body2", "body2Value");
        request.setBodys(bodys);

        //���÷����
        Response response = Client.execute(request);

        System.out.println(JSON.toJSONString(response));
    }

    /**
     * HTTP POST �ַ���
     *
     * @throws Exception
     */
    public void postString() throws Exception {
        //����path
        String path = "/poststring";
        //Body����
        String body = "demo string body content";

        Map<String, String> headers = new HashMap<String, String>();
        //���������������Response������������
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "application/json");
        //����ѡ��Body MD5,����˻�У��Body�����Ƿ񱻴۸�,����Body��Form��ʱ��Ӵ�Header
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_MD5, MessageDigestUtil.base64AndMD5(body));
        //��POST/PUT�����ѡ������Body���ݸ�ʽ
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT);
        
        headers.put("a-header1", "header1Value");
        headers.put("b-header2", "header2Value");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.clear();
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header1");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header2");
        

        Request request = new Request(Method.POST_STRING, HttpSchema.HTTP + HOST, path, APP_KEY, APP_SECRET, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);
        
        //�����query
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("a-query1", "query1Value");
        querys.put("b-query2", "query2Value");
        request.setQuerys(querys);
        
        request.setStringBody(body);

        //���÷����
        Response response = Client.execute(request);

        System.out.println(JSON.toJSONString(response));
    }

    /**
     * HTTP POST �ֽ�����
     *
     * @throws Exception
     */
    public void postBytes() throws Exception {
        //����path
        String path = "/poststream";
        //Body����
        byte[] bytesBody = "demo bytes body content".getBytes(Constants.ENCODING);

        Map<String, String> headers = new HashMap<String, String>();
        //���������������Response������������
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "application/json");
        //����ѡ��Body MD5,����˻�У��Body�����Ƿ񱻴۸�,����Body��Form��ʱ��Ӵ�Header
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_MD5, MessageDigestUtil.base64AndMD5(bytesBody));
        //��POST/PUT�����ѡ������Body���ݸ�ʽ
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT);

        headers.put("a-header1", "header1Value");
        headers.put("b-header2", "header2Value");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.clear();
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header1");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header2");
        
        Request request = new Request(Method.POST_BYTES, HttpSchema.HTTP + HOST, path, APP_KEY, APP_SECRET, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);
        
        //�����query
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("a-query1", "query1Value");
        querys.put("b-query2", "query2Value");
        request.setQuerys(querys);
        
        request.setBytesBody(bytesBody);

        //���÷����
        Response response = Client.execute(request);

        System.out.println(JSON.toJSONString(response));
    }

    /**
     * HTTP PUT �ַ���
     *
     * @throws Exception
     */
    public void putString() throws Exception {
        //����path
        String path = "/putstring";
        //Body����
        String body = "demo string body content";

        Map<String, String> headers = new HashMap<String, String>();
        //���������������Response������������
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "application/json");
        //����ѡ��Body MD5,����˻�У��Body�����Ƿ񱻴۸�,����Body��Form��ʱ��Ӵ�Header
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_MD5, MessageDigestUtil.base64AndMD5(body));
        //��POST/PUT�����ѡ������Body���ݸ�ʽ
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT);

        headers.put("a-header1", "header1Value");
        headers.put("b-header2", "header2Value");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.clear();
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header1");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header2");
        
        Request request = new Request(Method.POST_STRING, HttpSchema.HTTP + HOST, path, APP_KEY, APP_SECRET, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);
        request.setStringBody(body);

        //���÷����
        Response response = Client.execute(request);

        System.out.println(JSON.toJSONString(response));
    }

    /**
     * HTTP PUT �ֽ�����
     *
     * @throws Exception
     */
    public void putBytesBody() throws Exception {
        //����path
        String path = "/putstream";
        //Body����
        byte[] bytesBody = "demo bytes body content".getBytes(Constants.ENCODING);

        Map<String, String> headers = new HashMap<String, String>();
        //���������������Response������������
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "application/json");
        //����ѡ��Body MD5,����˻�У��Body�����Ƿ񱻴۸�,����Body��Form��ʱ��Ӵ�Header
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_MD5, MessageDigestUtil.base64AndMD5(bytesBody));
        //��POST/PUT�����ѡ������Body���ݸ�ʽ
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT);
        headers.put("a-header1", "header1Value");
        headers.put("b-header2", "header2Value");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.clear();
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header1");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("a-header2");
        
        Request request = new Request(Method.PUT_BYTES, HttpSchema.HTTP + HOST, path, APP_KEY, APP_SECRET, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);
        request.setBytesBody(bytesBody);

        //���÷����
        Response response = Client.execute(request);

        System.out.println(JSON.toJSONString(response));
    }

    /**
     * HTTP DELETE
     *
     * @throws Exception
     */
    public void delete() throws Exception {
        //����path
        String path = "/delete";

        Map<String, String> headers = new HashMap<String, String>();
        //���������������Response������������
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "application/json");

        Request request = new Request(Method.DELETE, HttpSchema.HTTP + HOST, path, APP_KEY, APP_SECRET, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);

        //���÷����
        Response response = Client.execute(request);

        System.out.println(JSON.toJSONString(response));
    }

    
}