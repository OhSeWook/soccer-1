package com.soccer1.user.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.soccer1.user.dto.UserRequestDto;
import com.soccer1.user.entity.User;
import com.soccer1.user.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	
    @Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
    	User memberVO = userRepository.findByLoginId(userId);
    	
		if(memberVO == null) {
			throw new UsernameNotFoundException("유효하지 않는 로그인 정보입니다.");
		}
		
		return memberVO;
	}
    
    @Transactional
  	public Optional<User> userFindById(Long id) throws Exception {
    	return userRepository.findById(id);
  	}
    
    @Transactional
  	public User userSave(UserRequestDto userRequestDto) throws Exception {
    	return userRepository.save(userRequestDto.toEntity());
  	}
}