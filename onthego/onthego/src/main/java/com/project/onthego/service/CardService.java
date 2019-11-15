package com.project.onthego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.model.Card;
import com.project.onthego.model.CardHistory;
import com.project.onthego.repository.CardHistoryRepository;
import com.project.onthego.repository.CardRepository;
@Service
public class CardService {
	@Autowired
	private CardRepository cardrepo;
	@Autowired
	private CardHistoryRepository cardHistoryrepo;
	public Card GetCarddetailsbycardID(String cardNum)
	{
		return cardrepo.findBycardNumber(cardNum);
		
	}
	public void CreateCardHistory(CardHistory cardhis)
	{
		cardHistoryrepo.save(cardhis);
		
	}
	public CardHistory GetCardHistory(CardHistory cardhis)
	{
		return cardHistoryrepo.findBycardHistorybycardNumber(cardhis.getCard_Id());
		
	}	 
}
