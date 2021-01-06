package com.votingsection.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.votingsection.enunmerations.Option;

import lombok.Data;

@Data
@Entity
@Table(name = "vote")
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=14, max=14)
	private String document;
	
	@NotNull
    @Enumerated(EnumType.STRING)
	private Option optionVote;
	
	@ManyToOne
    private Schedule schedule;
}
