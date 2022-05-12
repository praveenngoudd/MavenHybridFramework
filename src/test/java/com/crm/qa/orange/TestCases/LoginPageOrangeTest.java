package com.crm.qa.orange.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.BaseClass.TestBase;
import com.crm.qa.Constants.ConstantsOrangeDemo;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.orangedemo.Pages.HomePageOrange;
import com.crm.qa.orangedemo.Pages.LoginPageOrange;

public class LoginPageOrangeTest extends TestBase {

	LoginPageOrange loginPageOrange;
	HomePageOrange homePageOrange;

	public LoginPageOrangeTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		Log.info("Application Launched Successfully");

		loginPageOrange = new LoginPageOrange();
	}

	@Test(priority = 1, enabled = true)
	public void loginPageOrangeTitleTest() {
		String title = loginPageOrange.validateLoginPageTitle();
		Assert.assertEquals(title, ConstantsOrangeDemo.LOGIN_PAGE_TITLE, "Login Page Title is not Matched");
		Log.info("Login Page Title Verified");
	}

	@Test(priority = 2, enabled = true)
	public void orangeDemoLogoImageTest() {
		boolean flag = loginPageOrange.validateOrangeDemoLogo();
		Assert.assertTrue(flag);
		Log.info("OrangeDemo Logo Verified");
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void loginTest() {
		homePageOrange = loginPageOrange.loginOrange(property.getProperty("Username"), property.getProperty("Password"));
		Log.info("Successfully Logged into CRM Application");
	}

}
