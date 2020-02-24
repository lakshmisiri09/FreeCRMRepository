package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Checkingcontacts {
	
	public static void main(String [] args)
	{
		System.setProperty("webdriver.chrome.driver","C://chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		//driver.findElement(By.xpath("input[@name='password'][@class='form-control']")).sendKeys("Test@12345");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@type='submit']")));
		
		driver.switchTo().frame("mainpanel");
		//WebElement e1=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		//e1.click();
		
		//boolean b1=driver.findElement(By.xpath("//td[contains(text(),'Contacts')]")).isDisplayed();
		//System.out.println(b1);
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		
		Select oselect=new Select(driver.findElement(By.name("title")));
		oselect.selectByIndex(1);
		driver.findElement(By.name("first_name")).sendKeys("aa");
		
	}
	

}
