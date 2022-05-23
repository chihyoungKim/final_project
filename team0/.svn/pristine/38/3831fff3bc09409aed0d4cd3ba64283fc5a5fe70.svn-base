package com.inadang.controller;

import java.security.Principal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CartControllerTests {
	
	@Setter @Autowired
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	@Before
	public void setUp(){
		this.mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	// 카트 추가
	@Test
	public void testAddCart() throws Exception {
		Principal pc = new Principal() {
			
			@Override
			public String getName() {
				return "ksj000417";
			}
		};
		
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/store/add").principal(pc))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	// id로 카트 찾아오기
	@Test
	public void testCartById() throws Exception {
		Principal pc = new Principal() {
			
			@Override
			public String getName() {
				return "ksj000417";
			}
		};
		
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/store/id").principal(pc))
				.andReturn()
				.getModelAndView();
		log.info(mav.getViewName());
		
		ModelMap map = mav.getModelMap();
		
		List<?> carts = (List<?>) map.get("carts");
		carts.forEach(log::info);
	}
	
	
}
