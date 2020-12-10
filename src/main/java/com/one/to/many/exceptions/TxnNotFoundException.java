package com.one.to.many.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TxnNotFoundException extends RuntimeException {
  
  public TxnNotFoundException() {
	super();
  }
  
  public TxnNotFoundException(String message) {
	super(message);
  }
}
