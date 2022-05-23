package com.inadang.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.Payment;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PaymentServiceTests {
	
	@Setter @Autowired
	PaymentService service;
	
	@Test
	public void exist(){
		assertNotNull(service);
		log.info(service);
	}
	
	@Test //특정 아이디의 주문내역
	public void testFindSpecific(){
		Payment payments = service.findSpecific("ORD0220511135330", "fishnew");
		assertNotNull(payments);
		log.info(payments);
	}
	
	@Test
	public void test(){
		String id = "javaboy";
		List<Payment> list = service.get(id);
		list.forEach(log::info);
		
	}
	
	@Test 
	public void testList(){
		List<Payment> list = service.getList();
		assertNotNull(list);
		list.forEach(log::info);
	}
	
	@Test
	public void testInsert(){
		Payment payments = new Payment();
		payments.setOno("ORD1651351087458");
		payments.setId("augustin");
		payments.setAmount(78000);
		payments.setName("생어거스틴 영등포점");
		payments.setEmail("saint@gmail.com");
		payments.setImpUid("imp_300030471511");
		payments.setPayMethod("card");
		payments.setApplyNum(71776456);
		payments.setQuota(5);
		payments.setStatus("paid");
		payments.setPhoneNumber("01024568423");
		payments.setPostCode(51128);
		payments.setAddress("가나다라마사");
		payments.setDetailAddress("123");
		payments.setRequests("반반무많이");
		
		String id = payments.getId();
		
		service.insert(payments);
		log.info(payments);
	}
	
	@Test 
	public void testRemove(){
		String pno = "2";
		
		int exp = 1;
		int result = service.remove(pno);
		
		assertEquals("결제내역취소", exp, result);
		log.info(pno);
	}
	
	@Test
	public void testUpdateStatus(){
		String ono = "ORD0220511135331";
		Payment payments = service.select(ono);
		payments.setStatus("hide");
		log.info(payments);
	}
}
