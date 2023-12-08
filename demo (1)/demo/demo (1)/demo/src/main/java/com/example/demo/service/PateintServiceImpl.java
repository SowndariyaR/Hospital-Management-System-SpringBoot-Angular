package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.exception.ResourseNotFound;
import com.example.demo.repository.PatientRepo;
@Service
public class PateintServiceImpl implements PateintService {
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	public PateintServiceImpl(PatientRepo patientRepo) {
		super();
		this.patientRepo = patientRepo;
	}

	@Override
	public Patient savePatient(Patient patient) {
		
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		
		return patientRepo.findAll();
	}

	@Override
	public Patient getPatientById(long id) {
		
		return patientRepo.findById(id).orElseThrow(()
				->new ResourseNotFound("Patient","Id","id"));
	}

	@Override
	public Patient updatePatient(Patient patient, long id) {
		Patient existingPatient=patientRepo.findById(id).orElseThrow(()
				->new ResourseNotFound("Patient","Id","id"));
		existingPatient.setPatient_name(patient.getPatient_name());
		existingPatient.setBlood_group(patient.getBlood_group());
		existingPatient.setDisease(patient.getDisease());
		existingPatient.setAge(patient.getAge());
		existingPatient.setMobileno(patient.getMobileno());
		patientRepo.save(existingPatient);
		
		return existingPatient;
	}

	@Override
	public void deletePatient(long id) {
		patientRepo.findById(id).orElseThrow(()
				->new ResourseNotFound("Receptionist","Id","id"));
		patientRepo.deleteById(id);
		
		
	}

}

