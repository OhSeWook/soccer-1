package com.soccer1.userRole.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccer1.userRole.entity.UserRole;
import com.soccer1.userRole.entity.UserRoleId;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {

	List<UserRole> findAllByUserId(Long id);

}
