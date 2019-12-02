package com.project.onthego.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.onthego.DTO.UserMembershipDTO;
import com.project.onthego.model.UserMembership;
import com.project.onthego.repository.UserMembershipRepository;
import com.project.onthego.service.CardService;
import com.project.onthego.service.UserService;
import com.project.onthego.validator.DataConstants;
import com.project.onthego.view.UserMembershipview;
import com.project.onthego.service.CardLinkservice;
import com.project.onthego.service.Linkcard;

@RestController
@ResponseBody
@CrossOrigin
@RequestMapping(value = "/api/card")
public class CardController {
	@Autowired
	private UserService userservice;
	@Autowired
	private CardService cardservice;
	@Autowired
	private UserMembershipRepository UserMembership;

	@PostMapping("/Linkcard")
	public ResponseEntity<Object> Linkcard(@RequestBody UserMembershipview Usermembership) {
		try {
			//String Issucess = cardservice.Linkcardtouser(Usermembership.getCard_Num(), Usermembership.getUser_Id());
			CardLinkservice cardlink=new CardLinkservice(cardservice,UserMembership);
			Linkcard Card=new Linkcard(Usermembership.getCard_Num(),Usermembership.getUser_Id(),cardlink,UserMembership);
			
			String Issucess = Card.execute();
			if (Issucess == "0") {
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
				
			} else {
				String ErrorMessage=DataConstants.CardErrors.get(Issucess);
				return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body(ErrorMessage);
			}
		} catch (Exception ex) {

			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.Applicationcommonerror);

		}
	}
	@PostMapping("/DeLinkcard/{Cardid}")
	public ResponseEntity<Object> DeLinkcard(@PathVariable String Cardid) {
		try {
			//String Issucess = cardservice.Linkcardtouser(Usermembership.getCard_Num(), Usermembership.getUser_Id());
			//Loggedinuser
			//Linkcard Card=new Linkcard(Cardid,Usermembership.getUser_Id(),CardLinkservice,UserMembership);
			
			String Issucess = "0";
			if (Issucess == "0") {
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
				
			} else {
				String ErrorMessage=DataConstants.CardErrors.get(Issucess);
				return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body(ErrorMessage);
			}
		} catch (Exception ex) {

			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.Applicationcommonerror);

		}
	}
	@GetMapping("/GetLinkcards/{userid}")
	public ResponseEntity<Object> GetLinkedcards(@PathVariable int userid) {
		try {
		
			List<UserMembership> usercards = userservice.getAllLinkedcards(userid);
			List<UserMembershipview> usercardsview = new ArrayList<UserMembershipview>();
			Iterator<UserMembership> usercard_iterator=usercards.iterator();
			while(usercard_iterator.hasNext())
			{
				UserMembership Usermember=usercard_iterator.next();
				UserMembershipDTO tempusermemberDTO=new UserMembershipDTO();
				UserMembershipview tempusermemberview=new UserMembershipview();
				BeanUtils.copyProperties(Usermember, tempusermemberDTO);
				BeanUtils.copyProperties(tempusermemberDTO, tempusermemberview);
				tempusermemberview.setCard_Num(Usermember.getCard().getCard_Num());
				usercardsview.add(tempusermemberview);
			}
	
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(usercardsview);
		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.Applicationcommonerror);
		}
	}

}
