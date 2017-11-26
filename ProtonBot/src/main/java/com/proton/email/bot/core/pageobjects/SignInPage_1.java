package com.proton.email.bot.core.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
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
			_js = (JavascriptExecutor) _driver;
			_js.executeScript("arguments[0].setAttribute('style','border: 2px solid orange;');", freePlanPanel);
			_js.executeScript("arguments[0].click()", freePlanPanel);
			wait(2500);
			return true;
		}
		else 
		{
			snapShot();
			return false;
		}
	}
}