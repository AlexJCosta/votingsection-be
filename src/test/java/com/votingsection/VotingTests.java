package com.votingsection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.votingsection.entities.Schedule;
import com.votingsection.entities.Section;
import com.votingsection.entities.Vote;
import com.votingsection.repositories.ScheduleRepository;
import com.votingsection.repositories.VoteRepository;
import com.votingsection.services.VoteService;

@SpringBootTest
public class VotingTests {

	//Mock
	@Mock
	private VoteRepository voteRepo;
	
	@Mock
	private ScheduleRepository scheduleRepo;
	
	//Service
	@Autowired
	private VoteService vService;

	@Before(value = "")
	public void setup() {
		MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void computedVoteVerify() {
		Schedule schedule = new Schedule();
		schedule.setId(anyLong());
		
		Section section = new Section();
		section.setDate(LocalDateTime.now());
		section.setTimeValidity(-1L);
		section.setSchedule(schedule);

		Vote v = new Vote();
		v.setDocument("00099988800");
		v.setSchedule(schedule);
		
		when(voteRepo.findByDocumentAndScheduleId(anyString(), anyLong())).thenReturn(Optional.empty());
		
		vService.computedVoteVerify(v);
	}
	
	@Test
	public void votesTest() {
		Schedule schedule = new Schedule();
		schedule.setId(anyLong());
		
		Section section = new Section();
		section.setDate(LocalDateTime.now());
		section.setTimeValidity(-1L);
		section.setSchedule(schedule);

		Vote v = new Vote();
		v.setDocument("00099988801");
		v.setSchedule(schedule);
		
		Vote vSaved = voteRepo.save(v);
				
		assertEquals(voteRepo.findById(v.getId()).get().getId(), vSaved.getId());		
	}
	
}
