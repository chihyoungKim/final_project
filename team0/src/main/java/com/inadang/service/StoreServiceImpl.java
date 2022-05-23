package com.inadang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.Store;
import com.inadang.domain.StoreAttach;
import com.inadang.mapper.MemberMapper;
import com.inadang.mapper.MenuMapper;
import com.inadang.mapper.StoreAttachMapper;
import com.inadang.mapper.StoreMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Service @AllArgsConstructor @Log4j
public class StoreServiceImpl implements StoreService{
	@Autowired @Setter
	private StoreMapper storeMapper;
	@Autowired @Setter
	private StoreAttachMapper storeAttachMapper;
	@Autowired @Setter
	private MemberMapper memberMapper;
	@Autowired @Setter
	private MenuMapper menuMapper;
	
	@Override
	public List<Store> list(Long category, CriteriaScroll cri, String condition) {
		return storeMapper.selectAllByCategory(category, cri, condition);
	}
	
	@Override
	public List<Store> list(Long category, CriteriaScroll cri) {
		return storeMapper.selectAllByCategory(category, cri, "");
	}
	
	@Override
	public List<Store> listBySearch(Long category, CriteriaScroll cri, String search) {
		return storeMapper.selectAllBySearch(category, cri, search);
	}
	
	@Override
	public boolean likes(String id, Long sno) {
		return storeMapper.findLike(id, sno);
	}
	
	@Override
	public List<Long> listLike(String id) {
		return storeMapper.selectLike(id);
	}
	
	@Override
	public void changeLike(String id, Long sno) {
		if(storeMapper.findLike(id, sno)) {
			storeMapper.deleteLike(id, sno);
		}
		else {
			storeMapper.insertLike(id, sno);
		}
	}
	
	@Override
	public StoreAttach getLogo(Long sno) {
		return storeMapper.selectLogo(sno);
	}
	
	@Override
	public Store get(Long sno) {
//		storeAttachMapper.findBy(sno);
		return storeMapper.read(sno);
	}
	
	@Transactional
	public int register(Store store) {
		log.info("register("+ store +")");

		int result = storeMapper.insertSelectKey(store);
		
//		store.getAttachs().forEach((attach) -> {
//			attach.setSno(store.getSno());
//			storeAttachMapper.insert(attach);
//		} );
		
		// boardVO.bno == null
		return result;
	}

	@Override
	public Store getStoreById(String id) {
		Store result = storeMapper.read(memberMapper.getSno(id));
		return result;
	}

	@Override
	public int increaseReviewNum(Long sno) {
		return storeMapper.increaseReviewNum(sno);
	}

	@Override
	public List<Store> listAd(Long category) {
		return storeMapper.selectAd(category);
	}

	@Override
	public void modify(Store store, String id) {
		storeMapper.update(store, id);
	}

	@Override
	public void deleteAttach(String uuid) {
		storeAttachMapper.delete(uuid);
	}

	@Override
	@Transactional
	public void removeStore(Long sno) {
		menuMapper.deleteAll(sno);
		memberMapper.setSnoToNull(sno);
		storeMapper.removeStore(sno);
	}

}
