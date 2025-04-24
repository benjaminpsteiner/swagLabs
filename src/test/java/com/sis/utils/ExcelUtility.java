package com.sis.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook book;
	private static Sheet sheet;

	
	/**
	 * Will initialize a Workbook object given the filePath.
	 * 
	 * @param filePath
	 */
	private static void openExcel(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Will load a sheet given the sheetName.
	 * 
	 * @param sheetName
	 */
	private static void loadSheet(String sheetName)
	{
		sheet = book.getSheet(sheetName);
	}
	
	/**
	 * This method will return the row count of the current sheet.
	 * 
	 * @return
	 */
	private static int rowCount()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	
	/**
	 * This method will return the column count for a given row index in the current sheet.
	 * 
	 * @param rowIndex
	 * @return
	 */
	private static int colCount(int rowIndex)
	{
		return sheet.getRow(rowIndex).getLastCellNum();
	}

	/**
	 * This method will return the cell data as a String given the row and column number.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 */
	private static String cellData(int rowIndex, int colIndex)
	{
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	

	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {

		// open the file: filePath
		openExcel(filePath);

		// load the sheet: sheetName
		loadSheet(sheetName);

		// define the number of rows
		int rowNumber = rowCount();
		
		//
		List<Map<String, String>> list = new ArrayList<>();
		
		for (int row = 1; row < rowNumber;row++)
		{
			Map<String, String> rowMap = new LinkedHashMap<>();
			
			for (int col = 0; col < colCount(row); col++)
			{
				String key = cellData(0, col);
				String value = cellData(row, col);
				
				rowMap.put(key, value);
			}
			
			//add the filled map to the list
			list.add(rowMap);
		}
		
		return list;
	}
	
	
	

}
