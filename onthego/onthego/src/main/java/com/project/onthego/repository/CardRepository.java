package com.project.onthego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.onthego.model.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

	@Query("select c from Card c where c.Card_Status=1 and c.Card_Num=?1")
	Card findBycardNumber(String cardnumber);
	@Query("select c from Card c where c.Card_Status=1 and c.Card_Id=?1")
	Card findBycardid(int cardid);
}
