package com.soccer1.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soccer1.role.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> findAllByUserId(@Param("userId") Long UserId);
}