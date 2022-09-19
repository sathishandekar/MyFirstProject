package com.rest.webservices.webservices1.versioning;

public class Person2 {

	private Name name;

	public Person2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
}
