package com.example.demo.service;
import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	//import java.util.Optional; // Add this import

	import com.example.demo.entity.Appointments;
import com.example.demo.exception.ResourseNotFound;
import com.example.demo.repository.AppointmentsRepo;
	@Service
	public class AppointmentsServiceImpl  implements AppointmentsService {
	@Autowired
	private AppointmentsRepo appointmentsRepo;
		
	@Autowired
		public AppointmentsServiceImpl (AppointmentsRepo appointmentsRepo) {
			super();
			this.appointmentsRepo = appointmentsRepo;
		}

		@Override
		public Appointments saveAppointments(Appointments appointments) {
			
			return appointmentsRepo.save(appointments);
		}

		@Override
		public List<Appointments> getAllAppointments() {
			
			return appointmentsRepo.findAll();
		}

		@Override
		public Appointments getAppointmentsById(long id) {
			
			return appointmentsRepo.findById(id).orElseThrow(()->new ResourseNotFound("Appointments","Id","id"));
		}
		@Override
		public Appointments updateAppointments(Appointments appointments, long id) {
			Appointments existingAppointments=appointmentsRepo.findById(id).orElseThrow(()
					->new ResourseNotFound("Appointments","Id","id"));
			existingAppointments.setPatientname(appointments.getPatientname());
			existingAppointments.setAppointmentDate(appointments.getAppointmentDate());
			existingAppointments.setAppointmentTime(appointments.getAppointmentTime());
			existingAppointments.setDoctorname(appointments.getDoctorname());
			existingAppointments.setDescription(appointments.getDescription());
			existingAppointments.setCheckup(appointments.getCheckup());
			appointmentsRepo.save(existingAppointments);
			
			return existingAppointments;
		}

		@Override
		public void deleteAppointments(long id) {
			appointmentsRepo.findById(id).orElseThrow(()
					->new ResourseNotFound("Appointments","Id","id"));
			appointmentsRepo.deleteById(id);
			
			
		}


}



