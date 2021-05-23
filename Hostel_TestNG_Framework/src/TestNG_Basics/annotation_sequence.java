package TestNG_Basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annotation_sequence {
	
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	
	// to import all statement - ctrl+shift+O
	
	// Pre condition annotations
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class Annotation");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Annotation");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite Annotation");
	}
	
	
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method Annotation");
	}
	
	// @Test Refers a test case
	
	
	
	
	@Test
	public void test3() {
		System.out.println("Test 3");
	}
	
	
	
	@Test
	public void test5() {
		System.out.println("Test 5");
	}
	// Post Condition annotations
	

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite Annotation");
	}
	
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class Annotation");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method Annotation");
	}
	
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test Annotation");
	}
	
	
	@Test
	public void test4() {
		System.out.println("Test 4");
	}

}
