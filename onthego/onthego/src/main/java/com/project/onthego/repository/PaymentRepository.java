package com.project.onthego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.project.onthego.model.Payment;


public interface PaymentRepository extends JpaRepository<Payment,Integer> {

	@Query(value="Select p.Paymnt_Reference_Nbr from Payment p ORDER BY p.Paymnt_Reference_Nbr DESC LIMIT 1",nativeQuery=true)
	String findbyrefid();
	
	@Query(value="Select * from Payment where Paymnt_Reference_Nbr=?1",nativeQuery=true)
	Payment findpaymentbyrefid(String refno);
}
