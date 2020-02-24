package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Naveen Khunteta')]")
	WebElement usercheck;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactlink;
	
	@FindBy(xpath="//a[contains(text(),'Deals")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Task')]")
	WebElement tasklink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateusertitle()
	{
		return usercheck.isDisplayed();
	}
	
	public String verifyhomepagetitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage verifycontactslink()
	{
		contactslink.click();
		return new ContactsPage();
	}
	public DealsPage verifydealspagelink()
	{
		dealslink.click();
		return new DealsPage();
	}
	
	public TaskPage verifytaskpagelink()
	{
		tasklink.click();
		return new TaskPage();
	}
	
	//contacts link available in home page
	public void clickonNewContactLink() 
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		
		newcontactlink.click();
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
