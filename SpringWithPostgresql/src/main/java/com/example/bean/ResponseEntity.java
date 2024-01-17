package com.example.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude()
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseEntity<T> {

	private T data;
	private String message;
	private boolean isSuccess;

	public ResponseEntity() {
		super();
	}

	public ResponseEntity(T data, String message, boolean isSuccess) {
		super();
		this.data = data;
		this.message = message;
		this.isSuccess = isSuccess;
	}

	public ResponseEntity(String message, boolean isSuccess) {
		super();
		this.message = message;
		this.isSuccess = isSuccess;
	}

}
