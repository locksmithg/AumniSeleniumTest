package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverUtilities.WaitUtilities;
import pageObjects.HomePage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Aumni_Fund_Tests {

	private WebDriver driver;

	@Before
	public void BeforeEach() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\workspace\\Aumni_Selenium_Test\\src\\test\\resources\\drivers\\chromedriver89.exe");
		driver = new ChromeDriver();
		// Navigate to Page
		driver.get(HomePage.aumniUrl);
	}

	@Test
	public void testHomePage_Title_ShouldBeCorrect() {
		// Get page title
		String actualTitle = driver.getTitle();
		// Check title against the expected title.
		Assert.assertEquals("The title of the site did not match the expected title.", HomePage.title, actualTitle);

	}

	@Test
	public void testHomePage_NavLogo_Load() {
		WebElement navLogoElement = driver.findElement(By.xpath(HomePage.navLogo));
		// Check to see if the logo in the header loaded
		WaitUtilities.WaitForElementToBeVisible(driver, navLogoElement, 10);
		Assert.assertTrue("The Logo isn't displayed.", navLogoElement.isDisplayed());
	}

	@Test
	public void testHomePage_DemoButton_NavigatesToDemoPage() {
		// Could put this in a new Page Object for the demo page
		String expectedDemoUrl = "https://www.aumni.fund/demo";
		WebElement demoButton = driver.findElement(By.xpath(HomePage.bookADemoButton));
		WaitUtilities.WaitForElementAndClick(driver, demoButton, 10);

		// If I were writing a lot more tests, this line would be made a utility to make
		// it more readable.
		new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe(expectedDemoUrl));
		// This is a little redundant since the previous line passed, but having an
		// assert at the end of a test is aesthetically pleasing.
		Assert.assertEquals(expectedDemoUrl, driver.getCurrentUrl());
	}

	@Test
	public void testHomePage_ScrollDownHidesBruce_ScrollUpBringsBackBanner() {
		// Need a js executer to run a scrolling script
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// String that marks that the banner is visible
		String visible = "translate3d(0px, 0%, 0px)";
		// String that marks that the banner is NOT visible
		String invisible = "translate3d(0px, -101%, 0px)";

		// Check that banner is visible
		WebElement banner = driver.findElement(By.xpath(HomePage.banner));
		String bannerStyle = banner.getAttribute("style");
		Assert.assertTrue(bannerStyle.contains(visible));

		// Scroll down, check that banner is invisible
		js.executeScript("window.scrollBy(0,100)");
		bannerStyle = banner.getAttribute("style");
		Assert.assertTrue(bannerStyle.contains(invisible));

		// Scroll up, check that banner is visible
		js.executeScript("window.scrollBy(0,-100)");
		bannerStyle = banner.getAttribute("style");
		Assert.assertTrue(bannerStyle.contains(visible));
	}

	@After
	public void AfterEach() {
		driver.quit();
	}
}
