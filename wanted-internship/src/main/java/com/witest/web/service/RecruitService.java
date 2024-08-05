package com.witest.web.service;

import org.springframework.stereotype.Service;

import com.witest.web.domain.Recruitment;
import com.witest.web.repository.RecruitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitService {

	private final RecruitRepository recruitRepository;

	public Recruitment save(Recruitment recruitment) {
		return recruitRepository.save(recruitment);
	}

	public Recruitment editRecruitment(Recruitment recruitment, int id) {
		/*
		 * Recruitment getRecruitment = findRecruitment(id);
		 * getRecruitment.setContents(recruitment.getContents());
		 * getRecruitment.setPosition(recruitment.getPosition());
		 * getRecruitment.setCompensation(recruitment.getCompensation());
		 * getRecruitment.setTech(recruitment.getTech());
		 */
		return recruitRepository.save(null);
	}

}
