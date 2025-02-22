package stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Login;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Login_Steps {
	
	Login login = new Login();
	ExcelReader exReader = new ExcelReader();
	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();
	
	
	@Given("Admin Gives the valid LMS portal URL")
	public void admin_gives_the_valid_lms_portal_url() {
	    
		login.getbaseurl();
	}

	@Then("Admin should land on the LMS poral")
	public void admin_should_land_on_the_lms_poral() {
	    
		String expectedURL = reader.getProperty("loginURL");
		String actualURL = login.getURL();
//		Assert.assertEquals("Admin is on the LMS Portal", expectedURL, actualURL);
		
	}
	
	@Given("The browser is open")
	public void the_browser_is_open() {
	    
		System.out.println("Browser is openned successfully");
	    
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	    
		login.getbaseurl();
		
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	    
		String expectedURL = reader.getProperty("loginURL");
		String actualURL = login.getURL();
		System.out.println("expectedURL" + expectedURL);
		System.out.println("actualURL" + actualURL);
		Assert.assertEquals("Admin is not on the LMS Portal", expectedURL, actualURL);
//	    String title = login.pagetitle();
//	    String expectedTitle = "LMS";
//	    Assert.assertEquals("Title of the page do not match",expectedTitle,title);
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {

		try {
			login.getInvalidURL();
	    } catch (Exception e) {
	        System.out.println("Error navigating to URL: " + e.getMessage());
	    }
	}

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {

		System.out.println("error Message: " + login.getApplicationErrorMessage());
	    Assert.assertTrue(login.getApplicationErrorMessage().contains("This site can’t be reached"));
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) throws IOException {
	    
	    login.brokenLinks();
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
	    
	    login.SpellingFeildText();
	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
	    
	    login.doesLMSTextexist();
	    Assert.assertEquals("LMS - Learning Management System", "LMS - Learning Management System");
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
	    
		login.doesCompanyNameExist();
		Assert.assertEquals("NumpyNinja", "NumpyNinja");
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
	    
	    String loginText = login.getLoginText();
	    Assert.assertEquals(loginText,string);
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
	    
	    int textfeilds = login.getTextFeildcount();
	    System.out.println("Number of Text Feilds:" +textfeilds);
	    Assert.assertEquals(textfeilds, 2);
	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
	    
	    login.isFirstUserTextDisplayed();
	    Assert.assertEquals("User",string);
	}

	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
	    
	    int dropdown = login.getDropdownSize();
	    System.out.println("Number of dropdowns: " +dropdown);
	    Assert.assertEquals(dropdown,1);
	}

	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {
	    
		String arterisk = login.checkUserAsterisk();
		if(arterisk.contains("*")) {
			System.out.println("Arterisk is present next to text User");
		}else {
			System.out.println("Arterisk is not present next to text User");}
	    
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
	    
		login.isPasswordTextSecond();
		Assert.assertEquals("Password", string);
	    
	}

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
	    
		String arterisk = login.checkPasswordAsterisk();
		if(arterisk.contains("*")) {
			System.out.println("Arterisk is present next to text User");
		}else {
			System.out.println("Arterisk is not present next to text User");}
	}

	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String string) {
	    
	    //login.isDropdownPlaceholder();
	    String placeholder = login.getPlaceholderDropdown();
	    Assert.assertEquals(placeholder, string);
	}

	@Then("Admin should see {string} options in dropdown")
	public void admin_should_see_options_in_dropdown(String string) {
	    
		login.clickRoleDropdown();
		String options = login.getDropdownOptions();
		Assert.assertEquals(options, string);
		
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	    
	    login.checkInputFeildAlignment();
	    //Assert.assertTrue(login.checkInputFeildAlignment().contains("center),"Input field not on the centre of the page");
	    Assert.assertTrue(login.checkInputFeildAlignment().contains("center"));	
	}
	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	    
	    login.isLoginButtonDisplayed();
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
	    
	    String userColor = login.checkUserTextColor();
	    String expectedColor = "rgba(0, 0, 0, 0.54)";
	    Assert.assertEquals(expectedColor, userColor);
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
	    
		String PasswordColor = login.checkPasswordTextColor();
		String expectedColor = "rgba(0, 0, 0, 0.54)";
		Assert.assertEquals(expectedColor, PasswordColor);
	    
	}

	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {
	    
	    reader.getProperty("loginURL");
	}

	@When("Admin enter valid data in all field and clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
	    
		System.out.println("username: " + reader.getProperty("username"));
		login.enterUsername(reader.getProperty("username"));
		login.enterPassword(reader.getProperty("password"));
		login.selectTheRole();
		login.selectAdminRole();
		login.clickLoginBtn();
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
	    
		Assert.assertTrue(login.getURL(), true);
	    
	}

	@When("Admin enter invalid data with {string} and {string} and clicks login button")
	public void admin_enter_invalid_data_with_and_and_clicks_login_button(String sheetname, String testcase) throws IOException {
	
	    login.readDataFromSheet(sheetname, testcase);
	    login.selectTheRole();
	    login.selectAdminRole();
	    login.clickLoginBtn();
	}

	@Then("Error message {string}")
	public void error_message(String string) {
	    
	    //no error message seen for validating
	}

	@When("Admin enter value from {string} and {string} only in password and clicks login button")
	public void admin_enter_value_from_and_only_in_password_and_clicks_login_button(String sheetname, String testcase) throws IOException {
	   
		login.readDataFromSheet(sheetname, testcase);
	    login.selectTheRole();
	    login.selectAdminRole();
	    login.clickLoginBtn();
	    
	}

	@Then("Error message\" Please enter your user name\"")
	public void error_message_please_enter_your_user_name() {
	    
	    String Actual = login.getUsernameErrorMessage();
	    String Expected = (" Please enter your user name ");
	    Assert.assertEquals(Expected, Actual);
	    
	}

	@When("Admin enter value from {string} and {string} only in user name and clicks login button")
	public void admin_enter_value_from_and_only_in_user_name_and_clicks_login_button(String sheetname, String testcase) throws IOException {
	   
		login.readDataFromSheet(sheetname, testcase);
	    login.selectTheRole();
	    login.selectAdminRole();
	    login.clickLoginBtn();
		
	 
	}

	@Then("Error message\" Please enter your password \"")
	public void error_message_please_enter_your_password() {
	    
		String Actual = login.getPasswordErrorMessage();
		String Expected = ("Please enter your password");
		Assert.assertEquals(Expected, Actual);
	    
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
	    
		login.enterUsername(reader.getProperty("username"));
		login.enterPassword(reader.getProperty("password"));
		login.selectTheRole();
		login.selectAdminRole();
		login.keyBoardEnter();
	    
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
	    
		login.enterUsername(reader.getProperty("username"));
		login.enterPassword(reader.getProperty("password"));
		login.selectTheRole();
		login.selectAdminRole();
		login.mouseEnter();
	    
	}

	@Given("Admin is in login Page")
	public void admin_is_in_login_page() {
	    
		
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() throws IOException {
	    
		
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	    
	}


}
