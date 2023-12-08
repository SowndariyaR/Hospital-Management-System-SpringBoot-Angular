package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Prescription;

public interface PrescriptionService {
	Prescription savePrescription(Prescription prescription);
	List<Prescription>getAllPrescription();
	Prescription getPrescriptionById(long id);
	Prescription updatePrescription(Prescription prescription,long id);
	void deletePrescription(long id);

}
