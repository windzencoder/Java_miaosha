package org.seckill.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatedKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"
	})
public class SeckillServiceTest {

	private final Logger logger = Logger.getLogger(SeckillServiceTest.class.getName());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList() throws Exception{
		List<Seckill> list = seckillService.getSeckillList();
		logger.error(list);
	}

	@Test
	public void testGetById() throws Exception{
		long  id = 1000;
		Seckill seckill = seckillService.getById(id);
		System.out.println(seckill);
	}
	
	@Test
	public void testExportSeckillUrl() throws Exception{
		long id = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info(exposer);
		
		//Exposer [exposed=true, md5=02a0128cfc6394feef5e2051c50f71d2, seckillId=1000, now=0, start=0, end=0]
		
	}
	
	@Test
	public void testExecuteSeckill() throws Exception{
		long id = 1000L;
		long phone = 1234567890L;
		String md5 = "02a0128cfc6394feef5e2051c50f71d2";
		SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
		logger.info(execution);
	}
	
	//测试代码完整逻辑，注意可重复执行
	@Test
	public void testSeckillLogin() throws Exception{
		long id = 1001;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info(exposer);
		if (exposer.isExposed()) {
			long phone = 12345678901L;
			try {
				SeckillExecution execution = seckillService.executeSeckill(
						exposer.getSeckillId(), 
						phone, 
						exposer.getMd5()
					);
				logger.info(execution);
			} catch (RepeatedKillException e) {
				logger.error(e.getMessage());
			} catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
			
		} else {
			//秒杀未开启
			logger.warn("秒杀未开启");
		}
		
		
	}
	
		
	
	
}
