package org.seckill.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
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
public class SuccessKilledDaoTest {

	//注入Dao实现类依赖
	@Resource
	private SuccessKilledDao successKilledDao;
	

	@Test
	public void insertSuccessKilled() throws Exception{
		
		long id = 1000L;
		long phone = 13723415678L;
		int insertCount = successKilledDao.insertSuccessKilled(id, phone);
		System.out.println("insertCount="+insertCount);
		
		
	}
	
	@Test
	public void queryByIdWithSeckill() throws Exception{
		
		long id = 1000L;
		long phone = 13723415678L;
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
		
	}
	

	
	

}
