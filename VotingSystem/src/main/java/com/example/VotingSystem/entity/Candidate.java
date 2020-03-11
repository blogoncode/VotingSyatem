package com.example.VotingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="candidates")
@Entity
public class Candidate {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="candidate_name")
	private String name;
	
	@Column(name="numberOfVotes")
	private Integer numberOfVotes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Candidate(Integer id, String name, Integer numberOfVotes) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfVotes = numberOfVotes;
	}
	
	public Candidate() {
	}

	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	
}
