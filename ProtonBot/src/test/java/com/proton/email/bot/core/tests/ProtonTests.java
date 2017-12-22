package com.proton.email.bot.core.tests;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.proton.email.bot.core.pageobjects.FormPage;
import com.proton.email.bot.core.pageobjects.GmailInboxPage;
import com.proton.email.bot.core.pageobjects.HumanPage;
import com.proton.email.bot.core.pageobjects.LoginPage;
import com.proton.email.bot.core.pageobjects.SignInPage;

public class ProtonTests {
	
	
	protected WebDriver driver;
	
	public static final String BASE_URL = "https://mail.protonmail.com/login";
	public static final String GMAIL_SIGNIN_URL = "https://accounts.google.com/";
	public static final String RECOVERY_EMAIL = "sysmurff@gmail.com";
	public static final String RECOVERY_EMAIL_PASSWD = "%lol%#YourFac3~";
	
	private LoginPage login;
	private SignInPage sign;
	private FormPage form;
	private HumanPage human;
	private GmailInboxPage gmail;

	
	@BeforeClass
	public void setUp() {
		String engine = "webdriver.chrome.driver",
			   wdPath = System.getProperty("user.dir") + "/Drivers/chromedriver";
		System.setProperty(engine, wdPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get(BASE_URL);
		driver.manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS);
	}
	
	
	@Test(priority=1)
	public void Click_on_Create_Account_TEST() {
		login = new LoginPage(driver);
		Assert.assertTrue(login.attemptToClickOnCreateAccountBtn());
	}
	
	@Test(priority=2)
	public void Select_free_plan_TEST() {
		sign = new SignInPage(driver);
		Assert.assertTrue(sign.attemptToClickOnFreePlan());
		Assert.assertTrue(sign.attemptToClickOnSelectFreePlanBtn());
	}
	
	@Test(priority=3)
	public void Fill_form_details_and_create_dotCom_account_TEST() {	
		form = new FormPage(this.driver);
		form.attemptToFillFormDetails(getRandomString(), RECOVERY_EMAIL_PASSWD, RECOVERY_EMAIL);
		//form.attemptToFillFormDetails(getRandomString(), 1, this.passwd, recoveryEmail);
	}
	
	@Test(priority=4)
	public void Confirm_Human_and_Verify_Email() {
		human = new HumanPage(driver);
		Assert.assertTrue(human.attemptToVerifyHumanGivenEmail(RECOVERY_EMAIL));
	}
	
	@Test(priority=5)
	public void Verify_Proton_MSG_Inside_Gmail_Inbox() {
		gmail = new GmailInboxPage(driver);
		Assert.assertTrue(gmail.isProtonThreadInsideInbox());
	}
	
	@Test(priority=6)
	public void Grab_From_Thread_and_Retreive_BiggerKeyPass() {
		
	}
	

//	@AfterClass
//	public void tearDown() {
//		if(driver != null) {
//			driver.quit();
//		}	
//	}
	
	
	protected String getRandomString() { 
		return RandomStringUtils.randomAlphanumeric(8);
	} 

}
