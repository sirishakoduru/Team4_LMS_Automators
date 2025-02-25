package stepDefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.BatchPageFunctionalityEditDelete;
import pageFactory.BatchPagination;
import utilities.ConfigReader;

public class BatchPageFunctionalityEditDelete_Steps {
	BatchPageFunctionalityEditDelete bpf=new BatchPageFunctionalityEditDelete();
	BatchPagination bb=new BatchPagination();
	
	@Given("Admin is on the Batch Page")
	public void admin_is_on_the_batch_page() {
	   bpf.Click_BatchButton();
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
	    bpf.Click_BatchButton();
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
	    bpf.Verify_AddNewBatch();
	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
	    bpf.Click_AddNewBatch();
	}

	@Then("Admin should see the Batch details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
	    bpf.Verify_BatchDetails();
	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() throws InterruptedException {
	    bpf.Click_EditIcon();
	}

	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing() {
	    bpf.ProgName_Disabled();
	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
	    bpf.BatchName_Disabled();
	}
	
	@Given("Admin is on the Batch Details Page")
	public void admin_is_on_the_batch_details_page() throws InterruptedException {
		bpf.Click_BatchButton();
	}
	
	@When("Admin Updates any fields with invalid Description (.*) and No_Of_Classes (.*) and click save button$")
	public void admin_updates_any_fields_with_invalid_description_and_no_of_classes_$_and_click_save_button(String Description, String No_of_classes) throws InterruptedException {
		bpf.Click_EditIcon();
		bpf.update_InvalidField(Description, No_of_classes);
	}
	
	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {
	    bpf.ReadErrorMessage();
	}
	@When("Admin enters the batch name in the search text box")
	public void admin_enters_the_batch_name_in_the_search_text_box() {
	   bpf.SearchData();
	}

	@Then("Admin should see the filtered batches in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table() {
		assertTrue(bpf.searchlist().contains("TestProgram"));   
	}

	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() throws InterruptedException {
		bpf.EditBatchName_MandetoryFields();
	}

	@Then("Admin should get a successful message for editing the batch")
	public void admin_should_get_a_successful_message_for_editing_the_batch() {
	   //bpf.BatchUpdated_Message();
	}

	@When("Admin enters the valid data to all the mandatory fields and click Cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() throws InterruptedException {
	    bpf.EditBatchName_MandetoryFields_Cancel_Button();
	}
	
	@When("Admin clicks the delete Icon on any row")
	public void admin_clicks_the_delete_icon_on_any_row() throws InterruptedException {
	     bpf.click_Delete_Icon();
	     
	}

	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
		bpf.Delete_DialogueBox();
	     
	}

	@When("Admin clicks on the delete icon and click yes button")
	public void admin_clicks_on_the_delete_icon_and_click_yes_button() {
	     bpf.Delete_Popup_Yes();
	     
	}

	@Then("Admin should see the successful message and the batch should be deleted")
	public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted() {
	     bpf.Batch_Verification();
	     
	}

	@When("Admin clicks on the delete icon and click no button")
	public void admin_clicks_on_the_delete_icon_and_click_no_button() {
		bpf.Delete_Popup_No();
	     
	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
		bpf.Batch_Verification();
	     
	}
	@When("Admin clicks on the delete icon close icon")
	public void Admin_clicks_on_the_delete_icon_close_icon() {
		bpf.Delete_Popup_Close();
	     
	}

	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed() {
		bpf.Batch_Verification();
	     
	}

	@When("Admin check checkbox and clicks on the delete icon under the Manage batch header")
	public void Admin_check_checkbox_and_clicks_on_the_delete_icon_under_the_Manage_batch_header() {
	     bpf.check_checkbox_DeleteAll_Button();
	     
	}

	@Then("The respective row in the table should be deleted")
	public void the_respective_row_in_the_table_should_be_deleted() {
	     bpf.Batch_Verification();
	     
	}

	@When("Admin clicks multiple checkbox and click on the delete icon under the Manage batch header")
	public void Admin_clicks_multiple_checkbox_and_click_on_the_delete_icon_under_the_Manage_batch_header() {
	     bpf.checkAll_DeleteAll();
	     
	}
	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() {
	     bb.Click_NextPageLink();
	   
	}

	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_next_enabled_link() throws InterruptedException {
	     bb.Page2Link_IsEnabled();
	   
	}

	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() {
	     bb.Click_LastPageLink();
	   
	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
	     bb.NextPageLink_IsDisabled();
	   
	}

	@When("Admin clicks previous page link on the data table")
	public void admin_clicks_previous_page_link_on_the_data_table() {
	     bb.Click_PreviousPageLink();
	   
	}

	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {
	     bb.PreviousPageLink_IsDisplayed();
	   
	}

	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {
	     bb.Click_FirstPageLink();
	   
	}

	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() {
	     bb.FirstPageLink_IsDisplayed();
	   
	}

	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() {
	     bb.Click_LogOutButton();
	   
	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() {
	     bb.Admin_Loggedout();
	   
	}

}
