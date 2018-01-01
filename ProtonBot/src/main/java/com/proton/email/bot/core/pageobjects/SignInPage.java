package com.proton.email.bot.core.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends SignInPage_1 {


	@FindBy(css="div.panel-footer>div.row>div>button")
	private WebElement selectPlanBtn;
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	

	public boolean attemptToClickOnSelectFreePlanBtn() {
		selectPlanBtn = waitUntilElementLocatedByCSS("div.panel-footer>div.row>div>button");
		if(selectPlanBtn.isDisplayed())
		{
			scrollTo(selectPlanBtn);
			wait(1000);
			click(selectPlanBtn);
			return true;
		}
		else
		{
			snapShot();
			return false;
		}
	}

}
