package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.UserDTO;
import com.example.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserRepository userRepository;

	@Override
	public long add(UserDTO userDTO) {
		UserDTO dto = userRepository.save(userDTO);
		return dto.getId();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDTO> list() {
		List<UserDTO> list = userRepository.findAll();
		return list;
	}

	@Override
	public UserDTO getById(long id) {
		Optional<UserDTO> data =  userRepository.findById(id);
		return data.get();
	}

	@Override
	public void delete(long id) {
		UserDTO userDTO = getById(id);
		if (userDTO != null) {
			userRepository.delete(userDTO);
		}
	}

}
