package com.witest.web.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name="recruitment")
public class Recruitment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recruit_id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "company_id", nullable = false) // 외래키 null 허용 안함
	private Company company;
	
	@Column(columnDefinition = "TEXT")
	private String position;
	
	@Column(columnDefinition = "TEXT")
	private String compensation;
	
	@Column(columnDefinition = "TEXT")
	private String tech;
	
	@Column(columnDefinition = "LONGTEXT")
	private String contents;
	
}
