package pageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import driver.DriverFactory;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Login {
	
	String baseURL = ConfigReader.baseUrl();
	WebDriver driver = DriverFactory.getDriver();
	
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login")	WebElement loginbtn;
	@FindBy(id="mat-select-value-1") WebElement rolecombo;
	@FindBy(xpath="//span[contains(@class,'mat-option-text') and contains(text(),'Admin')]") WebElement roleAdmin;
	@FindBy(xpath="//div[@role='listbox']") List<WebElement> options;
	
	public Login() {
		PageFactory.initElements(driver, this);		
	}
	
	
	//To get LOg in URL
	public void getbaseurl() {
		driver.get(baseURL);
	}
	
//	public void readDataFromSheet(String sheetName, Integer rowNumber) throws IOException {
//	    String userNameExcelValue;
//	    String passwordExcelValue;
//        ExcelReader reader = new ExcelReader();
//        List<Map<String, String>> testdata = reader.getData("src/test/resources/TestData/LMS_TestData.xlsx", sheetName);
//        userNameExcelValue = testdata.get(rowNumber).get("Username");
//        passwordExcelValue = testdata.get(rowNumber).get("Password");
//        username.sendKeys(userNameExcelValue);
//        password.sendKeys(passwordExcelValue);
//        loginbtn.click();
//       
//    }
	
	public void enterUsername(String Username) {
		username.sendKeys(Username);
	}
	
	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}
	
	public void enterRole(String role) throws InterruptedException {
		
		System.out.println("Inside enterRole");
		rolecombo.click();
		
		Thread.sleep(1000);
		roleAdmin.click();
		//options.get(0).click();
		Thread.sleep(1000);
		
/*		for (WebElement option : options) {
			
			System.out.println("Inside for loop: "+option.getText());
            if (option.getText().equalsIgnoreCase(role)) {  // Replace with the desired value
            	System.out.println("Inside if"+role);
                option.click();
                break;            }
		}*/
		
	}
	
	
	public void clickLoginBtn() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(loginbtn).click().perform();
	}

}
