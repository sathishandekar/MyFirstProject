package com.rest.webservices.webservices1.versioning;

public class PersonAction {
   private Name name;
   
   public PersonAction(Name name) {
	   this.name = name;
   }
   
   public Name getName() {
	   return name;
   }
}
