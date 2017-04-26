package com.simon.nvwo.kit;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * ��־������
 * @author zhaoyi
 *
 */
public class LogUtil {
	
	private final static Logger GATELOG = LoggerFactory.getLogger("ACP_SDK_LOG");
	private final static Logger GATELOG_ERROR = LoggerFactory.getLogger("SDK_ERR_LOG");
	private final static Logger GATELOG_MESSAGE = LoggerFactory.getLogger("SDK_MSG_LOG");

	final static String LOG_STRING_REQ_MSG_BEGIN = "============================== SDK REQ MSG BEGIN ==============================";
	final static String LOG_STRING_REQ_MSG_END = "==============================  SDK REQ MSG END  ==============================";
	final static String LOG_STRING_RSP_MSG_BEGIN = "============================== SDK RSP MSG BEGIN ==============================";
	final static String LOG_STRING_RSP_MSG_END = "==============================  SDK RSP MSG END  ==============================";

	/**
	 * ��¼��ͨ��־
	 * 
	 * @param cont
	 */
	public static void writeLog(String cont) {
		GATELOG.info(cont);
	}

	/**
	 * ��¼ERORR��־
	 * 
	 * @param cont
	 */
	public static void writeErrorLog(String cont) {
		GATELOG_ERROR.error(cont);
	}

	/**
	 * ��¼ERROR��־
	 * 
	 * @param cont
	 * @param ex
	 */
	public static void writeErrorLog(String cont, Throwable ex) {
		GATELOG_ERROR.error(cont, ex);
	}

	/**
	 * ��¼ͨ�ű���
	 * 
	 * @param msg
	 */
	public static void writeMessage(String msg) {
		GATELOG_MESSAGE.info(msg);
	}

	/**
	 * ��ӡ������
	 * 
	 * @param reqParam
	 */
	public static void printRequestLog(Map<String, String> reqParam) {
		writeMessage(LOG_STRING_REQ_MSG_BEGIN);
		Iterator<Entry<String, String>> it = reqParam.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			writeMessage("[" + en.getKey() + "] = [" + en.getValue() + "]");
		}
		writeMessage(LOG_STRING_REQ_MSG_END);
	}

	/**
	 * ��ӡ��Ӧ����.
	 * 
	 * @param res
	 */
	public static void printResponseLog(String res) {
		writeMessage(LOG_STRING_RSP_MSG_BEGIN);
		writeMessage(res);
		writeMessage(LOG_STRING_RSP_MSG_END);
	}

	/**
	 * debug����
	 * 
	 * @param cont
	 */
	public static void debug(String cont) {
		if (GATELOG.isDebugEnabled()) {
			GATELOG.debug(cont);
		}
	}
	
}