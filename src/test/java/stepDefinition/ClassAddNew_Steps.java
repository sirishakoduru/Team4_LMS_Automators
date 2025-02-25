package stepDefinition;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Class;
import pageFactory.Login;
import pageFactory.ClassAddNew;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class ClassAddNew_Steps {
	Login login = new Login();
	Class cls = new Class();
	ClassAddNew addclass = new ClassAddNew();
	ExcelReader exReader = new ExcelReader();
	ConfigReader reader = new ConfigReader();
	
	
	
	@When("Admin clicks a add new class under the class menu bar.")
	public void admin_clicks_a_add_new_class_under_the_class_menu_bar() {
		login.getbaseurl();
		login.enterUsername(reader.getProperty("username"));
		login.enterPassword(reader.getProperty("password"));
		login.selectTheRole();
		login.selectAdminRole();
		login.clickLoginBtn();
		 cls.classbtn();
	    addclass.addnewclass();
	}

	@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		addclass.cancelDisp();
		addclass.saveDisp();
		addclass.crossBtnDisp();
		System.out.print("popup open");

	}
	@Then("Admin should see few input fields and their respective text boxes in the class details window")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
	   addclass.batchname();
	   addclass.classtopic();
	}
}
