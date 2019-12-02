package com.project.onthego.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.onthego.model.BusStops;

public interface BusStopsRepository extends JpaRepository<BusStops, Integer> {
	
}
