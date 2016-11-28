package org.seckill.exception;

/**
 * 重复秒杀异常（运行期异常）
 * @author Miller
 *
 */
public class RepeatedKillException extends SeckillException{

	public RepeatedKillException(String message) {
		super(message);
	}
	
	public RepeatedKillException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
