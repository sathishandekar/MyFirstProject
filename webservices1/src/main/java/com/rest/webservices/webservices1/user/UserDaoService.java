package com.rest.webservices.webservices1.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static int count =0;
	
	static {
		
		users.add(new User(++count,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++count,"Sathis",LocalDate.now().minusYears(20)));
		users.add(new User(++count,"Jim",LocalDate.now().minusYears(35)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User saveUser(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {		
				
	    Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	
	public void deleteById(int id) {		
		
	    Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		
	}

}
