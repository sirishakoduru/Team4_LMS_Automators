package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.messages.types.Duration;
import pageFactory.Login;
import pageFactory.Logout;
import pageFactory.Class;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Class_Steps {
	
	private static final WebDriver driver = null;
	Login login = new Login();
	Logout logout = new Logout();
	Class cls = new Class();
	ExcelReader exReader = new ExcelReader();
	ConfigReader reader = new ConfigReader();
	
	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
		login.getbaseurl();
		login.enterUsername(reader.getProperty("username"));
		login.enterPassword(reader.getProperty("password"));
		login.selectrole();
		login.clickLoginBtn();
        cls.classbtn();
	}

	@Then("Admin should land on the Manage class page")
	public void admin_should_land_on_the_manage_class_page() {
	    System.out.print("class page launched");
	}
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String string) {
	   cls.lmstitle();
	}
	@Then("Admin should see the {string} Header")
	public void admin_should_see_the_header(String string) {
	   cls.classheader();
	}
	@Then("Admin should see the Search Bar in Manage class page")
	public void admin_should_see_the_search_bar_in_manage_class_page() {
	   cls.searchbar();
	}
	@Then("Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit\\/Delete")
	public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() {
	    cls.classcolheader();
	}
	
	//classPageValidation.validatePaginationTextandIcons(text);

@Then("Admin should see the Sort icon of all the field in the datatable.")
public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
   cls.sortingicons();
}
@Then("Admin should see the Delete button under the Manage class page header.")
public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
   cls.comdeleteicon();
}
@Then("Admin should see Total no of classes in below of the data table.")
public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
	boolean count = cls.noofclasses();
	System.out.println("Total no of Classes: " + count);
}
@When("Admin clicks on Class link on Manage Class page")
public void admin_clicks_on_class_link_on_manage_class_page() {
    cls.classbtn();
}

@Then("Admin is redirected to class page")
public void admin_is_redirected_to_class_page() {
   
}

@When("Admin clicks on any page link on Manage Class page")
public void admin_clicks_on_any_page_link_on_manage_class_page() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();",cls);
    cls.home();
   
}

@Then("Admin is redirected to which page link they clicked")
public void admin_is_redirected_to_which_page_link_they_clicked() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks on Logout link on Manage class page")
public void admin_clicks_on_logout_link_on_manage_class_page() {
	logout.logout();
}

@Then("Admin is redirected to Login page")
public void admin_is_redirected_to_login_page() {

}



}
