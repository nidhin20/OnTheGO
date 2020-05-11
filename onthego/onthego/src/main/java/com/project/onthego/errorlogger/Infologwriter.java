package com.project.onthego.errorlogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Infologwriter {

	private static String LOG_LOCATION = "/Users/Nidhin/Downloads/logs/";
	private static String DATE_STR = "{Date_format_string}";
	private static String INFO_SUBDIR = "INFO/";
	private static String ERROR_SUBDIR = "ERROR/";
	private static String DB_SUBDIR = "DBERROR/";
	private static String INFO_FILENAME = "INFO_" + DATE_STR + ".txt";
	private static String ERROR_FILENAME = "ERROR_" + DATE_STR + ".txt";
	private static String DBERROR_FILENAME = "DBERROR_" + DATE_STR + ".txt";
	
	public void loginformation(int errortype, String errormessage) {
		try {
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
			DateFormat dateFormatminutes = new SimpleDateFormat("dd MMM yyyy HH:mm:ss ");
			errormessage = dateFormatminutes.format(date) + " ::  " + errormessage + "\n";
			String strDate = dateFormat.format(date);
			
			String filename = "";
			String directory="";
			switch (errortype) {
			case 2:
				directory= LOG_LOCATION + DB_SUBDIR ;
				filename = DBERROR_FILENAME.replace(DATE_STR, strDate);
				
				break;
			case 1:
				directory= LOG_LOCATION + ERROR_SUBDIR;
				filename = ERROR_FILENAME.replace(DATE_STR, strDate);
				break;
			default:
				directory=LOG_LOCATION + INFO_SUBDIR;
				filename = INFO_FILENAME.replace(DATE_STR, strDate);
				break;
			}
	
			File fileSaveDir = new File(directory);
			filename=directory+filename;
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdirs();
			}
			
			try (FileWriter writetofile = new FileWriter(filename,true)) {
				writetofile.append(errormessage);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
