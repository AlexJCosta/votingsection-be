package com.votingsection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingsection.entities.Section;
import com.votingsection.repositories.SectionRepository;

@Service
public class SectionService {
	
	@Autowired
	private SectionRepository repository;

	public List<Section> findAll() {
		return repository.findAll();
	}
	
	public Section findById(Long id) {
		Optional<Section> obj = repository.findById(id);
		if (obj.isPresent()) return obj.get();
		return null; 
	}
	
	public Section save(Section obj) {
		return repository.save(obj);
	}
	
	public void delete(Section obj) {
		repository.delete(obj);
	}

	public Section findByIdAndPautaId(Long section, Long schedule) {
		Optional<Section> obj = repository.findByIdAndScheduleId(section, schedule);
		if (obj.isPresent()) return obj.get();
		return null;
	}

}
