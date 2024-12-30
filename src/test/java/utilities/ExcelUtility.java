package utilities;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {
	
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell; 
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;
	}

	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try {
			data=formatter.formatCellValue(cell);
		}		
		catch(Exception e){
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rownum, int collnum, String data) throws IOException {
		File xlfile = new File(path);
		if (!xlfile.exists()) {
			workbook = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			workbook.write(fos);
		}
		
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		
		if(workbook.getSheetIndex(sheetName)==-1) //if sheet not exist then create sheet
		workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);

		if(sheet.getRow(rownum)==null) //if row not exist then create row
		sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(collnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	
	public void fillColor(String sheetName, int rownum, int collnum) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(collnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}	
}