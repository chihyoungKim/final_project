package com.inadang.service;

import java.util.List;

import com.inadang.domain.Order;

/**
 * @author 이나현
 * 
 */
public interface OrderService {
	//주문리스트
	public List<Order> getList();
	
	//매장에서 주문한 내역
	public List<Order> showList(Long sno);
	
	//주문하나
	public Order get(String ono);
	
	//주문넣기
	public void insert(Order order);
	
	//주문삭제
	public boolean delete (String ono);
	
	//주문총금액업데이트(오더메뉴트랜잭션)
	public boolean updateAmount(String ono);

	//주문취소시 상태변경
	public boolean cancel (String status);
	
	//주문완료시 상태변경
	public boolean paid (String status);

}
