package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	String sheetname="contact";
	public ContactPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		contactPage=new ContactPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage=homePage.clickOnContactLink();
		
		
	}
	
	@Test(priority = 1)
	public void verifyContactLabelTest()
	{
		
		boolean flag=contactPage.verifyContactsLabel();
		Assert.assertTrue(flag,"Conatct label not found");
	}
	
	@Test(priority = 2)
	public void selectContactNameTest()
	{
		contactPage.selectContactsByName("Aakash Shah");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsNameTest()
	{
		contactPage.selectContactsByName("Aakash Shah");
		contactPage.selectContactsByName("akash reddy");
		
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object[][] data=TestUtil.getTestData(sheetname);
		return data;
	
	}
	@Test(priority=4, dataProvider = "getCRMTestData")
	public void validateCreateNewContactTest(String title,String firstname,String lastname,String company)
	{
		homePage.clickOnNewContactLink();
	    contactPage.createNewContact(title,firstname,lastname,company);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
}
