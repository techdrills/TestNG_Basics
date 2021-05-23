package TestNG_Basics;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	// Annotations in TestNG
	@BeforeSuite	
	@BeforeClass	
	@BeforeMethod	
	@BeforeTest	
	@BeforeGroups	
		@Test
		public void abc() { }
	@AfterGroups
	@AfterTest
	@AfterMethod
	@AfterClass
	@AfterSuite
	
	@Test
	public void launchBrowser() {
		System.out.println("from testNG class");
		//System.out.println();
	}
	
	@Test
	public void failcase() {
		System.out.println("from fail case");
		int i =5;
		int j = i/0;
		System.out.println(j);
	}
	
	@Test
	public void add() {
		int a =5;
		int b =5;
		int c=a+b;
		System.out.println("Addition is "+ c);
			if(c==10) {
				System.out.println("Test case is passed");
			}
	//assertEquals(c, 10);
			
	}
	
	
	
	
	

}
