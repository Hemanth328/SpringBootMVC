package com.org.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import com.org.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdf_report")
public class PdfReportView  extends AbstractPdfView {
	
//	@Override
//	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
//			HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//get Model attributes data
			List<Employee> list=(List<Employee>)map.get("empsList");
			// add Paragraph
			Paragraph para=new Paragraph("Employee Report", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE,Font.BOLDITALIC));
			doc.add(para);
			//add table content
			Table table=new  Table(5,((ArrayList) list).size());
			for(Employee emp:list) {
				table.addCell(String.valueOf(emp.getEmpno()));
				table.addCell(emp.getEname());
				table.addCell(emp.getJob());
				table.addCell(String.valueOf(emp.getSal()));
				if(emp.getDeptno()!=null)
				   table.addCell(String.valueOf(emp.getDeptno()));
				else
					table.addCell("_____");
					
			}
			doc.add(table);
	}
	

}
