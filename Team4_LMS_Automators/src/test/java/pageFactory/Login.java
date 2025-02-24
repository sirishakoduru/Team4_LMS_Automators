package pageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Login {
	
	String baseURL = ConfigReader.baseUrl();
	WebDriver driver = DriverFactory.getDriver();
	
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login")	WebElement loginbtn;
	
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
	
	public void clickLoginBtn() {
		loginbtn.clear();
	}

}
