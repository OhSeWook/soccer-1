package com.soccer1.userRole.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	
	private Long role;

}
