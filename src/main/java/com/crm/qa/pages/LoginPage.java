package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page objects 
	//for getting screenshots of exception make below username webelement as username1 then the login testcase failed
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	//@FindBy(linkText="Login")
	@FindBy(xpath="//div[@class='input-group-btn']//input[@type='submit']")
	//@FindBy(xpath="//input[@type='submit' and @value='Login' and @class='btn btn-small']")
    WebElement login;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	@FindBy(xpath="/a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	//initialize the above page objects by using pagefactory class and initi method
	//here this means current class objects i.e. page objects
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", login);		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
}




