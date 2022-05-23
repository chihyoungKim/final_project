package com.inadang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.Menu;
import com.inadang.domain.MenuAttach;

public interface MenuMapper {
	int insert(Menu menu); // 메뉴 등록
	
	boolean delete(Long mno); // 메뉴 삭제
	
	int insertAttach(MenuAttach attach); // 메뉴 등록시 메뉴사진 등록
	
	MenuAttach selectAttach(Long mno); // 해당 메뉴의 첨부파일 확인
	
	boolean deleteAttach(Long mno); // 메뉴 삭제 혹은 수정시 메뉴사진 삭제
	
	boolean deleteAttachByUuid(String uuid);
	
	boolean update(Menu menu); // 메뉴 수정
	
	List<Menu> selectAll(@Param("sno") Long sno, @Param("cri") CriteriaScroll cri); // 해당 가게의 메뉴 전부 조회
	
	Menu select(Long mno); // 해당 메뉴 상세조회
	
	boolean updateState(Long mno); // 해당 메뉴 상태 변경
	
	
	boolean deleteAll(Long sno); // 가게 삭제시 메뉴 전체삭제
	
}
