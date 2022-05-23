package com.inadang.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * @author 김치형
 *
 */
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
@Alias("storeAttach")
public class StoreAttach extends AttachFileDTO{
	private Long sno;

	public StoreAttach(Long ano, String uuid, String origin, String path, String regDate, Long sno) {
		super(ano, uuid, origin, path, regDate);
		this.sno = sno;
	}
	
	public StoreAttach(MenuAttach attach, Long sno) {
		this(attach.getAno(), attach.getUuid(), attach.getOrigin(), attach.getPath(), attach.getRegDate(), sno);
	}
	
}