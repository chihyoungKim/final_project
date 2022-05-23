package com.inadang.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inadang.domain.Payment;

/**
 * @author 이나현
 * 
 */
public interface PaymentService {
	// 결제(주문내역)추가
	void insert(Payment payments);
	
	//특정 아이디의 특정주문내역찾기
	Payment findSpecific(@Param("ono") String ono,@Param("id") String id);
	
	//아이디의 주문내역찾기
	List<Payment> get (String id);
	
	//주문번호찾기
	Payment select(String ono);
	
	//전체주문내역찾기
	List<Payment> getList();
	
	//주문내역삭제
	int remove(String ono);
	
	//주문상태업데이트 (ready, paid, canceled, hide)
	public int updateState(@Param("status") String status,@Param("id") String id);
	
}
