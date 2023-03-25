package com.soccer1.userAuthority.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soccer1.userAuthority.entity.UserAuthority;
import com.soccer1.userAuthority.entity.UserAuthorityId;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, UserAuthorityId> {

	@Query("select u from UserAuthority u join fetch u.authority r where u.userId = :userId")
	List<UserAuthority> findAllByUserId(Long userId);

}
