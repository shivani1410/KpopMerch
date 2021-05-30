package com.infinite.kpopMerch.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinite.kpopMerch.Models.season_greeting;
import com.infinite.kpopMerch.Repository.SeasonGreetingRepo;

@Service
public class SeasonGreetingsServiceImpl implements SeasonGreetingsService {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	SeasonGreetingRepo seasonGreetingRepo;
	@SuppressWarnings("unchecked")
	@Override
	public List<season_greeting> getAllSeasonGreeting(int offset) {

	return seasonGreetingRepo.getSeasonGreetingUsingNativeQuery(offset);

	}

	@Override
	public List<season_greeting> getSeasonGreetingByArtistId(String id) throws JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}
