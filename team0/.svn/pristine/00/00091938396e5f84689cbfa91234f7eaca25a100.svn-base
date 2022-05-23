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
@Alias("reviewAttach")
public class ReviewAttach extends AttachFileDTO{
	private Long rno;

	public ReviewAttach(Long ano, String uuid, String origin, String path, String regDate, Long rno) {
		super(ano, uuid, origin, path, regDate);
		this.rno = rno;
	}
	
	public ReviewAttach(MenuAttach attach, Long rno) {
		this(attach.getAno(), attach.getUuid(), attach.getOrigin(), attach.getPath(), attach.getRegDate(), rno);
	}
	
}
