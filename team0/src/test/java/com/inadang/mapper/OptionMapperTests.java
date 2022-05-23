package com.inadang.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inadang.domain.OptGroup;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/*옵션그룹(일) 대 옵션(다) 라서
옵션그룹이 옵션id(고유값) 를 가지고 있는게 아닌 옵션이 옵션그룹id(고유값)를 
가지고 있는게 맞을 것 같습니다.
그리고 그 만들어진 옵션그룹id(일)
메뉴(다) 라서
옵션그룹이 mno 를 가지고있으면 되는건 맞는거같은대 
근대 그걸 처리를 어떻게 해야할지 모르겠어요*/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@Log4j
public class OptionMapperTests {
	@Setter @Autowired
	private OptionMapper mapper ;
	
/*	@Test
	public void testInsert() {
		OptGroup opt = new OptGroup(50L, "옵션그룹이름", "테스트옵션이름" , 15, 10000L, 20000L); 
		int result = mapper.insertOPT(opt);
		log.info(result);
	}*/
	
/*	@Test
	public void testDelete() {
		String name = "옵션그룹이름" ; 
		mapper.deleteOPT(name) ;
		
	}*/
	
/*	@Test
	public void testUpdate() {
		
	}*/
	
	@Test
	public void testDelete() {
		Long gno = 125L ;
		mapper.deleteGroup(gno) ; 
		mapper.delete(gno);
	}
}
