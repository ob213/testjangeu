package ob.qa.test.pages;

import org.openqa.selenium.WebDriver;

import ob.qa.test.elements.Ebay_Home_Page_Elements;

public class Ebay_Home_Page {

	WebDriver driver;
	Ebay_Home_Page_Elements homePageElements;

	public Ebay_Home_Page(WebDriver driver) {
		this.driver = driver;
		homePageElements = new Ebay_Home_Page_Elements(driver);
	}
	
	/**
	 * 
	 * click on search button
	 * 
	 */
	public void clickSearchButton() {
		homePageElements.searchBtn.click();
	}
	
	/**
	 * 
	 * Is Search button enabled
	 * 
	 */
	public boolean isSearchButtonEnabled() {
		return homePageElements.searchBtn.isEnabled();
	}

}
