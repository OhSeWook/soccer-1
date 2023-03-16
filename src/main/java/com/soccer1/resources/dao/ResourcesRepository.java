package com.soccer1.resources.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soccer1.resources.entity.Resource;

@Mapper
public interface ResourcesRepository {
	
	public List<Resource> findAllResources();

}