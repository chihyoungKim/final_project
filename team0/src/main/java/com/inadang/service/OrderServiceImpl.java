package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inadang.domain.Order;
import com.inadang.mapper.OrderMapper;
import com.inadang.mapper.OrderMenuMapper;

import lombok.AllArgsConstructor;

/**
 * @author 이나현
 * 
 */
@Service @AllArgsConstructor 
public class OrderServiceImpl implements OrderService{
	private OrderMapper orderMapper;
	private OrderMenuMapper orderMenuMapper; 
	
	public List<Order> getList() {
		return orderMapper.getList();
	}

	@Override
	public List<Order> showList(Long sno) {
		return orderMapper.showList(sno);
	}
	
	
	@Override
	public Order get(String ono) {
		return orderMapper.get(ono);
	}

	@Override
	@Transactional
	public void insert(Order order) {
		orderMapper.insert(order);
		order.getOrderMenus().forEach(om->{
			om.setOno(order.getOno());
			om.setId(order.getId());
			orderMenuMapper.insert(om);
		});
		orderMapper.updateAmount(order.getOno());
	}

	@Override
	public boolean updateAmount(String ono) {
		return orderMapper.updateAmount(ono) > 0;
	}

	@Override
	public boolean delete(String ono) {
		return orderMapper.delete(ono) > 0 ;
	}

	@Override //상태만 취소로 변경
	public boolean cancel(String status) {
		return orderMapper.cancel(status) > 0;
	}

	@Override
	public boolean paid(String status) {
		return orderMapper.paid(status) > 0;
	}

}
