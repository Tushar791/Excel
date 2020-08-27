package com.ReadWrite.write;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ReadWrite.model.Pizza;

public class WriteExcel {	

	public void write(ArrayList<Pizza> source, ArrayList<Pizza> target) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("Pizza.xlsx");
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet= wb.createSheet("Result");
		CellStyle cellgreen = wb.createCellStyle();
		CellStyle cellRed = wb.createCellStyle();
		int rownum =0;
		for(Pizza s: source) {
			Pizza t=search(s.getPizzaId(), target);
			Pizza[] pizza = {s,t};
			
			for(Pizza p: pizza) {
				Row row = sheet.createRow(rownum);
				row.createCell(0).setCellValue(p.getPizzaId());
				row.createCell(1).setCellValue(p.getPizzaName());
				row.createCell(2).setCellValue(p.getPrice());
				rownum+=1;
			}
			Row row=sheet.createRow(rownum);
			if(s.equals(t)) {
				cellgreen.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
				cellgreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				Cell cell = row.createCell(1);
				cell.setCellValue("Matches");
				cell.setCellStyle(cellgreen);
				sheet.autoSizeColumn(1);
				
			}else {
				cellRed.setFillForegroundColor(IndexedColors.RED.getIndex());
				cellRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				Cell cell = row.createCell(1);
				cell.setCellValue("Do Not Match");
				cell.setCellStyle(cellRed);
				sheet.autoSizeColumn(1);
			}
			Row blankRow=sheet.createRow(++rownum);
			blankRow.createCell(1).setBlank();
			
			
			
		}
		fis.close();
		FileOutputStream file = new FileOutputStream("Pizza.xlsx");
		wb.write(file);
		wb.close();
		file.flush();
		file.close();
		
		System.out.println("File has beenn written");
		
		
		
		
	}
	
	public static Pizza search(int pizzaId,ArrayList<Pizza> list) {
		List<Pizza> pizzaList= list.stream().filter(p -> p.getPizzaId() == pizzaId).collect(Collectors.toList());
		Pizza pizza = pizzaList.get(0);
		return pizza;
	}

}
