package com.alert.entity;

import java.time.*;

import com.alert.enums.ReportStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "biopsy_orders")
@NoArgsConstructor
@Getter
@Setter
public class BiopsyOrder {
	
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
	@JoinColumn(name = "department_id", nullable=false)
	private User departmentId;

	@Column(name = "order_date", updatable = false)
	private LocalDateTime orderDate;
	
	@PrePersist
    protected void onCreate() {
        if (this.orderDate == null) {
            this.orderDate = LocalDateTime.now();
        }
	}

	@Column(name = "sample_collected_date")
	private LocalDateTime sampleCollectedDate;

	@Column(name = "reported_date")
	private LocalDateTime reportedDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable=false)
	private ReportStatus status = ReportStatus.PENDING;

	@Column(columnDefinition = "TEXT")
    	private String notes;
		
}
