package com.hostel.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	
	// Generic method for log in to the app and it required one argument of type WebDriver
	public void loginApp(WebDriver driver) {
		driver.findElement(By.name("username")).sendKeys("root");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
	}
	
	
	public void loginAppWithParameter(WebDriver driver, String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
	}


}
