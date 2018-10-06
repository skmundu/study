package com.freecrm.qa.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.freecrm.qa.utility.TestUtil;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\freecrm\\qa\\configuration\\config.properties");
			prop.load(fis);
		
		
		} catch (Exception e) {
			
			System.out.println("Error Loading properties file"+e.getClass().toString());
		}
		
	
		
		
		
	}

	public static void initilization()
	{
		System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"src\\main\\java\\com\\freecrm\\qa\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();		
		
		/*
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
				{
						System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\com\\freecrm\\qa\\drivers\\chromedriver.exe");
						driver=new ChromeDriver();					
					
				}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.getProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\com\\freecrm\\qa\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		*/
	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	
	
	}
	

}
