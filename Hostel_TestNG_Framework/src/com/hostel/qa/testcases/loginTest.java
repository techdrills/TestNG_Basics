package com.hostel.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*
login test cases

1. valid username + valid password
2. invalid username + valid password
3. valid username + invalid password
4. username & password leave blank and click on sign in button
5. Sign button is enable or not
6. logo is showing or not
 */

public class loginTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		// setup method will use to open browser and launch url
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://ecollegeweb.in/hostel_project/login");
	}
	
	@Test(priority=1)
	public void verifyLogo() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean logoResult = driver.findElement(By.tagName("img")).isDisplayed();
		Assert.assertEquals(logoResult, true);
	}
	
	@Test(priority=1)
	public void verifyLoginButton() {
		boolean buttonVisibility = driver.findElement(By.tagName("button")).isEnabled();
		Assert.assertEquals(buttonVisibility, true);
	}
	
	@Test(priority=3)   // enabled false meaing test case will not run
	public void verifyLoginWithValidDetail() {
		// enter valid username and password and check login functionality
		// validation based on - after login url
		
		String expectedURL = "http://ecollegeweb.in/hostel_project/index";
		
		driver.findElement(By.name("username")).sendKeys("root");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		String actualURL = driver.getCurrentUrl(); // getting url after login
		
		Assert.assertEquals(actualURL, expectedURL , "Validation based on url's");
	}
	
	@Test(priority=4)
	public void verfiyinvalidUsernameDetails() {
		// test for invalid username and valid password
		
		String expectedURL = "http://ecollegeweb.in/hostel_project/login";
		
		driver.findElement(By.name("username")).sendKeys("root123");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		String actualURL = driver.getCurrentUrl(); // getting url after login
		
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(priority=5)
	public void verfiyinvalidPasswordDetails() {
		// test for invalid username and valid password
		
		String expectedURL = "http://ecollegeweb.in/hostel_project/login";
		
		driver.findElement(By.name("username")).sendKeys("root");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		String actualURL = driver.getCurrentUrl(); // getting url after login
		
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(priority=6)
	public void verfiyBlankLoginDetails() {
		// test for invalid username and valid password
		
		String expectedURL = "http://ecollegeweb.in/hostel_project/login";
		
		driver.findElement(By.tagName("button")).click();
		String actualURL = driver.getCurrentUrl(); // getting url after login
		
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	

}
