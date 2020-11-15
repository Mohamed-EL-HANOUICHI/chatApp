package com.mytech.tkpost.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mytech.tkpost.entities.Post;
import com.mytech.tkpost.entities.User;
import com.mytech.tkpost.services.PostServiceImplimentation;
import com.mytech.tkpost.services.UserServiceImplimentation;

@RestController
@CrossOrigin(origins = "**")
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	PostServiceImplimentation postService;
	
	@Autowired
	UserServiceImplimentation userService;
	
	@RequestMapping(value = "/posts", method=RequestMethod.GET)
	public List<Post> getAllPosts() {
			
		return postService.getAllPost();
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public Optional<Post> getPostById(@PathVariable("id") long id) {
		
		return postService.getPost(id);
	}
	
	@RequestMapping(value = "/posts/status", method = RequestMethod.GET)
	public List<Post> getPostByStatus(@RequestParam(value = "status") String status) {
		
		return postService.getPostByStatus(status);
	}
	
	@RequestMapping(value = "/user/{id}/posts/add", method = RequestMethod.POST)
	public Post addPost(@RequestParam List<String> post,@PathVariable("id") long id) {
		
		Post newPost = new Post(post.get(0), post.get(1));
		User user= userService.getUserById(id);
		newPost.setUser(user);
		return postService.addPost(newPost);
	}
	
	@RequestMapping(value = "/posts/update/{id}", method = RequestMethod.PUT)
	public void updatePost(@PathVariable("id") long id) {
		
		postService.updatePost();
	}
	
	@RequestMapping(value = "/posts/delete/{id}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable("id") long id) {
		
		 postService.deletePost(id);
	}
	
}
