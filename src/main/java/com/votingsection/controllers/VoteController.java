package com.votingsection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votingsection.entities.Vote;
import com.votingsection.services.VoteService;

@RestController
@RequestMapping("/votes")
public class VoteController {
	
	@Autowired
	private VoteService service;

	@GetMapping
	public ResponseEntity<List<Vote>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vote> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Vote> create(@RequestBody Vote obj, @PathVariable Long scheduleID, @PathVariable Long sectionID) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(obj, sectionID, scheduleID));
	}
	
	@GetMapping("/result/{id}")
	public ResponseEntity<List<Vote>> findVotosByPautaId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findVotesByScheduleId(id));
	}

	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Vote obj) {
		service.delete(obj);
        return ResponseEntity.status(HttpStatus.OK).build();
	}
}
