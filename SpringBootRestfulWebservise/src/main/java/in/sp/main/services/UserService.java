package in.sp.main.services;

import java.util.List;
import java.util.Optional;

import in.sp.main.entities.User;

public interface UserService {
	public User createUser(User user); // for creating user
	public List<User> getAllUsers(); // for get all user
	public Optional<User> getById(int id); // for getting userby its id
	public User updateUserDetails(int id , User newUser); // for updating data by its id 
	public void deleteUser(int id) ;
}
