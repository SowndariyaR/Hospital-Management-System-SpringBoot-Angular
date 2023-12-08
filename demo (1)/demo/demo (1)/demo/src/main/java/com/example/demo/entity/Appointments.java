package com.example.demo.entity;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="appointments")
public class Appointments {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	
	
	private long id;
	@Column(nullable = false)
	private String patientname;
	@Column(nullable = false)
    private String appointmentDate;
	@Column(nullable = false)
    private String appointmentTime;
	@Column(nullable = false)
	private String doctorname;
	@Column(nullable = false)
    private String description;
	private String checkup;
	 @ManyToOne
	    @JoinColumn(name = "doctor_id")
	    private Doctor doctor;

	    // Many-to-one relationship with Patient
	    @ManyToOne
	    @JoinColumn(name = "patient_id")
	    private Patient patient;

	    // Many-to-one relationship with Receptionist (to track who created the appointment)
	    @ManyToOne
	    @JoinColumn(name = "receptionist_id")
	    private Receptionist receptionist;

		public Appointments() {
			super();
		}

		public Appointments(long id, String patientname, String appointmentDate, String appointmentTime,
				String doctorname, String description, String checkup, Doctor doctor, Patient patient,
				Receptionist receptionist) {
			super();
			this.id = id;
			this.patientname = patientname;
			this.appointmentDate = appointmentDate;
			this.appointmentTime = appointmentTime;
			this.doctorname = doctorname;
			this.description = description;
			this.checkup = checkup;
			this.doctor = doctor;
			this.patient = patient;
			this.receptionist = receptionist;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPatientname() {
			return patientname;
		}

		public void setPatientname(String patientname) {
			this.patientname = patientname;
		}

		public String getAppointmentDate() {
			return appointmentDate;
		}

		public void setAppointmentDate(String appointmentDate) {
			this.appointmentDate = appointmentDate;
		}

		public String getAppointmentTime() {
			return appointmentTime;
		}

		public void setAppointmentTime(String appointmentTime) {
			this.appointmentTime = appointmentTime;
		}

		public String getDoctorname() {
			return doctorname;
		}

		public void setDoctorname(String doctorname) {
			this.doctorname = doctorname;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCheckup() {
			return checkup;
		}

		public void setCheckup(String checkup) {
			this.checkup = checkup;
		}

		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		public Receptionist getReceptionist() {
			return receptionist;
		}

		public void setReceptionist(Receptionist receptionist) {
			this.receptionist = receptionist;
		}

		@Override
		public String toString() {
			return "Appointments [id=" + id + ", patientname=" + patientname + ", appointmentDate=" + appointmentDate
					+ ", appointmentTime=" + appointmentTime + ", doctorname=" + doctorname + ", description="
					+ description + ", checkup=" + checkup + ", doctor=" + doctor + ", patient=" + patient
					+ ", receptionist=" + receptionist + "]";
		}

		
	
		
	    
	    
}
