package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Receptionist;
import com.example.demo.service.ReceptionistService;

@RestController//itself annotated @controller and @Response Body
@CrossOrigin("*")
@RequestMapping("/receptionist")
public class ReceptionistController{
	 @Autowired
	private final ReceptionistService receptionistService;

	public ReceptionistController(ReceptionistService receptionistService) {
		super();
		this.receptionistService = receptionistService;
	}
	@PostMapping
	public ResponseEntity<Receptionist>saveReceptionist(@RequestBody Receptionist receptionist)
	{
return new ResponseEntity<Receptionist>(receptionistService.saveReceptionist(receptionist)
		,HttpStatus.CREATED);
	}
	@GetMapping
	public List<Receptionist>getReceptionist()
	{
		return receptionistService.getAllReceptionist();
	}
	@GetMapping("{id}")
	public ResponseEntity<Receptionist>getReceptionistById(@PathVariable("id")
	int receptionistId)
	{
return new ResponseEntity<Receptionist>(receptionistService.getReceptionistById(receptionistId)
		,HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Receptionist>updateReceptionist(@PathVariable("id")
	int id,@RequestBody Receptionist receptionist)
	{
		return new ResponseEntity<Receptionist>(receptionistService
				.updateReceptionist(receptionist, id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteReceptionist(@PathVariable("id")
	int id)
	{
		receptionistService.deleteReceptionist(id);
return new ResponseEntity<String>("Receptionists Details deleted Successfully!!"
		,HttpStatus.OK);
	}
	

}
