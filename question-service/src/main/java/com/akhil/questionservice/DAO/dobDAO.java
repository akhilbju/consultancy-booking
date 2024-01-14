package com.akhil.questionservice.DAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akhil.questionservice.DTO.DateOfBooking;

@Repository
public interface dobDAO extends JpaRepository<DateOfBooking, Integer>{


	DateOfBooking findByDateAndTime(LocalDate date, String time);
	
	List<DateOfBooking> findByUserId(int id);

}
