package com.project.onthego.controller;

import java.io.File;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.Subscriptionplandto;
import com.project.onthego.DTO.Usersubscriptiondto;
import com.project.onthego.model.User;
import com.project.onthego.proxy.RealInternet;
import com.project.onthego.service.CardService;
import com.project.onthego.service.CommonService;
import com.project.onthego.service.SubscriptionService;
import com.project.onthego.validator.DataConstants;
import com.project.onthego.view.Subscriptionview;
import com.project.onthego.view.Usersubscriptionview;
import com.squareup.okhttp.Response;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/")
public class SubscriptionController {
	@Autowired
	private CommonService commonservice;

	@Autowired
	private SubscriptionService Subscriptionservice;
	@Autowired
	private CardService Cardservice;

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("Subscrption/Addsubscription")
	public ResponseEntity<Object> AddSubscription(@Valid @RequestBody Subscriptionview Subsciption) {
		try {
			User Loggedinuser = commonservice.Getloggedinuserdetails();
			Subscriptionplandto subplandto = new Subscriptionplandto();
			BeanUtils.copyProperties(Subsciption, subplandto);
			Date today = new Date();
			subplandto.setCreated_By(Loggedinuser.getId());
			subplandto.setCreated_Date(today);
			subplandto.setUpdated_By(Loggedinuser.getId());
			subplandto.setUpdated_Date(today);
			Subscriptionservice.CreateSubcriptionPlan(subplandto);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.APPLICATIONCOMMONERROR);

		}
	}

	@PostMapping("UserSubscrption/Addsubscription")
	public ResponseEntity<Object> AddSubscriptiontouser(@Valid @RequestBody Usersubscriptionview Usersubscription) {
		try {
			User loggedinuser = commonservice.Getloggedinuserdetails();
			Subscriptionplandto subplandto = Subscriptionservice.Getsubscriptionbyplanid(Usersubscription.getPlanid());
			if (subplandto.getPlan_Id() != Usersubscription.getPlanid()) {
				return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
						.body("Plan does not exist in the system");
			}
			Usersubscriptiondto usersubdto = new Usersubscriptiondto();
			Carddto card = Cardservice.GetCarddetailsbycardID(Usersubscription.getCardnumber());
			Date currentdate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentdate);
			c.add(Calendar.DATE, subplandto.getSub_Period());
			Date endperiod = c.getTime();

			usersubdto.setSubs_Start_Dt(currentdate);
			usersubdto.setSubs_End_Dt(endperiod);
			usersubdto.setCard_id(card.getCard_Id());
			usersubdto.setPlan_Id(Usersubscription.getPlanid());
			usersubdto.setDiscount(subplandto.getDiscount_rate());
			usersubdto.setPaymentref(Usersubscription.getRefno());
			usersubdto.setUpdated_By(loggedinuser.getId());
			usersubdto.setUpdated_Date(currentdate);
			usersubdto.setCreated_By(loggedinuser.getId());
			usersubdto.setCreated_Date(currentdate);
		
			Subscriptionservice.checksubscribtion(usersubdto);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
		} catch (Exception ex) {

			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.APPLICATIONCOMMONERROR);

		}
	}

}
