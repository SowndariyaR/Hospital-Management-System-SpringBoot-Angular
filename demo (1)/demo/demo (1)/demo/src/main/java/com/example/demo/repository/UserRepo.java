package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long >{
	//Optional<User >findOneByEmailAndPassword(String email, String password);
	User findByEmail(String email);
	//User findBypassword(String password);

}
