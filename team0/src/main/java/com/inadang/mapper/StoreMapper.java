package com.inadang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.Store;
import com.inadang.domain.StoreAttach;

public interface StoreMapper {
	List<Store> selectAll(); // 가게 목록 조회
	
	List<Store> selectAd(Long category); // 광고가게조회
	
	List<Store> selectAllByCategory(@Param("category") Long category, @Param("cri") CriteriaScroll cri, @Param("condition") String condition); // 카테고리기준
	
	List<Store> selectAllBySearch(@Param("category") Long category, @Param("cri") CriteriaScroll cri, @Param("search") String search);
	
	boolean findLike(@Param("id") String id, @Param("sno") Long sno);
	
	int deleteLike(@Param("id") String id, @Param("sno") Long sno);
	
	int insertLike(@Param("id") String id, @Param("sno") Long sno);
	
	List<Long> selectLike(String id);
	
	StoreAttach selectLogo(Long sno);
	
	Store select(Long sno); // 특정 가게 상세조회
	
	int increaseReviewNum(Long sno);
	
	int updateScope(@Param("sno") Long sno, @Param("scope") double scope);
	
	
	
	int register(Store store); // 가게 등록
	
	public int insertSelectKey(Store store);
	
	Store read(Long sno);

	void update(@Param("store")Store store, @Param("id")String id);

	void removeStore(Long sno);
	
}
