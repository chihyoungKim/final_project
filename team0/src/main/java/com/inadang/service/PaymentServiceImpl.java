package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inadang.domain.Payment;
import com.inadang.mapper.CartMapper;
import com.inadang.mapper.OrderMapper;
import com.inadang.mapper.PaymentMapper;

import lombok.AllArgsConstructor;

/**
 * @author 이나현
 * 
 */
@Service @AllArgsConstructor 
public class PaymentServiceImpl implements PaymentService{
	
	private PaymentMapper mapper;
	private CartMapper cartMapper;
	private OrderMapper orderMapper;
	
	@Override
	@Transactional
	public void insert(Payment payments) {
		mapper.insert(payments);
		cartMapper.drop(payments.getId());
		orderMapper.paid(payments.getOno());
	}

	@Override
	public List<Payment> getList() {
		return mapper.getList();
	}


	@Override
	public Payment findSpecific(String ono, String id) {
		return mapper.findSpecific(ono, id);
	}

	@Override
	public Payment select(String ono) {
		return mapper.select(ono);
	}
	
	

	@Override
	public List<Payment> get(String id) {
		return mapper.get(id);
	}

	@Override
	public int updateState(String status, String id) {
		return mapper.updateState(status);
	}
	
	@Override
	public int remove(String ono) {
		return mapper.remove(ono);
	}
}
