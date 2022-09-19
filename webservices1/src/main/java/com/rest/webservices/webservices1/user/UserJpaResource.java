package com.rest.webservices.webservices1.user;

import java.net.URI;



import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.webservices1.jpa.PostJpaRepository;
import com.rest.webservices.webservices1.jpa.UserJpaRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
//private UserDaoService service;
private UserJpaRepository repository;
private PostJpaRepository postRepository;
  
  public UserJpaResource(UserJpaRepository repository, PostJpaRepository postRepository) {
	  //this.service=service;
	  this.repository = repository;
	  this.postRepository = postRepository;
  }

  @GetMapping(path="/jpa/users")
  public List<User> retrieveAll(){
	  return repository.findAll();
  }
  
  @GetMapping(path="/jpa/users/{id}")
  public EntityModel<Optional> findingOne(@PathVariable int id){
	  
	  Optional<User> user =repository.findById(id);
	   if(user.isEmpty()) {
		   throw new UserNotFoundException("ID:"+ id);
	   }
	   EntityModel<Optional> entityModel = EntityModel.of(user);
	   
	   WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAll());
	   
	   entityModel.add(link.withRel("all users"));
	  return entityModel;
  }
  
  

@DeleteMapping(path="/jpa/users/{id}")
  public void deleteUser(@PathVariable int id){
	  
	repository.deleteById(id);
	   
  }

@GetMapping(path="/jpa/users/{id}/posts")
public List<Post> retrivePosts(@PathVariable int id){
	Optional<User> user =repository.findById(id);
	   if(user.isEmpty()) 
		   throw new UserNotFoundException("ID:"+ id);
	   return user.get().getPosts();
	   
	  
	
	   
}
  
  @PostMapping(path="/jpa/users")
  public ResponseEntity<User> creatUser(@Valid @RequestBody User user) {
	 User savedUser =(User) repository.save(user);
	 
	 URI location= ServletUriComponentsBuilder.fromCurrentRequest()
			 .path("/{id}")
			 .buildAndExpand(savedUser.getId()).toUri();
			 
	  return ResponseEntity.created(location).build();
  }
  
  
  @PostMapping(path="/jpa/users/{id}/posts")
  public ResponseEntity<Post> createPosts(@PathVariable int id, @Valid @RequestBody Post post){
  	Optional<User> user =repository.findById(id);
  	   if(user.isEmpty()) 
  		   throw new UserNotFoundException("ID:"+ id);
  	   post.setUser(user.get());
  	  Post savedPost= postRepository.save(post);
  	   
  	 URI location= ServletUriComponentsBuilder.fromCurrentRequest()
			 .path("/{id}")
			 .buildAndExpand(savedPost.getId()).toUri();			 
	  return ResponseEntity.created(location).build(); 	  
  	  	   
  }
}
