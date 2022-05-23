package com.inadang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.inadang.domain.StoreAttach;

public interface StoreAttachMapper {
	@Insert("INSERT INTO TBL_STORE_ATTACH VALUES( #{sno}, #{ano}, #{uuid}, #{origin}, #{path}, SYSDATE)")
	void insert(StoreAttach storeAttach);
	
	@Delete("DELETE TBL_STORE_ATTACH WHERE UUID = #{uuid}")
	void delete(String uuid);
	
	@Delete("DELETE TBL_STORE_ATTACH WHERE sno = #{sno}")
	void deleteALL(Long sno);
	
	@Select("SELECT * FROM TBL_STOREATTACH WHERE SNO = #{sno}")
	List<StoreAttach> findBy(Long sno);
	
}
