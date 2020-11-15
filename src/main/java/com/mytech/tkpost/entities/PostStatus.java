package com.mytech.tkpost.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class PostStatus implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String Status;
	@OneToMany(mappedBy = "status")
	List<Post> posts;

}
