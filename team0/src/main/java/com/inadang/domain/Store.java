package com.inadang.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author 김치형
 *
 */
@Data @AllArgsConstructor @NoArgsConstructor
@Alias("store")
public class Store {
	private Long category;
	private String address;
	private String tel;
	private String startTime;
	private String endTime;
	private String originInfo;
	private Long minPrice;
	private String delTime;
	private Double scope;
	private Long reviewNum;
	private Long likes;
	private String bno;
	private Long sno;
	private String notice;
	private String delPrice;
	private String name;
	
	private String ad;
	private String replyNum;
	
	private Long rn; // 다양한 조건에 의한 페이징을 위한 필드
	
	StoreAttach attach = new StoreAttach();
}
