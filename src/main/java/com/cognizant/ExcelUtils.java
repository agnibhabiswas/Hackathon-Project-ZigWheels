package com.cognizant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static HashMap<Integer,Object[]> readData(String fileLocation){
		
		try(FileInputStream fis=new FileInputStream(new File(fileLocation))) {
			HashMap<Integer,Object[]>out = new LinkedHashMap<>();
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheetAt(0);
			int noOfRows=sheet.getLastRowNum()-sheet.getFirstRowNum();
			for(int i=1;i<noOfRows+1;i++) {
				Row row=sheet.getRow(i);
				int noOfColumns=row.getLastCellNum()-row.getFirstCellNum();
				Object[] obj=new Object[noOfColumns];
				for(int j=0;j<noOfColumns;j++) {
					obj[j]=(Object)row.getCell(j).getStringCellValue();				
				}
				out.put(i,obj);
			}
			workbook.close();
			return out;
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void  writeData(HashMap<Integer,Object[]> data,String fileLocation,String browserName) {
		try(XSSFWorkbook workbook=new XSSFWorkbook();){
			XSSFSheet sheet=workbook.createSheet(browserName);
			Set<Integer> rows=data.keySet();
			for(int rownum:rows) {
				Row row=sheet.createRow(rownum);
				Object[] obj=data.get(rownum);
				for(int i=0;i<obj.length;i++) {
					Cell cell=row.createCell(i);
					cell.setCellValue((String) obj[i]);
					CellStyle style = workbook.createCellStyle();
					if(rownum==0) {
						style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());  
			            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			            style.setBorderRight(BorderStyle.MEDIUM);
			            style.setBorderLeft(BorderStyle.MEDIUM);
			            cell.setCellStyle(style);
			            
					}
					if(rownum>0) {
					style.setWrapText(true);
					cell.setCellStyle(style);
					row.setHeightInPoints((4*sheet.getDefaultRowHeightInPoints()));  
		            sheet.autoSizeColumn(i);  
					}
				}
			}
			FileOutputStream fos=new FileOutputStream(new File(fileLocation));
			workbook.write(fos);
			workbook.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
