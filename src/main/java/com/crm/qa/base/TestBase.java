package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebEventListener eventListner;
	public  static EventFiringWebDriver e_driver;
	public static	WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop =new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\Toshiba\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm"
					+ "\\qa\\config\\config.properties");
			prop.load(ip);
		    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public static void initialization()
	{
		prop.getProperty("chrome");
		
		
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListner = new WebEventListener();
			e_driver.register(eventListner);
			driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	

}
