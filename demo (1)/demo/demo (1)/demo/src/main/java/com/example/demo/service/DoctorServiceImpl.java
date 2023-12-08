package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepo;
@Service
public class DoctorServiceImpl implements  DoctorService {

@Autowired
private final DoctorRepo doctorRepo;

   
@Override
public List<Doctor> getAllDoctors() {
	  return doctorRepo.findAll();
}
public DoctorServiceImpl(DoctorRepo doctorRepo) {
	super();
	this.doctorRepo = doctorRepo;
}
@Override
public Doctor getDoctorById(long id) {
	 Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
       return optionalDoctor.orElse(null);
	
}
@Override
public Doctor addDoctor(Doctor doctor) {
	
	  return doctorRepo.save(doctor);
}
@Override
public Doctor updateDoctor(long id, Doctor updatedDoctor) {
	 return doctorRepo.findById(id)
               .map(doctor -> {
            	   doctor.setFirstname(updatedDoctor.getFirstname());
                   
                   doctor.setLastname(updatedDoctor.getLastname());
                   doctor.setLicenseNumber(updatedDoctor.getLicenseNumber());
                   doctor.setSpeciliazation(updatedDoctor.getSpeciliazation());
                   doctor.setLocation(updatedDoctor.getLocation());
                   doctor.setDescription(updatedDoctor.getDescription());
                   doctor.setExperience(updatedDoctor.getExperience());
                   return doctorRepo.save(doctor);}).orElse(null);
}
@Override
public void deleteDoctor(long id) {
	doctorRepo.deleteById(id);
}
}




