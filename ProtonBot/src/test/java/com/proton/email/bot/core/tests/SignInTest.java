package com.proton.email.bot.core.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.proton.email.bot.core.pageobjects.SignInPage;

public class SignInTest extends ProtonTests {


	protected SignInPage sign;
	
	@Test
	public void Select_free_plan_TEST() {
	
		
		sign = new SignInPage(this.driver);
		Assert.assertTrue(sign.attemptToClickOnFreePlan());
		Assert.assertTrue(sign.attemptToClickOnSelectFreePlanBtn());
	}


}
