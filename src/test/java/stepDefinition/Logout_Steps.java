package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Login;
import pageFactory.Logout;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Logout_Steps {
	
	//WebDriver driver = null;
	Login login = new Login();
	Logout logout = new Logout();
	ExcelReader exReader = new ExcelReader();
	ConfigReader reader = new ConfigReader();
	
	@When("Admin is in home page")
	public void admin_is_in_home_page() {
		login.getbaseurl();
		login.enterUsername(reader.getProperty("username"));
		login.enterPassword(reader.getProperty("password"));
		login.selectTheRole();
		login.selectAdminRole();
		login.clickLoginBtn();
//		Assert.assertEquals(login.getCurrentUrl(),"Admin is in DashBoard Page");
}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
	logout.logout();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		 Assert.assertTrue(login.getURL().contains("login"),"Admin is in Login Page");
	}
	@When("Admin clicks  browser back button")
	public void admin_clicks_browser_back_button() {
		logout.clickBack();
//		 driver.navigate().back();
//    	 try {
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
	    System.out.println("No error message received");
	}

}
