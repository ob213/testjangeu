package ob.qa.test.testNGJangu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ob.qa.test.pages.Ebay_Advanced_Search_Page;
import ob.qa.test.pages.Ebay_Search_Results_Page;

public class Abay_Advanced_Search_Sanity {

	WebDriver driver;

	Ebay_Advanced_Search_Page advSearchPage;
	Ebay_Search_Results_Page advSearchResultpage;

	WebDriverWait wait;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Omar BARRO\\Selenium Web Driver\\Driver\\chromedriver.exe");

		driver = new ChromeDriver();

		wait = new WebDriverWait(driver, 10);

		driver.get("https://www.ebay.com/sch/ebayadvsearch");

		WebElement webelmt;
		webelmt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gdpr-banner-decline")));

		if (webelmt.isDisplayed()) {
			System.out.println("OK");
			Thread.sleep(2000);
			driver.findElement(By.id("gdpr-banner-decline")).click();
		}

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='gdpr-banner-decline']")).click();

		Thread.sleep(2000);

		advSearchPage = new Ebay_Advanced_Search_Page(driver);
		advSearchResultpage = new Ebay_Search_Results_Page(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void empty_Search_test_advanced() throws Exception {

		String expectedUrl = "https://www.ebay.com/n/all-categories";
		String expectedTitle = "Shop by Category | eBay";
		// advSearchPage.clickAdvSearchButton();

		Assert.assertTrue(advSearchPage.isSearchButtonIsEnabled(), "Verify Search Button is enabled");

		advSearchPage.clickAdvSearchButton();

		Thread.sleep(2000);
		String newUrl = driver.getCurrentUrl();
		String newTitle = driver.getTitle();
		System.out.println(newUrl);
		System.out.println(newTitle);

		Assert.assertEquals(newUrl, expectedUrl, "Verify URL of the new page");
		Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");

	}

	@Test
	public void category_options_in_ascendant_order() throws Exception {

		List<WebElement> category_options = advSearchPage.getAllCatOptions();
		List<String> arr1 = new ArrayList<String>();

		for (WebElement option : category_options) {
			arr1.add(option.getText());
		}

		List<String> arr2 = new ArrayList<String>(arr1);
		Collections.sort(arr2);
		System.out.println("Actual List: " + arr1);
		System.out.println("Sorted List: " + arr2);

		Assert.assertTrue(arr1.equals(arr2), "Verify Category Items sorted");
	}

	@Test
	public void ebay_logo_link_navigate_home_page_test() throws Exception {
		String expectedUrl = "https://www.ebay.com/";
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";

		advSearchPage.clickOnEbayLogo();
		Thread.sleep(2000);
		String newUrl = driver.getCurrentUrl();
		String newTitle = driver.getTitle();

		System.out.println(newUrl);
		System.out.println(newTitle);
		Assert.assertEquals(newUrl, expectedUrl, "Verify URL of the new page");
		Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");
	}

	@Test
	public void advanced_keywords_test() throws Exception {

		String keyword1 = "unlocked";
		String keyword2 = "ios";
		String searchingKeywords = keyword1 + " " + keyword2;

		advSearchPage.enterSearchStringInKeywordsField(searchingKeywords);
		advSearchPage.clickAdvSearchButton();
		// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.space-top>button.btn"))).click();
		// new
		// Actions(driver).moveToElement(advSearchElements.advSearchBtn).click().perform();
		Thread.sleep(3000);

		String firstresultTitle = advSearchResultpage.getFirstResultTitle();

		Assert.assertTrue(firstresultTitle.toLowerCase().contains(keyword1),
				"Result Title Contains first Keyword " + keyword1);
		Assert.assertTrue(firstresultTitle.toLowerCase().contains(keyword2),
				"Result Title Contains first Keyword " + keyword2);
	}

}
