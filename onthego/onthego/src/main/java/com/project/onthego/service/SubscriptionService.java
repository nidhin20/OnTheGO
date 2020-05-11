
package com.project.onthego.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.PaymentDto;
import com.project.onthego.DTO.Subscriptionplandto;
import com.project.onthego.DTO.Usersubscriptiondto;
import com.project.onthego.model.Card;
import com.project.onthego.model.SubscriptionPlan;
import com.project.onthego.model.UserSubscription;
import com.project.onthego.repository.SubscriptionPlanRepository;
import com.project.onthego.repository.UserSubscriptionRepository;
import com.project.onthego.validator.Validatecard;
import com.project.onthego.validator.Validatepayment;
import com.project.onthego.validator.ValidationEngine;
import com.project.onthego.validator.Validationlist;
import com.project.onthego.validator.Validationset;

@Service
public class SubscriptionService {
	@Autowired
	private UserSubscriptionRepository Usersubrepo;

	@Autowired
	private SubscriptionPlanRepository subrepo;

	@Autowired
	private PaymentService paymentservice;
	@Autowired
	private ValidationEngine valengine;
	@Autowired
	private Emailnotificationservice Emailservice;
	List<String> useremail_list;

	public Usersubscriptiondto GetsubscriptionbyCardid(int cardid) {
		Date todaydate = new Date();
		UserSubscription subscription = new UserSubscription();
		Usersubscriptiondto subscriptiondto = new Usersubscriptiondto();
		subscription = Usersubrepo.findsubscriptionbycardid(cardid, todaydate, todaydate);
		BeanUtils.copyProperties(subscription, subscriptiondto);
		return subscriptiondto;

	}

	public void CreateSubcriptionPlan(Subscriptionplandto Subscriptionplan) throws Exception {
		SubscriptionPlan plan = new SubscriptionPlan();
		BeanUtils.copyProperties(Subscriptionplan, plan);
		subrepo.save(plan);
		CheckSubscription cs = new CheckSubscription();
		NotificationService ns = new NotificationService();
		useremail_list = subrepo.findUsersbyEmail();
		Iterator<String> itr = useremail_list.iterator();
		cs.setMessage(
				"New subscription plan has been added with " + Subscriptionplan.getDiscount_rate() + " % discount");

		while (itr.hasNext()) {
			String email = itr.next();
			EmailService es = new EmailService(email);
			ns.Attach(es);
		}
		ns.addSubscriptionlist(cs);

	}

	public void AddSubcriptiontouser(UserSubscription subplandto) {
		Usersubrepo.save(subplandto);
	}

	public void checksubscribtion(Usersubscriptiondto subplan) throws Exception {
		UserSubscription usersubplandmodel = new UserSubscription();
		BeanUtils.copyProperties(subplan, usersubplandmodel);

		CareTaker careTaker = new CareTaker(); // Memento pattern
		usersubplandmodel.setState("Created"); // Memento pattern
		careTaker.add(usersubplandmodel.saveStateToMemento()); // Memento pattern
		usersubplandmodel.setState("Pending payment"); // Memento pattern
		careTaker.add(usersubplandmodel.saveStateToMemento()); // Memento pattern
		Validationlist validation = new Validationlist(); // Visitor pattern
		validation.addvisitor(new Validatecard(subplan.getCard_id())); // Visitor pattern
		validation.addvisitor(new Validatepayment(subplan.getPaymentref())); // Visitor pattern
		Boolean result = validation.validate(valengine);
		if (result) {
			usersubplandmodel.setState("Active"); // Memento pattern
		}
		careTaker.add(usersubplandmodel.saveStateToMemento()); // Memento pattern
		AddSubcriptiontouser(usersubplandmodel);

	}

	public Subscriptionplandto Getsubscriptionbyplanid(int planid) {
		Subscriptionplandto subscriptiondto = new Subscriptionplandto();
		SubscriptionPlan subscription = new SubscriptionPlan();
		subscription = subrepo.findsubscriptionbyplanid(planid);
		BeanUtils.copyProperties(subscription, subscriptiondto);
		return subscriptiondto;

	}
}
