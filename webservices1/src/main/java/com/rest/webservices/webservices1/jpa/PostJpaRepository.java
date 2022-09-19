package com.rest.webservices.webservices1.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.webservices1.user.Post;

public interface PostJpaRepository extends JpaRepository<Post,Integer>{

}
