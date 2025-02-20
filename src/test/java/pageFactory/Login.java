package pageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	@FindBy(xpath="//div//div//div[2][@class='mat-select-arrow-wrapper ng-tns-c161-3']") WebElement SelectRole;
	@FindBy(id="mat-option-0") WebElement AdminRole;
	public Login() {
		PageFactory.initElements(driver, this);		
	}
	
	
	//To get LOg in URL
	public void getbaseurl() {
		driver.get(baseURL);
	}
	
	
	public void enterUsername(String Username) {
		username.sendKeys(Username);
	}
	
	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}
	
	public void select_role() {
		SelectRole.click();
		AdminRole.click();
	}
	
	public void clickLoginBtn() {
		loginbtn.click();
	}

}
