package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Admin;
public interface AdminRepo extends JpaRepository<Admin, Long > {

	Optional<Admin >findOneByEmailAndPassword(String email, String password);
	Admin findByEmail(String email);
	Admin findBypassword(String password);

}
