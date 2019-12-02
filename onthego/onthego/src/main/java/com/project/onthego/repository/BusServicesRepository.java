package com.project.onthego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.project.onthego.model.BusServices;

public interface BusServicesRepository extends JpaRepository<BusServices, Integer> {
	@Query(value="select b from BusServices b where b.Bus_Srvc_Id=:Serviceid")
	BusServices Getbusservicebyid(@Param("Serviceid") int Serviceid);
	
}
