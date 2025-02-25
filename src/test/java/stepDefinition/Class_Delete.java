package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Class;
import pageFactory.ClassDelete;
import pageFactory.Login;
import pageFactory.Logout;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Class_Delete {
	
	private static final WebDriver driver = null;
	Login login = new Login();
	Logout logout = new Logout();
	Class cls = new Class();
	ClassDelete clsdel =new ClassDelete();
	ExcelReader exReader = new ExcelReader();
	ConfigReader reader = new ConfigReader();
	
	
		@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
			login.getbaseurl();
			login.enterUsername(reader.getProperty("username"));
			login.enterPassword(reader.getProperty("password"));
			login.selectTheRole();
			login.selectAdminRole();
			login.clickLoginBtn();
			cls.classbtn();
			clsdel.clickOnDeleteIcon();
			 
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
	    clsdel.validatedelicons();
	}

	@When("Admin clicks yes option")
	public void admin_clicks_yes_option() {
	   clsdel.deloneprgm();
	}

	@Then("Admin gets a message {string} alert and do not see that Class in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_class_in_the_data_table(String string) {
		System.out.println("class alert");
	}

	@When("Admin clicks  No option")
	public void admin_clicks_no_option() {
	    clsdel.DropDelonePrgm();
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		System.out.println("alert disappears");
	}

	@When("Admin clicks on close button")
	public void admin_clicks_on_close_button() {
		
	   clsdel.close();
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
	   System.out.println("popupwindow closed");
	}
	
	@When("Admin clicks YES button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		clsdel.CheckBox();
	    clsdel.MultipleDel();
	  	}

	@Then("Admin should land on Manage class page and can see the selected class is deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_deleted_from_the_data_table() {
	    clsdel.DeleteSuccess();
	}

	@When("Admin clicks No button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
		clsdel.CheckBox();
	    clsdel.MultipleDel();
	    clsdel.no();
	}

	@Then("Admin should land on Manage class page and can see the selected class is not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_not_deleted_from_the_data_table() {
	    System.out.println("selected class not deleted");
	}




}
