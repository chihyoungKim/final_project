package com.inadang.domain;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("member")
public class MemberVO {

	private String id; // pk
	private String password;
	private String name;
	private String tel;
	private String email;
	private String nickName;
	private Date regDate;
	private String bossName;
	private String sno;
	private String bno; 
	private boolean enabled;
	
	
	private int emailAuth;
	private String authToken;
	
	
	
	private List<AuthVO> auths;
	
	private List<Address> addrs; // 배달받을 주소들
}
