package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testutil;
	String sheetname="contacts";
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void steup()
	{
		initialize();
		testutil=new TestUtil();
		loginpage=new LoginPage();
		contactspage=new ContactsPage();
		homepage=new HomePage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchtoframe();
		//contactspage=homepage.verifycontactslink();
		
	}
	/*@Test(priority=1)
	public void verifycontactslableTest() throws Exception
	{
		boolean b2=contactspage.verifycontactlable();
		System.out.println(b2);
		
		//Assert.assertTrue(contactspage.verifycontactlable(),"contacts lable is missing");
	}*/
	/*@Test(priority=2)
	public void verifycontactclickedTest()
	{
		contactspage.clickoncontactbyname("David Cris");
	}*/
	
	
	@DataProvider
	public Object[][] getCRMTestdata() throws Exception, Exception 
	{
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	@Test(priority=1,dataProvider="getCRMTestdata")
	public void verifyNewContactTest(String title,String ftname,String ltname,String cmp) 
	{
		homepage.clickonNewContactLink();
		contactspage.createNewContact(title,ftname,ltname,cmp);
	}
	
    @AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
