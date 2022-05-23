package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inadang.domain.Cart;
import com.inadang.mapper.CartMapper;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class CartServiceImpl implements CartService{
	
	private CartMapper mapper;
	
	@Override
	public void addCart(Long mno, int count, String id) {
		mapper.insertCart(mno, count, id);
	}

	@Override
	public Cart getLastCno(String id) {
		return mapper.getLastCno(id);
	}
	
	@Override
	public int deleteCart(Long cno, String id) {
		return mapper.delete(cno, id);
	}

	@Override
	public void dropCart(String id) {
		mapper.drop(id);
	}

	@Override
	public List<Cart> list(String id) {
		// TODO Auto-generated method stub
		return mapper.selectAllById(id);
	}

	@Override
	public Cart get(Long cno) {
		return mapper.read(cno);
	}

	@Override
	public int checkCart(String id, Long mno) {
		return mapper.checkCart(mno, id);
	}

	@Override
	public int plusCart(Long cno) {
		return mapper.plusCart(cno);
	}

	@Override
	public int minusCart(Long cno) {
		return mapper.minusCart(cno);
	}


	

}
