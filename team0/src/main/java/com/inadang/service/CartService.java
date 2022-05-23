package com.inadang.service;

import java.util.List;

import com.inadang.domain.Cart;

public interface CartService {
	
	void addCart(Long mno, int count, String id); // 카트에 추가
	
	Cart get(Long cno); // cno 로 카트 가져오기
	
	int deleteCart(Long cno, String id); // 카트에 하나 삭제
	
	void dropCart(String id); // 아이디로 카트 전체 삭제
	
	List<Cart> list(String id); // 카트 리스트 들고 오기
	
	Cart getLastCno(String id); // 마지막 번호 Cno 가져오기
	
	int checkCart(String id, Long mno); // 추가하려는 메뉴가 이미 장바구니에 있는지 확인

	int plusCart(Long cno); // 장바구니에 있는 메뉴 수량 추가

	int minusCart(Long cno); // 장바구니에 있는 메뉴 수량 삭제
}
