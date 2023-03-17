package com.soccer1.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccer1.member.entity.User;

@Repository
public interface MemberRepository extends JpaRepository<User, Long> {

	public User findByUserId(String userId);

}
