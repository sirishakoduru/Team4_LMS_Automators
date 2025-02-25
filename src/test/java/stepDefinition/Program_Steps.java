package stepDefinition;

import java.util.*;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageFactory.*;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Program_Steps {
	
	Login login = new Login();
	Home home = new Home();
	Program program = new Program();
	ExcelReader exReader = new ExcelReader();
	ConfigReader reader = new ConfigReader();
	private static boolean isSetupDone = false;
	List<String> expectedOrder = Arrays.asList("Home", "Program", "Batch", "Class", "Logout");
	List<String> expectedColOrder = Arrays.asList("", "Program Name", "Program Description", "Program Status", "Edit / Delete");
	
	@Given("Admin is logged in to LMS Portal")
	public void admin_logs_into_the_lmsportal() throws InterruptedException {
	   
				
				login.getbaseurl();
				System.out.println("username: " + reader.getProperty("username"));
				login.enterUsername(reader.getProperty("username"));
				login.enterPassword(reader.getProperty("password"));
				login.selectTheRole();
				login.selectAdminRole();
				login.clickLoginBtn();
				Thread.sleep(1000);
//				isSetupDone = true;

	}


	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() throws InterruptedException {
		
		Assert.assertEquals(home.homePageVerify(),true,"Verifying if we are on HOME page" );
	}

	@When("Admin clicks program on the navigation bar_1")
	public void admin_clicks_on_the_navigation_bar() throws InterruptedException {

		home.clickProgramLink();		
	}
	
	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() throws InterruptedException {
		
		Assert.assertEquals(program.programPageVerify(),true,"Verifying if we are on PROGRAM page" );	

	}

	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {

		Assert.assertEquals(program.logoutDisplay(),true,"Verifying if logout is displayed" );
	}
	

	@Then("Admin should see the page names as in order")
	public void ad_admin_should_see_the_page_names_as_in_order() {
		
		System.out.println("Passed Link Order: " + expectedOrder);
		Assert.assertEquals(program.actualOrderMenu(),expectedOrder,"Checking the order of menu links ");
	}
	
	@Then("Admin should see sub menu in menu bar as {string}_1")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
		
		Assert.assertEquals(program.isSubMenuDisplay(),true,"Verifying if Add program is displayed" );
	}

	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String string) {
	   
		if(string == "Manage Program") {
		Assert.assertEquals(program.getPgmMgmtText(),"Checking the Program Management Heading: ");
		}
		
		if(string == "LMS - Learning Management System") {
		Assert.assertEquals(program.getLMSText(),string,"Checking the LMS Heading: ");
		}
	}
	
	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
		
		Assert.assertEquals(program.tableBodyCheck(),true,"Verifying if name, description, etc is displayed" );
		
	}
	
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		
		Assert.assertEquals(program.validateMultipleDeleteBtnDisabled(),false,"Verifying if delete button is disabled" );

	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {

		Assert.assertEquals(program.validateSearchBar(),"Search...","Verifying search bar placeholder" );
	}

	@Then("Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit\\/Delete")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
	    
		Assert.assertEquals(program.colHeadersCheck(),expectedColOrder,"Verifying he column heades" );
	}
	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
		
		Assert.assertEquals(program.validateheaderCheckBoxUnchecked(),false,"Verifying if header checkbox is unchecked" );
	}

	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		
		Assert.assertEquals(program.validateAllCheckBoxesUnchecked(),false,"Verifying if all checkbox are unchecked" );
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		Assert.assertEquals(program.validateSortIcons(),true,"Verifying sort icon" );
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		Assert.assertEquals(program.validateEditDelIcons(),true,"Verifying edit & delete" );
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) throws InterruptedException {
		Assert.assertEquals(true, program.validatePaginationTextandIcons(string));

	}

	@Then("Admin should see the footer as {string}.")
	public void admin_should_see_the_footer_as(String string) {
		Assert.assertEquals(true, program.validateFooter(string));
	}
	
	///    Add Program /////
	
	@Given("Admin is on Program page")
	public void admin_is_on_program_page() {
		Assert.assertEquals(program.programPageVerify(),true,"Verifying if we are on PROGRAM page" );
	}

	@When("Admin clicks on {string} under the {string} menu bar_1")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
		program.programLinkAddClick();
	}

	@Then("Admin should see pop up window for program details")
	public void admin_should_see_pop_up_window_for_program_details() {
		Assert.assertEquals(program.isProgramDetailsPopup(),true,"See the Add window" );
	}
	
	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String string) {
		program.validateProgramDetailsTitle(string);
	}

	@Then("Admin should see red  asterisk mark  beside mandatory field {string}")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field(String string) {
		Assert.assertEquals(program.validateAsterisk(string), true);
	}

	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() {
		program.programLinkAddForm();
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
	    program.clickSaveAdd();
	}

	@Then("Admin gets error message")
	public void admin_gets_message() {
		Assert.assertEquals(program.mandatoryError(), true,"Error Message if a mandatory field is missed");
	}
	
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		program.clickCancelAdd();
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {
		Assert.assertEquals(program.isProgramDetailsPopup(),false,"The Add window disappears" );
	}
	
	@When("Admin enters the Name in the text box")
	public void admin_enters_the_name_in_the_text_box() {
		program.enterPgName();
	}

	@Then("Admin can see the text entered")
	public void admin_can_see_the_text_entered() {
		program.dispPgName();
	}
	
	@When("Admin enters the Description in text box")
	public void admin_enters_the_description_in_text_box() {
		program.enterPgDescName();
	}

	@Then("Admin can see the text entered in description box")
	public void admin_can_see_the_text_entered_in_description_box() {
		program.dispPgDescName();
	}

	@When("Admin selects the status of the program by clicking on the radio buttonx")
	public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_buttonx() {
		program.selBtn();
	}

	@Then("Admin can see status selected")
	public void admin_can_see_status_selected() {
		program.dispSelBtn();
	}
	

	@When("Admin enter valid details for mandatory fields and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button() {
		program.enterPgName();
		program.enterPgDescName();
		program.selBtn();
		program.clickSaveAdd();
		
	}
	
	@Then("Admin gets message {string}")
	public void admin_gets_message(String string) {

	}
	
	@When("Admin Click on cancel button")
	public void admin_click_on_cancel_button() {
		
		program.enterPgName();
		program.enterPgDescName();
		program.selBtn();
		program.clickCancelAdd();

	}
	
	@Then("Admin can see program details form disappear")
	public void admin_can_see_program_details_form_disappear() {

	}
	
	@When("Admin searches with newly created {string}")
	public void admin_searches_with_newly_created(String string) {

	}
	
	@Then("Records of the newly created  {string} is displayed and match the data entered")
	public void records_of_the_newly_created_is_displayed_and_match_the_data_entered(String string) {

	}

	@When("Admin Click on close button")
	public void admin_click_on_close_button() {

	}
	
	/***************************                    SORTING   
	 * @throws InterruptedException ********************************/
	
	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() throws InterruptedException {
		home.clickProgramLink();
		program.ProgramNameSortClick();
//		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin see the Program Name is sorted in {string} ascending or descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_or_descending_order(String sortingOrder) {
		Assert.assertTrue(program.verifyingProgramNameSorting(sortingOrder),
				"Sorting verification failed for order: " + sortingOrder);
	}


	@When("Admin clicks on Arrow next to program Description")
	public void adminClicksOnArrowNextToProgramDescription() throws InterruptedException {
		home.clickProgramLink();
		program.ProgramDescriptionSortClick();
	}

	@Then("Admin see the Program Description is sorted in {string} ascending or descending order")
	public void adminSeeTheProgramDescriptionIsSortedInAscendingOrDescendingOrder(String sortingOrder) {
		Assert.assertTrue(program.verifyingProgramDescSorting(sortingOrder),
				"Sorting verification failed for order: " + sortingOrder);
	}

	@When("Admin clicks on Arrow next to program status")
	public void adminClicksOnArrowNextToProgramStatus() throws InterruptedException {
		home.clickProgramLink();
		program.ProgramStatusSortClick();
	}

	@Then("Admin see the Program Status is sorted in {string} ascending or descending order")
	public void adminSeeTheProgramStatusIsSortedInAscendingOrDescendingOrder(String sortingOrder) {
		Assert.assertTrue(program.verifyingProgramStatusSorting(sortingOrder),
				"Sorting verification failed for order: " + sortingOrder);
	}
}

