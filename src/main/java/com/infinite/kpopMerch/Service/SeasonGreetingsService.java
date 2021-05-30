package com.infinite.kpopMerch.Service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinite.kpopMerch.Models.season_greeting;

public interface SeasonGreetingsService {
	public List<season_greeting> getAllSeasonGreeting(int offset);

	public List<season_greeting> getSeasonGreetingByArtistId(String id) throws JsonProcessingException;
}
