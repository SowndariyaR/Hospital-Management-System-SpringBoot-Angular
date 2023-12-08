package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Appointments;

public interface AppointmentsService {
	Appointments saveAppointments(Appointments appointments);
	List<Appointments>getAllAppointments();
	Appointments getAppointmentsById(long id);
	Appointments updateAppointments(Appointments appointments,long id);
	void deleteAppointments(long id);
}
