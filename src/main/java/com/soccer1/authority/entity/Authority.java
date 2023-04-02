package com.soccer1.authority.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.soccer1.authority.dto.RoleType;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_authority")
public class Authority implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authority_id")
    private Long id;
	
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	private String authorityName;

}