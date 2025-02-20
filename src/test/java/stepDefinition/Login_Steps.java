package stepDefinition;

import java.io.IOException;

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
	
	@Given("Admin Gives the valid LMS portal URL")
	public void admin_gives_the_valid_lms_portal_url() {
	    
		login.getbaseurl();
	}

	@Then("Admin should land on the LMS poral")
	public void admin_should_land_on_the_lms_poral() {
	    
	}

	@Given("Admin is in login Page")
	public void admin_is_in_login_page() {
	    
		
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() throws IOException {
	    
		System.out.println("username: " + reader.getProperty("username"));
		login.enterUsername(reader.getProperty("username"));
		login.enterPassword(reader.getProperty("password"));
		login.select_role();
		login.clickLoginBtn();
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	    
	}


}
