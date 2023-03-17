package com.soccer1.resources.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccer1.resources.entity.Resource;

@Repository
public interface ResourcesRepository extends JpaRepository<Resource, Long> {
	
}