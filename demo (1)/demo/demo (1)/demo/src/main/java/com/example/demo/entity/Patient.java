package com.example.demo.entity;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="patient")
public class  Patient{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	@Column(nullable = false)
	private String patient_name;
	@Column(nullable = false)
	private String blood_group;
	@Column(nullable = false)
	private String disease;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String mobileno;
	@ManyToOne
    @JoinColumn(name = "receptionist_id")
    private Receptionist receptionist;
    
    // One-to-many relationship with Appointments
    @OneToMany(mappedBy = "patient")
    private List<Appointments> appointments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Receptionist getReceptionist() {
		return receptionist;
	}

	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}

	public List<Appointments> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointments> appointments) {
		this.appointments = appointments;
	}

	public Patient(long id, String patient_name, String blood_group, String disease, int age, String mobileno,
			Receptionist receptionist, List<Appointments> appointments) {
		super();
		this.id = id;
		this.patient_name = patient_name;
		this.blood_group = blood_group;
		this.disease = disease;
		this.age = age;
		this.mobileno = mobileno;
		this.receptionist = receptionist;
		this.appointments = appointments;
	}

	public Patient() {
		super();
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", patient_name=" + patient_name + ", blood_group=" + blood_group + ", disease="
				+ disease + ", age=" + age + ", mobileno=" + mobileno + ", receptionist=" + receptionist
				+ ", appointments=" + appointments + "]";
	}
	
}
