package com.inadang.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.Order;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OrderMapperTests {
	
	@Setter @Autowired
	private OrderMapper mapper;
	
	@Test
	public void exist(){
		assertNotNull(mapper);
		log.info(mapper);
	}
	
	
	@Test
	public void testGetList(){
		List<Order> list = mapper.getList();
		list.forEach(log::info);;
		assertNotNull(list);
	}
	
	@Test
	public void testShowList(){
		Long sno = 301L;
		List<Order> list = mapper.showList(sno);
		list.forEach(log::info);
	}
	
	@Test
	public void testGet(){
		Order no = mapper.get("ORD1651351086994");
		log.info(no);
	}
	
	@Test
	public void testInsert(){
		Order no = new Order();
		no.setId("woong2");
		no.setName("백종원의역전우동신도림역점");
		
		
		mapper.insert(no);
		log.info(no);
	}
	
	@Test
	public void testDelete(){
		log.info("DELETE :: " + mapper.delete("ORD0220511170549"));
	}
	
	@Test
	public void testCancle(){
		String ono = "ORD0220511170551"; 
		Order order = mapper.get(ono);
		order.setStatus("canceled");
		log.info(order);
	}
	
	@Test 
	public void testPaid(){
		Order order = mapper.get("ORD0220516140534");
		order.setStatus("paid");
		log.info(order);
	}
	
	@Test
	public void testUpdateAmount(){
		String ono = "ORD0220511170551";
		Order order = mapper.get(ono);
		order.setAmount(10000);
		log.info(order);
	}
}
