package com.inadang.mapper;

import org.apache.ibatis.annotations.Param;

import com.inadang.domain.AuthVO;
import com.inadang.domain.MemberVO;

public interface MemberMapper {

	int insertMember(MemberVO vo); // 사용자 회원가입

	int insertManager(MemberVO vo); // 사장님 회원가입

	int insertAuth(AuthVO vo); // 권한
	
	MemberVO get(String id); // 

	
	long getSno(String id);
	
	int updateMember(MemberVO vo); // 사용자 수정

	int updateManager(MemberVO vo); // 사장님 수정
	
	int updateMemberAuth(AuthVO vo); // 권한 수정

	int updateSno(@Param("id") String id,@Param("sno") Long sno);

	
	int updateEmailAuth(MemberVO memberVO); // 이메일 권한
	
	int updateEmailAuthToken(MemberVO memberVO); // 이메일 토큰
	
	
	int deleteMember(String id);  // 멤버 삭제
	
	int deleteAuth(String id); // 권한 삭제

	void setSnoToNull(Long sno); // sno를 null로 초기화
	
}
