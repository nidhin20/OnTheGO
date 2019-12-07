package com.project.onthego.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.onthego.model.CardHistory;
import com.project.onthego.model.PeakTime;
import com.project.onthego.model.User;

public interface PeakTimeRepository extends JpaRepository<PeakTime,Integer> {

	 @Query(value="Select c from CardHistory c where c.Day_Of_Week=:day")
	List<CardHistory> getbydate(@Param("day") String day); 
	

}
