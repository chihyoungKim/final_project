package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inadang.domain.OrderMenu;
import com.inadang.mapper.OrderMapper;
import com.inadang.mapper.OrderMenuMapper;

import lombok.AllArgsConstructor;
@Service @AllArgsConstructor
public class OrderMenuServiceImpl implements OrderMenuService{
	private OrderMenuMapper mapper;
	private OrderMapper orderMapper;
	
	@Override
	public List<OrderMenu> getList() {
		return mapper.getList();
	}
	
	@Override
	public void insert(OrderMenu om, String ono) {
		mapper.insert(om);
	}

	@Override
	public List<OrderMenu> findBy(String ono) {
		return mapper.findBy(ono);
	}

	@Override
	public void delete(Long mno, String ono) {
		mapper.delete(mno);
		orderMapper.updateAmount(ono);
	}

	@Override
	public List<OrderMenu> deleteAll(String ono) {
		return mapper.deleteAll(ono);
	}

}
