package com.crm.qa.orangedemo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.BaseClass.TestBase;
public class HomePageOrange extends TestBase {

	@FindBy(xpath = "//a[@id='welcome']")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@id='menu_directory_viewDirectory']")
	WebElement directory;

	@FindBy(xpath = "//a[@id='menu_maintenance_purgeEmployee']")
	WebElement maintainance;

	public HomePageOrange() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public DirectoryPageOrange clickOnDirectoryLink() throws InterruptedException
	{
		directory.click();
		Thread.sleep(3000);
		return new DirectoryPageOrange();
	}

}
