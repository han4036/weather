package org.zerock.myapp.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;


@Log4j
@RestController
@RequestMapping("/excel")
public class ExcelController {
	
	
	@PostMapping("/xlsxdownload")
	public void excelDownload() throws Exception {
		log.debug("excelDownload() invoked.");
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("온도데이터");
		Row row = null;
		Cell cell = null;
		int rowNum = 0;
		
		// Header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("구분");
		cell = row.createCell(1);
		cell.setCellValue("온도");
		
	} // excelDownload
}
