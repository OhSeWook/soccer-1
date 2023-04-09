package com.soccer1.resources.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.soccer1.common.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_resources")
public class Resource extends BaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resources_id")
    private Long id;
    
    private String resourcesName;
    
    private String httpMethod;
    
    private int orderNum;
    
    private String resourceType;
    
    private Long roleId;
}
