package com.hostel.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hostel.qa.utilities.login;

public class homePageTest {

	public static WebDriver driver;
	login log = new login();
/*	
	@BeforeMethod 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://ecollegeweb.in/hostel_project/login");
		log.loginApp(driver);		
	}
	*/
	
	@BeforeMethod 
	@Parameters ({"username", "password"})
	
	public void setup(String username, String password) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://ecollegeweb.in/hostel_project/login");
		//log.loginApp(driver);	
		log.loginAppWithParameter(driver, username, password);
	}
	
	@AfterMethod 
	public void teardown() {
		driver.close();
	}
	
	@Test (groups="Homepage Elements")
	public void titleTest() {
		String titleAftetrLogin = driver.getTitle();
		System.out.println(titleAftetrLogin);
		
		//validate test case
		
		Assert.assertEquals(titleAftetrLogin, "Hostel Paradise");
	}
	
	@Test (groups="Homepage Elements")
	public void urlTest() {
		String urlAfterLogin = driver.getCurrentUrl();
		System.out.println(urlAfterLogin);
		
		// validate test case
		
		Assert.assertEquals(urlAfterLogin, "http://ecollegeweb.in/hostel_project/index");
	}
	
	@Test (groups="Link Verifications")
	public void verifyHomeLink() {
	
		WebElement homeLink = driver.findElement(By.xpath("//body/div[1]/aside[1]/div[2]/nav[1]/ul[1]/li[1]/a[1]"));
		
		boolean result = homeLink.isDisplayed();		
		Assert.assertEquals(result, true);
		
		homeLink.click();
		String homeURL = driver.getCurrentUrl();
		Assert.assertEquals(homeURL, "http://ecollegeweb.in/hostel_project/index");
	}
	
	@Test (groups="Link Verifications")
	public void verifyAddStudentLink() throws InterruptedException {
	
		WebElement addStudentLink = driver.findElement(By.xpath("//body/div[1]/aside[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]"));
		
		boolean result = addStudentLink.isDisplayed();		
		Assert.assertEquals(result, true);
		
		addStudentLink.click();
		Thread.sleep(2000);
		String addStudURL = driver.getCurrentUrl();
		Assert.assertEquals(addStudURL, "http://ecollegeweb.in/hostel_project/add_student");
	}
	
	@Test (groups="Homepage Elements")
	public void verifyAddStudentButton() {
		WebElement button = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/button[1]"));
		boolean buttonResult = button.isDisplayed();
		Assert.assertEquals(buttonResult, true);
		
		button.click();
		String urlAfterButtonClick = driver.getCurrentUrl();
		String expectedURl = "http://ecollegeweb.in/hostel_project/add_student";
		Assert.assertEquals(urlAfterButtonClick, expectedURl);
			
	}
	
	@Test (groups="Log Out", invocationCount = 1)
	public void verifyLogOut() throws InterruptedException {
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/a[1]")).click();
		String urlAfterLogOut = driver.getCurrentUrl();
		Assert.assertEquals(urlAfterLogOut, "http://ecollegeweb.in/hostel_project/login");
	}
	
	@Test (dependsOnMethods = "verifyLogOut")
	public void averifyUserName() {
		String userName = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]")).getText();
		Assert.assertEquals(userName, "John Doe");
	}
	
//	@Test (invocationTimeOut = 10)
//	public void infiite() {
//		for(;;) {
//			System.out.println("Infinite Test Case...");
//		}
//	}
	

	
	

//=======================================================================================================	
	// Definition of Assertion
	//Assertions in TestNG are a way to verify that the expected result and the actual result matched or not. If we could decide the outcome on different small methods using assertions in our test case, we can determine whether our test failed or passed overall.	
	
	
}
