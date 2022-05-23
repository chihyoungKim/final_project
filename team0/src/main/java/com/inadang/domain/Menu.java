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
@Alias("menu")
public class Menu {
	private Long sno;
	private Long mno;
	private String name;
	private Long price;
	private String info;
	private boolean state = true; // 메뉴 품절 or 판매 상태 조절, 기본값 판매
	
	private MenuAttach attach = new MenuAttach();
}
