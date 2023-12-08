package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Receptionist;
import com.example.demo.exception.ResourseNotFound;
import com.example.demo.repository.ReceptionistRepo;

@Service
public class ReceptionistServiceImpl  implements ReceptionistService{
	@Autowired
	private ReceptionistRepo receptionistRepo;
	@Autowired

	public ReceptionistServiceImpl(ReceptionistRepo receptionistRepo) {
		super();
		this.receptionistRepo = receptionistRepo;
	}

	@Override
	public Receptionist saveReceptionist(Receptionist receptionist) {
		
		return receptionistRepo.save(receptionist);
	}

	@Override
	public List<Receptionist> getAllReceptionist() {
		
		return receptionistRepo.findAll();
	}

	@Override
	public Receptionist getReceptionistById(long id) {
		
		return receptionistRepo.findById(id).orElseThrow(()
				->new ResourseNotFound("Receptionist","Id","id"));
	}

	@Override
	public Receptionist updateReceptionist(Receptionist receptionist,long id) {
		Receptionist existingReceptionist=receptionistRepo.findById(id).orElseThrow(()
				->new ResourseNotFound("Receptionist","Id","id"));
		existingReceptionist.setName(receptionist.getName());
		existingReceptionist.setMobile_no(receptionist.getMobile_no());
		existingReceptionist.setAddress(receptionist.getAddress());
		existingReceptionist.setPatients(receptionist.getPatients());
		existingReceptionist.setAppointments(receptionist.getAppointments());
		
		receptionistRepo.save(existingReceptionist);
		
		return existingReceptionist;
	}

	@Override
	public void deleteReceptionist(long id) {
		receptionistRepo.findById(id).orElseThrow(()
				->new ResourseNotFound("Receptionist","Id","id"));
		receptionistRepo.deleteById(id);
		
		
	}

}