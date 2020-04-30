package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//input[@value='New Deal']")
	WebElement dealLabel;
	
	@FindBy(id="title")
	WebElement titleDeal;
	
	@FindBy(name="client_lookup")
	WebElement companyDeal;
	
	@FindBy(name="type")
	WebElement typeDeal;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	
	public DealsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyDealsLabel()
	{
		dealsLink.click();
		return dealLabel.isDisplayed();
	}
	
	public void createNewDeal(String title,String company,String type)
	{
		titleDeal.sendKeys(title);
		companyDeal.sendKeys(company);
		
		Select dd=new Select(typeDeal);
		dd.selectByVisibleText(type);
		
		saveBtn.click();
		
	}
	
	

}
