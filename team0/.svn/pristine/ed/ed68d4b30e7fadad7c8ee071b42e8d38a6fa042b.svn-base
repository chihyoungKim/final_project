package com.inadang.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.Cart;
import com.inadang.domain.Order;
import com.inadang.domain.OrderMenu;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.net.aso.l;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OrderServiceTests {
	@Setter @Autowired
	OrderService orderService;
	@Autowired @Setter
	private OrderMenuService menuService;
	@Autowired @Setter
	private CartService cartService;
	
	@Test
	public void testExist(){
		assertNotNull(orderService);
		log.info(orderService);
	}
	
	@Test
	public void testGetList(){
		List<Order> list = orderService.getList();
		assertNotNull(list);
	}
	
	@Test
	public void testShowList(){
		Long sno = 301L;
		List<Order> list = orderService.showList(sno);
		assertNotNull(list);
		for(Order l : list){
			l.setSno(301L);
			log.info(l);
		}
	}
	
	@Test
	public void testGet(){
		Order orders = new Order();
		orders.setOno("ORD1651351086999");
		log.info(orderService.get(orders.getOno()));
	}
	
	@Test
	public void testnInsert(){
		Order order = new Order();
		order.setId("inadang");
		order.setName("엉클피자");
		order.setSno(11L);

		OrderMenu menu = new OrderMenu();
		menu.setOno("ORD0220513120557");
		menu.setCount(1);
		menu.setPrice(2000);
		menu.setMno(529L);
		
		String id = order.getId();
		cartService.dropCart(id); 
//		orderService.insert(order, menu, cart);
		
		String ono = "ORD0220513120557";
		
		menuService.insert(menu, ono);
	}
	
	@Test
	public void testUpdateAmount(){
		String ono = "ORD0220512170538";
		Order order = orderService.get(ono);
		order.setAmount(1000);
		log.info(order);
	}
	
	@Test
	public void testDelete(){
		String ono = "ORD0220512170538";
		log.info(ono);
		boolean exp = true;
		boolean result = orderService.delete(ono);
		assertEquals("게시글삭제", exp, result);
	}	
	
	@Test
	public void testCancel(){
		String ono = "ORD0220512170538";
		Order order = orderService.get(ono);
		order.setStatus("canceled");
		
		log.info(order);
	}
}
