package com.inadang.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.CriteriaReview;
import com.inadang.domain.Review;
import com.inadang.domain.ReviewAttach;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReviewMapperTests {
	@Autowired @Setter
	private ReviewMapper mapper;
	
	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testSelectAll() {
		Long sno = 1L;
		CriteriaReview cri = new CriteriaReview();
		mapper.selectAll(sno, cri).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testSelectMine() {
		String id = "rk**님";
		mapper.selectMine(id).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testSelect() {
		Long rno = 1L;
		log.info(mapper.select(rno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testInsert() {
		Review review = new Review(null, "javaboy", 333L, "testtest", 4.8, null, null, null, null);
		mapper.insert(review);
		CriteriaReview cri = new CriteriaReview();
		mapper.selectAll(333L, cri).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testInsertAttach() {
		ReviewAttach attach = new ReviewAttach(1074L, null, "test", "test", null, null);
		log.info(mapper.insertAttach(attach));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testDeleteAttach() {
		Long rno = 1074L;
		log.info(mapper.deleteAttach(rno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testDelete() {
		Long rno = 1074L;
		log.info(mapper.delete(rno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testSelectAttach() {
		Long rno = 11029L;
		mapper.selectAttach(rno).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testDeleteAll() {
		Long sno = 333L;
		mapper.deleteAll(sno);
		CriteriaReview cri = new CriteriaReview();
		mapper.selectAll(sno, cri).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testUpdateReply() {
		Long rno = 1074L;
		Review review = mapper.select(rno);
		review.setContent("리뷰내용 수정 테스트");
		log.info(mapper.updateReply(review));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void insertReply() {
		Review review = new Review(null, "javaboy", 333L, "답글등록테스트", 0d, null, 1074L, null, null);
		log.info(mapper.insertReply(review));
	}
	
	
	
	
}
