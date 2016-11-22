package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

/*
 * 秒杀库存接口
 */
public interface SeckillDao {

	/**
	 * 减库存
	 * @param seckillId 库存的id
	 * @param killTime 减库存的时间
	 * @return 如果影响的行数>1 ,表示更新的记录行数
	 */
	int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
	
	/**
	 * 根据id查询库存
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 根据偏移量查询秒杀商品列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offset,  @Param("limit") int limit);
	
}
