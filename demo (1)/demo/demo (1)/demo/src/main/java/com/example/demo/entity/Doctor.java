package com.example.demo.entity;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
private long id;
@Column(nullable=false)
private String firstname;
@Column(nullable=false)
private String lastname;
@Column(nullable=false,unique=true)
private String licenseNumber;
@Column
private String speciliazation;
@Column
private String location;
@Column
private String description;
@Column
private int experience;
@ManyToOne
@JoinColumn(name = "admin_id")
private Admin admin;

// One-to-many relationship with Appointments
@OneToMany(mappedBy = "doctor")
private List<Appointments> appointments;

public Doctor() {
	super();
}

public Doctor(long id, String firstname, String lastname, String licenseNumber, String speciliazation, String location,
		String description, int experience, Admin admin, List<Appointments> appointments) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.licenseNumber = licenseNumber;
	this.speciliazation = speciliazation;
	this.location = location;
	this.description = description;
	this.experience = experience;
	this.admin = admin;
	this.appointments = appointments;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getLicenseNumber() {
	return licenseNumber;
}

public void setLicenseNumber(String licenseNumber) {
	this.licenseNumber = licenseNumber;
}

public String getSpeciliazation() {
	return speciliazation;
}

public void setSpeciliazation(String speciliazation) {
	this.speciliazation = speciliazation;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getExperience() {
	return experience;
}

public void setExperience(int experience) {
	this.experience = experience;
}

public Admin getAdmin() {
	return admin;
}

public void setAdmin(Admin admin) {
	this.admin = admin;
}

public List<Appointments> getAppointments() {
	return appointments;
}

public void setAppointments(List<Appointments> appointments) {
	this.appointments = appointments;
}

@Override
public String toString() {
	return "Doctor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", licenseNumber="
			+ licenseNumber + ", speciliazation=" + speciliazation + ", location=" + location + ", description="
			+ description + ", experience=" + experience + ", admin=" + admin + ", appointments=" + appointments + "]";
}





}