package com.example.service;

import java.util.List;

import com.example.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO userDTO);

	public void update();

	public List<UserDTO> list();

	public UserDTO getById(long id);

	public void delete(long id);

}
