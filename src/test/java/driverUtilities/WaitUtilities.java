package driverUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities 
{
	public static void WaitForElementToBeVisible(WebDriver driver, WebElement element, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void WaitForElementAndClick(WebDriver driver, WebElement element, int timeout)
	{
		WaitForElementToBeVisible(driver, element, timeout);
		element.click();
	}
}
