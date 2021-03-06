package com.proton.email.bot.core.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.proton.email.bot.core.BasePage;

public class LoginPage extends BasePage {


	@FindBy(css="a.loginForm-link-signup.loginForm-actions-right")
	private WebElement createAccountBtn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	public boolean attemptToClickOnCreateAccountBtn() {
		createAccountBtn = waitUntilElementLocatedByCSS("a.loginForm-link-signup.loginForm-actions-right");
		if(createAccountBtn.isDisplayed()) {
			click(createAccountBtn);
			return true;
		}
		else {
			snapShot();
			return false;
		}
	}
	
}
