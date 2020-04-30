package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDealLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initialization 
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactPage clickOnContactLink()
	{
		//contactLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		//dealsLink.click();
		return new DealsPage();
		
	}
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		
	}
	
	public void clickOnNewDealLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDealLink.click();
	}

}
