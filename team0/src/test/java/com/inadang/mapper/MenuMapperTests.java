package com.inadang.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MenuMapperTests {
	@Setter @Autowired
	private MenuMapper mapper;
	
	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testInsert() {
		Menu menu = new Menu(1L, null, "오늘저녁뭐먹노", 200000L, "메뉴추가테스트", false, null);
		int result = mapper.insert(menu);
		log.info(result);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testDelete() {
		Long mno = 5860L;
		log.info(mapper.delete(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testInsertAttach() {
		MenuAttach attach = new MenuAttach(5880L, null, UUID.randomUUID().toString(), "origin", null, null);
		log.info(mapper.insertAttach(attach));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testSelectAttach() {
		Long mno = 2973L;
		log.info(mapper.selectAttach(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testDeleteAttach() {
		Long mno = 5880L;
		log.info(mapper.delete(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testDeleteAttachByUuid() {
		String uuid = "6e18699b-4a61-49e7-8bbf-9fdc5214d2b0.jpg";
		log.info(mapper.deleteAttachByUuid(uuid) ? 1 : 0);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testUpdate() {
		Menu menu = new Menu(1L, 5880L, "내일점심뭐먹노", 200000L, "메뉴수정테스트", false, null);
		log.info(mapper.update(menu));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testSelectAll() {
		Long sno = 1L;
		CriteriaScroll cri = new CriteriaScroll();
		mapper.selectAll(sno, cri).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testSelect() {
		Long mno = 5880L;
		log.info(mapper.select(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testUpdateState() {
		Long mno = 5880L;
		log.info(mapper.updateState(mno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testDeleteAll() {
		Long sno = 1L;
		CriteriaScroll cri = new CriteriaScroll();
		for(Menu menu : mapper.selectAll(sno, cri)) {
			mapper.deleteAttach(menu.getMno());
		}
		log.info(mapper.deleteAll(sno));
	}
	
}
