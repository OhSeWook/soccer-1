package com.soccer1.userRole.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soccer1.userRole.entity.UserRole;
import com.soccer1.userRole.entity.UserRoleId;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {

	@Query("select u from UserRole u join fetch u.role r where u.userId = :userId")
	List<UserRole> findAllByUserId(Long userId);

}
