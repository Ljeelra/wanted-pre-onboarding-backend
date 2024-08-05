package com.witest.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.witest.web.domain.Company;
import com.witest.web.domain.Recruitment;

@Repository
public interface companyRepository extends JpaRepository<Company, Integer >{
}
