package com.inadang.domain;

import java.util.ArrayList;
import java.util.List;

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
@Alias("review")
public class Review {
	private Long rno;
	private String id;
	private Long sno;
	private String content;
	private Double scope;
	private String regDate;
	
	private Long groupId;
	
	private String ono;
	
	private List<ReviewAttach> attachs = new ArrayList<>();
}
