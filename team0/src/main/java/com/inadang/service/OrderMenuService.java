package com.inadang.service;

import java.util.List;

import com.inadang.domain.OrderMenu;

public interface OrderMenuService {
	public List<OrderMenu> getList();
	
	List<OrderMenu> findBy(String ono);
	
	public void delete(Long mno, String ono);
	
	public List<OrderMenu> deleteAll(String ono);

	void insert(OrderMenu om, String ono);
	
}
