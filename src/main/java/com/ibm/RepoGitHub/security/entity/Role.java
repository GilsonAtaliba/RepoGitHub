package com.ibm.RepoGitHub.security.entity;

import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority	{

	private static final long serialVersionUID = -4568893811384697368L;
	
	public static final	Role	ROLE_ADMIN	=	new	Role("ROLE_ADMIN");
	public static final	Role	ROLE_ALUNO	=	new	Role("ROLE_ALUNO");
	
	private	String	authority;
	public	Role() {
		
	}
	public	Role(String	authority) {
		this.authority	=	authority;
	}
	
	@Override
	public	String	getAuthority() {
		return this.authority;
	}
	
		@Override
		public	boolean	equals(Object object) {
			if (this ==	object)	{
				return true;	
			}
			if	(object	==	null ||	getClass() != object.getClass())	{
				return false;
			}
			Role role =	(Role)	object;
			return	Objects.equals(authority,	role.authority);
		}
}
