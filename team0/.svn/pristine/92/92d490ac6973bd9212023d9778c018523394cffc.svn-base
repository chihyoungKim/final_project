package com.inadang.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.OrderMenu;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OrderMenuMapperTests {
	@Autowired @Setter
	private OrderMenuMapper mapper;
	
	@Test
	public void testExist(){
		log.info(mapper);
		assertNotNull(mapper);
	}
	
	@Test
	public void testGetList(){
//		mapper.getList().forEach(menu -> log.info(menu));
		mapper.getList().forEach(log::info);
	}
	
	@Test
	public void testInsert(){
		OrderMenu menu = new OrderMenu();
		menu.setOno("ORD0220512110510");
		menu.setCount(1);
		menu.setPrice(300);
		menu.setMno(3113L);
		
		mapper.insert(menu);
		log.info(menu);
	}
	
	@Test //주문할 메뉴리스트노출
	public void testFindBy(){
		List<OrderMenu> menus = mapper.findBy("ORD1651351087012");
		menus.forEach(log::info);
	}
	
	@Test //메뉴단일삭제
	public void testDelete(){
		Long mno = 3011L;
		mapper.delete(mno);
		
		log.info(mno);
	}
	
	@Test //메뉴전체삭제
	public void testDeleteAll(){
		String ono = "ORD1651351087011";
		mapper.deleteAll(ono);
		log.info(ono);
	}
	
	
}
