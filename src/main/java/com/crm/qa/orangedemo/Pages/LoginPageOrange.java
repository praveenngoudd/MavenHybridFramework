package com.crm.qa.orangedemo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.BaseClass.TestBase;
import com.crm.qa.Pages.HomePage;

public class LoginPageOrange extends TestBase{
	
	@FindBy(xpath="//input[@name='txtUsername']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='button' and @type='submit']") 
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id='divLogo']/img")
	WebElement orangeLogo;
	
	
	public LoginPageOrange()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateOrangeDemoLogo()
	{
		return orangeLogo.isDisplayed();
	}
	
	public HomePageOrange loginOrange(String uname, String pword)
	{
		username.sendKeys(uname);
		password.sendKeys(pword);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
				
		return new HomePageOrange();
	}
}
