package com.soccer1.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.soccer1.component.CustomPasswordEncoding;
import com.soccer1.member.entity.User;
import com.soccer1.userRole.entity.UserRole;
import com.soccer1.userRole.repository.UserRoleRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService userDetailsService; //CustomUserDetails Class Autowired.
	
	@Autowired
	private UserRoleRepository userRoleRepository; //CustomUserDetails Class Autowired.
	
	@Autowired
	private CustomPasswordEncoding passwordEncoder; //BCryptPasswordEncoder Class Autowired.
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userId = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		User customUserDetails = (User) userDetailsService.loadUserByUsername(userId);
	
		if(!passwordEncoder.sha256Matching(password, customUserDetails.getPassword())) {
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		}
				
		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		List<UserRole> list = userRoleRepository.findAllByUserId(customUserDetails.getId());
		
		for(UserRole u:list) {
			authorities.add(new SimpleGrantedAuthority(u.getRole().getRoleCode()));
		}
		
		return new UsernamePasswordAuthenticationToken(customUserDetails,password,authorities);

	}

	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}