package com.mytech.tkpost.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mytech.tkpost.entities.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	@Query("SELECT role FROM UserRole role  WHERE role.id = :id")
	UserRole FindRoleById(@Param("id") long id);

}
