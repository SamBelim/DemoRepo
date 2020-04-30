package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory--- ObjectRepository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signuplink;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	//Initialization of objects
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	//Actions
	public String validateLoginPageTitle()
	{
		 return driver.getTitle();
		
	}
	
	public boolean validateCRMLogo()
	{
		 return crmlogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String psw)
	{
		username.sendKeys(un);
		password.sendKeys(psw);
		loginbtn.click();
		return new HomePage();
	}
}
