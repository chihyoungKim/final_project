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
@Alias("menuAttach")
public class MenuAttach extends AttachFileDTO{
	private Long mno;

	public MenuAttach(Long ano, String uuid, String origin, String path, String regDate, Long mno) {
		super(ano, uuid, origin, path, regDate);
		this.mno = mno;
	}
	
	public MenuAttach(MenuAttach attach, Long mno) {
		this(attach.getAno(), attach.getUuid(), attach.getOrigin(), attach.getPath(), attach.getRegDate(), mno);
	}
	
}
