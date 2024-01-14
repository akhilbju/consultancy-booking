package com.akhil.questionservice.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.questionservice.DAO.dobDAO;
import com.akhil.questionservice.DAO.doctorDAO;
import com.akhil.questionservice.DAO.hospitalDAO;
import com.akhil.questionservice.DAO.userDAO;
import com.akhil.questionservice.DTO.DateOfBooking;
import com.akhil.questionservice.DTO.Doctor;
import com.akhil.questionservice.DTO.Hospital;
import com.akhil.questionservice.DTO.user;

@Service
public class logService {
	
	@Autowired
	private userDAO users;
	@Autowired
	private hospitalDAO hos;
	@Autowired
	private dobDAO dob;
	@Autowired
	private doctorDAO doc;
	
	public user log(String email,String pass) {
		return users.findByEmailAndPassword(email,pass);
	}
	
	public void save(user user1) {
		user i = users.save(user1);
		System.out.println(i);
	}
	
	public List<Hospital> gethos() {
		return hos.findAll();
	}
	
	public List<Doctor> getdoc(int id){
		Optional<Hospital> hospital = hos.findById(id);
		List<Doctor> doctors = hospital.get().getDoctors();
		return doctors;
	}
	
	public DateOfBooking getDate(LocalDate date,String time) {
		DateOfBooking DOB = dob.findByDateAndTime(date,time);
		return DOB;
	}

	public Doctor getDoctor(int id) {
		return doc.getById(id);
	}
	public user getuser(int id) {
		return users.getById(id);
	}
	
	public void savedob(DateOfBooking date) {
		dob.save(date);
	}
	public List<DateOfBooking> getBooking(int id){
		return dob.findByUserId(id);
	}

	public user update(user user1) {
		user use = users.save(user1);
		return use;
	}
	

}
