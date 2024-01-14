package com.akhil.questionservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhil.questionservice.DTO.user;

@Repository
public interface userDAO extends JpaRepository<user, Integer>{

	user findByEmailAndPassword(String email, String pass);

}
