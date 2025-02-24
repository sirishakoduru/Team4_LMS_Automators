package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Class;
import pageFactory.Login;
import pageFactory.Logout;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class ClassPagi_Steps {
	
	Login login = new Login();
	Logout logout = new Logout();
	Class cls = new Class();
	ExcelReader exReader = new ExcelReader();
	ConfigReader reader = new ConfigReader();
	@When("Admin clicks Next page link on the class table")
	public void admin_clicks_next_page_link_on_the_class_table() {
	    cls.clickNextPg();
	}

	@Then("Admin should see the next page record on the table  with Pagination has next active link enabled")
	public void admin_should_see_the_next_page_record_on_the_table_with_pagination_has_next_active_link_enabled() {
		Assert.assertTrue(cls.isNextButtonEnabled(),"Next Page Link is Active");
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
	    cls.clickLastPage();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		Assert.assertTrue(cls.isNextButtonEnabled(),"Next Page link is Disabled");
		Assert.assertTrue(cls.LastPage(),"Previous Page Record is present");
	}

	
	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
	    cls.clickFirstPg();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link enabled")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_enabled() {
		Assert.assertFalse(cls.isPrevButtonEnabled(),"Previous Page Link is Enabled");
		//Assert.assertTrue(cls.PrevPg(), "previous page link enabled");
		Assert.assertFalse(cls.PrevPg(),"Previous Page Record is present");
	}

	@When("Admin clicks Start page link")
	public void admin_clicks_start_page_link() {
	    cls.clickstartbtn();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		//Assert.assertTrue(cls.FirstPg(),"Previous Page Link is Disabled");
		//Assert.assertTrue(cls.PrevPg(), "previous page link enabled");
		Assert.assertTrue(!cls.isPrevButtonEnabled(),"Previous Page Link is Disabled");
		Assert.assertTrue(!cls.FirstPg(),"First Page Record is present");
	}



}
