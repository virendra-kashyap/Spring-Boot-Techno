package com.example.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDTO;
import com.example.service.UserServiceInt;

@RestController
@RequestMapping("/api/v1/user")
public class UserCtl {

	@Autowired
	UserServiceInt userServiceInt;

	@GetMapping("/allUsers")
	public ResponseEntity<?> allUsers() {
		com.example.bean.ResponseEntity<?> responseEntity = null;
		try {
			responseEntity = new com.example.bean.ResponseEntity<>(userServiceInt.list(),
					"User fetched successfully !!", true);
			return new ResponseEntity<>(responseEntity, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new com.example.bean.ResponseEntity<>(e.getMessage(), false);
			return new ResponseEntity<>(responseEntity, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
		com.example.bean.ResponseEntity<?> responseEntity = null;
		responseEntity =  new com.example.bean.ResponseEntity<>(userServiceInt.add(userDTO), "User Created Successfully", true);
		return new ResponseEntity<>(responseEntity, HttpStatus.OK);
	}

@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") long id) {
		com.example.bean.ResponseEntity<?> responseEntity = null;
		try {
			responseEntity = new com.example.bean.ResponseEntity<>(userServiceInt.getById(id),
					"User fetched successfully !!", true);
			return new ResponseEntity<>(responseEntity, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new com.example.bean.ResponseEntity<>(e.getMessage(), false);
			return new ResponseEntity<>(responseEntity, HttpStatus.BAD_REQUEST);
		}
	}

@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		com.example.bean.ResponseEntity<?> responseEntity = null;
		try {
			responseEntity = new com.example.bean.ResponseEntity<>(userServiceInt.delete(id),
					"User fetched successfully !!", true);
			return new ResponseEntity<>(responseEntity, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new com.example.bean.ResponseEntity<>(e.getMessage(), false);
			return new ResponseEntity<>(responseEntity, HttpStatus.BAD_REQUEST);
		}
	}

}
