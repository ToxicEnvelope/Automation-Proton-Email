package com.proton.email.bot.core.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.proton.email.bot.core.BasePage;


import net.serenitybdd.core.annotations.findby.FindBy;


public class HumanPage extends BasePage {
	

	@FindBy(css="div.humanVerification-wrapper")
	WebElement humanWrapper;
	// --- Non-PageFactory Associated --- //
	WebElement humanTitleMSG;
	WebElement helpInfo;
	WebElement helpInfoDeep;
	WebElement emailRadioBtn; 
	WebElement smsRadioBtn;
	WebElement donateRadioBtn;
	WebElement emailVerificationField;
	WebElement sendBtn;
	WebElement verificationMSG;
	WebElement verificationBiggerField;
	
	// Constructor
	public HumanPage(WebDriver driver) {
		super(driver);
		identifyElements();
	}

	public boolean attemptToVerifyHumanGivenEmail(String email) {		
		try {
			click(emailRadioBtn);
			fillText(emailVerificationField, email);
			click(sendBtn);
			if (isVerificationCodeSentMSGDisplayed())
			{
				verificationBiggerField = waitUntilElementLocatedByCSS("form.pm_grid div.margin > input.bigger");
				return true;
			}
			return false;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected void identifyElements() {
		humanWrapper = waitUntilElementLocatedByCSS("div.humanVerification-wrapper");
		this.humanTitleMSG = humanWrapper.findElement(By.cssSelector("label.titleLabel > span"));
		this.helpInfo = humanWrapper.findElement(By.cssSelector("p.help"));
		this.helpInfoDeep = humanWrapper.findElement(By.cssSelector("p.help.humanVerification-help-privacy"));
		this.emailRadioBtn = humanWrapper.findElement(By.cssSelector("div.humanVerification-block-email div > input.customRadio-input")); 
		this.smsRadioBtn = humanWrapper.findElement(By.cssSelector("div.humanVerification-block-sms div > input.customRadio-input"));
		this.donateRadioBtn = humanWrapper.findElement(By.cssSelector("div.humanVerification-block-donation div > input.customRadio-input"));
		this.emailVerificationField = humanWrapper.findElement(By.cssSelector("form.pm_grid div > input[type=email]"));
		this.sendBtn = humanWrapper.findElement(By.cssSelector("form.pm_grid div > button.pm_button"));
	}


	private boolean isVerificationCodeSentMSGDisplayed() {
		verificationMSG = waitUntilElementLocatedByCSS("form.pm_grid > p.alert.alert-success");
		if (verificationMSG.isDisplayed())
		{
			return false;
		}
		return false;
	}
}
