package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Receptionist;

public interface ReceptionistService {
	Receptionist saveReceptionist(Receptionist receptionist);
	List<Receptionist>getAllReceptionist();
	Receptionist getReceptionistById(long id);
	Receptionist updateReceptionist(Receptionist receptionist,long id);
	void deleteReceptionist(long id);
}
