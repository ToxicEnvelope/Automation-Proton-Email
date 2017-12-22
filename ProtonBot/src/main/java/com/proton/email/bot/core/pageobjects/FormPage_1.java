package com.proton.email.bot.core.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.proton.email.bot.core.BasePage;

public class FormPage_1 extends BasePage {

	
	public FormPage_1(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(css="div.usernameWrap#username")
	protected WebElement alias;
	@FindBy(css="input#password")
	protected WebElement pwd;
	@FindBy(css="input#passwordc")
	protected WebElement pwdc;
	@FindBy(css="input#notificationEmail")
	protected WebElement recoveryEmail;
	@FindBy(css="button.signUpProcess-btn-create")
	protected WebElement createAccountBtn;
	
	protected ArrayList<WebElement> listOfElemnets;
}
