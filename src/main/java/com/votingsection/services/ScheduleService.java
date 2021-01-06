package com.votingsection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingsection.entities.Schedule;
import com.votingsection.repositories.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository repository;

	public List<Schedule> findAll() {
		return repository.findAll();
	}
	
	public Schedule findById(Long id) {
		Optional<Schedule> obj = repository.findById(id);
		if (obj.isPresent()) return obj.get();
		return null; 
	}
	
	public Schedule save(Schedule obj) {
		return repository.save(obj);
	}
	
	public void delete(Schedule obj) {
		repository.delete(obj);
	}


}
