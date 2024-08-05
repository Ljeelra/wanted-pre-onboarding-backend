package com.witest.web.dto;

import lombok.Data;

@Data
public class RecruitDTO {
	private int recruit_id, company_id;
	private String position, compensation, contents, tech;
}
