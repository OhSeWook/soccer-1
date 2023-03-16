package com.soccer1.member.vo;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.soccer1.role.dto.RoleDTO;

import lombok.Data;

@Data
public class MemberVO implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String userId;
	private String name;
	private String password;
	private LocalDateTime regDate;
	private LocalDateTime updDate;
	
	private Set<RoleDTO> userRoles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public String getUsername() {
		return this.name;
	}

}
