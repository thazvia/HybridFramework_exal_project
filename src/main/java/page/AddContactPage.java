package page;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class AddContactPage extends BasePage {
	
	WebDriver driver;

	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH,using = "//h5[contains(text(), 'Add Contact')]") WebElement ADD_CONTACT_ELEMENT;
	@FindBy(how = How.XPATH,using = "//input[@id='account']") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH,using = "//select[@id='cid']") WebElement COMPANY_NAME_ELEMENT;
	@FindBy(how = How.XPATH,using = "//input[@id='email']") WebElement email_ELEMENT;
	@FindBy(how = How.XPATH,using = "//input[@id='phone']") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH,using = "//input[@id='address']") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH,using = "//input[@id='city']") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH,using = "//input[@id='state']") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"zip\"]") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH,using = "//select[@id='country']") WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"submit\"]") WebElement SUBMIT_ELEMENT;
	//@FindBy(how = How.XPATH,using = "//a[@id='summary']") WebElement SUMMER_ON_PROFILE_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"application_ajaxrender\"]/a") WebElement CREATE_AUTO_LOGIN_ELEMENT;
	@FindBy(how = How.XPATH,using = "/html/body/div[1]/div/div/div[2]/button[2]") WebElement Ok_Button_ELEMENT;
	
	String Generatedname;
	
	public void verifyAddContactPage() {
		Assert.assertEquals(ADD_CONTACT_ELEMENT.getText(),"Add Contact","wrong page");
	}
	
	public void fullNameField(String fullname) {
		 Generatedname=fullname + generateRandomNo(999);
		FULL_NAME_ELEMENT.sendKeys(Generatedname);
	}
	
	
	public void selectCompaney(String company) {
		
		selectFromDropdown(COMPANY_NAME_ELEMENT,company);
		
	}
	
	public void InsertEmail(String email) {
		email_ELEMENT.sendKeys( generateRandomNo(9999)+ email);
	}
	
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(generateRandomNo(99)+phone+ generateRandomNo(99));
	}
	
	public void insertAdress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void insertcity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	public void insertstate(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	
	public void insertZip(String zipcode) {
		ZIP_ELEMENT.sendKeys(zipcode);
	}
	
	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_ELEMENT,country);
	}
	
	public void ClickOnSubmitButton() {
		SUBMIT_ELEMENT.click();
	}
	//public void verifyProfilePage() {
	
		//waitForElement(driver,5,SUMMER_ON_PROFILE_ELEMENT);
		//Assert.assertEquals(SUMMER_ON_PROFILE_ELEMENT.getText(),"summary","wrong massage!!" );
	//}
	public void CreateAutoLoginPage() {
		
		waitForElement(driver,5,CREATE_AUTO_LOGIN_ELEMENT);
		//Assert.assertEquals(SUMMER_ON_PROFILE_ELEMENT.getText(),"summary","wrong massage!!" );
	}
	
	//tbody//tr[1]//td[3]
	//tbody//tr[2]//td[3]
	//tbody//tr[3]//td[3]
	
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]

	String beforeXpath="//tbody/tr[";
	String afterXpath="]/td[3]";
	String afterXpathDelete ="]/td[3]/following-sibling::td[4]/a[2]";
	//String clikok="/html/body/div[1]/div/div/div[2]/button[2]"	;	
	
	public void verifyEnteredNameAndDelete()  {
		for(int i=1;i<=10;i++) {
			String enteredName=driver.findElement(By.xpath(beforeXpath + i +afterXpath)).getText();
			/*System.out.println(enteredName);
			Assert.assertEquals(enteredName, Generatedname, "Entered name does not exist!!");*/
			if(enteredName.contains(Generatedname)) {
				System.out.println("enterd name exist!!");
				driver.findElement(By.xpath(beforeXpath + i +afterXpathDelete)).click();
				
				}
			
			break;
		}	
			
			
		}
          // Thread.sleep(2000);
	
		
		//String alertmsg = driver.switchTo().alert().getText();
		//System.out.println(alertmsg);
		
		//Alert ale = driver.switchTo().alert();
		
		//ale.accept();
		 
	
	public void alertpopup() {
		
		Ok_Button_ELEMENT.click();
				
				 
	}
	
	
	
}

