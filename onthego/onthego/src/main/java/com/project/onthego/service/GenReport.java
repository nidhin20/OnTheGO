package com.project.onthego.service;

import java.io.ByteArrayInputStream;
import java.util.List;

public abstract class GenReport {

	public abstract ByteArrayInputStream generateReport(List<TravelHistoryInterface> carddetails);

	}
