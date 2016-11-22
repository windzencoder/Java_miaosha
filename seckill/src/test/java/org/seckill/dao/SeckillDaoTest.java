package org.seckill.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIoc容器
 * @author Miller
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	

	@Test
	public void testReduceNumber() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date killTime = sdf.parse("2015-11-01 12:00:00");
		
		int updateCount = seckillDao.reduceNumber(1000, killTime);
		System.out.println("updateCount="+updateCount);
		
	}
	
	@Test
	public void testQueryById() throws Exception{
		
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill);
		//Seckill [seckillId=1000, name=1000元秒杀iphone6, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Mon Nov 21 15:44:01 CST 2016]

		
	}
	
	@Test
	public void testQueryAll() throws Exception{
		
		List<Seckill> seckills =  seckillDao.queryAll(0, 1000);
		for (Seckill seckill : seckills) {
			System.out.println(seckill);
		}
		/*
		 * Seckill [seckillId=1000, name=1000元秒杀iphone6, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Mon Nov 21 15:44:01 CST 2016]
			Seckill [seckillId=1001, name=500元秒杀ipad2, number=200, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Mon Nov 21 15:44:01 CST 2016]
			Seckill [seckillId=1002, name=300元秒杀小米4, number=300, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Mon Nov 21 15:44:01 CST 2016]
			Seckill [seckillId=1003, name=200元秒杀红米note, number=400, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Mon Nov 21 15:44:01 CST 2016]

		 */
		
	}
	
	

}
