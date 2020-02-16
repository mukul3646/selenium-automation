package Selenium.exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HandsOnFour {
	
	SoftAssert sf;
	WebDriver webDriver;
	@BeforeMethod
	public void soft()
	{
		sf=new SoftAssert();
	}
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver","libs/drivers/geckodriver");
		webDriver=new FirefoxDriver();
		webDriver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		webDriver.manage().window().maximize();
	}
	
	@Test
	public void TestOne()
	{
	
	try {
	
	
	webDriver.findElement(By.xpath("//div[@class='input-group date']")).click();
	webDriver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='today'][contains(text(),'Today')]")).click();
	
	LocalDate ld=LocalDate.now();
	DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
	String localDate = ld.format(formatters);
	
	String selectedDate=webDriver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']")).getAttribute("value");
	
	//System.out.println(localDate);
	//System.out.println(selectedDate);
	
	sf.assertEquals(selectedDate,localDate);
	sf.assertAll();
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail("Exception");
	}
	
}
	
	@Test
	public void TestTwo(){
		
		try {
		webDriver.findElement(By.xpath("//div[@class='input-group date']")).click();
		webDriver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='clear'][contains(text(),'Clear')]")).click();
		
		String inputBoxValue=webDriver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']")).getAttribute("placeholder");
	//	System.out.println(inputBoxValue);
		sf.assertNotEquals(inputBoxValue, "dd/mm/yy");
		sf.assertAll();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("OOOPs");
		}
		
	}
	
	@Test
	public void testThree()
	{
		try {
			webDriver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
			webDriver.findElement(By.xpath("//div[@class='input-group date']//span[@class='input-group-addon']")).click();
			
			String actualResult=webDriver.findElement(By.xpath("//th[@class='dow']")).getText().trim().toLowerCase();
			Assert.assertEquals("mo", actualResult);
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
		
		
	}
	
	@Test
	public void testFour()
	{
		try {
			webDriver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
			List<WebElement> oElem=webDriver.findElements(By.xpath("//div[@class='datepicker-days']//tbody//tr"));
			
			for(WebElement oResult:oElem)
            {	
			 List<WebElement> childs=oResult.findElements(By.xpath("./child::*"));                
			 sf.assertEquals(childs.get(6).getAttribute("class"),"disabled disabled-date day");
           
            }

            sf.assertAll();                

        }
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	@AfterClass
    public void tearDown()
    {

		webDriver.quit();        
		
    }
	
}