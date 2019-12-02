package com.project.onthego.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import com.project.onthego.validator.CardValidator;
import com.project.onthego.validator.DataConstants;
import org.apache.catalina.connector.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.onthego.DTO.BusRoutesdto;
import com.project.onthego.DTO.BusTypesdto;
import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.ServiceProviderdto;
import com.project.onthego.model.BusRoutes;
import com.project.onthego.model.BusTypes;
import com.project.onthego.model.ServiceProvider;
import com.project.onthego.model.User;
import com.project.onthego.repository.BusRoutesRepository;
import com.project.onthego.service.AuthenticationService;
import com.project.onthego.service.BusService;
import com.project.onthego.service.CardService;
import com.project.onthego.service.CommonService;
import com.project.onthego.view.BusRouteview;
import com.project.onthego.view.BusTypeview;
import com.project.onthego.view.ServiceProviderview;

@RestController
@RequestMapping(value = "/api/bus")
public class BusController {

	@Autowired
	private BusService Busservice;
	@Autowired
	private AuthenticationService Authservice;
	@Autowired
	private CardService Cardservice;
	@Autowired
	private CardValidator CardValidator;
	@Autowired
	private CommonService commonservice;
	@Autowired
	private BusRoutesRepository BusRoutesrepo;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/Tapin/{Serviceid}/{stopid}/{cardnum}")
	public ResponseEntity<Object> Bustapin(@PathVariable int Serviceid, @PathVariable int stopid,
			@PathVariable String cardnum) {
		try {
			
			User Loggedinuser=commonservice.Getloggedinuserdetails();
			Carddto card = Cardservice.GetCarddetailsbycardID(cardnum);
			String isvalid = CardValidator.Checkcardforuse(card,false);
			if (isvalid != "0") {
				String ErrorMessage = DataConstants.CardErrors.get(isvalid);
				return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
						.body(ErrorMessage);

			} else {
				Cardservice.checkintobus(card, stopid, Loggedinuser, Serviceid);
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Chedked in");

			}


		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.Applicationcommonerror);
		}
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/Tapout/{Serviceid}/{stopid}/{cardnum}")
	public ResponseEntity<Object> Bustapout(@PathVariable int Serviceid, @PathVariable int stopid,
			@PathVariable String cardnum) {
		try {
			User Loggedinuser=commonservice.Getloggedinuserdetails();
			Carddto card = Cardservice.GetCarddetailsbycardID(cardnum);
			String isvalid = CardValidator.Checkcardforuse(card,false);
			if (isvalid != "0") {
				String ErrorMessage = DataConstants.CardErrors.get(isvalid);
				return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
						.body(ErrorMessage);

			} else {
				Cardservice.checkoutfrombus(card, stopid, Loggedinuser, Serviceid);
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Checked out");
			}

		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.Applicationcommonerror);
		}
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/CreatebusserviceProvider")
	public ResponseEntity<Object> Createbusserviceprovider(@RequestBody @Valid ServiceProviderview serviceProv) {
		try {
			ServiceProviderdto spdto = new ServiceProviderdto();
			ServiceProvider spmodel = new ServiceProvider();
			BeanUtils.copyProperties(serviceProv, spdto);
			BeanUtils.copyProperties(spdto, spmodel);
			Busservice.CreateBusservice(spmodel);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();

		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.Applicationcommonerror);
		}
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/Createbussroute")
	public ResponseEntity<Object> Createbusroute(@RequestBody @Valid List<BusRouteview> Busservice) {
		try {

			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();

		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.Applicationcommonerror);
		}
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/Createbusservice")
	public ResponseEntity<Object> Createbusservice(@RequestBody @Valid BusRouteview Busservice) {
		try {
			Date currentdate=new Date();
			User Loggedinuser=commonservice.Getloggedinuserdetails();
			BusRoutesdto busroute=new BusRoutesdto();
			BusRoutes busroutemodel=new BusRoutes();
			busroute.setBus_Route_Id(Busservice.getBus_Route_Id());
			busroute.setBus_Stop_Id(Busservice.getBus_Stop_Id());
			busroute.setDistnce_to_Destn(Busservice.getDistnce_to_Destn());
			busroute.setStop_Reach_Time(Busservice.getStop_Reach_Time());
			BeanUtils.copyProperties(busroute, busroutemodel);
			busroutemodel.setCreated_By(Loggedinuser.getId());
			busroutemodel.setUpdated_By(Loggedinuser.getId());
			busroutemodel.setCreated_Date(currentdate);
			busroutemodel.setUpdated_Date(currentdate);
		 BusRoutes Maxbusroute=	BusRoutesrepo.GetMaxsequenceidbyroute(Busservice.getBus_Route_Id());
		 if (Maxbusroute !=null)
		 {
			 busroutemodel.setStop_Seqnce_Id(Maxbusroute.getStop_Seqnce_Id()+1);
		 }
		 else
		 {
			 busroutemodel.setStop_Seqnce_Id(1);
		 }
		 BusRoutesrepo.save(busroutemodel);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();

		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.Applicationcommonerror);
		}
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/Createbustype")
	public ResponseEntity<Object> Createbustype(@RequestBody @Valid BusTypeview Bustype) {
		try {
			User Loggedinuser=commonservice.Getloggedinuserdetails();
			Date currentdate=new Date();
			BusTypesdto Bustypedto = new BusTypesdto();
			BusTypes bustypemodel = new BusTypes();
			BeanUtils.copyProperties(Bustype, Bustypedto);
			BeanUtils.copyProperties(Bustypedto, bustypemodel);
			bustypemodel.setCreated_By(Loggedinuser.getId());
			bustypemodel.setCreated_Date(currentdate);
			Busservice.CreateBusType(bustypemodel);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Bus Type Created successfully");

		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.Applicationcommonerror);
		}
	}

}
