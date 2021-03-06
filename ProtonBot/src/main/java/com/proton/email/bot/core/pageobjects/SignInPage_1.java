package com.proton.email.bot.core.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.proton.email.bot.core.BasePage;

public class SignInPage_1 extends BasePage {
	
	
	@FindBy(css="div.col-sm-1.col-xs-2>i")
	private WebElement freePlanPanel;
	
	public SignInPage_1(WebDriver driver) {
		super(driver);
	}
	
	public boolean attemptToClickOnFreePlan() {	
		freePlanPanel = waitUntilElementLocatedByCSS("div.col-sm-1.col-xs-2>i");
		if(freePlanPanel.isDisplayed()) 
		{
			click(freePlanPanel);
			return true;
		}
		else 
		{
			snapShot();
			return false;
		}
	}
}
