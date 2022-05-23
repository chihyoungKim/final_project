package com.inadang.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.Store;
import com.inadang.mapper.StoreMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class StoreServiceTests {
	@Setter @Autowired
	StoreService storeService;
	
	private StoreMapper storeMapper;
	
	@Test
	public void testExist() {
		assertNotNull(storeService);
	}
	
	@Test
	public void testGetStoreById(){
		log.info(storeService.getStoreById("woong2"));
		
	}
	
	@Test
	public void testLike() {
		log.info(storeService.likes("javaboy123", 1L));
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testList() {
		Long category = 1L;
		CriteriaScroll cri = new CriteriaScroll();
		storeService.list(category, cri).forEach(log::info);
		String condition = "R"; // 리뷰많은순
		storeService.list(category, cri, condition).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testListBySearch() {
		Long category = 1L;
		CriteriaScroll cri = new CriteriaScroll();
		String search = "치킨";
		storeService.listBySearch(category, cri, search).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testListAd() {
		Long category = 1L;
		storeService.listAd(category).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testLikes() {
		String id = "javaboy";
		Long sno = 301L; 
		log.info(storeService.likes(id, sno) ? 1 : 0);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testListLike() {
		String id = "javaboy";
		storeService.listLike(id).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testChangeLike() {
		String id = "javaboy";
		Long sno = 301L;
		storeService.changeLike(id, sno);
		
		storeService.listLike(id).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testGetLogo() {
		Long sno = 1L;
		storeService.getLogo(sno).getUuid();
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testGet() {
		Long sno = 1L;
		log.info(storeService.get(sno).getName());
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testIncreaseReviewNum() {
		Long sno = 301L;
		log.info(storeService.get(sno).getReviewNum());
		log.info(storeService.increaseReviewNum(sno));
		log.info(storeService.get(sno).getReviewNum());
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testDeleteAttach() {
		String uuid = "14b22e60-04ea-4c60-a1f1-ef33cc1b008a.jpg";
		storeService.deleteAttach(uuid);
	}
	
	
	
	
	
}
