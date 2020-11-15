package com.mytech.tkpost.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String firstName;
	String secondeName;
	String email;
	String password;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(
			name="role_user",
			joinColumns= @JoinColumn(name="id_user"),
			inverseJoinColumns = @JoinColumn(name="id_role")
			)
	Set<UserRole> roles = new HashSet<UserRole>();
	
	@ManyToMany(mappedBy = "users")
	Set<Post> posts = new HashSet<Post>();
	
	public User() {	
	}

	public User(String firstName, String secondeName, String email, String password) {
		super();
		this.firstName = firstName;
		this.secondeName = secondeName;
		this.email = email;
		this.password= password;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondeName() {
		return secondeName;
	}
	public void setSecondeName(String secondeName) {
		this.secondeName = secondeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public Set<Post> getPosts() {
	return posts;
    }
//	public void setPost(Post post) {
//		this.posts.add(post);
//	}
//	
	public Set<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(UserRole role) {
		this.roles.add(role);
	}


}
