package com.witest.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.witest.web.domain.Company;
import com.witest.web.domain.Recruitment;
import com.witest.web.repository.companyRepository;
import com.witest.web.service.RecruitService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@AutoConfigureMockMvc
class RecruitTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	RecruitService recruitService;
	
	@Autowired
	private companyRepository companyRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Company company;
	
	@BeforeEach
	@Transactional
    public void setUp() {
        // DB에 이미 저장되어 있는 Company 엔티티를 불러오기
        company = companyRepository.findById(1).orElseThrow(() -> new IllegalArgumentException("Company not found"));

	}
	
	@Test
	@Transactional
	public void createRecruitment() throws JsonProcessingException, Exception {
			
		Recruitment recruitment = new Recruitment();
        recruitment.setContents("Test content");
        recruitment.setCompensation("Test compensation");
        recruitment.setTech("Test skill");
        recruitment.setPosition("Test position");
        recruitment.setCompany(company);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/recruitment/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recruitment)))
                .andExpect(MockMvcResultMatchers.status().isOk());
	}

}
