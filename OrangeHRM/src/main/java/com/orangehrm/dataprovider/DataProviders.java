package com.orangehrm.dataprovider;

import org.testng.annotations.DataProvider;

import com.orangehrm.utility.ExcelLibrary;
//import com.swaglabs.utility.NewExcelLibrary;

public class DataProviders {

	ExcelLibrary obj = new ExcelLibrary();
	
	@DataProvider(name = "Credentials")
	public Object[][] getCredentials() throws Throwable
	{
		int row = obj.getrowCount("Credentials");
		
		int column = obj.getcolCount("Credentials");
		
		Object[][] data = new Object[row][column];
		
		for(int i = 0; i<row; i++)
		{
			for(int j=0; j<column ; j++)
			{
				data[i][j] = obj.getCellData("Credentials", i+1, j);
			}
		}
		return data;
	}
	/*
	ExcelLibrary obj = new ExcelLibrary();


	@DataProvider(name = "Credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}*/

}
