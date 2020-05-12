/**
 * 
 */
package com.project.onthego.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.onthego.model.UserSubscription;

/**
 * @author Nidhin
 *
 */
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer> {

	@Query(nativeQuery = true,value="select * from UserSubscription u where u.Card_Id=?1 and u.Subs_Start_Dt <= ?2 and ?3 <= u.Subs_End_Dt LIMIT 1")
	UserSubscription findsubscriptionbycardid(int Cardid,Date startdate,Date Tilldate);
	
}
