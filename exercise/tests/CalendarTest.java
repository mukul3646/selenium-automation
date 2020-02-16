package Selenium.exercise.tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Selenium.exercise.pom.CalendarPO;
import Selenium.exercise.util.WebDriverManager;

public class CalendarTest {

	WebDriver driver;
	WebDriverManager webDrvMgr;
	CalendarPO calendarPO;
	SoftAssert sf;
	
	@BeforeMethod
	public void softSetUp()
	{
		sf=new SoftAssert();
		
	}
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser)
	{
		webDrvMgr=new WebDriverManager();
		driver=webDrvMgr.launchBrowser(browser);
		
	}
	
	@Test
	public void testTodayDate()
	{
		try{
		calendarPO=new CalendarPO(driver);
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		
		calendarPO.clickSelectBtn();
		calendarPO.clickTodayBtn();
		
		LocalDate ld=LocalDate.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String localDate = ld.format(formatters);

		Assert.assertTrue(calendarPO.getSelectedAttribute().contains(localDate));
	
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testClearBtn()
	{
		try {
		calendarPO=new CalendarPO(driver);
		
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		calendarPO.clickSelectBtn();
		calendarPO.clickTodayBtn();
		calendarPO.clickSelectBtn();
		calendarPO.clickClearBtn();
		
		
		Assert.assertEquals(calendarPO.getClearedAttribute(), "dd/mm/yyyy");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testFirstDayMonday()
	{
		try {
		calendarPO=new CalendarPO(driver);
		
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		calendarPO.clickSelectBtn();
		Assert.assertEquals("mo", calendarPO.getFirstDay());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testSundaysDisabled()
	{
		calendarPO=new CalendarPO(driver);
		
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		calendarPO.clickSelectBtn();
		List<WebElement> oElem=calendarPO.getCols();
		
		for(WebElement oResult:oElem)
        {	
			List<WebElement> childs=calendarPO.childxx(oResult);
			String actual=calendarPO.isDisabled(childs);
			System.out.println(actual);
			
			sf.assertTrue(actual.contains("disabled disabled-date day"));

        }
	
	sf.assertAll();
	}
	@AfterClass
	public void tearDown()
    {

		driver.quit();        
		
    }
	
		
}
