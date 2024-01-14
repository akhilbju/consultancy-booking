package com.akhil.questionservice.DTO;

import java.io.Serializable;
import java.util.List;



import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
public class user implements Serializable{
	@Id
	@GenericGenerator(name = "id",strategy = "increment")
	@GeneratedValue(generator = "id")
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@OneToMany(mappedBy =  "user",fetch = FetchType.EAGER)
	private List<DateOfBooking> dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<DateOfBooking> getDob() {
		return dob;
	}
	public void setDob(List<DateOfBooking> dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "user [user_id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dob="
				+ dob + "]";
	}
	public user() {
		super();
	}
}
