package com.votingsection.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.votingsection.entities.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

	Optional<Vote> findByDocumentAndScheduleId(String document, Long id);

	Optional<List<Vote>> findVotesByScheduleId(Long id);

}
