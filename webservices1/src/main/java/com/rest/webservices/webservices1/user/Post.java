package com.rest.webservices.webservices1.user;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="Post_Details")
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	public Post() {
		
	}
	
	
	public Post(Integer id, User user, String description) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", user=" + user + ", description=" + description + "]";
	}
	
	

}
