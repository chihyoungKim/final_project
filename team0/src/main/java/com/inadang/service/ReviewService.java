package com.inadang.service;

import java.util.List;

import com.inadang.domain.CriteriaReview;
import com.inadang.domain.Review;
import com.inadang.domain.ReviewAttach;

public interface ReviewService {
	
	List<Review> list(Long sno, CriteriaReview cri); // 해당 가게의 리뷰 전부 조회(no paging)    
	
	List<Review> list(String id); // 본인이 작성한 리뷰, 답글만 조회	
	
	Review get(Long rno); // 해당 리뷰 or 답글 정보 조회
	
	int register(Review review); // 리뷰등록
	
	boolean remove(Long rno); // 리뷰, 답글 삭제
	
	int addAttach(ReviewAttach attach); // 리뷰 작성시 첨부파일 추가
	
	boolean removeAttach(Long rno); // 리뷰 삭제시 첨부파일 삭제
	
	List<ReviewAttach> getAttach(Long rno); // 해당 리뷰 첨부파일 조회
	
	int replyRegister(Review review); // 답글 등록(그룹아이디로 사용할 rno가져와야한다.)       test필요
	
	boolean replyModify(Review review); // 답글 수정       test필요
	
	
	
	
	
	boolean removeAll(Long sno); // 가게 삭제시 해당가게 리뷰 전체삭제
	
	boolean existReview(String ono); // 해당 주문의 리뷰가 존재하는지 확인
	
	
}
