package com.soccer1.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.soccer1.member.dao.MemberRepository;
import com.soccer1.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements UserDetailsService {

	@Autowired
    private MemberRepository memberRepository;
	
    @Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
    	MemberVO memberVO = memberRepository.getUserDetails(userId);
    	
		if(memberVO == null) {
			throw new UsernameNotFoundException("유효하지 않는 로그인 정보입니다.");
		}
		
		return memberVO;
	}

}