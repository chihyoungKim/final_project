package com.inadang.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.AuthVO;
import com.inadang.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@Log4j
public class MemberMapperTests {
	@Setter @Autowired
	private MemberMapper mapper;
	@Setter @Autowired
	private PasswordEncoder encoder;
	
	
	@Test
	public void testExist() {
		assertNotNull(mapper);
		log.info(mapper);
	}
	
	@Test
	public void testInsertMember() {
		MemberVO vo = new MemberVO();
		vo.setId("sang");
		vo.setPassword(encoder.encode("1234"));
		vo.setName("웅3");
		vo.setTel("010-0000-0000");
		vo.setEmail("woong3.naver.com");
		vo.setNickName("웅3");
		log.info(vo);
		mapper.insertMember(vo);
	}

	@Test
	public void testInsertManager() {
		MemberVO vo = new MemberVO();
		vo.setId("manager1");
		vo.setPassword(encoder.encode("1234"));
		vo.setName("매니저");
		vo.setTel("010-0000-0000");
		vo.setEmail("woong3.naver.com");
		vo.setBossName("김승종");
		vo.setBno("111111111");
		log.info(vo);
		mapper.insertManager(vo);
	}

	@Test
	public void testInsertAuth() {
		AuthVO vo = new AuthVO();
		vo.setId("manager1");
		vo.setAuth("ROLE_MANAGER");
		mapper.insertAuth(vo);
		log.info(vo);
	}
	
	
	
	@Test
	public void testGet() {
		log.info(mapper.get("member"));
	}
	
	@Test
	public void testUpdateMember() {
		String id = "member";
		MemberVO vo = mapper.get(id);
		vo.setName("웅이");
		vo.setNickName("웅이아버지");
		mapper.updateMember(vo);
		log.info(vo);
	}
	
	@Test
	public void testUpdateManager() {
		String id = "manager";
		MemberVO vo = mapper.get(id);
		vo.setName("웅이");
		vo.setBossName("웅이아버지");
		mapper.updateManager(vo);
		log.info(vo);
	}

	@Test
	public void testUpdateAuth() {
		AuthVO vo = new AuthVO();
		vo.setId("member");
		vo.setAuth("ROLE_MANAGER");
		mapper.updateMemberAuth(vo);
		log.info(vo);
	}
	@Test
	public void testDeleteAuth() {
		mapper.deleteAuth("javaboy123");
	}
	
	@Test
	public void testDeleteMember() {
		mapper.deleteMember("javaboy123");
	}
	
	@Test
	public void testGetSno(){
		log.info(mapper.getSno("woong2"));
		
	}
	
	@Test
	public void testEmailAuth() {
		MemberVO memberVO = mapper.get("woong");
		memberVO.setEmailAuth(1);
		mapper.updateEmailAuth(memberVO);
	}
	
	@Test
	public void testAuthToken() {
		MemberVO memberVO = mapper.get("woong");
		memberVO.setAuthToken(encoder.encode(memberVO.getAuthToken()));
		mapper.updateEmailAuthToken(memberVO);
	}
}
