package com.inadang.mapper;

import java.util.List;

import com.inadang.domain.Order;

/**
 * @author 이나현
 * 
 */
public interface OrderMapper {
	//주문리스트
	public List<Order> getList();
	
	//해당 메뉴의 주문리스트
	public List<Order> showList(Long ono);
	
	//주문하나
	public Order get(String ono);
	
	//주문넣기
	public int insert(Order order);
	
	//주문삭제
	public int delete (String ono);
	
	//주문총금액업데이트(오더메뉴트랜잭션)
	public int updateAmount(String ono);

	//주문취소시 상태변경
	public int cancel (String status);
	
	//주문완료시 상태변경
	public int paid (String status);

}
