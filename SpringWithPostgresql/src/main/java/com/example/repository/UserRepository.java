package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Long> {

}
