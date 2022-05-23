package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.Menu;
import com.inadang.domain.MenuAttach;
import com.inadang.mapper.MenuMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service @AllArgsConstructor @Log4j
public class MenuServiceImpl implements MenuService{

	private MenuMapper mapper;
	
	@Override
	public int register(Menu menu) {
		int result = mapper.insert(menu);
		if(menu.getAttach().getUuid() != null) {
			MenuAttach attach = menu.getAttach();
			attach.setMno(menu.getMno());
			mapper.insertAttach(attach);
		}
		return result;
	}

	@Override
	public boolean remove(Long mno) {
		return mapper.delete(mno);
	}

	@Override
	public int addAttach(MenuAttach attach) {
		return mapper.insertAttach(attach);
	}

	@Override
	public boolean removeAttach(Long mno) {
		return mapper.deleteAttach(mno);
	}

	@Override
	public boolean modify(Menu menu) {
		return mapper.update(menu);
	}

	@Override
	public List<Menu> list(Long sno, CriteriaScroll cri) {
		return mapper.selectAll(sno, cri);
	}

	@Override
	public boolean changeState(Long mno) {
		return mapper.updateState(mno);
	}

	@Override
	public boolean removeAll(Long sno) {
		return mapper.deleteAll(sno);
	}

	@Override
	public Menu get(Long mno) {
		return mapper.select(mno);
	}

	@Override
	public MenuAttach getAttach(Long mno) {
		return mapper.selectAttach(mno);
	}

	@Override
	public boolean removeAttachByUuid(String uuid) {
		return mapper.deleteAttachByUuid(uuid);
	}
	
	
}
