package com.soccer1.role.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_id")
	private Long roleId;
	
	@Id
	@Column(name = "user_id")
	private Long userId;
	
}
