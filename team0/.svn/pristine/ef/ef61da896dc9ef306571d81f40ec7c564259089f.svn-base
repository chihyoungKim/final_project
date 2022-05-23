package com.inadang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inadang.domain.Cart;

public interface CartMapper {
	void insertCart(@Param("mno") Long mno, @Param("count") int count, @Param("id") String id); // 장바구니에 등록
	
	; // 장바구니 정보 조회
	
	int delete(@Param("cno") Long cno, @Param("id") String id); // 장바구니 안에 메뉴 삭제
	
	boolean drop(String id); // 사용자의 장바구니 전체 삭제
	
	int checkCart(@Param("mno")Long mno, @Param("id")String id);

	List<Cart> selectAllById(String id);
	
	Cart read(Long cno);
	
	Cart getLastCno(String id);

	int plusCart(Long cno);

	int minusCart(Long cno);
}
