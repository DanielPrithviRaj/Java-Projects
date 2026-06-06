package com.alert.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.alert.enums.BloodGroup;
import com.alert.enums.Gender;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@Getter
@Setter
public class Patient {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "patient_hospital_number", nullable=false, unique=true, length=20)
	private String patientHospitaNumber;
	
	@Column(name= "full_name", nullable=false, length=100)
	private String fullName;
	
	@Column(name= "dob", nullable=false)
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "gender", nullable=false)
	private Gender gender;
	
	@Column(name= "phone", nullable=false, length=20)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "blood_group", nullable=false)
	private BloodGroup bloodGroup;
	
	@Column(name= "created_at", updatable=false)
	private LocalDateTime createdAt;
	
	@PrePersist
	protected void onCreate() {
		if(this.createdAt == null) {
			this.createdAt = LocalDateTime.now();
		}
	}
	
}
