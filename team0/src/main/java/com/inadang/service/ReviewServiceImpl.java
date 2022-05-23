package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inadang.domain.CriteriaReview;
import com.inadang.domain.Review;
import com.inadang.domain.ReviewAttach;
import com.inadang.mapper.ReviewMapper;
import com.inadang.mapper.StoreMapper;

import lombok.AllArgsConstructor;
@Service @AllArgsConstructor
public class ReviewServiceImpl implements ReviewService{

	private ReviewMapper mapper;
	
	private StoreMapper storeMapper;
	
	@Override
	public List<Review> list(Long sno, CriteriaReview cri) {
		return mapper.selectAll(sno, cri);
	}
	
	@Override
	public List<Review> list(String id) {
		return mapper.selectMine(id);
	}

	@Override
	public Review get(Long rno) {
		return mapper.select(rno);
	}

	@Override
	@Transactional
	public int register(Review review) {
		int result = mapper.insert(review);
		for(ReviewAttach r : review.getAttachs()) {
			r.setRno(review.getRno());
			System.out.println(r);
			mapper.insertAttach(r);
		}
		storeMapper.increaseReviewNum(review.getSno());
		storeMapper.updateScope(review.getSno(), review.getScope());
		return result;
	}

	@Override
	@Transactional
	public boolean remove(Long rno) {
		mapper.deleteAttach(rno);
		return mapper.delete(rno);
	}

	@Override
	public int addAttach(ReviewAttach attach) {
		return mapper.insertAttach(attach);
	}

	@Override
	public boolean removeAttach(Long rno) {
		return mapper.deleteAttach(rno);
	}

	@Override
	@Transactional
	public boolean removeAll(Long sno) {
		CriteriaReview cri = new CriteriaReview();
		cri.setAmount(Integer.MAX_VALUE);
		cri.setLastRno(0L);
		for(Review r : mapper.selectAll(sno, cri)) {
			mapper.deleteAttach(r.getRno());
		}
		mapper.deleteAll(sno);
		return mapper.deleteAll(sno);
	}

	@Override
	public int replyRegister(Review review) {
		return mapper.insertReply(review);
	}

	@Override
	public boolean replyModify(Review review) {
		return mapper.updateReply(review);
	}

	@Override
	public List<ReviewAttach> getAttach(Long rno) {
		return mapper.selectAttach(rno);
	}

	@Override
	public boolean existReview(String ono) {
		return mapper.existReview(ono);
	}
	
}
