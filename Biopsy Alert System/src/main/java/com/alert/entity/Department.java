package com.alert.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
public class Department {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "department_code", nullable=false, unique=true)
		private int departmentCode;
		
		@Column(name ="department_name", nullable=false, unique=true, length=50)
		private String departmentName;
		
		@Column(name= "created_at", updatable=false)
		private LocalDateTime createdAt;
		
		@PrePersist
		protected void onCreate() {
			if(this.createdAt == null) {
				this.createdAt = LocalDateTime.now();
			}
		}
}
