package com.wuyufei.domain;

// Generated 2015-5-21 14:23:55 by Hibernate Tools 4.0.0

/**
 * Userinfo generated by hbm2java
 */
public class Userinfo implements java.io.Serializable {

	private String username;
	private String password;

	public Userinfo() {
	}

	public Userinfo(String username) {
		this.username = username;
	}

	public Userinfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
