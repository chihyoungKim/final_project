package com.inadang.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * @author 이나현
 * 주문결제내역
 */
@Data 
public class Payment {
	
	private Long pno; //결제시퀀스
	
	@SerializedName("merchant_uid")
	private String ono; //주문번호

	@SerializedName("customer_uid")
	private String id ; //결제자아이디

    private int amount; //결제금액

    private String name; //가게명
    
    @SerializedName("buyer_email")
    private String email; //영수메일
    
    private String impUid; //가게번호

    @SerializedName("pay_method")
    private String payMethod; //결제방식
    
    @JsonProperty("apply_num")
    private int applyNum;//승인번호
    
    @SerializedName("card_quota")
    private int quota; //할부
    
    private String status; //결제상태

    private String timeStamp; //결제일자
    
    private String cancleDate; //취소일자
    
    @SerializedName("buyer_tel")
    private String phoneNumber;
    
    @SerializedName("buyer_postcode")
    private int postCode;
    
    @SerializedName(" buyer_addr")
    private String address;
    
    private String detailAddress;
    
    private String requests;
    
    private List<OrderMenu> orderMenus; // 주문내역 > 리뷰작성에 사용
    
    private Order ord; // 주문내역 > 리뷰작성에 사용
    
    private boolean existReview = false; // 주문내역 하나당 결제 하나만 이뤄지게끔 하기 위함
    
}
