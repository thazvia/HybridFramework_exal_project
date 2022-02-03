package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashbordPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest  {

WebDriver driver;
	
	//login data
	//String USER_NAME = "demo@techfios.com";
	//String PASSWORD = "abc123";
	//String fullname = "testng";
	//String Company= "Techfios";
	//String Email= "abc@Techfios.com";
	//String Phone= "12334567";
	//String Country= "Uruguay";
	
	//read from exal data
	
	ExcelReader exlRead = new ExcelReader("testData\\TF_TestData.xlsx");
	
	String username =exlRead.getCellData("LoginInfo","UserName", 2);
	String password =exlRead.getCellData("LoginInfo","Password", 2);
	
	String Fullname = exlRead.getCellData("AddContactInfo","FullName", 2);
	String companey = exlRead.getCellData("AddContactInfo","CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo","Email", 2);
	String phone = exlRead.getCellData("AddContactInfo","Phone", 2);
	String address = exlRead.getCellData("AddContactInfo","Address", 2);
	String city = exlRead.getCellData("AddContactInfo","City", 2);
	String state = exlRead.getCellData("AddContactInfo","State", 2);
	String zipcode = exlRead.getCellData("AddContactInfo","ZipCode", 2);
	String country = exlRead.getCellData("AddContactInfo","Country", 2);
	
	
	@Test
public void verifiedUserShouldBeAbleToAddCustomer() {
		
		driver = BrowserFactory.init();
		

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(username);
		login.insertPassword(password);
		login.clickSignInButton();
		
		DashbordPage dashbord = PageFactory.initElements(driver,DashbordPage.class);
		dashbord.verifyDashbordPage();
		dashbord.clickCustomerButton();
		dashbord.clickAddCustomerButton();
		
		AddContactPage AddContact = PageFactory.initElements(driver, AddContactPage.class);
		AddContact.verifyAddContactPage();
		AddContact.fullNameField(Fullname);
		AddContact.selectCompaney(companey);
		AddContact.InsertEmail(email);
		AddContact.insertPhone(phone);
		AddContact.insertAdress(address);
		AddContact.insertcity(city);
		AddContact.insertstate(state);
		AddContact.insertZip(zipcode);;
		AddContact.selectCountry(country);
		AddContact.ClickOnSubmitButton();
		//AddContact.verifyProfilePage();
		AddContact.CreateAutoLoginPage();
		
		dashbord.clickListCustomerButton();
		
		AddContact.verifyEnteredNameAndDelete();
		AddContact.alertpopup();
		
		
		
}
}
