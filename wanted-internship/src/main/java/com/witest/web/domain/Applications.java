package com.witest.web.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="applications")
public class Applications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apply_id;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "user_id")
	 private User user;

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "recruit_id")
	 private Recruitment recruitment;
}
