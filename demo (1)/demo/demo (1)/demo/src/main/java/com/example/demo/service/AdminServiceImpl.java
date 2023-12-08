package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.AdminLoginDto;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepo;
import com.example.demo.response.Loginresponse;
@Service
public class AdminServiceImpl  implements AdminService{
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public AdminServiceImpl(AdminRepo adminRepo) {
		super();
		this.adminRepo = adminRepo;
	}
	@Override
	public String addAdmin(AdminDto adminDto) {
		
		Admin admin=new Admin(adminDto.getName(),adminDto.getEmail(),
			this.passwordEncoder.encode(adminDto.getPassword()));
		adminRepo.save(admin);
				return admin.getName();
	}
	AdminDto adminDto;
	@Override
	public Loginresponse loginAdmin(AdminLoginDto adminLoginDto) {
		String msg="";
		Admin admin1=adminRepo.findByEmail(adminLoginDto.getEmail());
		
		if(admin1!=null) {
		String password=adminLoginDto.getPassword();
		String encoderPassword=admin1.getPassword();
		boolean pwdRight=passwordEncoder
		.matches(password, encoderPassword);
		if(pwdRight)
		{
			Optional<Admin>admin=adminRepo.findOneByEmailAndPassword
		(adminLoginDto.getEmail(),encoderPassword );
		if(admin.isPresent())
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
		}

	}