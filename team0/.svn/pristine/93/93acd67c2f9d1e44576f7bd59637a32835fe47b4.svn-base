package com.inadang.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.Menu;
import com.inadang.domain.MenuAttach;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CartServiceTests {
	@Setter @Autowired
	CartService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
	}
	
	@Test
	public void testAddCart(){
		service.addCart(40L, 1, "woong2");
	}
	
	@Test
	public void testDeleteCart(){
		service.deleteCart(40L, "woong2");
	}
			
	@Test
	public void testDropCart(){
		service.dropCart("woong2");
	}
	
	@Test
	public void testGet(){
		log.info(service.get(345L));
	}
}
