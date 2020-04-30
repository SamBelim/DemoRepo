package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactPage contactPage;
	 public HomePageTest() 
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
	
	}
	
	@Test(priority =1)
	public void verifyHomePageTitleTest()
	{
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Home page title not match");
	}
	
	@Test(priority=2)
	public void verifyHomePageUsernameTest()
	{
		testUtil.switchToFrame();
		boolean flag=homePage.verifyCorrectUsername();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactPage=homePage.clickOnContactLink();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
