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
public class MenuServiceTests {
	@Setter @Autowired
	MenuService menuService;
	
	@Test
	public void testExist() {
		assertNotNull(menuService);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testRegister() {
		Menu menu = new Menu(1L, null, "test", 30000L, "testInfo", true, null);
		log.info(menuService.register(menu));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testAddAtthach() {
		MenuAttach menuAttach = new MenuAttach(null, "test", "test", null, null, 30002L);
		log.info(menuService.addAttach(menuAttach));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testRemoveAttach() {
		Long mno = 30002L;
		log.info(menuService.removeAttach(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testGetAttach() {
		Long mno = 30002L;
		log.info(menuService.getAttach(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testModify() {
		Long mno = 30002L;
		Menu menu = menuService.get(mno);
		log.info(menuService.get(mno));
		menu.setName("modify test");
		menuService.modify(menu);
		log.info(menuService.get(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testRemove() {
		Long mno = 30002L;
		log.info(menuService.remove(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testList() {
		Long sno = 1L;
		CriteriaScroll cri = new CriteriaScroll();
		menuService.list(sno, cri).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testGet() {
		Long mno = 13642L;
		log.info(menuService.get(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testChangeState() {
		Long mno = 13642L;
		menuService.changeState(mno);
		log.info(menuService.get(mno).isState());
		menuService.changeState(mno);
		log.info(menuService.get(mno).isState());
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testRemoveAll() {
		Long sno = 281L;
		log.info(menuService.removeAll(sno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testRemoveAttachByUuid() {
		String uuid = "6e18699b-4a61-49e7-8bbf-9fdc5214d2b0.jpg";
		log.info(menuService.removeAttachByUuid(uuid) ? 1 : 0);
	}
}
