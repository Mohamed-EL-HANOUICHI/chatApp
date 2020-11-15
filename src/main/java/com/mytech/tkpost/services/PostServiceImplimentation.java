package com.mytech.tkpost.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.tkpost.dao.PostRepository;
import com.mytech.tkpost.entities.Post;

@Service
public class PostServiceImplimentation {
	
	@Autowired
	PostRepository postRepository;

	public List<Post> getAllPost() {
		
		return postRepository.findAll();
	}

	
	public Optional<Post> getPost(Long id) {
		
		return postRepository.findById(id);
	}

	
	public List<Post> getPostByStatus(String status) {
		
		return null;
	}

	
	public Post addPost(Post post) {
		
		return postRepository.save(post);
	}

	
	public boolean updatePost() {
		
		return true;
	}

	
	public void deletePost(Long id) {
		
		 postRepository.deleteById(id);
	}
	

}
