package org.seckill.dto;

import java.security.KeyStore.PrivateKeyEntry;

/**
 * 所有Ajax请求 封装json结果
 * @author Miller
 *
 * @param <T>
 */
public class SeckillResult<T> {

	private boolean success;
	private T data;
	private String error;
	
	public SeckillResult() {
	}

	public SeckillResult(boolean success) {
		this.success = success;
	}

	public SeckillResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public SeckillResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
