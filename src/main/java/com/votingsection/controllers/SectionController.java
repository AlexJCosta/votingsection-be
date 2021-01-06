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

import com.votingsection.entities.Section;
import com.votingsection.services.SectionService;

@RestController
@RequestMapping("/sections")
public class SectionController {
	
	@Autowired
	private SectionService service;

	@GetMapping
	public ResponseEntity<List<Section>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Section> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Section> create(@RequestBody Section obj) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(obj));
	}
	
	@PutMapping
	public ResponseEntity<Section> update(@RequestBody Section obj) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(obj));
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Section obj) {
		service.delete(obj);
        return ResponseEntity.status(HttpStatus.OK).build();
	}

}
