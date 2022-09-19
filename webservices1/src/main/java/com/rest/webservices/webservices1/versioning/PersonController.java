package com.rest.webservices.webservices1.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@GetMapping(path="/v1/person")
	public Person firstVersionName() {
		return new Person("Andekar Sathish");
	}

	@GetMapping(path="/v2/person")
	public Person2 secondVersionName() {
		return new Person2(new Name("Andekar","Sathish"));
	}
	
	@GetMapping(path="/person",params="version=1")
	public Person firstVersionNameRequestParam() {
		return new Person("Andekar Sathish");
	}

	@GetMapping(path="/person",params="version=2")
	public Person2 secondVersionNameRequestParam() {
		return new Person2(new Name("Andekar","Sathish"));
	}
	
	@GetMapping(path="/person/header",headers="X-API-VERSION=1")
	public Person firstVersionNameHeader() {
		return new Person("Andekar Sathish");
	}

	@GetMapping(path="/person/header",headers="X-API-VERSION=2")
	public Person2 secondVersionNameHeader() {
		return new Person2(new Name("Andekar","Sathish"));
	}
	
	@GetMapping(path="/person/accpet",produces="application/vnd.app-v1+json")
	public Person firstVersionNameAccept() {
		return new Person("Andekar Sathish");
	}

	@GetMapping(path="/person/accpet",produces="application/vnd.app-v2+json")
	public Person2 secondVersionNameAccept() {
		return new Person2(new Name("Andekar","Sathish"));
	}
}
