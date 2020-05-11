package com.project.onthego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.onthego.model.CardHistory;
import com.project.onthego.service.TravelHistory;
import com.project.onthego.service.TravelHistoryInterface;

public interface CardHistoryRepository extends JpaRepository<CardHistory, Integer> {
	@Query(nativeQuery = true,value="select * from CardHistory c where c.Is_Debit=1 and c.Card_Id=?1 order by c.Card_History_Id desc LIMIT 1")
	CardHistory findBycardHistorybycardNumber(int Cardid);
	@Query(nativeQuery = true,value="select c.Created_Date,bs.Bus_Route_Id,bs.Bus_Start_Time, bi.Bus_Stop_Nm as Startstop, bo.Bus_Stop_Nm as 'Endstop', c.Amount,c.Is_Debit from CardHistory c inner join BusStops bi on bi.Bus_Stop_Id=c.Check_In_BusStop inner join BusStops bo on bo.Bus_Stop_Id=c.Check_Out_BusStop inner join BusServices bs on bs.Bus_Srvc_Id=c.Bus_Servce_Id where Card_Id=?1 order by c.Created_Date asc")
	List<TravelHistoryInterface> getcarddetails(int Cardid);
	@Query(nativeQuery=true, value="select count(1) from CardHistory c where c.Bus_Servce_Id=?1 and DATEDIFF( Check_in, CURDATE()) =0")
	int getbususersbyserviceid(int serviceid);
	
	
}
