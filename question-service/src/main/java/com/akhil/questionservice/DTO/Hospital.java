package com.akhil.questionservice.DTO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
public class Hospital implements Serializable{
	
	@Id
	@GenericGenerator(name = "id",strategy = "increment")
	@GeneratedValue(generator = "id")
	private int id;
	private String name;
	@OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
	private List<Doctor> doctors;
	public int getHospital_id() {
		return id;
	}
	public void setHospital_id(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	@Override
	public String toString() {
		return "Hospital []";
	}
	public Hospital() {
		super();
	}

}
