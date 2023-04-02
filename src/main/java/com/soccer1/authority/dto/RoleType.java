package com.soccer1.authority.dto;

import lombok.Getter;

@Getter
public enum RoleType {

	ROLE_ADMIN(1, "ROLE_ADMIN", "관리자")
	, ROLE_USER(2, "ROLE_USER", "관리자")
	, ROLE_MASTER(3, "ROLE_MASTER", "관리자")
	, ROLE_SUB_ADMIN(4, "ROLE_SUB_ADMIN", "관리자");
	
	private int code;
	private String type;
	private String desc;
	
	
	RoleType(int code, String type, String desc){
		this.code = code;
		this.type = type;
		this.desc = desc;
	}
	
}
