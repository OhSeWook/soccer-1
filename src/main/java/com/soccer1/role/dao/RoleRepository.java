package com.soccer1.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soccer1.role.entity.Role;

@Mapper
public interface RoleRepository {

	public List<Role> findAllRoles();
}
