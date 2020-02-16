package Selenium.exercise.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Selenium.exercise.pom.AlertBoxPO;
import Selenium.exercise.util.WebDriverManager;

public class AlertBoxTest {

	WebDriver driver;
	WebDriverManager webDrvMgr;
	AlertBoxPO alertPO;
	@BeforeClass
	public void setUp()
	{
		webDrvMgr=new WebDriverManager();
		driver=webDrvMgr.launchBrowser("ff");
		
	}
	
	@Test
	public void AlertBtnTest()
	{
		try {
		alertPO=new AlertBoxPO(driver);
		
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		alertPO.clickAlertBtn();
		driver.switchTo().alert().accept();
		Assert.assertFalse(doesAlertExist());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	
	
	
	public boolean doesAlertExist()
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		
		catch(Exception e) {
			
			return false;
		}
		
	}
}
