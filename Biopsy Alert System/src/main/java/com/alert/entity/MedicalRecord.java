package com.alert.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medical_records")
@NoArgsConstructor
@Getter
@Setter
public class MedicalRecord {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "patient_id", nullable=false)
		private Patient patientId;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "doctor_id", nullable=false)
		private User doctorId;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "biopsy_order_id", nullable=false)
		private User biopsyOrderId;
		
		@Column(name = "diagnosis", nullable=false, length=255)
		private String diagnosis;
		
		@Column(columnDefinition = "TEXT")
		private String reportDetails;
		
		@Column(name = "created_at", updatable=false)
		private LocalDateTime createdAt;
		
		@PrePersist
		protected void OnCreate() {
			if(this.createdAt == null) {
				this.createdAt = LocalDateTime.now();
			}
		}
		
}
