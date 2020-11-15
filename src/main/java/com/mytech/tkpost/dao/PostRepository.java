package com.mytech.tkpost.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytech.tkpost.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
