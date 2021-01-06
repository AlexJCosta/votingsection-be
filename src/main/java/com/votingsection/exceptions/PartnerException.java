package com.votingsection.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PartnerException extends RuntimeException {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String code;
	private final HttpStatus status;

}
