package com.inadang.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ex02에서 가져옴 

@Data @NoArgsConstructor @AllArgsConstructor
public class Criteria {
	private int pageNum = 1;
	private int pageAmount = 10;
	private String type;
//	private String[] typeArr; //TCW
	private String keyword;
	
	//상세조회들어가기
	public String getParams(){
		return UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", pageNum)
				.queryParam("amount", pageAmount)
				.queryParam("type", type)
				.queryParam("keyword", keyword)
				.toUriString();
	}
	public String getParamsWithoutPageNum(){
		return UriComponentsBuilder.fromPath("")
				.queryParam("amount", pageAmount)
				.toUriString();
	}
	
	public String[] getTypeArr(){
		return type == null ? new String[]{} : type.split("");
	}
	//public String getType(){
//		return typeArr == null ? null : String.join("", typeArr);
	//}
}
