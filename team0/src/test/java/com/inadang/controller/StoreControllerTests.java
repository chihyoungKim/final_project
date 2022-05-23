package com.inadang.controller;

import static org.junit.Assert.assertNotNull;

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

import com.inadang.domain.Menu;
import com.inadang.domain.Store;

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
public class StoreControllerTests {
	
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
	
	//주문하기 - java.lang.NullPointerException
	@Test
	public void testInsert() throws Exception {
		ModelAndView mav = mvc.perform(
				MockMvcRequestBuilders.post("/store/detail")
				.param("ono", "ORD0220520140558")
				.param("id", "inadang")
				.param("name", "엘리시움맛집")
				.param("sno", "301"))
			.andReturn()
			.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	//주문내역확인
	@Test
	public void testStoreHistory() throws Exception{
		ModelMap mav = mvc.perform(MockMvcRequestBuilders
				.get("/store/storeHistory")
				.param("sno", "301"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		
		List<?> list1 = (List<?>) mav.get("showList");
		list1.forEach(log::info);
	}
	
	// 가게 리스트 조회
	@Test
	public void testList() throws Exception {
		String category = "1";
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/store/list/" + category))
				.andReturn()
				.getModelAndView()
				.getModelMap();
		
//				log.info(mav);
		List<?> list = (List<?>) map.get("stores");
		list.forEach(log::info);
	}
	
	
	// 가게 상세 조회
	@Test
	public void testDetail() throws Exception {
		Long sno = 301L;
		Principal pc = new Principal() {
			@Override
			public String getName() {
				return "inadang";
			}
		};
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/store/detail/" + sno).principal(pc))
				.andReturn()
				.getModelAndView();
		log.info(mav.getViewName());
		ModelMap map = mav.getModelMap();
		
		Store store = (Store)map.get("store");
		List<?> menus = (List<?>) map.get("menus");
		boolean like = (boolean) map.get("like");
		List<?> reviews = (List<?>) map.get("reviews");
		
		log.info(store);
		menus.forEach(log::info);
		log.info(like);
		reviews.forEach(log::info);
		
	}
	
	// 메뉴 페이징
	@Test
	public void testMenu() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/store/menu/11/0/10"))
				.andReturn()
				.getModelAndView();
		log.info(mav.getViewName());
		ModelMap map = mav.getModelMap();
		
		
		List<?> menus = (List<?>) map.get("menus");
		menus.forEach(log::info);
	}
	
	// 가게목록 페이징
	@Test
	public void testPages() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/store/pages/1/0/10"))
				.andReturn()
				.getModelAndView();
		log.info(mav);
		log.info(mav.getViewName());
	}
	
	// 찜
	@Test
	public void testLike() throws Exception {
		Principal pc = new Principal() {
			
			@Override
			public String getName() {
				return "inadang";
			}
		};
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/store/like/301").principal(pc))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
		
	}
	
	// 가게 메뉴 조회
	@Test
	public void testGetMenu() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/store/menu/301"))
				.andReturn()
				.getModelAndView();
		log.info(mav.getViewName());
		
		ModelMap map = mav.getModelMap();
		
		List<?> menus = (List<?>) map.get("menus");
		menus.forEach(log::info);
	}
	
	// 메뉴 등록
	@Test
	public void testPostMenu() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/store/menu")
					.param("name", "testMenu")
					.param("price", "20000")
					.param("sno", "301")
					.param("info", "testInfo")
					)
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	// 메뉴 판매상태 변경
	@Test
	public void testMenuState() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/store/menuState/mno"))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	// 리뷰와 답글 조회
	@Test
	public void testGetReply() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/store/reply/"))
				.andReturn()
				.getModelAndView()
				.getModelMap();
		
		List<?> store = (List<?>) map.get("store");
		log.info(store);
	}
	
	// 답글 작성
	@Test
	public void testPostReply() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/store/reply"))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
}
