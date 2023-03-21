package com.soccer1.userRole.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.soccer1.role.entity.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@IdClass(UserRoleId.class)
@Entity
@NoArgsConstructor
@Table(name = "tb_user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

	@Id
    @Column(name = "user_id")
    private Long userId;

}
