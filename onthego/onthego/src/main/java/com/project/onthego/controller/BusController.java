package com.project.onthego.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
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
import com.project.onthego.DTO.BusServicesdto;
import com.project.onthego.DTO.BusTypesdto;
import com.project.onthego.DTO.Carddto;
import com.project.onthego.DTO.Mlpeaktime;
import com.project.onthego.DTO.ServiceProviderdto;
import com.project.onthego.errorlogger.Chainerrorlog;
import com.project.onthego.errorlogger.Errorlogger;
import com.project.onthego.model.BusRoutes;
import com.project.onthego.model.BusTypes;
import com.project.onthego.model.ServiceProvider;
import com.project.onthego.model.User;
import com.project.onthego.repository.BusRoutesRepository;
import com.project.onthego.service.AuthenticationService;
import com.project.onthego.service.BusService;
import com.project.onthego.service.CardService;
import com.project.onthego.service.CommonService;
import com.project.onthego.service.Peaktimeservice;
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
	@Autowired
	private Peaktimeservice Peakservice;
	@Autowired
	private Chainerrorlog chainerrorlog;
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/Tapin/{Serviceid}/{stopid}/{cardnum}")
	public ResponseEntity<Object> Bustapin(@PathVariable int Serviceid, @PathVariable int stopid,
			@PathVariable String cardnum) {
		try {
			
			User Loggedinuser=commonservice.Getloggedinuserdetails();
			Carddto card = Cardservice.GetCarddetailsbycardID(cardnum);
			String isvalid = CardValidator.checkcardforuse(card);
			if (!isvalid.equals("0")) {
				String ErrorMessage = DataConstants.CardErrors.get(isvalid);
				return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
						.body(ErrorMessage);

			} else {
				BusServicesdto bus=Busservice.Getbusservice(Serviceid);
				int noofpass=Cardservice.getcurrentusersinbus(Serviceid);
				Calendar cal = Calendar.getInstance();
				Mlpeaktime mlp= new Mlpeaktime();
				mlp.setYear(cal.get(Calendar.YEAR));
				mlp.setDayofweek(cal.get(Calendar.DAY_OF_WEEK));
				mlp.setHour(cal.get(Calendar.HOUR));
				mlp.setMonth(cal.get(Calendar.MONTH));
				mlp.setNoofpass(noofpass);
				mlp.setRouteid(bus.getBus_Route_Id());
				Boolean ispeaktime = Peakservice.getpeaktimestatus(mlp); // Microservice call
				Cardservice.checkintobus(card, stopid, Loggedinuser, Serviceid);
				String output =(Boolean.TRUE.equals(ispeaktime) ? "Peak Time - " :"Not Peak Time - ") + "Checked in";
				
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(output);

			}


		} catch (Exception ex) {
			Errorlogger log = chainerrorlog.getchainlog(); // chain of responsibility DP
			log.logmessage(Errorlogger.SEVEREERROR, ex.getMessage());
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.APPLICATIONCOMMONERROR);
		}
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/Tapout/{serviceid}/{stopid}/{cardnum}")
	public ResponseEntity<Object> bustapout(@PathVariable int serviceid, @PathVariable int stopid,
			@PathVariable String cardnum) {
		try {
			User loggedinuser=commonservice.Getloggedinuserdetails();
			Carddto card = Cardservice.GetCarddetailsbycardID(cardnum);
			String isvalid = CardValidator.checkcardforuse(card);
			if (!isvalid.equals("0")) {
				String errorMessage = DataConstants.CardErrors.get(isvalid);
				return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
						.body(errorMessage);

			} else {
				Cardservice.checkoutfrombus(card, stopid, loggedinuser, serviceid);
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Checked out");
			}

		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.APPLICATIONCOMMONERROR);
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
					.body(DataConstants.APPLICATIONCOMMONERROR);
		}
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/Createbussroute")
	public ResponseEntity<Object> createbusroute(@RequestBody @Valid List<BusRouteview> busservice) {
		try {

			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();

		} catch (Exception ex) {
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON)
					.body(DataConstants.APPLICATIONCOMMONERROR);
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
					.body(DataConstants.APPLICATIONCOMMONERROR);
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
					.body(DataConstants.APPLICATIONCOMMONERROR);
		}
	}

}
