package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Patient;

public interface PateintService {
	Patient savePatient(Patient patient);
	List<Patient>getAllPatient();
	Patient getPatientById(long id);
	Patient updatePatient(Patient patient,long id);
	void deletePatient(long id);

}
