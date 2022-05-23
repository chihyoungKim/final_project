package com.inadang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inadang.domain.Criteria;
import com.inadang.domain.Payment;

/**
 * @author 이나현
 * 
 */
public interface PaymentMapper {
	public List<Payment> getList();
	public Payment select(String ono);
	
	//아이디, 주문번호로 개인결제내역찾기
	public List<Payment> get(String id);
	
	//아이디 로 특정 결제(주문)내역찾기
	public Payment findSpecific(@Param("ono") String ono, @Param("id") String id);
	
	public int insert(Payment payments);
	
	//주문내역삭제
	public int remove(String pno);
	
	//주문내역 회원이 삭제하면 안보이게 처리 (update)
	//실제 삭제되지 않음 (가게또는 회원 둘 중 하나는 유지해야하는 정보이기 때문)
	public int updateState(String status);
	
	//마이페이지 주문내역확인 페이징
	public int getTotalCount(Criteria cri);
	public List<Payment> getListWithPaging(Criteria criteria);
	

}
