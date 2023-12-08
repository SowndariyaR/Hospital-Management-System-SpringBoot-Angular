package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.AdminLoginDto;
import com.example.demo.response.Loginresponse;
import com.example.demo.service.AdminService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/admin")
public class AdminController  {	
@Autowired
private AdminService  adminService;

public AdminController(AdminService adminService) {
	super();
	this.adminService = adminService;
}
@PostMapping(path="/save")
public String saveAdmin(@RequestBody AdminDto adminDto) {
	String id=adminService.addAdmin(adminDto);
	return id;	
}
@PostMapping(path="/login")	
public ResponseEntity<?>loginAdmin(@RequestBody AdminLoginDto adminLoginDto){
	Loginresponse loginResponse=adminService.loginAdmin(adminLoginDto);
	return ResponseEntity.ok(loginResponse);
}
}

