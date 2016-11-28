package org.seckill.exception;

/**
 * 秒杀相关异常
 * @author Miller
 *
 */
public class SeckillException extends RuntimeException{

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillException(String message) {
		super(message);
	}
	
}
