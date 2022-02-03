package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashbordPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	//inherit //object //by the name of the class
	
	WebDriver driver;
	
	//login data
	String USER_NAME = "demo@techfios.com";
	String PASSWORD = "abc123";
	
	ExcelReader exlRead = new ExcelReader("testData\\TF_TestData.xlsx");
	
	String username =exlRead.getCellData("LoginInfo","UserName", 2);
	String password =exlRead.getCellData("LoginInfo","Password", 2);
	
	
	@Test
	public void verifiedUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		
		
		//LoginPage login1 = new LoginPage();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(username);
		login.insertPassword(password);
		login.clickSignInButton();
		
		DashbordPage dashbord = PageFactory.initElements(driver,DashbordPage.class);
		dashbord.verifyDashbordPage();
		dashbord.clickCustomerButton();
		dashbord.clickAddCustomerButton();
		
		
	    
		//BrowserFactory.teardown();
		
		
	}

}
