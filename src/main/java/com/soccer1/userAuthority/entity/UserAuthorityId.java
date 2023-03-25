package com.soccer1.userAuthority.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthorityId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	
	private Long authority;

}
