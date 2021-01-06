package com.votingsection.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingsection.entities.Section;
import com.votingsection.entities.Vote;
import com.votingsection.exceptions.ComputedVoteException;
import com.votingsection.repositories.VoteRepository;

@Service
public class VoteService {
	
	@Autowired
	private VoteRepository repository;
	
	@Autowired
	private SectionService sectionService;

	public List<Vote> findAll() {
		return repository.findAll();
	}
	
	public Vote findById(Long id) {
		Optional<Vote> obj = repository.findById(id);
		if (obj.isPresent()) return obj.get();
		
		return null; 
	}
	
	public List<Vote> findVotesByScheduleId(Long id) {
		Optional<List<Vote>> obj = repository.findVotesByScheduleId(id);
		if (obj.isPresent()) return obj.get();
		
		return null;
	}
	
	public Vote save(Vote vote, Long section, Long schedule) {
		Section s = sectionService.findByIdAndPautaId(section, schedule);
		if (voteVerify(vote, s)) return repository.save(vote);
		
		return null;
	}
	
	public void delete(Vote obj) {
		repository.delete(obj);
	}
	
	public boolean computedVoteVerify(Vote v) {
		Optional<Vote> votoByCpfAndPauta = repository.findByDocumentAndScheduleId(v.getDocument(), v.getSchedule().getId());
		if (votoByCpfAndPauta.isPresent()) throw new ComputedVoteException();
		
		return true;
	}
	
	private boolean cpfEnabledVote(Vote v) {		
		return true;
	}
	
	private boolean voteVerify(Vote vote, Section section) {
		LocalDateTime time = section.getDate().plusMinutes(section.getTimeValidity());
		
		if (LocalDateTime.now().isAfter(time)) return false;
		if (cpfEnabledVote(vote)) return true;
		if (computedVoteVerify(vote)) return true;
		
		return true;
	}

}
