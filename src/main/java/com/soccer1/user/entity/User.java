package com.soccer1.user.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.soccer1.common.entity.BaseEntity;
import com.soccer1.order.entity.Order;
import com.soccer1.userAuthority.entity.UserAuthority;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_user")
public class User extends BaseEntity implements UserDetails {

	private static final long serialVersionUID = 2599924012058210220L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "login_id")
	private String loginId;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private String zipcode;
	
	private String city;
	
	private String street;
	
	@OneToMany(mappedBy = "user")
	private List<Order> order = new ArrayList<Order>();
	
	@OneToMany(mappedBy = "user")
	private List<UserAuthority> userAuthoritys = new ArrayList<UserAuthority>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public String getUsername() {
		return this.name;
	}

	@Builder
    public User(String loginId, String password, String email, String name) {
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.regDate = LocalDateTime.now();
		this.updDate = LocalDateTime.now();
    }

}
