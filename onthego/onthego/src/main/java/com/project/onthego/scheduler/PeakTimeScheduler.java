
package com.project.onthego.scheduler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.onthego.model.CardHistory;
import com.project.onthego.model.PeakTime;
import com.project.onthego.repository.PeakTimeRepository;

@Component
public class PeakTimeScheduler {
	
	@Autowired
	PeakTimeRepository peakTimeRepository;
	
	
	
	@Scheduled(cron = "0 05 00 * * ?")
	public void schedulerjob()
	
	{
		
		PeakTime peakTime=new PeakTime();
	
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
		String day =simpleDateFormat.format(date);
		List<CardHistory> peaktime = peakTimeRepository.getbydate(day);
		List<Object> objectlist=new ArrayList<Object>();
		for(int i=0;i<peaktime.size();i++)
		{
			objectlist.add(peaktime.get(i));	
		}
		Scheduler schedule=new Scheduler(objectlist);
		ArrayList<Integer> hour = new ArrayList<Integer>();
		for(Iterator_pattern itr = schedule.getIterator(); itr.hasNext();)
		{
		
			hour.add(((CardHistory) itr.next()).getCheck_In().getHours());
			
		}
		
		 Collections.sort(hour);
		 int max = 0;
	      int curr = 0;
	      int secondpeakhour=0;
	      int firstpeakhour = 0  ;
	      Set<Integer> unique = new HashSet<Integer>(hour);

	          for (Integer key : unique) {
	                curr = Collections.frequency(hour, key);

	               if(max <= curr){
	            	 secondpeakhour = firstpeakhour;
	                 max = curr;
	                 firstpeakhour = key;
	                }
	            }
	         System.out.print("Highest : "+firstpeakhour+" Second: "+secondpeakhour );
	          
	          Date date1=new Date();
	  		  peakTime.setCurrDate(date1);
	          peakTime.setDay(day);
	          peakTime.setFirstpeakhour(firstpeakhour);
	          peakTime.setSecondpeakhour(secondpeakhour);
	          
	          peakTimeRepository.save(peakTime);
	          
		
		
		
	}

	
}