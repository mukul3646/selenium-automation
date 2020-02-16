package Selenium.exercise.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Selenium.exercise.pom.TablePO;
import Selenium.exercise.util.WebDriverManager;

public class TableTest {
	
	WebDriver driver;
	WebDriverManager webDrvMgr;
	TablePO tablePO;
	SoftAssert sf;
	
	@BeforeMethod
	public void softSetUp()
	{
		sf=new SoftAssert();
		
	}
	
	@BeforeClass
	public void setUp()
	{
		webDrvMgr=new WebDriverManager();
		driver=webDrvMgr.launchBrowser("ff");
		
	}
	
	@Test
	public void testSearch()
	{
		try {
			
		
		tablePO=new TablePO(driver);
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		
		tablePO.enterSearchValue("m");
		List<WebElement> oElem=tablePO.getTableList();
		
		for(WebElement oTemp:oElem)
		{
			List<WebElement> childs=tablePO.childCols(oTemp);
			
			System.out.println(tablePO.isVisible(childs));
			
			if(!((tablePO.isVisible(childs)).equals("display: none;")))	
			{
				
				sf.assertTrue(tablePO.isPresent(childs,"m"));			
			}
			
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

		driver.quit();        
		

    }
}
