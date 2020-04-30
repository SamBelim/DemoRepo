package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest  extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactPage contactPage;
	DealsPage dealPage;
	String sheetname="deals";
	public DealsPageTest()
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
		dealPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority = 1)
	public void verifyDealLabelTest()
	{
		
		boolean flag=dealPage.verifyDealsLabel();
		Assert.assertTrue(flag,"New Deals label not found");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority = 2,dataProvider = "getData")
	public void createNewDealTest(String title,String company,String type)
	{
		homePage.clickOnNewDealLink();
		dealPage.createNewDeal(title, company, type);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	
	
}
