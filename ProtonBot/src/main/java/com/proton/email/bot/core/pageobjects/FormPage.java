package com.proton.email.bot.core.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.proton.email.bot.core.BasePage;

public class FormPage extends BasePage{

	
	@FindBy(id="username")
	private WebElement alias;
	@FindBy(css="div.pm_select>select")
	private Select select;
	@FindBy(css="input#password")
	private WebElement pwd;
	@FindBy(css="input#passwordc")
	private WebElement pwdc;
	@FindBy(css="input#notificationEmail")
	private WebElement recoveryEmail;
	@FindBy(css="button.signUpProcess-btn-create")
	private WebElement createAccountBtn;
	
	private ArrayList<WebElement> listOfElemnets;
	
	public FormPage(WebDriver driver) {
		super(driver);
		identifyElements();
	}
	
	public boolean attemptToFillFormDetails(String aliasMail, int selectIndex, String pwd, String email) {
		try {
			for(int n = 0; n < listOfElemnets.size(); n++) {
				switch(n) {
				case 0:
					fillText(listOfElemnets.get(n), aliasMail);
					click(select.getOptions().get(selectIndex));
					break;
				case 1:
					fillText(listOfElemnets.get(n), pwd);
					break;
				case 2:
					fillText(listOfElemnets.get(n), pwd);
					break;
				case 3:
					fillText(listOfElemnets.get(n), email);
					break;
				case 4:
					click(listOfElemnets.get(n));
					break;
				}
			}
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	private void identifyElements() {
		select = new Select(waitUntilElementLocatedByCSS("div.pm_select>select"));
		listOfElemnets = new ArrayList<WebElement>();
		
		listOfElemnets.add(alias);
		listOfElemnets.add(pwd);
		listOfElemnets.add(pwdc);
		listOfElemnets.add(recoveryEmail);
		listOfElemnets.add(createAccountBtn);
	}
	
	
	
	
}