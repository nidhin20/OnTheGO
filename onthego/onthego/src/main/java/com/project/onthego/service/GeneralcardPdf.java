package com.project.onthego.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneralcardPdf extends GenReport {

	
		private static Logger logger = LoggerFactory.getLogger(StudentcardPdf.class);

		@Override
		public ByteArrayInputStream generateReport(List<TravelHistoryInterface> carddetails) {
			// TODO Auto-generated method stub
			Document document = new Document();
			ByteArrayOutputStream out = new ByteArrayOutputStream();

			try {

				PdfWriter.getInstance(document, out);
				document.open();

				// Add Text to PDF file ->
				Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
				Paragraph para = new Paragraph("Travel History", font);
				para.setAlignment(Element.ALIGN_CENTER);
				document.add(para);
				document.add(Chunk.NEWLINE);

				PdfPTable table = new PdfPTable(6);
				// Add PDF Table Header ->
				Stream.of("Journey Date", "Bus Route", "Bus Start Time", "Start Stop", "End Stop", "Amount")
						.forEach(headerTitle -> {
							PdfPCell header = new PdfPCell();
							Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
							header.setBackgroundColor(BaseColor.LIGHT_GRAY);
							header.setHorizontalAlignment(Element.ALIGN_CENTER);
							header.setBorderWidth(2);
							header.setPhrase(new Phrase(headerTitle, headFont));
							table.addCell(header);
						});

				for (TravelHistoryInterface details : carddetails) {
					PdfPCell Createdate = new PdfPCell(new Phrase(details.getCreated_Date().toString()));
					Createdate.setPaddingLeft(4);
					Createdate.setVerticalAlignment(Element.ALIGN_MIDDLE);
					Createdate.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(Createdate);

					PdfPCell busrouteid = new PdfPCell(new Phrase(Integer.toString(details.getBus_Route_Id())));
					busrouteid.setPaddingLeft(4);
					busrouteid.setVerticalAlignment(Element.ALIGN_MIDDLE);
					busrouteid.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(busrouteid);

					PdfPCell busstarttime = new PdfPCell(new Phrase(details.getBus_Start_Time().toString()));
					busstarttime.setPaddingLeft(4);
					busstarttime.setVerticalAlignment(Element.ALIGN_MIDDLE);
					busstarttime.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(busstarttime);

					PdfPCell startstop = new PdfPCell(new Phrase(details.getStartstop()));
					startstop.setPaddingLeft(4);
					startstop.setVerticalAlignment(Element.ALIGN_MIDDLE);
					startstop.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(startstop);

					PdfPCell endstop = new PdfPCell(new Phrase(details.getEndstop()));
					endstop.setPaddingLeft(4);
					endstop.setVerticalAlignment(Element.ALIGN_MIDDLE);
					endstop.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(endstop);

					PdfPCell amount = new PdfPCell(new Phrase(Float.toString(details.getAmount())));
					amount.setPaddingLeft(4);
					amount.setVerticalAlignment(Element.ALIGN_MIDDLE);
					amount.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(amount);

				}

				document.add(table);

				document.close();

			} catch (DocumentException e) {
				logger.error(e.toString());
			}
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

