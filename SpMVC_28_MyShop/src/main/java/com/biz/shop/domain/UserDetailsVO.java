package com.biz.shop.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDetailsVO implements UserDetails {

	private static final long serialVersionUID = 3812867868171304547L;
	
	// 필수 항목 필드 변수
	private long id;
	private String username;
	private String password;
	
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private Collection<? extends GrantedAuthority> authorities;
	// -------------------
	
	private String nickname;
	private String email;
	private String phone;
	private int age;
	
}
