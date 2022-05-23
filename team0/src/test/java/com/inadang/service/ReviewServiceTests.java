package com.inadang.service;

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
public class ReviewServiceTests {
	@Setter @Autowired
	ReviewService reviewService;

	@Test
	public void testExist() {
		assertNotNull(reviewService);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testListReview() {
		Long sno = 1L;
		CriteriaReview cri = new CriteriaReview();
		reviewService.list(sno, cri).forEach(log::info);
	}

	/**
	 * @author 김치형
	 */	
	@Test
	public void testListReply() {
		Long sno = 1L;
		CriteriaReview cri = new CriteriaReview();
		reviewService.list(sno, cri).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testList() {
		String id = "ha**님";
		reviewService.list(id).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testGet() {
		Long rno = 6670L;
		log.info(reviewService.get(rno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testRegister() {
		Review review = new Review(null, "javaboy", 1L, "test", 5.0, null, 1074L, null, null);
		log.info(reviewService.register(review));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testRemove() {
		Long rno = 6672L;
		log.info(reviewService.remove(rno));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testAddAttach() {
		ReviewAttach attach = new ReviewAttach(null, "test", "test", null, null, 6673L);
		log.info(reviewService.addAttach(attach));
		reviewService.getAttach(6673L).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testRemoveAttach() {
		reviewService.removeAttach(6673L);
		reviewService.getAttach(6673L).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testReplyRegister() {
		Review review = new Review(null, "javaboy", 1L, "test", null, null, 1074L, null, null);
		reviewService.replyRegister(review);
		CriteriaReview cri = new CriteriaReview();
		reviewService.list(1L, cri).forEach(log::info);
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testReplyModify() {
		Long rno = 6676L;
		Review review = reviewService.get(rno);
		review.setContent("modify test");
		log.info(reviewService.replyModify(review));
	}
	
	/**
	 * @author 김치형
	 */	
	@Test
	public void testRemoveAll() {
		Long sno = 281L;
		reviewService.removeAll(sno);
		CriteriaReview cri = new CriteriaReview();
		reviewService.list(sno, cri).forEach(log::info);
	}
}
