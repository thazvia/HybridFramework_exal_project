package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	

	//methods//variables/Attribute/Field----class associate with
	//class//object ----java associate with
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// storing element with by class
	By UserNameField = By.xpath("//input[@id='username']");
	By PsswordField = By.xpath("//input[@id='password']");
	By SignInButtonField = By.xpath("//button[contains(text(), 'Sign in')]");
	
	//login data
			String USER_NAME = "demo@techfios.com";
			String PASSWORD = "abc123";
			
		@FindBy(how = How.XPATH,using = "//input[@id='username']") WebElement USERNAME_ELEMENT;	
		@FindBy(how = How.XPATH,using = "//input[@id='password']") WebElement PASSWORD_ELEMENT;
		@FindBy(how = How.XPATH,using = "//button[contains(text(), 'Sign in')]") WebElement SIGNIN_BUTTON_ELEMENT;
		
		//individual methods
		public void insertUserName(String USER_NAME) {
			USERNAME_ELEMENT.sendKeys(USER_NAME);
		}
		
		public void insertPassword(String PASSWORD) {
			PASSWORD_ELEMENT.sendKeys(PASSWORD);
		}
		public void clickSignInButton() {
			SIGNIN_BUTTON_ELEMENT.click();
		}
		
		//together
		public void loginTest(String USER_NAME,String PASSWORD) {
			USERNAME_ELEMENT.sendKeys(USER_NAME);
			PASSWORD_ELEMENT.sendKeys(PASSWORD);
			SIGNIN_BUTTON_ELEMENT.click();
		}
		
		
			
}
