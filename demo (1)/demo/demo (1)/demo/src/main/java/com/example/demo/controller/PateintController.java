package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Patient;
import com.example.demo.service.PateintService;



@RestController//itself annotated @controller and @Response Body
@CrossOrigin("*")
@RequestMapping("/patient")
public class PateintController {
	 @Autowired
	private final PateintService pateintService;

	public PateintController(PateintService pateintService) {
		super();
		this.pateintService =pateintService;
	}
	@PostMapping
	public ResponseEntity<Patient>savePatient(@RequestBody Patient patient)
	{
return new ResponseEntity<Patient>(pateintService.savePatient(patient)
		,HttpStatus.CREATED);
	}
	@GetMapping
	public List<Patient>getPatient()
	{
		return pateintService.getAllPatient();
	}
	@GetMapping("{id}")
	public ResponseEntity<Patient>getPatientById(@PathVariable("id")
	int patientId)
	{
return new ResponseEntity<Patient>(pateintService.getPatientById(patientId)
		,HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Patient>updatePatient(@PathVariable("id")
	int id,@RequestBody Patient patient)
	{
		return new ResponseEntity<Patient>(pateintService
				.updatePatient(patient, id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String>deletePatient(@PathVariable("id")
	int id)
	{
		pateintService.deletePatient(id);
return new ResponseEntity<String>("Patient Details deleted Successfully!!"
		,HttpStatus.OK);
	}

}
