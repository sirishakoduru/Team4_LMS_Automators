package stepDefinition;

import java.text.ParseException;

import org.junit.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.ClassAddNewPopup;
import pageFactory.Login;
import utilities.ConfigReader;

public class ClassAddNewPopup_Steps {
	
	Login login = new Login();
	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();
	ClassAddNewPopup addClass = new ClassAddNewPopup();
	
	@Given("Admin is on the home Page after login the LMS portal")
	public void admin_is_on_the_home_page_after_login_the_lms_portal() {
	   
		login.getbaseurl();
		System.out.println("username: " + reader.getProperty("username"));
		login.enterUsername(reader.getProperty("username"));
		login.enterPassword(reader.getProperty("password"));
		login.selectTheRole();
		login.selectAdminRole();
		login.clickLoginBtn();
	    
	}

	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
	    
		addClass.clickClass();
	}

	@Then("Admin should land Manage Class page")
	public void admin_should_land_manage_class_page() {
	    
		//addClass.clickHome();
		String ActualUrl = addClass.getUrl();
		String ExpectedUrl = reader.getProperty("ManageClassUrl");
		Assert.assertEquals(ActualUrl,ExpectedUrl);
	    
	}

	@Given("Admin is on the Class Popup window")
	public void admin_is_on_the_class_popup_window() {
	    addClass.clickAddNewClass();
	}

	@When("Admin enters mandatory fields in the form and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button() throws InterruptedException {
	    addClass.clickBatchNameDropdown();
	    addClass.selectBatchNameDrpdownValue();
	    addClass.EnterClassTopic();
	    addClass.clickStaffName();
	    addClass.selectStaffName();
	    addClass.selectStatus();
	    addClass.clickDatePicker();
	    addClass.selectClassDate();
	    addClass.clickSaveBtn();
	}

	@Then("Admin gets message Class added Successfully")
	public void admin_gets_message_class_added_successfully() {
	    Assert.assertTrue(addClass.isSuccessMsgDisplayed());
	}

	@When("Admin selects class date in date picker")
	public void admin_selects_class_date_in_date_picker() throws InterruptedException {
		addClass.clickDatePicker();
		addClass.selectClassDate();
		
	    
	}

	@Then("Admin should see no of class value is added automatically")
	public void admin_should_see_no_of_class_value_is_added_automatically() throws InterruptedException {
		String number =  addClass.getNoOfClasses();
		System.out.println("No of classes: " +number);
	    
	}

	@When("Admin clicks date picker")
	public void admin_clicks_date_picker() throws InterruptedException {
	    addClass.clickDatePicker();
	}

	@Then("Admin should see weekends dates are disabled to select")
	public void admin_should_see_weekends_dates_are_disabled_to_select() throws ParseException {
//		addClass.checkDisabledWeekends();
		System.out.println("date disabled count is: " + addClass.checkDisabledWeekends());
	    Assert.assertTrue(addClass.checkDisabledWeekends());
	}

	@When("Admin skips to add value in mandatory field and enter only the optional field")
	public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field() {
	    
		addClass.createOptionsfeilds();
		addClass.clickSaveBtn();
	}

	@Then("Admin should see error message below the test field and the field will be highlighted in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighted_in_red_color() {
	    
		addClass.getEmptyClassFeildsError();
	    String color = addClass.emptyFeildHighlightedColour();
	    String Expected = "rgba(255, 255, 255, 1)";
	    Assert.assertEquals(Expected, color);
	    //Assert.assertTrue(addClass.getEmptyClassFeildsError());
//	    System.out.println(emptyFeildHighlightedColour.getCssValue("background-color"));
	}

	@When("Admin enters invalid data in all of the  fields in the form and clicks on save button")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_save_button() throws InterruptedException {
	    
	    addClass.invalidDataInputs();
	    addClass.clickSaveBtn();
	}

	@Then("Admin gets error message and class is not created")
	public void admin_gets_error_message_and_class_is_not_created() {
	    
		Assert.assertFalse(addClass.isSuccessMsgDisplayed());
//		succes message is getting created instaed of error message
	}

	@When("Admin clicks on save button without entering data")
	public void admin_clicks_on_save_button_without_entering_data() {
		addClass.clickSaveBtn();
		
	}

	@Then("class wont be created and Admin gets error message")
	public void class_wont_be_created_and_admin_gets_error_message() {
		//String Error = addClass.EmptyFormSubmission();
	    Assert.assertTrue(addClass.EmptyFormSubmission());
	}

	@When("Admin clicks Cancel or Close\\(X) Icon on Admin Details form")
	public void admin_clicks_cancel_or_close_x_icon_on_admin_details_form() {
	    
		addClass.clickCancelButton();
	}


	@Then("Class Details popup window should be closed without saving")
	public void class_details_popup_window_should_be_closed_without_saving() {
	    
		addClass.isClassPopupClosed();
	}

	@When("Admin clicks save button")
	public void admin_clicks_save_button() throws InterruptedException {
		addClass.clickBatchNameDropdown();
	    addClass.selectBatchNameDrpdownValue();
	    addClass.EnterClassTopic();
	    addClass.clickStaffName();
	    addClass.selectStaffName();
	    addClass.selectStatus();
	    addClass.clickDatePicker();
	    addClass.selectClassDate();
	    addClass.clickSaveBtn();
	    
	}

	@Then("Admin can see the class details popup closed and adding new class")
	public void admin_can_see_the_class_details_popup_closed_and_adding_new_class() {
		 addClass.isClassPopupClosed();
		 Assert.assertTrue(addClass.isSuccessMsgDisplayed());
	    
	}


}
