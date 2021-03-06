package com.votingsection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votingsection.entities.Schedule;
import com.votingsection.services.ScheduleService;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
	
	@Autowired
	private ScheduleService service;

	@GetMapping
	public ResponseEntity<List<Schedule>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Schedule> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Schedule> create(@RequestBody Schedule obj) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(obj));
	}
	
	@PutMapping
	public ResponseEntity<Schedule> update(@RequestBody Schedule obj) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(obj));
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Schedule obj) {
		service.delete(obj);
        return ResponseEntity.status(HttpStatus.OK).build();
	}
}
