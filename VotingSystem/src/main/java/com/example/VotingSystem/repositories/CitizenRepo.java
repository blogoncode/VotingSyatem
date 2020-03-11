package com.example.VotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystem.entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer>{

	public Citizen findByName(String name);
}
