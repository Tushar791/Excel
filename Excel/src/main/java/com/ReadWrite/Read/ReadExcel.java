package com.ReadWrite.Read;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ReadWrite.model.Pizza;


public class ReadExcel{
	
	private String name= "Pizza.xlsx" ;
	
	public ArrayList<Pizza> read(String sheetName) throws IOException{
		ArrayList<Pizza> list = new ArrayList<Pizza>();
		FileInputStream file = new FileInputStream(this.name);
		
		Workbook wb = new XSSFWorkbook(file);
		
		Sheet sheet = wb.getSheet(sheetName);
		
		Iterator<Row> rows = sheet.iterator();
		while(rows.hasNext()) {
			Row row = rows.next();
			Pizza p = new Pizza();
			if(!isRowEmpty(row)) {
				Iterator<Cell> cells = row.cellIterator();
				while(cells.hasNext()) {
					Cell cell= cells.next();
					if(cell.getColumnIndex() == 0)
						p.setPizzaId((int)cell.getNumericCellValue());
					if(cell.getColumnIndex()==1)
						p.setPizzaName(cell.getStringCellValue());
					if(cell.getColumnIndex()==2) {
						p.setPrice((int)cell.getNumericCellValue());
						list.add(p);
					}			
				}
				
			}
		}
		file.close();
		return list;
	}
	
	public static boolean isRowEmpty(Row row) {
		Iterator<Cell> cells = row.iterator();
		while(cells.hasNext()) {
			Cell cell = cells.next();
			if((cell!= null) && (cell.getCellType() != CellType.BLANK)) {
				return false;
			}
		}
		return true;
	}
	
	
	
}
