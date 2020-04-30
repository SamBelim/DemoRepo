package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	//Page Factory
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel; 
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit'and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	
	//Initialization of Objects
	public ContactPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public boolean verifyContactsLabel()
	{
		//contactLink.click();
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	{
		contactLink.click();
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String tit,String fname,String lname,String comp)
	{
		Select titledd=new Select(title);
		titledd.selectByVisibleText(tit);
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	

}
