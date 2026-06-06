package com.alert.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notifications")
@NoArgsConstructor
@Getter
@Setter
public class Notification {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "user_id", nullable=false)
	private User userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "biopsy_order_id", nullable=false)
	private BiopsyOrder biopsyOrderId;
	
	@Column(name = "message", nullable=false, length=255)
	private String message;
	
	@Column(name= "is_read")
	private Boolean isRead;
	
	@Column(name = "created_at", updatable=false)
	private LocalDateTime createdAt;
	
	@PrePersist
	protected void OnCreate() {
		if(this.createdAt == null) {
			this.createdAt = LocalDateTime.now();
		}
	}
	
	
}
