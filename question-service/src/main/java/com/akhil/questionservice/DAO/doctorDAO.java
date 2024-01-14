package com.akhil.questionservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.questionservice.DTO.Doctor;

public interface doctorDAO extends JpaRepository<Doctor, Integer>{

}
