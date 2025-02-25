package stepDefinition;

import org.junit.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.ClassAddNewPopup;
import pageFactory.EditNewClassAndSort;
import pageFactory.Login;
import utilities.ConfigReader;

public class EditNewClassAndSort_Steps {
	
	Login login = new Login();
	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();
	ClassAddNewPopup addClass = new ClassAddNewPopup();
	EditNewClassAndSort editClass = new EditNewClassAndSort();
	
	@Given("Admin is on the Manage Class page")
	public void admin_is_on_the_manage_class_page() {
		String Actual = editClass.getUrl();
		String Expected = reader.getProperty("ManageClassUrl");
		Assert.assertEquals(Actual,Expected);
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
	    
		editClass.clickEditBtn();
	}

	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
	    
	    Assert.assertTrue(editClass.isEditPopupappear());
	}

	@Then("Admin should see batch name field is disabled")
	public void admin_should_see_batch_name_field_is_disabled() {
		Assert.assertTrue(editClass.isBatchNameDisabled());
	    
	}

	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		Assert.assertTrue(editClass.isClassTopicDisabled());
	    
	}

	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() {
	    
		editClass.clickEditBtn();
	}

	@When("Update the fields with valid data and click save")
	public void update_the_fields_with_valid_data_and_click_save() throws InterruptedException {
		addClass.createOptionsfeilds();
//		addClass.clickStaffName();
//	    addClass.selectStaffName();
	    addClass.selectStatus();
	    addClass.clickDatePicker();
	    addClass.selectClassDate();
	    addClass.clickSaveBtn();
	    
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
		
		String SuccessMsg = editClass.getSuccessMsg();
		String Expected = "Class Updated Successful";
	    System.out.println(editClass.getSuccessMsg());
	    Assert.assertEquals(Expected,SuccessMsg);
	    
	}

	@When("Update the fields with invalid values and click save")
	public void update_the_fields_with_invalid_values_and_click_save() throws InterruptedException {
	    
		addClass.invalidDataInputsForEdit();
		addClass.clickSaveBtn();
	}

	@Then("Admin should get Error message")
	public void admin_should_get_error_message() {
	    
		Assert.assertFalse(addClass.isSuccessMsgDisplayed());
//		succes message is getting created instaed of error message
	}

	@When("Update the mandatory fields with valid values and click save")
	public void update_the_mandatory_fields_with_valid_values_and_click_save() throws InterruptedException {
	    
//		addClass.clickStaffName();
//	    addClass.selectStaffName();
	    addClass.selectStatus();
	    addClass.clickDatePicker();
	    addClass.selectClassDate();
	    addClass.clickSaveBtn();
	}

	@When("Update the optional fields with valid values and click save")
	public void update_the_optional_fields_with_valid_values_and_click_save() {
	    
		addClass.createOptionsfeilds();
		addClass.clickSaveBtn();
	}

	@When("Admin enters only numbers or special char in the text fields")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {
	    
	    addClass.CreateTextFeildsSpecialChar();
	    addClass.clickSaveBtn();
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
	    
		addClass.clickCancelButton();
	}

	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {
	    
		addClass.isClassPopupClosed();
	}
	
	@When("Admin clicks on the Batchname sort icon")
	public void admin_clicks_on_the_batchname_sort_icon() {
	    
		editClass.clickSortBatchName();
	}

	@Then("Admin should see Class details are sorted by Batch Name")
	public void admin_should_see_class_details_are_sorted_by_batch_name() {
		editClass.getSortedBatchnameAsc();
		Assert.assertTrue(editClass.getBatchNameList().equals(editClass.getSortedBatchnameAsc()));
	}
	
	@When("Admin clicks on the Class topic sort icon")
	public void admin_clicks_on_the_class_topic_sort_icon() {
	    editClass.clickSortClassTopic();
	}

	@Then("Admin should see Class details are sorted by Class Topic")
	public void admin_should_see_class_details_are_sorted_by_class_topic() {
	    editClass.getSortedClassTopicAsc();
	    editClass.getSortedClassTopicdesc();
	    Assert.assertTrue(editClass.getClassTopicList().equals(editClass.getSortedClassTopicAsc()));
	}
	@When("Admin clicks on the Class description  sort icon")
	public void admin_clicks_on_the_class_description_sort_icon() {
	    editClass.clickSortClassDescription();
	}

	@Then("Admin should see Class details are sorted by Class Description")
	public void admin_should_see_class_details_are_sorted_by_class_description() {
	   editClass.getSortedClassDescriptionAsc();
	   editClass.getSortedClassDescriptiondesc();
	   Assert.assertTrue(editClass.getSortclassDescription().equals(editClass.getSortedClassDescriptionAsc()));
	}
	
	@When("Admin clicks on the Status sort icon")
	public void admin_clicks_on_the_status_sort_icon() {
	   editClass.clickSortStatus();
	}

	@Then("Admin should see Class details are sorted by Status")
	public void admin_should_see_class_details_are_sorted_by_status() {
	    editClass.getSortedStatusAsc();
	    editClass.getSortedStatusdesc();
	    Assert.assertTrue(editClass.getSortStatus().equals(editClass.getSortedStatusAsc()));
	}
	
	@When("Admin clicks on the Class Date sort icon")
	public void admin_clicks_on_the_class_date_sort_icon() {
	   editClass.clickSortClassDate();
	}

	@Then("Admin should see Class details are sorted by Class Date")
	public void admin_should_see_class_details_are_sorted_by_class_date() {
	    editClass.getSortedClassDteAsc();
	    editClass.getSortedClassDtedesc();
	    Assert.assertTrue(editClass.getSortClassDate().equals(editClass.getSortedClassDteAsc()));
	}
	
	@When("Admin clicks on the Staff Name sort icon")
	public void admin_clicks_on_the_staff_name_sort_icon() {
	    editClass.clickSortStaffName();
	}

	@Then("Admin should see Class details are sorted by Staff name")
	public void admin_should_see_class_details_are_sorted_by_staff_name() {
	   editClass.getSortedStaffNameAsc();
	   editClass.getSortedStaffNamedesc();
	   Assert.assertTrue(editClass.getSortStaffName().equals(editClass.getSortedStaffNameAsc()));
	}




}
