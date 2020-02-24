package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("before navigate to:  '"+url+"'");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("navigate to: ' "+url+"'");
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver driver) {

		System.out.println("navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {

		System.out.println("navigating back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {

		System.out.println("navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {

		System.out.println("navigate forward to next page");
	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

		System.out.println("trying to find element By: " +by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {

		System.out.println("found element by: "+by.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("trying to click on: "+element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
 
		System.out.println("clicked on: "+element.toString());
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

		System.out.println("value of the element: "+element.toString()+"before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

		System.out.println("element value changed to: "+element.toString());
	}

	public void onException(Throwable throwable, WebDriver driver) {

		System.out.println("exception occured: "+throwable);
		try
		{
			TestUtil.takeScreenshotAtEndOfTest();
		}catch(IOException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


}
