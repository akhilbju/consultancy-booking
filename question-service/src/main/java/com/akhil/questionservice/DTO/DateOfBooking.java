package com.akhil.questionservice.DTO;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class DateOfBooking implements Serializable{
	
	@Id
	@GenericGenerator(name = "id",strategy = "increment")
	@GeneratedValue(generator = "id")
	private int id;
	@Temporal(TemporalType.DATE)
	private LocalDate date;
	private String time;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")  
	private user user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "DateOfBooking [booking_id=" + 
	id + ", booking_date=" + date + ", booking_time="
				+ time + ", doctor=" + doctor + ", patient=" + user + "]";
	}
	
	public DateOfBooking( LocalDate date, String time, Doctor doctor,
			com.akhil.questionservice.DTO.user user) {
		super();
		this.date = date;
		this.time = time;
		this.doctor = doctor;
		this.user = user;
	}
	public DateOfBooking() {
		super();
	}
	
	
	
}
