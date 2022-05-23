package com.inadang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inadang.domain.CriteriaReview;
import com.inadang.domain.Review;
import com.inadang.domain.ReviewAttach;

public interface ReviewMapper {
	
	List<Review> selectAll(@Param("sno") Long sno, @Param("cri") CriteriaReview cri); // 해당 가게의 리뷰 전부 조회(paging)1
	
	List<Review> selectMine(String id); // 본인이 작성한 리뷰만 조회1	
	
	Review select(Long rno); // 해당 리뷰 정보 조회1
	
	int insert(Review review); // 리뷰등록1
	
	boolean delete(Long rno); // 리뷰 삭제1
	
	int insertAttach(ReviewAttach attach); // 리뷰 작성시 첨부파일 추가1
	
	boolean deleteAttach(Long rno); // 리뷰 삭제시 첨부파일 삭제1
	
	List<ReviewAttach> selectAttach(Long rno); // 해당 리뷰 첨부파일 조회
	
	
	int insertReply(Review review); // 답글 등록
	
	boolean updateReply(Review review); // 답글 수정
	
	
	boolean deleteAll(Long sno); // 가게 삭제시 해당가게 리뷰 전체삭제1
	
	boolean existReview(String ono); // 해당 주문의 리뷰가 존재하는지 확인
}
