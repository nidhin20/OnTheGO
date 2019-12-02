package com.project.onthego.service;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.DTO.Subscriptionplandto;
import com.project.onthego.DTO.Usersubscriptiondto;
import com.project.onthego.model.SubscriptionPlan;
import com.project.onthego.model.UserSubscription;
import com.project.onthego.repository.SubscriptionPlanRepository;
import com.project.onthego.repository.UserSubscriptionRepository;
@Service
public class SubscriptionService {
	@Autowired
	private UserSubscriptionRepository Usersubrepo;

	@Autowired
	private SubscriptionPlanRepository subrepo;
	public Usersubscriptiondto GetsubscriptionbyCardid(int cardid) {
		Date todaydate = new Date();
		UserSubscription subscription= new UserSubscription();
		Usersubscriptiondto subscriptiondto= new Usersubscriptiondto();
		subscription= Usersubrepo.findsubscriptionbycardid(cardid, todaydate, todaydate);
		BeanUtils.copyProperties(subscription, subscriptiondto);
		return subscriptiondto;

	}
	public void CreateSubcriptionPlan(Subscriptionplandto Subscriptionplan) {
		SubscriptionPlan plan= new SubscriptionPlan();
		BeanUtils.copyProperties(Subscriptionplan, plan);
		subrepo.save(plan);
	}
	public void AddSubcriptiontouser(Subscriptionplandto subplandto) {
		UserSubscription usersubplandmodel= new UserSubscription();
		BeanUtils.copyProperties(subplandto, usersubplandmodel);
		Usersubrepo.save(usersubplandmodel);
	}
	public Subscriptionplandto Getsubscriptionbyplanid(int planid) {
		Subscriptionplandto subscriptiondto = new Subscriptionplandto();
		SubscriptionPlan subscription = new SubscriptionPlan();
		subscription= subrepo.findsubscriptionbyplanid(planid);
		BeanUtils.copyProperties(subscription, subscriptiondto);
		return subscriptiondto;

	}
}
