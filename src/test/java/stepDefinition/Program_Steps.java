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
	    
		if(!isSetupDone) {
				
				login.getbaseurl();
				System.out.println("username: " + reader.getProperty("username"));
				login.enterUsername(reader.getProperty("username"));
				login.enterPassword(reader.getProperty("password"));
				login.enterRole("Admin");
				login.clickLoginBtn();
				Thread.sleep(1000);
				isSetupDone = true;
		}

	}


	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() throws InterruptedException {
		
		Assert.assertEquals(true,home.homePageVerify(),"Verifying if we are on HOME page" );
	}

	@When("Admin clicks program on the navigation bar")
	public void admin_clicks_on_the_navigation_bar() throws InterruptedException {

		home.clickProgramLink();		
	}
	
	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() throws InterruptedException {
		
		Assert.assertEquals(true,program.programPageVerify(),"Verifying if we are on PROGRAM page" );	

	}

	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {

		Assert.assertEquals(true,program.logoutDisplay(),"Verifying if logout is displayed" );
	}
	

	@Then("Admin should see the page names as in order")
	public void ad_admin_should_see_the_page_names_as_in_order() {
		
		System.out.println("Passed Link Order: " + expectedOrder);
		Assert.assertEquals(expectedOrder,program.actualOrderMenu(),"Checking the order of menu links ");
	}
	
	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
		
		Assert.assertEquals(true,program.isSubMenuDisplay(),"Verifying if Add program is displayed" );
	}

	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String string) {
	   
		if(string == "Manage Program") {
		Assert.assertEquals(string,program.getPgmMgmtText(),"Checking the Program Management Heading: ");
		}
		
		if(string == "LMS - Learning Management System") {
		Assert.assertEquals(string,program.getLMSText(),"Checking the LMS Heading: ");
		}
	}
	
	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
		
		Assert.assertEquals(true,program.tableBodyCheck(),"Verifying if name, description, etc is displayed" );
		
	}
	
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		
		Assert.assertEquals(false,program.validateMultipleDeleteBtnDisabled(),"Verifying if delete button is disabled" );

	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {

		Assert.assertEquals("Search...",program.validateSearchBar(),"Verifying search bar placeholder" );
	}

	@Then("Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit\\/Delete")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
	    
		Assert.assertEquals(expectedColOrder,program.colHeadersCheck(),"Verifying he column heades" );
	}
}

