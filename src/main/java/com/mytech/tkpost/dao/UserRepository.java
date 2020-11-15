package com.mytech.tkpost.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mytech.tkpost.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u  WHERE u.id = :id")
	User FindUserById(@Param("id") long id);
	
	@Query("SELECT u FROM User u  WHERE u.email = :email")
	User FindUserByEmail(@Param("email") String email);

}
