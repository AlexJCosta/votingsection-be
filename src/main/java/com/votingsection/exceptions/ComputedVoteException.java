package com.votingsection.exceptions;

import org.springframework.http.HttpStatus;

public class ComputedVoteException extends PartnerException {

	private static final long serialVersionUID = 5553707156721755355L;

	public ComputedVoteException() {
		super("Vote", HttpStatus.ALREADY_REPORTED);
	}

}
