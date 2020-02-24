package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=20;
	public static Workbook book;
	public static Sheet sh;
	
	
	
	public void switchtoframe()
	{
		driver.switchTo().frame("mainpanel");
	}
 
	public static Object[][] getTestData(String sheetname) throws Exception, Exception, IOException
	{
		FileInputStream file=null;
		
		try
		{
			file=new FileInputStream("C:\\Users\\Harshita\\photon_workspace\\FreeCRMTest\\"
					+ "src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx");
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
		book=WorkbookFactory.create(file);
		}catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		sh=book.getSheet(sheetname);	
		
		Object[][] data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue().toString();
			}
		}
		return data;
	}
	
	//takes screenshot whenever exception occur
	public static void takeScreenshotAtEndOfTest() throws Exception
	{
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String driverpath=System.getProperty("user.dir");
		FileUtils.copyFile(scr,new File(driverpath +"/screenshot/"+System.currentTimeMillis() +".png" ));
		
		
	}
	
}
