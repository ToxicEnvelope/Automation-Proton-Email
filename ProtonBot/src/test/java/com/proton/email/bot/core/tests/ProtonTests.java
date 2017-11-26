package com.proton.email.bot.core.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProtonTests {
	
	
	protected WebDriver driver;
	protected String passwd = "Aa12345678";
	protected String recoveryEmail = "sysmurff@gmail.com";
	
	public static final String BASE_URL = "https://mail.protonmail.com/login";
	public static final String GMAIL_SIGNIN_URL = "https://accounts.google.com/";
	public static final String RECOVERY_EMAIL = "sysmurff@gmail.com";
	public static final String RECOVERY_EMAIL_PASSWD = "%lol%#YourFac3~";
	
	@BeforeClass
	public void setUp() {
		String engine = "webdriver.chrome.driver",
			   wdPath = System.getProperty("user.dir") + "/Drivers/chromedriver";
		System.setProperty(engine, wdPath);
		driver = new ChromeDriver();
		driver.get(BASE_URL);
	}

//	@AfterClass
//	public void tearDown() {
//		if(driver != null) {
//			driver.quit();
//		}	
//	}
	
	
	protected String getRandomString() { 
		return RandomStringUtils.random(8);
	} 
	

}