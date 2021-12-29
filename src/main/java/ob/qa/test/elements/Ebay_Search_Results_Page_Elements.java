package ob.qa.test.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebay_Search_Results_Page_Elements {
	
	WebDriver driver;
	
	@FindBy(css="//div[@id='e1-10']/descendant::h3[1]") public WebElement firstSearchresult;
	
	public Ebay_Search_Results_Page_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
