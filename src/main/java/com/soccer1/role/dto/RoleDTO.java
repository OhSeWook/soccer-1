package com.soccer1.role.dto;

import org.springframework.security.core.GrantedAuthority;

public class RoleDTO implements GrantedAuthority {

	private static final long serialVersionUID = -4281180437923186286L;

	@Override
	public String getAuthority() {
		return null;
	}
	
}
