package Selenium.exercise.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TablePO {

WebDriver driver;
	
	public TablePO(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By searchInputBtn=By.xpath("//input[@id='task-table-filter']");
	By tableValues=By.xpath("//div[@class='panel panel-primary']//tbody//tr");
	By childx=By.xpath("./child::*");
	
	
	public List<WebElement> childCols(WebElement oResult)
	{
		return oResult.findElements(childx);
		
	}
	
	public String isVisible(List<WebElement> childs)
	{
		return childs.get(2).getAttribute("style");
		
	}
	
	public boolean isPresent(List<WebElement> childs,String c)
	{
		return childs.get(2).getText().trim().contains(c);
		
	}
	
	public void enterSearchValue(String str)
	{
		driver.findElement(searchInputBtn).sendKeys(str);
		
	}

	public List<WebElement> getTableList()
	{
		return driver.findElements(tableValues);
	}
	
	
}
