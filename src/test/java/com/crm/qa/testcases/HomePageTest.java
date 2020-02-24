package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TaskPage taskpage;
	TestUtil testutil;
	
	
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		homepage=new HomePage();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void validatehomepagetitleTest()
	{
		String title=homepage.verifyhomepagetitle();
		Assert.assertEquals(title,"CRMPRO", "title is not matched");
	}
	@Test(priority=2)
	public void validateuserchecktTest()
	{
		testutil.switchtoframe();
		Assert.assertTrue(homepage.validateusertitle());
	}
	
	@Test(priority=3)
	public void validatecontactslinkTest()
	{
		testutil.switchtoframe();
		contactspage=homepage.verifycontactslink();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}
