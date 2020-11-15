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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String title;
	String content;

	@ManyToOne
	@JoinColumn(name="status_id")
	PostStatus status;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(
			name="user_post",
			joinColumns= @JoinColumn(name="id_post"),
			inverseJoinColumns = @JoinColumn(name="id_user")
			)
	Set<User> users = new HashSet<User>();

	
	
	

	public Post() {
		
	}

	public Post(String title, String content) {
		super();
		this.title = title;
		this.content = content;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public void setStatus(PostStatus status) {
		this.status = status;
	}

	public PostStatus getStatus() {
		return status;
	}


		
		public Set<User> getUsers() {
			return users;
		}
	
		public void setUser(User user) {
			this.users.add(user);
		}



}
