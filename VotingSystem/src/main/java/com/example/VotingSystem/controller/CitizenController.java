package com.example.VotingSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.VotingSystem.entity.Candidate;
import com.example.VotingSystem.entity.Citizen;
import com.example.VotingSystem.repositories.CandidateRepo;
import com.example.VotingSystem.repositories.CitizenRepo;


@Controller
public class CitizenController {

	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@RequestMapping("/")
	public String goToVote() { 
		return "vote.html";
	}
	
	@RequestMapping("/doCheckVoted")
	public String hasVoted(@RequestParam String name, Model model, HttpSession session) {
		
		Citizen citizen = citizenRepo.findByName(name);
		session.setAttribute("citizen", citizen);
		
		if (!citizen.getHasVoted()) {
			List<Candidate> candiates = candidateRepo.findAll();
			model.addAttribute("candiates", candiates);
			
			return "/performedVote.html";
		} else {
			return "/alreadyVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Integer id, HttpSession session) {
		
		Citizen citizen = (Citizen) session.getAttribute("citizen");
		
		if(!citizen.getHasVoted()) {
			Candidate c = candidateRepo.findById((int)id);
			c.setNumberOfVotes(c.getNumberOfVotes() + 1);
			
			citizen.setHasVoted(true);
			citizenRepo.save(citizen);
			candidateRepo.save(c);			
			return "/voted.html";
		}
		return "alreadyVoted.html";
 		
	}
	
	/*@RequestMapping("/doAction")
	public String doAction() {
		Citizen c = new Citizen((long)1, "abc");
		cRepo.save(c);
		
		return "success";
	}*/
}
