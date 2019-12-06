package com.project.onthego.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.project.onthego.DTO.Carddto;
import com.project.onthego.model.UserMembership;
import com.project.onthego.repository.UserMembershipRepository;
@Service
public class CardLinkservice {
	private CardService Cardservice;
	private UserMembershipRepository UserMembershipRepo;
//	private String Cardnum;
//	private int userid;
	public CardLinkservice(CardService card,UserMembershipRepository UserMembership) {
//		Cardnum=Cardno;
//		userid=user;
		Cardservice=card;
		UserMembershipRepo=UserMembership;
	}
	public String Linkcardtouser(String Cardnum,int userid) {
		Carddto carddetails = Cardservice.GetCarddetailsbycardID(Cardnum);
		if (carddetails == null) {
			return "102";

		} else {
			UserMembership Cardmembership = Cardservice.getusermembershipbycard(carddetails.getCard_Id());
			if (Cardmembership != null) {
				return "103";
			} else {
				Date today = new Date();
				UserMembership usermember = new UserMembership();
				usermember.setUser_Id(userid);
				usermember.setCard_Id(carddetails.getCard_Id());
				usermember.setUpdated_By(userid);
				usermember.setUpdated_Date(today);
				usermember.setCreated_By(userid);
				usermember.setCreated_Date(today);
				UserMembershipRepo.save(usermember);
				return "0";
			}
		}

	}
	public String DeLinkcardtouser(String Cardnum,int userid) {
		Carddto carddetails = Cardservice.GetCarddetailsbycardID(Cardnum);
		if (carddetails == null) {
			return "102";

		} else {
			
				UserMembership usermember=UserMembershipRepo.findUserMembershipBycardid(carddetails.getCard_Id());
				if(usermember.getUser_Id() != userid) {
					return "104";
				}
				UserMembershipRepo.delete(usermember);
			
		}
		return "0";
		}
}

