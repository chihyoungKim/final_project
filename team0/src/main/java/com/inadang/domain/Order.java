package com.inadang.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author 이나현
 * 주문번호 확인하고 아이디랑 일치여부 확인
 */
@Data
public class Order {
	private String ono; //주문번호 PK
	private String id; //회원아이디 FK
	private boolean pickup; //포장/배달
	private String orderDate; //주문날짜
	private String name; //가게 FK
	private int amount;//총가격
	private String status; //주문상태
	private Long sno;//가게번호 FK
	
	private List<OrderMenu> orderMenus = new ArrayList<OrderMenu>();
}
