package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Prescription;
import com.example.demo.service.PrescriptionService;


@RestController//itself annotated @controller and @Response Body
@CrossOrigin("*")
@RequestMapping("/prescription")
public class PrescriptionController {
	@Autowired
	private final PrescriptionService prescriptionService;

	public PrescriptionController(PrescriptionService prescriptionService) {
		super();
		this.prescriptionService = prescriptionService;
	}
	@PostMapping
	public ResponseEntity<Prescription>savePrescription(@RequestBody Prescription prescription)
	{
return new ResponseEntity<Prescription>(prescriptionService.savePrescription(prescription)
		,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Prescription>getPrescription()
	{
		return prescriptionService.getAllPrescription();
	}
	@GetMapping("{id}")
	public ResponseEntity<Prescription>getPrescriptionById(@PathVariable("id")
	long prescriptionId)
	{
return new ResponseEntity<Prescription>(prescriptionService.getPrescriptionById(prescriptionId)
		,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Prescription>updatePrescription(@PathVariable("id")
	long id,@RequestBody Prescription prescription)
	{
		return new ResponseEntity<Prescription>(prescriptionService
				.updatePrescription(prescription, id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String>deletePrescription(@PathVariable("id")
	long id)
	{
		prescriptionService.deletePrescription(id);
return new ResponseEntity<String>("Prescription Details deleted Successfully!!"
		,HttpStatus.OK);
	}

}
