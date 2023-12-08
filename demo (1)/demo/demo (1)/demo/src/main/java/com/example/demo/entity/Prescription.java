package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prescription")
public class Prescription {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private String patientName;
	private String doctorName;
	private String medicineName;
	private long appointmentId;
	private boolean injection;
	private String description;
	public Prescription() {
		super();
	}
	public Prescription(long id, String patientName, String doctorName, String medicineName, long appointmentId,
			boolean injection, String description) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.medicineName = medicineName;
		this.appointmentId = appointmentId;
		this.injection = injection;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public boolean isInjection() {
		return injection;
	}
	public void setInjection(boolean injection) {
		this.injection = injection;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Prescription [id=" + id + ", patientName=" + patientName + ", doctorName=" + doctorName
				+ ", medicineName=" + medicineName + ", appointmentId=" + appointmentId + ", injection=" + injection
				+ ", description=" + description + "]";
	}
	

}
