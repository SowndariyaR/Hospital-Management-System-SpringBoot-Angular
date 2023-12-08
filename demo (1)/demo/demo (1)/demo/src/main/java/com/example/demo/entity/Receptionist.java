package com.example.demo.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="receptionist")
public class Receptionist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String mobile_no;
	@Column(nullable = false)
	private String address;
	 @ManyToOne
	    @JoinColumn(name = "admin_id")
	    private Admin admin;
	    
	    // One-to-many relationship with Patients
	    @OneToMany(mappedBy = "receptionist")
	    private List<Patient> patients;
	    @OneToMany(mappedBy = "receptionist")
	    private List<Appointments> appointments;
	    
	    
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMobile_no() {
			return mobile_no;
		}
		public void setMobile_no(String mobile_no) {
			this.mobile_no = mobile_no;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Admin getAdmin() {
			return admin;
		}
		public void setAdmin(Admin admin) {
			this.admin = admin;
		}
		public List<Patient> getPatients() {
			return patients;
		}
		public void setPatients(List<Patient> patients) {
			this.patients = patients;
		}
		public List<Appointments> getAppointments() {
			return appointments;
		}
		public void setAppointments(List<Appointments> appointments) {
			this.appointments = appointments;
		}
		public Receptionist(long id, String name, String mobile_no, String address, Admin admin, List<Patient> patients,
				List<Appointments> appointments) {
			super();
			this.id = id;
			this.name = name;
			this.mobile_no = mobile_no;
			this.address = address;
			this.admin = admin;
			this.patients = patients;
			this.appointments = appointments;
		}
		public Receptionist() {
			super();
		}
		@Override
		public String toString() {
			return "Receptionist [id=" + id + ", name=" + name + ", mobile_no=" + mobile_no + ", address=" + address
					+ ", admin=" + admin + ", patients=" + patients + ", appointments=" + appointments + "]";
		}
	    
}

		