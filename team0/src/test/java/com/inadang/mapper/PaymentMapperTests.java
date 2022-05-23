package com.inadang.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.Criteria;
import com.inadang.domain.Payment;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
// 상태수정 테스트해야됨
public class PaymentMapperTests {
	@Setter @Autowired
	private PaymentMapper mapper;
	
	@Test
	public void exist(){
		log.info(mapper);
		assertNotNull(mapper);
	}
	
	@Test
	public void testGetList(){
		List<Payment> result = mapper.getList();
		assertNotNull(result);
		result.forEach(log::info);
	}
	
	@Test
	public void testGet(){
		List<Payment> payments = mapper.get("javaboy");
		payments.forEach(log::info);
		assertNotNull(payments);
	}
	
	@Test
	public void testFindSpecific(){
		Payment payments = mapper.findSpecific("ORD0220511135330", "fishnew");
		log.info(payments);
		assertNotNull(payments);
	}
	
	@Test
	public void testInsert(){
		Payment payments = new Payment();
		payments.setOno("ORD0220511135331");
		payments.setId("fishnew");
		payments.setAmount(22000);
		payments.setName("지코바치킨 영등포점");
		payments.setEmail("fifinew@gmail.com");
		payments.setImpUid("imp_300030471511");
		payments.setPayMethod("card");
		payments.setApplyNum(71776425);
		payments.setQuota(0);
		payments.setStatus("paid");
		payments.setPhoneNumber("01024568423");
		payments.setPostCode(51128);
		payments.setAddress("가나다라마사");
		payments.setDetailAddress("123");
		payments.setRequests("반반무많이");
		
		int exp = 1;
		int result = mapper.insert(payments); 
		
		assertEquals("결제내역추가", exp, result);
		
		log.info(payments);
	}
	
	@Test
	public void testRemove(){
		String pno = "6";
		
		int exp = 1;
		int result = mapper.remove(pno);
		
		assertEquals("결제내역삭제", exp, result);
		log.info(pno);
	}
	
	@Test
	public void testStatus(){
		String ono = "ORD0220511135331";
		Payment payments = mapper.select(ono);
		payments.setStatus("hide");
		log.info(payments);
	}
	
	@Test
	public void testGetListWithPaging(){
		Criteria cri = new Criteria();
		log.info(cri);
		
		List<Payment> result = mapper.getListWithPaging(cri);
		assertNotNull(cri);
		result.forEach(log::info);
	}
}
