package com.rest.webservices.webservices1.helloworld;

public class HelloWorldBean {
 private String message;

public HelloWorldBean(String message) {
		this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

//[message=" + message + "]
@Override
public String toString() {
	return "HelloWorldBean ";
}


 
}
