package com.votingsection.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.votingsection.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

	Optional<Section> findByIdAndScheduleId(Long section, Long schedule);

}
