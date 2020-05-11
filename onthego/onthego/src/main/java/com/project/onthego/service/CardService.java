package com.project.onthego.service;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.project.onthego.DTO.BusServicesdto;
import com.project.onthego.DTO.CardHistorydto;
import com.project.onthego.DTO.Carddto;
import com.project.onthego.model.BusRoutes;
import com.project.onthego.model.Card;
import com.project.onthego.model.CardHistory;
import com.project.onthego.model.User;
import com.project.onthego.model.UserMembership;
import com.project.onthego.repository.BusRoutesRepository;
import com.project.onthego.repository.CardHistoryRepository;
import com.project.onthego.repository.CardRepository;
import com.project.onthego.repository.UserMembershipRepository;

@Service
public class CardService {
	@Autowired
	private CardRepository cardrepo;
	@Autowired
	private CardHistoryRepository cardHistoryrepo;
	@Autowired
	private UserMembershipRepository UserMembershipRepo;
	@Autowired
	private BusRoutesRepository BusRouteRepo;
	@Autowired
	private BusService busService;
	@Autowired
	private StudentFactory student;
	@Autowired
	private GeneralFactory general;
	

	public int getcurrentusersinbus(int serviceid) {
		return cardHistoryrepo.getbususersbyserviceid(serviceid);
	}
	
	public Carddto GetCarddetailsbycardID(String cardNum) {
		Carddto carddto = new Carddto();

		Card card = cardrepo.findBycardNumber(cardNum);
		Assert.notNull(card, "There is no card");
		BeanUtils.copyProperties(card, carddto);
		return carddto;

	}

	public Carddto getCarddetailsbycardID(int cardid) {
		Carddto carddto = new Carddto();

		Card card = cardrepo.findBycardid(cardid);
		Assert.notNull(card, "There is no card");
		BeanUtils.copyProperties(card, carddto);
		return carddto;}
		
	public Cardmember Getcardmembership(Carddto card) {
		switch (card.getCard_Category()) {
		case "STU":
			return student.calculateDiscount(card);
		default:
			return general.calculateDiscount(card);
		}

	}

	public GenReport Getcardmembershipstatus(Carddto card) {
		switch (card.getCard_Category()) {
		case "STU":
			return student.generateReport();
		default:
			return general.generateReport();
		}

	}

	public String IsCardcheckedin(Card card, int Busserviceid, int Endstopid) {

		CardHistory cardhis = cardHistoryrepo.findBycardHistorybycardNumber(card.getCard_Id());
		if (cardhis.getCheck_Out() == null) {
			if (cardhis.getBus_Servce_Id() == Busserviceid) {

			}
		}

		return "0";
	}

	public UserMembership getusermembershipbycard(int Cardid) {

		return UserMembershipRepo.findUserMembershipBycardid(Cardid);
	}

	public void CreateCardHistory(CardHistorydto card) {
		CardHistory cardModel = new CardHistory();
		BeanUtils.copyProperties(card, cardModel);
		cardHistoryrepo.save(cardModel);

	}

	public CardHistory GetCardHistory(CardHistory cardhis) {
		return cardHistoryrepo.findBycardHistorybycardNumber(cardhis.getCard_Id());

	}

	public CardHistorydto GetCardHistorybycardID(int Cardid) {
		CardHistory CardHistmodel = cardHistoryrepo.findBycardHistorybycardNumber(Cardid);
		CardHistorydto cardhistdto = new CardHistorydto();
		BeanUtils.copyProperties(CardHistmodel, cardhistdto);
		// cardhistdto.setCard_History_Id(card_History_Id);
		return cardhistdto;

	}

	public void Reduceamountfromcard(float amount, Carddto carddto) {
		carddto.setBalance(carddto.getBalance() - amount);
		Card card = new Card();
		BeanUtils.copyProperties(carddto, card);
		cardrepo.save(card);
	}

	public float Getdistancebetweenstops(int Startstopid, int EndStopid, int Serviceid) {
		BusServicesdto busservicedto = busService.Getbusservice(Serviceid);
		Assert.notNull(busservicedto, "Bus service does not exist");
		int Routeid = busservicedto.getBus_Route_Id();
		BusRoutes Startbusstop = BusRouteRepo.Getbusroutestopinfobystopid(Routeid, Startstopid);
		BusRoutes Endbusstop = BusRouteRepo.Getbusroutestopinfobystopid(Routeid, EndStopid);
		float distance = (float) (Endbusstop.getDistnce_to_Destn() - Startbusstop.getDistnce_to_Destn());
		return distance;

	}

	public void checkintobus(Carddto card, int stopid, User Loggedinuser, int Serviceid) {
		Date CurrentDate = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("EEEE");
		String day = dateformat.format(CurrentDate);
		CardHistorydto cardhistdto = new CardHistorydto();
		cardhistdto.setCard_Id(card.getCard_Id());
		cardhistdto.setAmount(0);
		cardhistdto.setBus_Servce_Id(Serviceid);
		cardhistdto.setCheck_In(CurrentDate);
		cardhistdto.setCheck_In_BusStop(stopid);
		cardhistdto.setIs_Debit(true);
		cardhistdto.setCreated_By(Loggedinuser.getId());
		cardhistdto.setCreated_Date(CurrentDate);
		cardhistdto.setUpdated_Date(CurrentDate);
		cardhistdto.setUpdated_By(Loggedinuser.getId());
		cardhistdto.setDay_Of_Week(day);
		CreateCardHistory(cardhistdto);
	}

	public void checkoutfrombus(Carddto card, int stopid, User Loggedinuser, int Serviceid) {
		
		GenReport report = Getcardmembershipstatus(card);
		List<TravelHistoryInterface> carddetails = cardHistoryrepo.getcarddetails(card.getCard_Id());

		ByteArrayInputStream bis = report.generateReport(carddetails);

		int d;
		try {
			OutputStream out = new FileOutputStream("D:/Studies/Software Architecture/out.pdf");
			while ((d = bis.read()) != -1) {

				out.write((char)d);
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Cardmember Cardmember = Getcardmembership(card);
		Date CurrentDate = new Date();
		CardHistorydto cardhistdto = GetCardHistorybycardID(card.getCard_Id());
		int Startstopid = cardhistdto.getCheck_In_BusStop();
		int Endstopid = stopid;
		float distancetravelled = Getdistancebetweenstops(Startstopid, Endstopid, Serviceid);
		float totalfare = Cardmember.getDiscountRate(distancetravelled,Serviceid);
		cardhistdto.setAmount(totalfare);
		cardhistdto.setCheck_Out_BusStop(Endstopid);
		cardhistdto.setCheck_Out(CurrentDate);
		cardhistdto.setUpdated_By(Loggedinuser.getId());
		cardhistdto.setUpdated_Date(CurrentDate);
		CreateCardHistory(cardhistdto);
		card.setUpdated_By(Loggedinuser.getId());
		card.setUpdated_Date(CurrentDate);
		Reduceamountfromcard(totalfare, card);

	}
}
