package com.inadang.service;

import java.util.List;

import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.Menu;
import com.inadang.domain.MenuAttach;

public interface MenuService {
	int register(Menu menu); // 메뉴 등록
	
	boolean remove(Long mno); // 메뉴 삭제
	
	int addAttach(MenuAttach attach); // 메뉴 등록시 메뉴사진 등록
	
	MenuAttach getAttach(Long mno); // 해당 메뉴의 첨부파일 확인
	
	boolean removeAttach(Long mno); // 메뉴 삭제 혹은 수정시 메뉴사진 삭제

	boolean removeAttachByUuid(String uuid);
	
	boolean modify(Menu menu); // 메뉴 수정
	
	List<Menu> list(Long sno,CriteriaScroll cri); // 해당 가게의 메뉴 전부 조회
	
	Menu get(Long mno); // 특정 메뉴 상세조회
	
	boolean changeState(Long mno); // 해당 메뉴 상태 변경
	
	
	boolean removeAll(Long sno); // 가게 삭제시 메뉴 전체삭제
	
}
