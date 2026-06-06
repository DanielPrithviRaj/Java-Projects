package com.alert.entity;

import java.time.LocalDateTime;

import com.alert.enums.Role;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name= "employee_id", nullable=false, unique=true, length=10)
		private String employeeId;
		
		@Column(name= "fullname", nullable = false, length = 100)
	    private String fullName;

	    @Column(name= "password", nullable = false)
	    private String password;

	    @Enumerated(EnumType.STRING)
	    @Column(name= "role", nullable=false)
	    private Role role;

	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private Department departmentId;

	    @Column(name= "email", length = 100)
	    private String email;

	    @Column(name= "phone", length = 20)
	    private String phone;

	    @Column(name= "created_at", updatable=false)
		private LocalDateTime createdAt;
		
		@PrePersist
		protected void onCreate() {
			if(this.createdAt == null) {
				this.createdAt = LocalDateTime.now();
			}
		}

}

