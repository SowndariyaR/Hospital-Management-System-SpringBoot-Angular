package com.example.demo.dto;

public class UserDto {
	private long id;
	private String userName;
	private String email;
	private String password;
	private String phoneNo;
	public UserDto() {
		super();
	}
	public UserDto(long id, String userName, String email, String password, String phoneNo) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", phoneNo=" + phoneNo + "]";
	}
	
	

}
