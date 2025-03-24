package com.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	private UserRepository userRepository;
	
	public UserJpaResource(UserRepository userRepository) {
		super();
		this.userRepository=userRepository;
	}

	// GET /users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	// POST /users
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User savedUser = userRepository.save(user);
		
		// Return Status Code as 201
		// and also return URI of user created
		// ServletUriComponentsBuilder.fromCurrentRequest() -> details of Current Request
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	// GET /users/{id}
	@GetMapping("/jpa/users/{id}")
	public User retrieveUser(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id: "+id+" not found");
		}
		return user.get();
	}
	
	// GET /users/{id}
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		userRepository.deleteById(id);
	}
}
