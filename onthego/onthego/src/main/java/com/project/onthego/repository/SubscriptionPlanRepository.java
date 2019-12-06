package com.project.onthego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.onthego.model.SubscriptionPlan;
import com.project.onthego.model.User;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Integer> {

	@Query("select u.email from User u join UserMembership um on u.id=um.User_Id join  UserSubscription us on um.Card_Id=us.Card_id join SubscriptionPlan sp on us.plan_Id=sp.Plan_Id")
	List<String> findUsersbyEmail();

	@Query(nativeQuery = true,value="select * from SubscriptionPlan u where u.Plan_Id=?1 ")
	SubscriptionPlan findsubscriptionbyplanid(int Planid);

}
