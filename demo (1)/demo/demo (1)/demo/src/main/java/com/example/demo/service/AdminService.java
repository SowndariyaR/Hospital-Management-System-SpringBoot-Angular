package com.example.demo.service;


import com.example.demo.dto.AdminDto;
import com.example.demo.dto.AdminLoginDto;
import com.example.demo.response.Loginresponse;

public interface AdminService{
String addAdmin( AdminDto adminDto ); 
Loginresponse loginAdmin(AdminLoginDto adminLoginDto );
}
