package com.proton.email.bot.core.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.proton.email.bot.core.pageobjects.LoginPage;

public class LoginTest extends ProtonTests {

	
	protected LoginPage login;
	
	@Test
	public void Click_on_Create_Account_TEST() {
		login = new LoginPage(this.driver);
		Assert.assertTrue(login.attemptToClickOnCreateAccountBtn());
	}
}