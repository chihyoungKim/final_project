package com.inadang.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;
import java.util.Map;

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
public class MemberControllerTests {
	
	@Setter @Autowired
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
	
	// 회원이 찜한 가게 목록 조회
	@Test
	public void testLike() throws Exception{
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/member/like"))
				.andReturn()
				.getModelAndView()
				.getModelMap();
		
	}
	
	// 회원의 주문내역 조회
	@Test
	public void testOrderHistory() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/member/orderHistory"))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	@Test
	public void testLogin() throws Exception{
		ModelAndView mav =  mvc.perform(post("/member/login")
				.param("id", "gyu")
				.param("password", "1234"))
		.andReturn()
		.getModelAndView();
		log.info(mav.getViewName());
	}
	
	@Test
	public void testMemberJoin() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/member/memberJoin")
				.param("id", "gyu")
				.param("password", "1234")
				.param("name", "규")
				.param("tel", "01011112222")
				.param("email", "gyu@gyu.com")
				.param("nickName", "규"))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	@Test
	public void testManagerJoin() throws Exception{
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/member/managerJoin")
				.param("id", "gyu1")
				.param("password", "1234")
				.param("name", "규1")
				.param("tel", "01022223333")
				.param("email", "gyu1@gyu.com")
				.param("bossName", "김치형")
				.param("bno", "2222222222"))
				.andReturn()
				.getModelAndView();
		log.info(mav.getViewName());
	}
	
	@Test
	public void testMemberNotice() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("member/notice").param("id", "gyu"))
				.andReturn()
				.getModelAndView();
		
	}
	
	@Test
	public void testMemberModify() throws Exception{
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/member/modify")
				.param("password", "1234")
				.param("name", "황")
				.param("tel", "01011123332")
				.param("nickName", "황황"))
				.andReturn()
				.getModelAndView();
		log.info(mav.getViewName());
	}
}
