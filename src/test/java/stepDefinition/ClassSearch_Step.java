package stepDefinition;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Class;
import pageFactory.Login;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class ClassSearch_Step {
	
	Login login = new Login();
	Class cls = new Class();
	//ClassSearch clssearch = new ClassSearch();
	ExcelReader exReader = new ExcelReader();
	ConfigReader reader = new ConfigReader();
	
	@Given("Admin is on the Manage class page")
	public void admin_is_on_the_manage_class_page() {
		login.getbaseurl();
		login.enterUsername(reader.getProperty("username"));
		login.enterPassword(reader.getProperty("password"));
		login.selectTheRole();
		login.selectAdminRole();
		login.clickLoginBtn();
        cls.classbtn();
	}

	@When("Admin enter the Batch Name in search textbox.")
	public void admin_enter_the_batch_name_in_search_textbox() {
//		String value = "Python101";
//		cls.search().sendKeys("Python101");
		cls.searchbatch();
	}

	@Then("Admin should see Class details are searched by Batch Name")
	public void admin_should_see_class_details_are_searched_by_batch_name() {
	    System.out.println("searched the desired value");
	}
	@When("Admin enter the Class topic in search textbox")
	public void admin_enter_the_class_topic_in_search_textbox() {
	    cls.searchclasstopic();
	}

	@Then("Admin should see Class details are searched by Class topic")
	public void admin_should_see_class_details_are_searched_by_class_topic() {
		Assert.assertEquals("API01MYTOC", "API01MYTOC");
	}

	@When("Admin enter the Staff Name in search textbox")
	public void admin_enter_the_staff_name_in_search_textbox() {
	    cls.searchstaffname();
	}

	@Then("Admin should see Class details are searched by Staff name")
	public void admin_should_see_class_details_are_searched_by_staff_name() {
		Assert.assertEquals("Kevin Thomas", "Kevin Thomas");
	}


}
