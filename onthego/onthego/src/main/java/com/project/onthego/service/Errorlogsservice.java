package com.project.onthego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onthego.model.Errorlogs;
import com.project.onthego.repository.ErrorlogsRepository;
@Service
public class Errorlogsservice {
	@Autowired
	private ErrorlogsRepository errorlogrepo;
	public void inserterrorlog(Errorlogs errorlog) {
		errorlogrepo.save(errorlog);
	}
}
