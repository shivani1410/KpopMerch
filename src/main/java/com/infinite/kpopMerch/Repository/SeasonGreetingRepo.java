package com.infinite.kpopMerch.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infinite.kpopMerch.Models.season_greeting;

public interface SeasonGreetingRepo extends CrudRepository<season_greeting,Serializable>{
	@Query(value="SELECT * FROM season_greeting sg "
			+ " ORDER BY sg.sg_id ASC LIMIT 3 OFFSET :offset", nativeQuery = true)
	List<season_greeting> getSeasonGreetingUsingNativeQuery(@Param("offset") int offset);

}
