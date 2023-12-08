package com.example.demo.service;


import java.util.List;


import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.entity.User;
import com.example.demo.response.Loginresponse;

public interface UserService {
	//String addUser( UserDto userDto ); 
	//Loginresponse loginUser(UserLoginDto userLoginDto );
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User updateUser(long id, User user);
    void deleteUser(long id);
	User registerUser(User user);
	User loginUser(String email, String password);

	 User registerUser(UserDto userDto);
	 User loginUser(UserLoginDto credentials);

}
