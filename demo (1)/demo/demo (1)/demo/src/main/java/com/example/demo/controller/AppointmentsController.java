package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Appointments;
import com.example.demo.service.AppointmentsService;

@RestController//itself annotated @controller and @Response Body
@CrossOrigin("*")
@RequestMapping("/appointments")
public class AppointmentsController {
	 @Autowired
	private final AppointmentsService appointmentsService;

	public AppointmentsController(AppointmentsService appointmentsService) {
		super();
		this.appointmentsService = appointmentsService;
	}
	@PostMapping
	public ResponseEntity<Appointments>saveAppointments(@RequestBody Appointments appointments)
	{
return new ResponseEntity<Appointments>(appointmentsService.saveAppointments(appointments)
		,HttpStatus.CREATED);
	}
	@GetMapping
	public List<Appointments>getAppointments()
	{
		return appointmentsService.getAllAppointments();
	}
	@GetMapping("{id}")
	public ResponseEntity<Appointments>getAppointmentsById(@PathVariable("id")
	long appointmentsId)
	{
return new ResponseEntity<Appointments>(appointmentsService.getAppointmentsById(appointmentsId)
		,HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Appointments>updateAppointments(@PathVariable("id")
	long id,@RequestBody Appointments appointments)
	{
		return new ResponseEntity<Appointments>(appointmentsService
				.updateAppointments(appointments, id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteAppointments(@PathVariable("id")
	long id)
	{
		appointmentsService.deleteAppointments(id);
return new ResponseEntity<String>("Appointments Details deleted Successfully!!"
		,HttpStatus.OK);
	}

}
