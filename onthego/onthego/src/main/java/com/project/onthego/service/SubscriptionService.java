
package com.project.onthego.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
	
	List<String> useremail_list;
	
	public Usersubscriptiondto GetsubscriptionbyCardid(int cardid) {
		Date todaydate = new Date();
		UserSubscription subscription= new UserSubscription();
		Usersubscriptiondto subscriptiondto= new Usersubscriptiondto();
		subscription= Usersubrepo.findsubscriptionbycardid(cardid, todaydate, todaydate);
		BeanUtils.copyProperties(subscription, subscriptiondto);
		return subscriptiondto;

	}
	public void CreateSubcriptionPlan(Subscriptionplandto Subscriptionplan) throws Exception {
		SubscriptionPlan plan= new SubscriptionPlan();
		BeanUtils.copyProperties(Subscriptionplan, plan);
		subrepo.save(plan);
		CheckSubscription cs=new CheckSubscription();
		NotificationService ns=new NotificationService();
		useremail_list=subrepo.findUsersbyEmail();
		Iterator<String>itr=useremail_list.iterator();
		cs.setMessage("New subscription plan has been added with "+Subscriptionplan.getDiscount_rate()+ " % discount");
		
		while(itr.hasNext())
		{
			String email=itr.next();
			EmailService es=new EmailService(email);
			ns.Attach(es);
		}
		ns.addSubscriptionlist(cs);
		
	}
	public void AddSubcriptiontouser(Usersubscriptiondto subplandto) {
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
