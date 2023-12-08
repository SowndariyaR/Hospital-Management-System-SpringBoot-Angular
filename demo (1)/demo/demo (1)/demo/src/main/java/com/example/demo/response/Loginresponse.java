package com.example.demo.response;
public class Loginresponse {
String meesage;
boolean status;
public String getMeesage() {
	return meesage;
}
public void setMeesage(String meesage) {
	this.meesage = meesage;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public Loginresponse(String meesage, boolean status) {
	super();
	this.meesage = meesage;
	this.status = status;
}
public Loginresponse() {
	super();
}
@Override
public String toString() {
	return "LoginResponse [meesage=" + meesage + ", status=" + status + "]";
}

}
