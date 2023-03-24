package com.soccer1.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccer1.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByLoginId(String userId);

}
