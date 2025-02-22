package pageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Login {
	
	String baseURL = ConfigReader.baseUrl();
	String invalidUrl = ConfigReader.invalidURL();
	WebDriver driver = DriverFactory.getDriver();
	
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login")	WebElement loginbtn;
	@FindBy(tagName="h1") WebElement errorElement;
	@FindBy(tagName="body")WebElement spellingfeild;
	@FindBy(xpath="//img[@src='assets/img/LMS-logo.jpg']")WebElement LMSText;
	@FindBy(xpath = "//p[text()='Please login to LMS application']")WebElement loginText;
	@FindBy(tagName="input")List<WebElement> textFeild;
	@FindBy(xpath="//span[text()='User']")WebElement userText;
	@FindBy(xpath="//span[text()='Password']")WebElement passwordText;
	@FindBy(xpath="//div[@class='mat-select-arrow ng-tns-c161-3']")List<WebElement> dropdown;
	@FindBy(xpath="//span[text()=' *']")WebElement userAsterisk;
	@FindBy(xpath="//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c158-1 ng-star-inserted']")WebElement passwordAsterisk;
	@FindBy(xpath="//span[text()='Select the role']")WebElement dropdownPlaceholder;
	@FindBy(tagName="mat-select")WebElement dropdownSelector;
	@FindBy(tagName="mat-option")List<WebElement> dropdownOptions;
	@FindBy(className = "mat-card-content") WebElement inputFeildAlignment;
	@FindBy(xpath="//button[@id='login']")WebElement Loginbtn;
	@FindBy(xpath="//div//div//div[2][@class='mat-select-arrow-wrapper ng-tns-c161-3']") WebElement SelectRole;
	@FindBy(id="mat-option-0") WebElement AdminRole;
	@FindBy(id="mat-error-1") WebElement UsernameErrorMsg;
	@FindBy(xpath="//div[@class='ng-tns-c158-1 ng-trigger ng-trigger-transitionMessages ng-star-inserted']") WebElement PasswordErrorMsg;
	
	public Login() {
		PageFactory.initElements(driver, this);		
	}
	
	
	//To get LOg in URL
	public void getbaseurl() {
		driver.get(baseURL);
	}
	
	public void getInvalidURL() {
		driver.get(invalidUrl);
	}
	
	public String getURL() {
		return driver.getCurrentUrl();
	}
	

	
	public void readDataFromSheet(String sheetName, String testCase) throws IOException {
	    ExcelReader reader = new ExcelReader();
        String userNameExcelValue = reader.getTestData(sheetName, testCase, "username");
        String passwordExcelValue = reader.getTestData(sheetName, testCase, "password");
        username.sendKeys(userNameExcelValue);
        password.sendKeys(passwordExcelValue);
    }
	
	public void enterUsername(String Username) {
		username.sendKeys(Username);
	}
	
	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}
	
	public void clickLoginBtn() {
		loginbtn.click();
	}
	
	public String pagetitle() {
		return driver.getTitle();
	}
	
	public String getApplicationErrorMessage() {
	    return errorElement.getText();
	}
	
	public boolean doesLMSTextexist() {
		return LMSText.isDisplayed();
	}
	
	public boolean doesCompanyNameExist() {
		return LMSText.isDisplayed();
	}
	public String getLoginText() {
		return loginText.getText();
	}
	
	public void brokenLinks () throws IOException {
	
		String url = driver.getCurrentUrl();
		URL link = new URL(url); 
		// open connection to the server
		HttpURLConnection httpConn = (HttpURLConnection) link.openConnection(); 
		httpConn.connect(); 
		// Getting The Response Code 
		int code = httpConn.getResponseCode(); 
			          
		// If The Number Is Greater Than 400,  
		// Then It Is Broken Link 
		if(code >= 400) { 
			System.out.println("Broken Link: " +url); 
		} else { 
			System.out.println("Valid Link: " +url); 
		}
    }
	
	public void SpellingFeildText() {
    	String pageText = spellingfeild.getText();
    	System.out.println(pageText);
    	JLanguageTool languageTool = new JLanguageTool (new AmericanEnglish());
    	try {
    		List<RuleMatch> errors =languageTool.check(pageText);
    		if (errors.isEmpty()) {
    			System.out.println("No spelling mistakes found");
    		} else {
    			System.out.println("Spelling mistakes found");
    			for (RuleMatch error :errors) {
    				System.out.println("Potential typo at line" +error.getLine() +", column" + error.getColumn() + ":" + error.getMessage());
    				System.out.println("Context:" + error.getShortMessage());
    				System.out.println("Suggested correction:" + error.getSuggestedReplacements());
    				System.out.println("----");
    			}
    		}
    	
    	}	catch (IOException e) {
    			// Handle IO exceptions
    			e.printStackTrace();
    		}
	}
	
	public int getTextFeildcount() {
		return textFeild.size();
	}
	
	public boolean isFirstUserTextDisplayed() {
		return userText.isDisplayed();
	}
	public boolean isPasswordTextSecond() {
		return passwordText.isDisplayed();
	}
	public int getDropdownSize() {
		return dropdown.size();
	}
	public String checkUserAsterisk() {
		return userAsterisk.getText();
	}
	public String checkPasswordAsterisk() {
		return passwordAsterisk.getText();
	}
//	public boolean isDropdownPlaceholder() {
//		return dropdownPlaceholder.isDisplayed();
//	}
	public String getPlaceholderDropdown() {
		return dropdownPlaceholder.getText();
	}
	
	public void clickRoleDropdown() {
		dropdownSelector.click();
	}

	public String getDropdownOptions() {
//		String output = "";
		System.out.println("List of dropdown Options: ");
//		for (WebElement option : dropdownOptions) {
//            String value = option.getText();
//            
//            System.out.println("Option value: " + value);
//        }
		String commaSeparatedString = dropdownOptions.stream()
	        .map(WebElement::getText)
	        .collect(Collectors.joining(", "));
		System.out.println("commaSeparatedString: " + commaSeparatedString);
		return commaSeparatedString;
	}
	
	public String checkInputFeildAlignment() {
		WebElement textInputFeild = inputFeildAlignment;
		String elementLocation = textInputFeild.getCssValue("text-align");
		return elementLocation;
	}
	
	public boolean isLoginButtonDisplayed() {
		return loginbtn.isDisplayed();
	}
	
	public String checkUserTextColor() {
		WebElement UserTextColor = userText;
		String elementColor = UserTextColor.getCssValue("color");
		System.out.println("The color of the user is :" +elementColor);
		return elementColor;
	}
	
	public String checkPasswordTextColor() {
		WebElement PasswordTextColor = passwordText;
		String elementColor = PasswordTextColor.getCssValue("color");
		System.out.println("The color of the user is :" +elementColor);
		return elementColor;
	}
	public void selectTheRole() {
		SelectRole.click();
	}
	public void selectAdminRole() {
		AdminRole.click();
	}
	public String getUsernameErrorMessage() {
		return UsernameErrorMsg.getText();
	}
	public String getPasswordErrorMessage() {
		return PasswordErrorMsg.getText();
	}
	public void keyBoardEnter() {
		Actions actions = new Actions(driver);
		actions.click(loginbtn).sendKeys(Keys.ENTER).perform();
	}
	public void mouseEnter() {
		Actions actions = new Actions(driver);
		actions.moveToElement(loginbtn).click().perform();
	}
	
	
	

	
}
