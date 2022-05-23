package com.inadang.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.Store;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.net.aso.l;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CartMapperTests {
	@Autowired @Setter
	private StoreMapper mapper;
	
	@Autowired @Setter
	private MemberMapper memberMapper;
	
	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testSelectAll() {
		mapper.selectAll().forEach(log::info);
	}
	
	@Test
	public void testSelectLogo() {
		Long sno = 1L;
		log.info(mapper.selectLogo(sno));
	}
	
	@Test
	public void testRead() {
		Store result =  mapper.read(123L);
		assertNotNull(result);
		log.info(result);
	}
	
	@Test
	public void testInsert() {
		
		// init
		Store store = new Store();
		store.setCategory(1L);
		store.setName("ksj000417");
		store.setBno("118-658-653468");
		store.setAddress("잉양양양양양");
		store.setStartTime("10시");
		store.setEndTime("23시");
		store.setNotice("배고프다");
		store.setOriginInfo("국 산 이 요");
		store.setMinPrice(14000L);
		store.setDelPrice("2000원");
		store.setDelTime("10분");
		
		log.info(store);
		
		// expect
		int exp = 1;
		
		// result 
		int result = mapper.insertSelectKey(store);
		
		log.info(store.getSno());
		
		assertEquals("가게 추가", exp, result);
		log.info(store);
	}
	
	@Test
	public void testSelectAllById(){
//		long sno = mapper.selectAllById("woong2");
		
		log.info(mapper.read(memberMapper.getSno("woong2")));
	}
}
