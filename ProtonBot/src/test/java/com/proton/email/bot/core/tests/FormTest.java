package com.proton.email.bot.core.tests;

import org.testng.annotations.Test;

import com.proton.email.bot.core.pageobjects.FormPage;

public class FormTest extends ProtonTests {
	
	
	private FormPage form;
	
	@Test
	public void Fill_form_details_and_create_dotCom_account_TEST() {
		
	
		
		form = new FormPage(this.driver);
		form.attemptToFillFormDetails(getRandomString(), 0, this.passwd, recoveryEmail);
		//form.attemptToFillFormDetails(getRandomString(), 1, this.passwd, recoveryEmail);
	}
	
	
	
}
