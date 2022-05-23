package com.inadang.domain;

import lombok.Getter;
import lombok.ToString;

//ex02에서 가져옴

@Getter //셋터필요없고 생성자로 다 할거
@ToString
//하단페이징 넘버링 버튼 담당
public class PageDTO {
	private static final int PAGE_COUNT = 10; //한페이지에 몇 개 보여주는지
	
	private int start; //하단에 보여질 페이지의 시작점 ex 시작숫자 1, 13
 	private int end; //하단에 보여질 페이지의 끝점 ex 끝숫자 페이지 마지막 24
	private int total; //게시글총갯수
	private boolean next; //다음페이지
	private boolean prev; //이전페이지
	private Criteria cri; //pageNum, amount
	
	// total, page, amount
	public PageDTO(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
		end = (cri.getPageNum() + (PAGE_COUNT - 1)) / PAGE_COUNT * PAGE_COUNT;
		start = end - PAGE_COUNT + 1;
		
		int realEnd = (total + (cri.getPageAmount()-1)) / cri.getPageAmount();
		if (realEnd < end) {
			end = realEnd;
		}

		prev = start > 1;
		next = end < realEnd;
				
	}
}
