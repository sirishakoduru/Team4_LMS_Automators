package stepDefinition;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Then;
import pageFactory.HomePageFactory;
import pageFactory.Login;
import utilities.ConfigReader;



public class Home_Steps {
	
	Login login = new Login();
//	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();	
	HomePageFactory Home = new HomePageFactory();
	

	public void stepsToLogin() {
		login.enterUsername(ConfigReader.getProperty("username"));
		login.enterPassword(ConfigReader.getProperty("password"));
		Home.selectrole();
		Home.clicklogin();
	}

	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
//		stepsToLogin();
	    Assert.assertEquals(Home.pagetitle(),"LMS");
	}

	@Then("Admin should NOT see LMS_Test as title")
	public void admin_should_not_see_lms_test_as_title() {
//		stepsToLogin();
	    Assert.assertNotEquals(Home.pagetitle(),"LMS_Test");
	}
	
	@Then("Admin should see LMS title on the top left corner of page")
	public void admin_should_see_lms_title_on_the_top_left_corner_of_page() {
//		stepsToLogin();
	    Assert.assertEquals(Home.get_lms_location(),true);
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
//		stepsToLogin();
	    Assert.assertEquals(Home.get_toolbar_elements_text(),"Home"+"Program"+"Batch"+"Class"+"Logout");
	}
	
	
	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
//	  stepsToLogin();
	  Assert.assertEquals(Home.getLMSTitleText(),"LMS - Learning Management System");
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
//	    stepsToLogin();
//	    Assert.assertEquals(Home.getnavBarText(),"Home\r\n"
//	    		+ "Program\r\n"
//	    		+ "Batch\r\n"
//	    		+ "Class\r\n"
//	    		+ "Logout");
	    Assert.assertEquals(Home.getnavBarLoc(), true);
	}

	@Then("Admin should see home in the first place")
	public void admin_should_see_home_in_the_first_place() {
//		stepsToLogin();
		Assert.assertEquals(Home.toolBarElement_place(Home.get_webelement("home"), 0),true);
	}

	@Then("Admin should see program in the Second place")
	public void admin_should_see_program_in_the_second_place() {
//		stepsToLogin();
		Assert.assertEquals(Home.toolBarElement_place(Home.get_webelement("program"), 1),true);
	}

	@Then("Admin should see batch in the Third place")
	public void admin_should_see_batch_in_the_third_place() {
//		stepsToLogin();
		Assert.assertEquals(Home.toolBarElement_place(Home.get_webelement("batch"), 2),true);
	}
	
	@Then("Admin should see class in the Fourth place")
	public void admin_should_see_class_in_the_fourth_place() {
//		stepsToLogin();
		Assert.assertEquals(Home.toolBarElement_place(Home.get_webelement("class"), 3),true);
	}
	
	@Then("Admin should see logout in the Fifth place")
	public void admin_should_see_logout_in_the_fifth_place() {
//		stepsToLogin();
		Assert.assertEquals(Home.toolBarElement_place(Home.get_webelement("logout"), 4),true);
	}
	
	@Then("Admin should see welcome message with user name and role")
    public void admin_should_see_welcome_message_with_user_name_and_role() {
//		stepsToLogin();
        String expectedWelcomeMessage = "Welcome sdetnumpyninja@gmail.com";
        Assert.assertEquals(Home.getWelcomeMessage().contains(expectedWelcomeMessage), true);
    }
	
	@Then("Admin shoud see piechart")
	public void admin_shoud_see_piechart() {
//	    stepsToLogin();
	    Assert.assertEquals(Home.isDisplayed(Home.get_webelement("doughnut")),true);
	}
	
	@Then("Admin should see bar chart for Active and inactive user")
	public void admin_should_see_bar_chart_for_active_and_inactive_user() {
//	    stepsToLogin();
//	    Home.getElementText();
	    Assert.assertEquals(Home.isDisplayed(Home.get_webelement("bargraph")),true);
	}
	
	@Then("Admin should see user count")
	public void admin_should_see_user_count() {
//	    stepsToLogin();
	    Assert.assertEquals(Home.isDisplayed(Home.get_webelement("UserCount")),true);
	}
	
	
	@Then("Admin should see staff count")
	public void admin_should_see_staff_count() {
//		 stepsToLogin();
		 Assert.assertEquals(Home.isDisplayed(Home.get_webelement("StaffCount")),true);
	}
	
	
	@Then("Admin should see Program count")
	public void admin_should_see_program_count() {
//		stepsToLogin();
		 Assert.assertEquals(Home.isDisplayed(Home.get_webelement("ProgramCount")),true);
	}

	@Then("Admin should see batch count")
	public void admin_should_see_batch_count() {
//		stepsToLogin();
//		System.out.println("TagName:"+Home.get_webelement("batchCount").getTagName());
//		System.out.println("Value:"+Home.get_webelement("batchCount").getAttribute("value"));
//		System.out.println("InnerHTML:"+Home.get_webelement("batchCount").getAttribute("InnerHTML"));
//		System.out.println("Text:"+Home.get_webelement("batchCount").getText());
//		System.out.println("Location:"+Home.get_webelement("batchCount").getLocation());
		Assert.assertEquals(Home.isDisplayed(Home.get_webelement("batchCount")),true);
	}

	
	
	@Then("Admin should see previous page icon disabled")
	public void admin_should_see_previous_page_icon_disabled() {
//		stepsToLogin();
		System.out.println("Text:"+Home.get_webelement("prePage").getAccessibleName());
//	    Assert.assertEqualsc(Home.isEnabled(Home.get_webelement("prePage")),false);
	}
	
	@Then("Admin should see first page icon disabled")
	public void admin_should_see_first_page_icon_disabled() {
//		stepsToLogin();
		System.out.println("Text:"+Home.get_webelement("firstPage"));
//	    Assert.assertEquals(Home.isEnabled(Home.get_webelement("firstPage")),true);
	}
	
	
	@Then("Admin should see {int} staff data in a page")
	public void admin_should_see_staff_data_in_a_page(Integer int1) {
//		stepsToLogin();
		Home.getStaffCount();
//		Assert.assertEquals(Home.getStaffCount(),5);
	}

	
	@Then("Admin should see staff table with pagination icons")
	public void admin_should_see_staff_table_with_pagination_icons() {

	}
	
}



