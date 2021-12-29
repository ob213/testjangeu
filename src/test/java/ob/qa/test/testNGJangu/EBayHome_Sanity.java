package ob.qa.test.testNGJangu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ob.qa.test.pages.Ebay_Home_Page;

public class EBayHome_Sanity {
	
	WebDriver driver;
	Ebay_Home_Page home_Page;

	@BeforeClass
	public void beforeClassSetUp() {
		System.out.println("BeforeClass settings done");
		System.out.println("Executions starts: EBayHome_Sanity");
	}

	@AfterClass
	public void afterClassSetUp() {
		System.out.println("AfterClass settings done");
		System.out.println("Executions ends: EBayHome_Sanity");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Omar BARRO\\Selenium Web Driver\\Driver\\chromedriver.exe");

		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://www.ebay.com/");
		home_Page = new Ebay_Home_Page(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void empty_Search_test() throws Exception {

		String expectedUrl = "https://www.ebay.com/n/all-categories";
		String expectedTitle = "Shop by Category | eBay";

		Assert.assertTrue(home_Page.isSearchButtonEnabled(), "Verify Search Button is enabled");

		Thread.sleep(2000);

		home_Page.clickSearchButton();

		Thread.sleep(2000);

		String newUrl = driver.getCurrentUrl();
		String newTitle = driver.getTitle();
		System.out.println(newUrl);
		System.out.println(newTitle);

		Assert.assertEquals(newUrl, expectedUrl, "Verify URL of the new page");
		Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");

	}

	@Test
	public void empty_Search_test_softassert() throws Exception {

		SoftAssert sa = new SoftAssert();

		String expectedUrl = "https://www.ebay.com/n/all-categories";
		String expectedTitle = "Shop by Category | eBay";

		sa.assertTrue(home_Page.isSearchButtonEnabled(), "Verify Search Button is enabled");

		Thread.sleep(2000);

		home_Page.clickSearchButton();

		Thread.sleep(2000);

		String newUrl = driver.getCurrentUrl();
		String newTitle = driver.getTitle();
		System.out.println(newUrl);
		System.out.println(newTitle);

		sa.assertEquals(newUrl, expectedUrl, "Verify URL of the new page");
		sa.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");

		sa.assertAll();
	}
}
