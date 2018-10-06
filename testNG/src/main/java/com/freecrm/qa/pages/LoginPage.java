package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	
	/** page factory,**/
	@FindBy(xpath="//input[@type=\"text\" and @name=\"username\"]")
	WebElement userName;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	
	/** initilization**/
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/*Initilization*/
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String enterUserName(String username)
	{
		userName.sendKeys(username);
		return userName.getText();
	}
	
	public String enterpassword(String pwd)
	{
		password.sendKeys(pwd);
		return userName.getText();
	}
	
	
	public HomePage login(String unam, String pwd)
	{
		userName.sendKeys(unam);
		password.sendKeys(pwd);
		loginBtn.submit();
		return new HomePage();
	}
	
}
