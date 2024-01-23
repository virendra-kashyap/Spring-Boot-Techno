package com.example.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude()
@JsonIgnoreProperties(ignoreUnknown = true)
public class ORSResponseEntity<T> {

	private T data;
	private String message;
	private boolean isSuccess;

	public ORSResponseEntity() {
		super();
	}

	public ORSResponseEntity(T data, String message, boolean isSuccess) {
		super();
		this.data = data;
		this.message = message;
		this.isSuccess = isSuccess;
	}

	public ORSResponseEntity(String message, boolean isSuccess) {
		super();
		this.message = message;
		this.isSuccess = isSuccess;
	}

}
