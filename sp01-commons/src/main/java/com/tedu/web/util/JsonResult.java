package com.tedu.web.util;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("rawtypes")
@Getter
@Setter
public class JsonResult<T> {
	/** 鎴愬姛 */
	public static final int SUCCESS = 200;

	/** 娌℃湁鐧诲綍 */
	public static final int NOT_LOGIN = 400;

	/** 鍙戠敓寮傚父 */
	public static final int EXCEPTION = 401;

	/** 绯荤粺閿欒 */
	public static final int SYS_ERROR = 402;

	/** 鍙傛暟閿欒 */
	public static final int PARAMS_ERROR = 403;

	/** 涓嶆敮鎸佹垨宸茬粡搴熷純 */
	public static final int NOT_SUPPORTED = 410;

	/** AuthCode閿欒 */
	public static final int INVALID_AUTHCODE = 444;

	/** 澶绻佺殑璋冪敤 */
	public static final int TOO_FREQUENT = 445;

	/** 鏈煡鐨勯敊璇� */
	public static final int UNKNOWN_ERROR = 499;
	
	private int code;
	private String msg;
	private T data;
	
	

	public static JsonResult build() {
		return new JsonResult();
	}
	public static JsonResult build(int code) {
		return new JsonResult().code(code);
	}
	public static JsonResult build(int code, String msg) {
		return new JsonResult<String>().code(code).msg(msg);
	}
	public static <T> JsonResult<T> build(int code, T data) {
		return new JsonResult<T>().code(code).data(data);
	}
	public static <T> JsonResult<T> build(int code, String msg, T data) {
		return new JsonResult<T>().code(code).msg(msg).data(data);
	}
	
	public JsonResult<T> code(int code) {
		this.code = code;
		return this;
	}
	public JsonResult<T> msg(String msg) {
		this.msg = msg;
		return this;
	}
	public JsonResult<T> data(T data) {
		this.data = data;
		return this;
	}
	
	
	public static JsonResult ok() {
		return build(SUCCESS);
	}
	public static JsonResult ok(String msg) {
		return build(SUCCESS, msg);
	}
	public static <T> JsonResult<T> ok(T data) {
		return build(SUCCESS, data);
	}
	public static JsonResult err() {
		return build(EXCEPTION);
	}
	public static JsonResult err(String msg) {
		return build(EXCEPTION, msg);
	}
	
	@Override
	public String toString() {
		return JsonUtil.to(this);
	}
}