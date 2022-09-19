package com.rest.webservices.webservices1.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="User_Details")
public class User {
	
  @Id
  @GeneratedValue
  private Integer id;
  @Size(min=2, message="name should contain atleast 2 chars")
  private String name;
  @Past(message ="Date of birth must be in past")
  private LocalDate birthDate;
  
  @JsonIgnore
  @OneToMany(mappedBy ="user")
  private List<Post> posts;
  
  public User() {
	  
  }
  
public User(Integer id, String name, LocalDate birthDate) {
	super();
	this.id = id;
	this.name = name;
	this.birthDate = birthDate;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public LocalDate getBirthDate() {
	return birthDate;
}

public void setBithDate(LocalDate bithDate) {
	this.birthDate = bithDate;
}

public List<Post> getPosts() {
	return posts;
}

public void setPosts(List<Post> posts) {
	this.posts = posts;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", bithDate=" + birthDate + "]";
}




}
