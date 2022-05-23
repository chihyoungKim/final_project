package com.inadang.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.Store;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StoreMapperTests {
	@Autowired @Setter
	private StoreMapper mapper;
	
	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testRegister(){
		Store store = new Store();
		store.setCategory(1L);
		store.setName("후우우우웅?");
		store.setBno("123-165-498513");
		store.setAddress("웅냐냐냥냐냐냐냥냐냥");
		store.setStartTime("11:00");
		store.setEndTime("23:00");
		store.setNotice("얌마!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		store.setOriginInfo("우앙아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
		store.setDelPrice("히이이이이잉");
		store.setDelTime("우웅우ㅜ웅ㅇ");
		store.setMinPrice(12000L);
		
		log.info(store);
		
		mapper.insertSelectKey(store);
//		log.info(mapper.read(302L));
	}
	
	@Test
	public void testModify(){
		Store store = new Store();
		store.setCategory(1L);
		store.setName("후우우우웅?");
		store.setBno("123-165-498513");
		store.setAddress("웅냐냐냥냐냐냐냥냐냥");
		store.setStartTime("11:00");
		store.setEndTime("23:00");
		store.setNotice("얌마!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		store.setOriginInfo("우앙아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
		store.setDelTime("10분");
		store.setDelPrice("히이이이이잉");
		store.setMinPrice(12000L);
		
		mapper.update(store, "ksj000417");
		log.info(mapper.read(302L));
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testSelectAll() {
		mapper.selectAll().forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testSelectAd() {
		Long category = 1L;
		for(Store s : mapper.selectAd(category)) {
			log.info(s.getAd());
		}
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testSelectAllByCategory() {
		Long category = 1L;
		CriteriaScroll cri = new CriteriaScroll();
		mapper.selectAllByCategory(category, cri, "").forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testSelectAllBySearch() {
		Long category = 1L;
		CriteriaScroll cri = new CriteriaScroll();
		String search = "치킨";
		mapper.selectAllBySearch(category, cri, search).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testFindLike() {
		String id = "inadang";
		Long sno = 301L;
		log.info(mapper.findLike(id, sno) ? 1 : 0);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testDeleteLike() {
		String id = "inadang";
		Long sno = 301L;
		log.info(mapper.deleteLike(id, sno));
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testInsertLike() {
		String id = "inadang";
		Long sno = 301L;
		log.info(mapper.insertLike(id, sno));
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testSelectLike() {
		String id = "inadang";
		mapper.selectLike(id).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testSelectLogo() {
		Long sno = 301L;
		log.info(mapper.select(sno));
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testSelect() {
		Long sno = 301L;
		log.info(mapper.select(sno));
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testIncreaseReviewNum() {
		Long sno = 301L;
		log.info(mapper.select(sno).getReviewNum());
		mapper.increaseReviewNum(sno);
		log.info(mapper.select(sno).getReviewNum());
	}
	
	/**
	 * @author 김치형
	 */
	@Test
	public void testUpdateScope() {
		Long sno = 301L;
		double scope = 5.0;
		log.info(mapper.select(sno).getScope());
		mapper.updateScope(sno, scope);
		log.info(mapper.select(sno).getScope());
	}
	
}
