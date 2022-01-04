package com.Niche.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "username", unique = true)
	private String username;
	private String password;
	private boolean enabled = true;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<UserAuthority> userAuthorities = new ArrayList<>();
	
	User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(User user) {
		this.username = user.username;
		this.password = user.password;
		this.userAuthorities = new ArrayList<>(user.userAuthorities);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(List<UserAuthority> authorities) {
		this.userAuthorities = authorities;
	}
	
	public void addUserAuthority(String authority) {
		this.userAuthorities.add(new UserAuthority(this, authority));
	}
}
