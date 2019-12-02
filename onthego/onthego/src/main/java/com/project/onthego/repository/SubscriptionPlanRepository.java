package com.project.onthego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.onthego.model.SubscriptionPlan;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Integer> {
	@Query(nativeQuery = true,value="select top 1 * from SubscriptionPlan u where u.Plan_Id=?1 ")
	SubscriptionPlan findsubscriptionbyplanid(int Planid);
}
