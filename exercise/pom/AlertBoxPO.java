package Selenium.exercise.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertBoxPO {

	WebDriver driver;
	
	public AlertBoxPO(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By byAlertBtn=By.xpath("//button[@class='btn btn-default']");
	
	public void clickAlertBtn()
	{
		driver.findElement(byAlertBtn).click();
	}
	
}
