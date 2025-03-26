package in.sp.main.controllers;

import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entities.User;

import in.sp.main.services.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User adduserDetails(@RequestBody User user) {
		
		return userService.createUser(user);
		
	}
	
	@GetMapping("/user")
	public List<User> getAllUsersDetails(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		User user =  userService.getById(id).orElse(null);
		if(user != null) {
			return ResponseEntity.ok().body(user);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping("/user/{id}")

	public ResponseEntity<User> updateUserInfo( @PathVariable int id, @RequestBody User user) {
	User updatedUser =	userService.updateUserDetails(id, user);
	if(updatedUser != null) {
		return ResponseEntity.ok(updatedUser);
	}else {
		return  ResponseEntity.notFound().build();
	}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		 userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
