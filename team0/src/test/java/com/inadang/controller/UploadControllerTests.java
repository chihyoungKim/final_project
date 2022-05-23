package com.inadang.controller;

import static org.junit.Assert.assertNotNull;

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
public class UploadControllerTests {

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
	
	// 첨부파일 업로드
	@Test
	public void testUpload() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/upload/3")
				.param("originalFilename", "testFile")
				)
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	// 첨부된 파일 보여주기
	@Test
	public void testDisplay() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/upload/display"))
				.andReturn()
				.getModelAndView();
	}
	
	// 첨부된 파일 다운로드
	@Test
	public void testDownload() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/upload/download"))
				.andReturn()
				.getModelAndView();
	}

	// 첨부된 파일 삭제
	@Test
	public void testDeleteFile() throws Exception {
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/upload/deleteFile"))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
}
