package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashbordPage {
	WebDriver driver;

	public DashbordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH,using="//h2[contains(text(), 'Dashboard')]") WebElement DashBoard_Header_element;
	@FindBy(how = How.XPATH,using="//span[contains(text(), 'Customers')]") WebElement customer_button_element;
	@FindBy(how = How.XPATH,using="//a[contains(text(), 'Add Customer')]") WebElement Addcustomer_button_element;
	@FindBy(how = How.XPATH,using="//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement List_customer_button_element;

	public void verifyDashbordPage() {
		Assert.assertEquals(DashBoard_Header_element.getText(),"Dashboard","wrong page");
	}
	
	public void clickCustomerButton() {
		customer_button_element.click();
	}
	
	public void clickAddCustomerButton() {
		Addcustomer_button_element.click();
	}
	public void clickListCustomerButton() {
		List_customer_button_element.click();
	}
}
