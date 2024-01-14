package com.akhil.questionservice.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhil.questionservice.DTO.Doctor;
import com.akhil.questionservice.DTO.Hospital;

@Repository
public interface hospitalDAO extends JpaRepository<Hospital, Integer>{



}
