package com.one.to.many.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotfoundExceptions extends RuntimeException {
  public UserNotfoundExceptions() {
	super();
  }
  
  public UserNotfoundExceptions(String message) {
	super(message);
  }
  
  
}
