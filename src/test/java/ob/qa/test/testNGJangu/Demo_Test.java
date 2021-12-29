package ob.qa.test.testNGJangu;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_Test {
	
	@BeforeSuite
	public void beforeSuiteSetup() {
		System.out.println("Before Suite Executed");
	}
	
	@AfterSuite
	public void afterSuiteSetup() {
		System.out.println("After Suite Executed");
	}

	@BeforeTest
	public void beforeTestSetup() {
		System.out.println("Before Test Setup done");
	}
	
	@AfterTest
	public void aftertestTearDown() {
		System.out.println("After Test Teardown done");
	}
	
	@BeforeClass
	public void beforeClassSetup() {
		System.out.println("Before Class Setup done");
	}
	
	@AfterTest
	public void afterClassTearDown() {
		System.out.println("After Class Teardown done");
	}
	
	@BeforeMethod
	public void beforeMethodSetup() {
		System.out.println("Before Method Setup done");
	}
	
	@AfterMethod
	public void afterMethodTeardown() {
		System.out.println("After Method Teardown done");
	}
	
	@Test
	public void test1() {
		System.out.println("Test1 executed");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2 executed");
	}
	
	@Test
	public void test3() {
		System.out.println("Test3 executed");
	}
	
	@Test
	public void test4() {
		System.out.println("Test4 executed");
	}
	
	@Test
	public void test5() {
		System.out.println("Test5 executed");
	}

}
