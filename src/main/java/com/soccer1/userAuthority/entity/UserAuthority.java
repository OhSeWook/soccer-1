package com.soccer1.userAuthority.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.soccer1.authority.entity.Authority;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@IdClass(UserAuthorityId.class)
@Entity
@NoArgsConstructor
@Table(name = "tb_user_authority")
public class UserAuthority implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority_id")
    private Authority authority;

	@Id
    @Column(name = "user_id")
    private Long userId;

}
