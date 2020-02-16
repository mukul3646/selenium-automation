package Selenium.exercise.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarPO {
	WebDriver driver;
	
	public CalendarPO(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By selectBtn=By.xpath("//div[@class='input-group date']//span[@class='input-group-addon']");
	By todaySelectBtn=By.xpath("//div[@class='datepicker-days']//th[@class='today'][contains(text(),'Today')]");
	By clearBtn=By.xpath("//div[@class='datepicker-days']//th[@class='clear'][contains(text(),'Clear')]");
	By selectedDate=By.xpath("//input[@placeholder='dd/mm/yyyy']");
	By picker=By.xpath("//div[@class='datepicker-days']//tbody//tr");	
	By childx=By.xpath("./child::*");
	
	public List<WebElement> childxx(WebElement oResult)
	{
		return oResult.findElements(childx);
		
	}
	
	public String isDisabled(List<WebElement> childs)
	{
		return childs.get(6).getAttribute("class");
		
	}
	
	public String getSelectedAttribute()
	{
		return driver.findElement(selectedDate).getAttribute("value");
		
	}
	
	public List<WebElement> getCols()
	{
		
		return driver.findElements(By.xpath("//div[@class='datepicker-days']//tbody//tr"));
	}
	
	public String getFirstDay()
	{
		return driver.findElement(By.xpath("//th[@class='dow']")).getText().trim().toLowerCase();
	}
	
	public String getClearedAttribute()
	{
		return driver.findElement(selectedDate).getAttribute("placeholder");
		
	}
	
	public void clickSelectBtn()
	{
		driver.findElement(selectBtn).click();
	}
	
	public void clickTodayBtn()
	{
		driver.findElement(todaySelectBtn).click();
	}
	
	public void clickClearBtn()
	{
		driver.findElement(clearBtn).click();
	}
}
