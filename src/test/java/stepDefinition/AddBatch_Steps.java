package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.AddBatch;
import pageFactory.BatchPageFunctionalityEditDelete;

public class AddBatch_Steps {
	AddBatch ab=new AddBatch();
	BatchPageFunctionalityEditDelete bpfed=new BatchPageFunctionalityEditDelete();
	
	@Given("Admin is on the Batch Details Pop Up WIndow")
	public void admin_is_on_the_batch_details_pop_up_w_indow() {
		bpfed.Click_Batch();
		bpfed.Click_AddNewBatch();
	}

	@When("Admin checks all the fields are enabled")
	public void admin_checks_all_the_fields_are_enabled() {
	    ab.Fields_Enabled();
	}

	@Then("The pop up should include the mandetory fields")
	public void the_pop_up_should_include_the_mandetory_fields() {
	    ab.Fields_Displayed();
	}

	@When("Admin selects program name present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown() throws InterruptedException {
		ab.Select_dropdown();
		ab.Select_ProgramName_From_Dropdown();
	}

	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		ab.Selected_Prog_Same_BatchName();
	}

	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
	    ab.Selected_Prog_Same_BatchName();
	}

	@Then("Admin should get error message below the text box of respective field")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
		ab.Invalid_BatchNumber_Error();
	}

	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
	    ab.EnterAlphabets();
	}

	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() {
	   ab.empty_Batch_Prefix();
	}

	@When("Admin enters the data only to the mandatory fields and clicks save button")
	public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_save_button() throws InterruptedException {
	    ab.AddBatch_ValidData();
	}

	@Then("Admin should get a successful message")
	public void admin_should_get_a_successful_message() {
	   // ab.Batch_Created_Successful_Message();
	}

	@When("Admin leaves blank one of the mandatory fields")
	public void admin_leaves_blank_one_of_the_mandatory_fields() throws InterruptedException {
	   ab.AddBatch_MissingData();
	}

	@Then("Admin should get a error message on the respective mandatory field")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field() {
	    ab.ReadError();
	}

	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() throws InterruptedException {
	    ab.AddBatch_CancelClick();
	}

	@Then("Admin can see the batch details popup closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
	    ab.get_CurrentPage();
	}

	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() throws InterruptedException {
	    ab.AddBatch_CloseClick();
	}

	@Then("batch details pop up closes")
	public void batch_details_pop_up_closes() {
		ab.get_CurrentPage();
	}
}
