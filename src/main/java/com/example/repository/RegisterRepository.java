package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Register;
@Repository
public interface RegisterRepository extends JpaRepository<Register,Long> {


	
	
}
