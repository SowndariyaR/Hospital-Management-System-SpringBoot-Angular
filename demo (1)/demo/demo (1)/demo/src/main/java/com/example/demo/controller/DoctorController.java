package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepo;


@RestController
@CrossOrigin("*")
@RequestMapping("/doctors")
public class DoctorController{
	@Autowired
    private final DoctorRepo doctorRepo;

   
    public DoctorController(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @GetMapping("{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @PutMapping("{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
        return doctorRepo.findById(id)
                .map(doctor -> {
                    doctor.setFirstname(updatedDoctor.getFirstname());
                   
                    doctor.setLastname(updatedDoctor.getLastname());
                    doctor.setLicenseNumber(updatedDoctor.getLicenseNumber());
                    doctor.setSpeciliazation(updatedDoctor.getSpeciliazation());
                    doctor.setLocation(updatedDoctor.getLocation());
                    doctor.setDescription(updatedDoctor.getDescription());
                    doctor.setExperience(updatedDoctor.getExperience());
                    return doctorRepo.save(doctor);
                })
                .orElse(null);
    }

    @DeleteMapping("{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRepo.deleteById(id);
    }
}
