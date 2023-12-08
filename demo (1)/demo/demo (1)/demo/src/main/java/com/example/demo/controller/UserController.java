package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.entity.User;
import com.example.demo.response.Loginresponse;
import com.example.demo.service.UserService;


@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/user")
public class UserController {
	@Autowired
	private UserService  userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	/*@PostMapping(path="/save")
	public String saveUser(@RequestBody UserDto userDto) {
		String id=userService.addUser(userDto);
		return id;	
	}
	@PostMapping(path="/login")	
	public ResponseEntity<?>loginUser(@RequestBody UserLoginDto userLoginDto){
		Loginresponse loginResponse=userService.loginUser(userLoginDto);
		return ResponseEntity.ok(loginResponse);
	}*/
	
	@PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
        User registeredUser = userService.registerUser(userDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
	
	@PostMapping("/login")
    public ResponseEntity<User> loginAdmin(@RequestBody UserLoginDto credentials) {
        String email = credentials.getEmail();
        String password = credentials.getPassword();

        User loggedInUser = userService.loginUser(email, password);

        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
