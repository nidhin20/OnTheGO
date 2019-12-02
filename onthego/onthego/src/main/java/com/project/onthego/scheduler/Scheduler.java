package com.project.onthego.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler implements Container {

	public List<Object> cardhistory=new ArrayList<Object>();
	
	public Scheduler(List<Object> obj_list)
	{
		this.cardhistory=obj_list;
	}
	@Override
	public Iterator_pattern getIterator() {
	
		return new CardIterator();
	}
	
private class CardIterator implements Iterator_pattern
{
   int no;
   
   @Override
	public boolean hasNext() {
	   
	   if(no<cardhistory.size())
	   {
		   return true;
	   }
		return false;
	}
   
	@Override
	public Object next() {
		
		if(this.hasNext())
		{
			return cardhistory.get(no++);
		}
		return null;
	}

	
	
}
}
