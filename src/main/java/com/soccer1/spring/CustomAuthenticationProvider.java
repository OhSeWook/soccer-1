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
import com.soccer1.user.entity.User;
import com.soccer1.userAuthority.entity.UserAuthority;
import com.soccer1.userAuthority.repository.UserAuthorityRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService userDetailsService; //CustomUserDetails Class Autowired.
	
	@Autowired
	private UserAuthorityRepository userRoleRepository; //CustomUserDetails Class Autowired.
	
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
		
		List<UserAuthority> list = userRoleRepository.findAllByUserId(customUserDetails.getId());
		
		for(UserAuthority u:list) {
			authorities.add(new SimpleGrantedAuthority(u.getAuthority().getAuthorityCode()));
		}
		
		return new UsernamePasswordAuthenticationToken(customUserDetails,password,authorities);

	}

	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}