package ob.qa.test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ob.qa.test.elements.Ebay_Advanced_Search_Page_Elements;
import ob.qa.test.elements.Ebay_Search_Results_Page_Elements;

public class Ebay_Advanced_Search_Page {
	
	WebDriver driver;
	Ebay_Advanced_Search_Page_Elements advSearchElements;
	Ebay_Search_Results_Page_Elements searchResultsElements;
	
	public Ebay_Advanced_Search_Page(WebDriver driver) {
		this.driver = driver;
		advSearchElements = new Ebay_Advanced_Search_Page_Elements(driver);
		searchResultsElements = new Ebay_Search_Results_Page_Elements(driver);
	}
	
	/**
	 * 
	 * 
	 * Is Search Button Enabled
	 * 	 */
	public boolean isSearchButtonIsEnabled() {
		return advSearchElements.advSearchBtn.isEnabled();
	}
	
	/**
	 * 
	 * GET all category dropdown options
	 * 
	 */
	public List<WebElement> getAllCatOptions() {
		return advSearchElements.allCasSelectBoxOptions;
	}
	
	/**
	 * 
	 * Click on Ebay Logo
	 * 
	 */
	public void clickOnEbayLogo() {
		advSearchElements.ebayLogo.click();
	}
	
	/**
	 * 
	 * Enter Search String in keyword field
	 * 
	 **/
	public void enterSearchStringInKeywordsField(String srcString) {
		advSearchElements.keywordsField.sendKeys(srcString);
	}
	
	/**
	 * 
	 * Click advanced search Button
	 * 
	 **/
	public void clickAdvSearchButton() {
		advSearchElements.advSearchBtn.click();
	}
	 

}
