package br.com.sample.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.restapi.models.User;
import br.com.sample.restapi.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/app/users")
	public List<User> getUsers() {
		return this.userService.getAll();
	}
	
	@GetMapping("/app/user/{id}")
	public User getUser(@PathVariable(name="id") long userId) {
		return this.userService.get(userId);
	}
	
	@PostMapping("/app/user/save")
	public void saveUser(@RequestBody User user) {
		this.userService.save(user);
	}
	
	@DeleteMapping("/app/user/delete/{id}")
	public void delete(@PathVariable(name="id") long userId) {
		this.userService.delete(userId);
	}
	
	@PutMapping("/app/user/update/{id}")
	public void update(@RequestBody User user, @PathVariable(name="id") long userId) {
		User user1 = userService.get(userId);
		if(user1 != null) {
			userService.update(user);
		}
	}
	
}
