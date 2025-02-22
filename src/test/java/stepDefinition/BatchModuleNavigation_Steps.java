package stepDefinition;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.BatchModuleNavigation;

public class BatchModuleNavigation_Steps {
	BatchModuleNavigation bmn=new BatchModuleNavigation();
	
	@Given("Admin is on the home page")
	public void admin_is_on_the_home_page() {
	   bmn.click_HomeButton();
	}
	
	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
	    bmn.click_BatchModule();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
	    bmn.Verify_Title_Manage_Batch();
	}
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String string) {
	    bmn.Verify_LMSTitle();
	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String string) {
		bmn.Verify_Title_Manage_Batch();
	}

	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String string) {
	    bmn.verify_DeleteAll_Disabled();
	}

	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
	    bmn.verify_NextPage_Pagination_Enabled();
	}

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		boolean allEditIconsEnabled = bmn.Edit_Icon_Each_Row();
        assertTrue(allEditIconsEnabled);
	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		boolean AllDeleteIconsEnabled = bmn.Delete_Icon_Each_row();
        assertTrue(AllDeleteIconsEnabled);
	}

	@Then("Admin should see the checkbox in each row")
	public void admin_should_see_the_checkbox_in_each_row() {
	    boolean CheckboxIconEnabled=bmn.Checkbox_Icon_Each_Row();
	    assertTrue(CheckboxIconEnabled);
	}

	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
	    bmn.Header_Validation();
	}

	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
	    bmn.TableHeader_Checkbox();
	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
	   bmn.Sort_Icon_Table();
	}
}
