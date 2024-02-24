package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.dto.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Long> {

	@Query("SELECT u FROM UserDTO u WHERE u.emailId = :loginId")
	public UserDTO findLoginId(@Param("loginId") String loginId);

}
