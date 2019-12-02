package com.project.onthego.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.DTO.BusServicesdto;
import com.project.onthego.model.BusServices;
import com.project.onthego.model.BusTypes;
import com.project.onthego.model.ServiceProvider;
import com.project.onthego.repository.BusRoutesRepository;
import com.project.onthego.repository.BusServicesRepository;
import com.project.onthego.repository.BusTypesRepository;
import com.project.onthego.repository.ServiceProviderRepository;


@Service
public class BusService {
	@Autowired
    private ServiceProviderRepository SerProvideruserrepository;
	@Autowired
    private BusTypesRepository Bustyperepository;
	@Autowired
    private BusServicesRepository BusServicesrepo;
	public void CreateBusservice(ServiceProvider SP){
		 SerProvideruserrepository.save(SP);

	}
	public BusServicesdto Getbusservice(int serviceid) {
		BusServicesdto busservicedto= new BusServicesdto();
		BusServices busservice=new BusServices();
		busservice= BusServicesrepo.Getbusservicebyid(serviceid);
		BeanUtils.copyProperties(busservice, busservicedto);
		return busservicedto;
	}
	public void CreateBusType(BusTypes Bustype){
		Bustyperepository.save(Bustype);

	}
		
}
