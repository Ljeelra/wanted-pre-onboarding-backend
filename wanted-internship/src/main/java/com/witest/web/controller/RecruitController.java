package com.witest.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.witest.web.domain.Recruitment;
import com.witest.web.service.RecruitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruitment")
public class RecruitController {
	
	private final RecruitService recruitService;
	
	@PostMapping("/create")
	public void create(@RequestBody Recruitment recruitment){
		Recruitment post = recruitService.save(recruitment);
	}
	
	@GetMapping("/board")
	public String postBoard() {
		return "board";
	}
	
	@PutMapping("/update/{recruitid}")
	public void update(@PathVariable int id, @RequestBody Recruitment recruitment){
		Recruitment postEdit = recruitService.editRecruitment(recruitment, id);
	}
	
	@DeleteMapping
	public void delete() {}
	
	
}
