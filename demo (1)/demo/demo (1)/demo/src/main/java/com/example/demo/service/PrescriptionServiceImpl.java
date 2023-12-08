package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Prescription;
import com.example.demo.exception.ResourseNotFound;
import com.example.demo.repository.PrescriptionRepo;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
	
	@Autowired
	private PrescriptionRepo prescriptionRepo;
	
	@Autowired
	public PrescriptionServiceImpl(PrescriptionRepo prescriptionRepo) {
		super();
		this.prescriptionRepo = prescriptionRepo;
	}
	

	@Override
	public Prescription savePrescription(Prescription prescription) {
		
		return prescriptionRepo.save(prescription);
	}



	@Override
	public List<Prescription> getAllPrescription() {
		
		return prescriptionRepo.findAll();
	}

	@Override
	public Prescription getPrescriptionById(long id) {
		
		return prescriptionRepo.findById(id).orElseThrow(()
				->new ResourseNotFound("Prescription","Id","id"));
		
	}

	@Override
	public Prescription updatePrescription(Prescription prescription, long id) {
		Prescription existingPrescription=prescriptionRepo.findById(id).orElseThrow(()
				->new ResourseNotFound("Prescription","Id","id"));
		existingPrescription.setPatientName(prescription.getPatientName());
		existingPrescription.setDoctorName(prescription.getDoctorName());
		existingPrescription.setMedicineName(prescription.getMedicineName());
		existingPrescription.setAppointmentId(prescription.getAppointmentId());
		existingPrescription.setDescription(prescription.getDescription());
		prescriptionRepo.save(existingPrescription);
		
		return existingPrescription;
	}

	@Override
	public void deletePrescription(long id) {
		
		prescriptionRepo.findById(id).orElseThrow(()
				->new ResourseNotFound("Prescription","Id","id"));
		prescriptionRepo.deleteById(id);
		
	}

}
