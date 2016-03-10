package com.dkt.school.user.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsDto implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9007363385402127375L;
	
	private String userName;
	
	private String password;
	
	private boolean enabled;
	
	private Collection<GrantedAuthority> auths;
	
	private boolean accountNonExpired;
	
	private boolean accountNonLocked;
	
	private boolean credentialsNonExpired;
	
	public UserDetailsDto(String userName,String password,boolean enabled,Collection<GrantedAuthority> auths,
			boolean accountNonExpired,boolean accountNonLocked,boolean credentialsNonExpired){
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.auths = auths;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return this.auths;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.userName;
	}

	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

}

