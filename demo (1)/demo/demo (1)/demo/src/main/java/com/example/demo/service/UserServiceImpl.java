package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.response.Loginresponse;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	
	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	/*@Override
	public String addUser(UserDto userDto) {
		User user=new User(userDto.getUserName(),userDto.getEmail(),
				this.passwordEncoder.encode(userDto.getPassword()),
				userDto.getPhoneNo());
		userRepo.save(user);
		
					return user.getUserName();
	}
	UserDto userDto;
	@Override
	public Loginresponse loginUser(UserLoginDto userLoginDto) {
		String msg="";
		User user1=userRepo.findByEmail(userLoginDto.getEmail());
		
		if(user1!=null) {
		String password=userLoginDto.getPassword();
		String encoderPassword=user1.getPassword();
		boolean pwdRight=passwordEncoder
		.matches(password, encoderPassword);
		if(pwdRight)
		{
			Optional<User>user=userRepo.findOneByEmailAndPassword
		(userLoginDto.getEmail(),encoderPassword );
		if(user.isPresent())
		{
		   return new Loginresponse("Login Successfull!!",true);
		}
		else
		{
		return new Loginresponse("Login failed",false);
		}
		}
		else
		{
		return new Loginresponse("password not match",false);
		}
		}
		else
		{
		return new Loginresponse("email not exist",true);
		}
		}*/
	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	@Override
	public User getUserById(long id) {
		 return userRepo.findById(id).orElse(null);
	}
	@Override
	public User updateUser(long id, User user) {
		User existingUser = userRepo.findById(id).orElse(null);
        if (existingUser != null) {
        	existingUser.setUserName(user.getUserName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhoneNo(user.getPhoneNo());
            return userRepo.save(existingUser);
        }
        return null;
	}
	@Override
	public void deleteUser(long id) {
		 userRepo.deleteById(id);
		
	}
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User loginUser(String email, String password) {
		User user = userRepo.findByEmail(email);
        
        if (user != null && user.getPassword().equals(password)) {
            return user; // Successful login
        }
        
        return null;
	}
	@Override
	public User registerUser(UserDto userDto) {
		User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNo(userDto.getPhoneNo());
        
        // Save the user to the database
        return userRepo.save(user);
	}
	@Override
	public User loginUser(UserLoginDto credentials) {
		return loginUser(credentials.getEmail(), credentials.getPassword());
	}
	
	


}
