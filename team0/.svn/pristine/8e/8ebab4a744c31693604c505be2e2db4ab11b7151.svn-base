package com.inadang.service;

import java.io.UnsupportedEncodingException;

import com.inadang.domain.MemberVO;

public interface MemberService {

	void joinMember(MemberVO vo);

	void joinManager(MemberVO vo);
	
	MemberVO get(String id);
	
	boolean updateMember(MemberVO memberVO);
	long getSno(String id);
	
	
	boolean updateManager(MemberVO memberVO);
	
	int delete(String id);
	
	
	void updateSno(String id, Long sno);
	
	void emailAuth(String id, String email) throws UnsupportedEncodingException, IllegalArgumentException;
	
	int emailAuthToken(String id, String authToken);
	
}
