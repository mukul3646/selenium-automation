package Selenium.exercise.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPageFactory {

	WebDriver driver;
	
	public CalendarPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='input-group date']//span[@class='input-group-addon']")
	WebElement selectBtn;
	
	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='today'][contains(text(),'Today')]")
	WebElement todaySelectBtn;
	
	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='clear'][contains(text(),'Clear')]")
	WebElement clearBtn;
	
	@FindBy(xpath="//input[@placeholder='dd/mm/yyyy']")
	WebElement selectedDate;
	
	@FindBy(xpath="//div[@class='datepicker-days']//tbody//tr")
	List<WebElement> picker;
	
//	@FindBy(xpath="./child::*")
//	List<WebElement> childx;
	
	@FindBy(xpath="//th[@class='dow']")
	WebElement firstDay;
	
	public List<WebElement> childxx(WebElement oResult)
	{
		return oResult.findElements(By.xpath("./child::*"));
		
	}
	
	public String isDisabled(List<WebElement> childs)
	{
		return childs.get(6).getAttribute("class");
		
	}
	
	public String getSelectedAttribute()
	{
		return selectedDate.getAttribute("value");
		
	}
	
	public List<WebElement> getCols()
	{
		
		return picker;
	}
	
	public String getFirstDay()
	{
		return firstDay.getText().trim().toLowerCase();
	}
	
	public String getClearedAttribute()
	{
		return selectedDate.getAttribute("placeholder");
		
	}
	
	public void clickSelectBtn()
	{
		selectBtn.click();
	}
	
	public void clickTodayBtn()
	{
		todaySelectBtn.click();
	}
	
	public void clickClearBtn()
	{
		clearBtn.click();
	}
}

