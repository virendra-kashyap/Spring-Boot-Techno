package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.UserDTO;
import com.example.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInt {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public long add(UserDTO userDTO) {
		UserDTO dto = userRepository.save(userDTO);
		return dto.getId();
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		UserDTO dto = getById(userDTO.getId());
		if (dto != null) {
			userRepository.save(userDTO);
			return userDTO;
		}
		return null;
	}

	@Override
	public List<UserDTO> list() {
		return userRepository.findAll();
	}

	@Override
	public UserDTO getById(long id) {
		Optional<UserDTO> data =  userRepository.findById(id);
		if (data.isPresent()) {
		return data.get();
	}
		return null;
	}

	@Override
	public UserDTO delete(long id) {
		UserDTO userDTO = getById(id);
		if (userDTO != null) {
			userRepository.delete(userDTO);
			return userDTO;
		}
		return null;
	}

}
