package com.crm.qa.orange.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.BaseClass.TestBase;
import com.crm.qa.Constants.ConstantsOrangeDemo;
import com.crm.qa.Utilities.TestUtility;
import com.crm.qa.orangedemo.Pages.DirectoryPageOrange;
import com.crm.qa.orangedemo.Pages.HomePageOrange;
import com.crm.qa.orangedemo.Pages.LoginPageOrange;

public class HomePageOrangeTest extends TestBase {

	LoginPageOrange loginPageOrange;
	HomePageOrange homePageOrange;
	TestUtility testUtil;
	DirectoryPageOrange directoryPageOrange;
	
	public HomePageOrangeTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization();
		Log.info("Application Launched Successfully");
		loginPageOrange = new LoginPageOrange();
	    directoryPageOrange = new DirectoryPageOrange();
	    testUtil = new TestUtility();
		homePageOrange = loginPageOrange.loginOrange(property.getProperty("Username"),property.getProperty("Password"));
	}

	@Test(priority=1, enabled=true)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePageOrange.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, ConstantsOrangeDemo.HOME_PAGE_TITLE, "Home Page Title is not Matched");
		Log.info("Home Page Title Verified");
	}

	@Test(priority=2, enabled=true)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePageOrange.verifyCorrectUserName());
		Log.info("UserName Verified");
	}
	
	@Test(priority=3, enabled=true)
	public void verifyContactsLinkTest() throws InterruptedException
	{
		testUtil.switchToFrame("mainpanel");
		directoryPageOrange = homePageOrange.clickOnDirectoryLink();
		Log.info("Switched into Frame and Clicked on Contacts Link");
	}
	
}
