package com.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/*
 * A DAO (Data Access Object) service is a design pattern used in software development to abstract 
 * and encapsulate all interactions with a data source, such as a database or external service. 
 * The goal of a DAO service is to separate the logic that interacts with the data source from 
 * the business logic, making it easier to manage, test, and maintain.
 */
@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"Aman",LocalDate.now().minusYears(25)));
		users.add(new User(2,"Ekta",LocalDate.now().minusYears(31)));
	}
	
	public List<User> findAll(){
		return users;
	}
}
