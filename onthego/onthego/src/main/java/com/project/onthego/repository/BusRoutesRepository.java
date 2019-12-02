package com.project.onthego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.onthego.model.BusRoutes;

public interface BusRoutesRepository extends JpaRepository<BusRoutes, Integer> {
	@Query(value="select * from BusRoutes b where b.Bus_Route_Id=:BusRouteid and b.Bus_Stop_Id=:stopid",nativeQuery=true)
	BusRoutes Getbusroutestopinfobystopid(@Param("BusRouteid") int BusRouteid,@Param("stopid") int stopid);
	@Query(value="select * from BusRoutes b where b.Bus_Route_Id=:BusRouteid order by b.Stop_Seqnce_Id desc limit 1",nativeQuery=true)
	BusRoutes GetMaxsequenceidbyroute(@Param("BusRouteid") int BusRouteid);
	
}
