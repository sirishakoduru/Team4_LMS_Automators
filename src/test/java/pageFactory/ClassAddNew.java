package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import driver.DriverFactory;
import utilities.ConfigReader;

public class ClassAddNew {
	WebDriver driver=DriverFactory.getDriver();
	ConfigReader reader=new ConfigReader();
	@FindBy(xpath="//button[@role='menuitem']")WebElement Addnewclass;
	@FindBy(xpath = "//button[@label='Cancel']") WebElement cancelBtn;
	@FindBy(xpath = "//button[@label='Save']")WebElement saveBtn;
	@FindBy(css = ".p-dialog-header-close")WebElement crossBtn;
	@FindBy(css = ".p-datatable-footer.ng-star-inserted")WebElement footer;
	@FindBy(xpath = "//label[text()='Batch Name']")WebElement batchNamePopup;
	@FindBy(xpath = "//label[text()='Class Topic ']")WebElement classTopicPopup;
	@FindBy(xpath = "//div[normalize-space()='Manage Class']")WebElement managePage;

	public ClassAddNew() {
		PageFactory.initElements(driver, this);
	}
	public void addnewclass() {
		Addnewclass.click();
	}

	public void cancelDisp() {
					
		boolean expected = true;
		Assert.assertEquals(expected, cancelBtn.isDisplayed());
		 cancelBtn.isDisplayed();
	}

	public void saveDisp() {
		boolean expected = true;
		Assert.assertEquals(expected, saveBtn.isDisplayed());
		saveBtn.isDisplayed();
		 	}

	public void crossBtnDisp() {
		boolean expected = true;
		Assert.assertEquals(expected, crossBtn.isDisplayed());
		crossBtn.isDisplayed();
	}
	public void batchname() {
		boolean expected = true;
		Assert.assertEquals(expected, batchNamePopup.isDisplayed());
		batchNamePopup.isDisplayed();
	}
	public void classtopic() {
		boolean expected = true;
		Assert.assertEquals(expected, classTopicPopup.isDisplayed());
		classTopicPopup.isDisplayed();
	}
}
