package com.soccer1.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soccer1.member.vo.MemberVO;

@Mapper
public interface MemberRepository {

	public List<MemberVO> findAllMember();
	
	public MemberVO getUserDetails(String userId);

}
