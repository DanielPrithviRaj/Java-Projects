package com.alert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alert.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
