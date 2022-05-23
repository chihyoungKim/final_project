package com.inadang.service;

import java.util.List;

import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.MemberVO;
import com.inadang.domain.Store;
import com.inadang.domain.StoreAttach;

public interface StoreService {
	List<Store> list(Long category, CriteriaScroll cri, String condition); // 가게 목록 조회
	
	List<Store> list(Long category, CriteriaScroll cri);
	
	List<Store> listBySearch(Long category, CriteriaScroll cri, String search);
	
	List<Store> listAd(Long category);
	
	boolean likes(String id, Long sno);
	
	List<Long> listLike(String id);
	
	void changeLike(String id, Long sno);
	
	StoreAttach getLogo(Long sno);
	
	Store get(Long sno); // 특정 가게 상세조회
	
	int register(Store store); // 가게 등록
	
	Store getStoreById(String id); // 현재 접속중인 사람의 가게 가져오기
	
	void modify(Store store, String id); // 현재 접속중인 사람의 가게 수정하기
	
	int increaseReviewNum(Long sno);
	
	void deleteAttach(String uuid);

	void removeStore(Long sno);

}
