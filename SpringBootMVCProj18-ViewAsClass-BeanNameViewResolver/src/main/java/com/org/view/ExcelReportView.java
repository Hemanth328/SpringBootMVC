package com.org.view;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.org.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("excel_report")
public class ExcelReportView extends AbstractXlsxView {

	private int i = 1;
	
	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		//get Model Attributes Data
		List<Employee> list = (List<Employee>) map.get("empsList");
		
		//create excel sheet in workbook
		Sheet sheet = workbook.createSheet("Employee");
		
		//add rows to Excel sheet
		
		Row row = sheet.createRow(i);
		
		// add cells to row
		
		row.createCell(0).setCellValue("Emp No");
		row.createCell(1).setCellValue("Emp Name");
		row.createCell(2).setCellValue("Emp Job");
		row.createCell(3).setCellValue("Emp DeptNo");
		row.createCell(4).setCellValue("Emp Sal");
		
		
		list.forEach(emp -> {
			// add row to excel sheet
			Row row1 = sheet.createRow(i);
			
			// add cells to row
			
			row1.createCell(0).setCellValue(emp.getEmpno());
			row1.createCell(1).setCellValue(emp.getEname());
			row1.createCell(2).setCellValue(emp.getJob());
			if(emp.getDeptno() != null)
				row1.createCell(3).setCellValue(emp.getDeptno());
			row1.createCell(4).setCellValue(emp.getSal());
			
			i++;
		});
		
	}

}
