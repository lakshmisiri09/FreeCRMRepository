package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[@class='datacardtitle'][contains(text(),'Contacts')]")
	//@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlable;
	//@FindBy(xpath="//a[text()='David Cris']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input")
	//WebElement contactname;
	
	//by using below page factory objects code doesn't work properly that's why i used again driver.fibdby methods
	/*@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;*/

	
	public void ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontactlable() throws Exception
	{
		
		boolean b1= contactlable.isDisplayed();
		return b1;
	}
	
	public void clickoncontactbyname(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input")).click();
	}
	
	public void createNewContact(String gender,String ftname,String ltname,String cmp) {
		
		Select oselect=new Select(driver.findElement(By.name("title")));
		oselect.selectByVisibleText(gender);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(ftname);
		driver.findElement(By.id("surname")).sendKeys(ltname);
		driver.findElement(By.name("client_lookup")).sendKeys(cmp);
		//company.sendKeys("c");
	}
	
	
	
}
