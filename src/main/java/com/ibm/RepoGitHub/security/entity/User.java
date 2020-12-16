package com.ibm.RepoGitHub.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
	private static final long serialVersionUID = -5719176835798241438L;
	
	private	Long id;
	
	private	String name;
	
	private	String password;
	
	private	String	userName;
	

	private	List<Role>	authorities	= new ArrayList<>();
	
	@Override
	public	Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public	boolean	isAccountNonExpired() {
		return true;
	}

	@Override
	public	boolean	isAccountNonLocked() {
		return true;	
	}
 
	@Override
	public	boolean	isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public	boolean	isEnabled() {
		return true;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}






	
}