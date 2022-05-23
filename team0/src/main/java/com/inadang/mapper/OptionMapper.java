package com.inadang.mapper;

import com.inadang.domain.OptGroup;
import com.inadang.domain.Option;


public interface OptionMapper {
/*	public List<OptGroup> getList();
	
	public int insertOPT(OptGroup name);
	
	public boolean deleteOPT(String name);

	boolean updateOPT(OptGroup name);
*/
	
	int insert(Option option); // 옵션 등록
	int insertGroup(OptGroup optGroup); // 옵션그룹 등록
	
	int delete(Long gno) ;
	int deleteGroup(Long gno); 




	

	
}
