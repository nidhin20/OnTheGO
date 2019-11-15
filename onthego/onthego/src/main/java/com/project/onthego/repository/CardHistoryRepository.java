package com.project.onthego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.onthego.model.CardHistory;

public interface CardHistoryRepository extends JpaRepository<CardHistory, Integer> {
	@Query("select  c from CardHistory c where c.Is_Debit=1 and c.Card_Id=?1 order by c.Card_History_Id desc")
	CardHistory findBycardHistorybycardNumber(int Cardid);
}
