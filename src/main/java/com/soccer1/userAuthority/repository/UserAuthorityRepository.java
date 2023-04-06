package com.soccer1.userAuthority.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccer1.userAuthority.entity.UserAuthority;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

//	@Query("select u from UserAuthority u join fetch u.authority r where u.userId = :userId")
//	List<UserAuthority> findAllByUserId(Long userId);

}
