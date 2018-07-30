package System;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class NewTest {
	private ChromeDriver driver;
	public static final String USERNAME = "G00003@100002.com";
	public static final String USERNAME1 = "G00003@100002.com2";
	public static final String ACCESS_KEY = "nQr6n6Td!9";

	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dell\\Documents\\LEA\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev.cardholder.an-other.co.uk/user/login");

		WebElement usernameElement = driver.findElement(By.name("LoginForm[login]"));
		WebElement passwordElement = driver.findElement(By.name("LoginForm[password]"));
		WebElement formElement = driver.findElementById("LoginForm");

		usernameElement.sendKeys(USERNAME);
		passwordElement.sendKeys(ACCESS_KEY);

		formElement.submit();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement assertElement = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.id("lnk-account-settings")));

		// Run a test
		String assertElementValue = assertElement.getText();

		System.out.println(assertElementValue);
		System.out.println(USERNAME);
		// Assertion.assertTrue(assertElementValue.contains(USERNAME));
		Assert.assertEquals(assertElementValue, USERNAME1);
		// Conclude a test
	}
	
	@Test
	public void anotherTestMethod() {
		System.out.println("asdasd");
	}

	@BeforeTest
	public void beforeTest() {
		

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
