package com.inadang.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.inadang.domain.OrderMenu;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Transactional @Commit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OrderMenuServiceTests {
	@Autowired @Setter
	private OrderMenuService menuService;
	@Setter @Autowired 
	private OrderService orderService;
	
	@Test
	public void testExist(){
		log.info(menuService);
		assertNotNull(menuService);
	}
	
	@Test
	public void testgetList(){
		List<OrderMenu> list = menuService.getList();
		list.forEach(log::info);
	}
	
	@Test
	public void testFindBy(){
		String ono = "ORD0220511160518";
		List<OrderMenu> list = menuService.findBy(ono);
		list.forEach(log::info);
	}
	
	@Test
	public void testInsertTransation(){
		OrderMenu menu = new OrderMenu();
		menu.setOno("ORD0220513100521");
		menu.setCount(1);
		menu.setPrice(2000);
		menu.setMno(529L);
		
		String ono = "ORD0220513100521";
		
		menuService.insert(menu, ono);
		log.info("가나다" + menuService.findBy(ono));
		log.info("====================");
//		log.info(orderService.get(ono));
	}
}
