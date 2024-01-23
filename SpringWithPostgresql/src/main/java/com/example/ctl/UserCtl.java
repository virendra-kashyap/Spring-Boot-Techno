package com.example.ctl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.ORSResponseEntity;
import com.example.dto.UserDTO;
import com.example.service.UserServiceInt;

@RestController
@RequestMapping("/api/v1/user")
public class UserCtl {

	private final UserServiceInt userServiceInt;

	public UserCtl(UserServiceInt userServiceInt) {
		this.userServiceInt = userServiceInt;
	}

	@GetMapping("/allUsers")
	public ResponseEntity<?> allUsers() {
		ORSResponseEntity<?> responseEntity = null;
		try {
			responseEntity = new ORSResponseEntity<>(userServiceInt.list(), "User fetched successfully !!", true);
			return new ResponseEntity<>(responseEntity, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ORSResponseEntity<>(e.getMessage(), false);
			return new ResponseEntity<>(responseEntity, HttpStatus.BAD_REQUEST);
		}
	}

		@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
		ORSResponseEntity<?> responseEntity = null;

		try {
			responseEntity = new ORSResponseEntity<>(userServiceInt.add(userDTO), "User Created Successfully", true);
			return new ResponseEntity<>(responseEntity, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ORSResponseEntity<>(e.getMessage(), false);
			return new ResponseEntity<>(responseEntity, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
		ORSResponseEntity<?> responseEntity = null;

		try {
			if (userDTO.getId() > 0) {
				responseEntity = new ORSResponseEntity<>(userServiceInt.update(userDTO), "User Update Successfully",
						true);
				return new ResponseEntity<>(responseEntity, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			responseEntity = new ORSResponseEntity<>(e.getMessage(), false);
			return new ResponseEntity<>(responseEntity, HttpStatus.BAD_REQUEST);
		}
	}

@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") long id) {
		ORSResponseEntity<?> responseEntity = null;
		try {
			responseEntity = new ORSResponseEntity<>(userServiceInt.getById(id), "User fetched successfully !!", true);
			return new ResponseEntity<>(responseEntity, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ORSResponseEntity<>(e.getMessage(), false);
			return new ResponseEntity<>(responseEntity, HttpStatus.BAD_REQUEST);
		}
	}

@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		ORSResponseEntity<?> responseEntity = null;
		try {
			responseEntity = new ORSResponseEntity<>(userServiceInt.delete(id), "Delete user successfully !!", true);
			return new ResponseEntity<>(responseEntity, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ORSResponseEntity<>(e.getMessage(), false);
			return new ResponseEntity<>(responseEntity, HttpStatus.BAD_REQUEST);
		}
	}

}
