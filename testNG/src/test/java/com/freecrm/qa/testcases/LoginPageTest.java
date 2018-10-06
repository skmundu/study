package com.freecrm.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.testbase.TestBase;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		loginPage=new LoginPage();
		
			
	}
	
	@Test
	public void validateTitle()
	{
		String actualTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", actualTitle);

	}
	
	@Test
	public void login()
	{
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password") );
		
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
