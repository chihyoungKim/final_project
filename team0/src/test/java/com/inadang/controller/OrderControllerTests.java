package com.inadang.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.security.Principal;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@WebAppConfiguration
@Log4j
public class OrderControllerTests {
	
	@Autowired @Setter
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	@Before
	public void setUp(){
		this.mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testExist(){
		log.info(ctx);
		log.info(mvc);
		assertNotNull(ctx);
		assertNotNull(mvc);
	}
	
	@Test //카트에서 주문으로 넘어갈 때 주문페이지
	public void testGetOrder() throws Exception{
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders
				.get("/order/payment")
				.param("ono", "ORD0220520140557"))
				.andReturn()
				.getModelAndView();
		
		Map<String, Object> map = mav.getModel();
		Object order = map.get("order");
		Map<String, Object> map1 = mav.getModel();
		Object orderMenu = map1.get("orderMenu");
		log.info(order);
		log.info(orderMenu);
	}
	
	//결제내역 가져오기 (order/history)
	@Test
	public void testGetHistory() throws Exception{
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders
				.get("/order/history")
				.param("ono", "ORD0220520140557"))
				.andReturn()
				.getModelAndView();
		
		Map<String, Object> map = mav.getModel();
		Object history = map.get("payment");
		log.info(history);
	}
	
	// ono를 갖고 orderMenu 가져오기
	@Test
	public void testFindOrder() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/order/findorder/ono"))
				.andReturn()
				.getModelAndView()
				.getModelMap();
		
	}
}
