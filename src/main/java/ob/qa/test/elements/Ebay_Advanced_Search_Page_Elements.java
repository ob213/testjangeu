package ob.qa.test.elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebay_Advanced_Search_Page_Elements {
	
	WebDriver driver;
	
	@FindBy(css="button.btn-prim") public WebElement advSearchBtn;
	
	@FindBy(css="a#gh-la") public WebElement ebayLogo;
	
	@FindBy(css="//input[@id='_nkw']") public WebElement keywordsField;
	
	@FindBy(css="select#e1-1>option") public List<WebElement> allCasSelectBoxOptions;
	
	public Ebay_Advanced_Search_Page_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
