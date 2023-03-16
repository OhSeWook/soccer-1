package com.soccer1.role.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long roleId;
	private Long resourcesId;
	private String roleCode;
	private String roleName;

}