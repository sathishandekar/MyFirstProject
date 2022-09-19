package com.rest.webservices.webservices1.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.webservices1.user.User;

public interface UserJpaRepository extends JpaRepository<User,Integer>{

}
