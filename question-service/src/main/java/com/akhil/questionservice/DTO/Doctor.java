package com.akhil.questionservice.DTO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
public class Doctor implements Serializable{
	@Id
	@GenericGenerator(name = "id",strategy = "increment")
	@GeneratedValue(generator = "id")
	private int id;
	private String Doctor_name;
	private String specialization;
	@ManyToOne
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	@OneToMany(mappedBy = "doctor",fetch = FetchType.EAGER)
	private List<DateOfBooking> date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctor_name() {
		return Doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		Doctor_name = doctor_name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public List<DateOfBooking> getDate() {
		return date;
	}
	public void setDate(List<DateOfBooking> date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Doctor [Doctor_id=" + id + ", Doctor_name=" + Doctor_name + ", specialization=" + specialization
				+ ", hospital=" + hospital + ", date=" + date + "]";
	}
	public Doctor() {
		super();
	}

}
