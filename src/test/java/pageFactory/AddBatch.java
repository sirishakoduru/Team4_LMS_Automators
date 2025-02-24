package pageFactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import junit.framework.Assert;
import utilities.ConfigReader;
import utilities.Utils;

public class AddBatch {
	WebDriver driver=DriverFactory.getDriver();
	//driver.manage().window().maximize();
	ConfigReader reader=new ConfigReader();
	Utils us=new Utils();
	
	public AddBatch() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@role='button' and @aria-haspopup='listbox']") WebElement PrognameDropDown;
	//@FindBy(xpath="//p-dropdown[@id='programName']/div/div/span") WebElement PrognameDropDown;
	@FindBy(id="batchName") WebElement BatchName;
	@FindBy(id="batchDescription") WebElement BatchDescription;
	@FindBy(id="batchNoOfClasses") WebElement NoOfClasses;
	@FindBy(xpath="//div[2]//div[4]//div[2]//p-radiobutton[@class='ng-untouched ng-pristine ng-valid']") WebElement Active_Button;
	@FindBy(xpath="//*[text()=' INACTIVE ']") WebElement Inactive_Button;
	@FindBy(xpath="//ul[@class='p-dropdown-items ng-tns-c88-25']") WebElement DropdownArea;
	
	String drpProgNameXPATH="//li[@aria-label='"+reader.ProgramName()+"']";
	//@FindBy(xpath="drpProgNameXPATH") WebElement drpProgname;
	
	@FindBy(xpath="//li[@aria-label='TestProgramTeamFive']")WebElement drpProgname;
	@FindBy(id="batchProg") WebElement Batchname_Prefix;
	@FindBy(xpath="//div//div//input[@class='p-dropdown-label p-inputtext ng-tns-c88-59 ng-star-inserted']") WebElement Selected_ProgName;
	@FindBy(xpath="//button[@class='p-button-rounded p-button-success p-button p-component ng-star-inserted']") WebElement SaveButton;
	@FindBy(xpath="//p-dialog[1]//div//div//div[3]//button[1][@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']")
	WebElement CancelButton;
	@FindBy(xpath="//div//div//button[@class='ng-tns-c81-9 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']") 
	WebElement CloseButton;
	@FindBy(xpath="//div//div[2]//div[3]//small[contains(text(),'Batch Description is required.')]") 
	WebElement Description_Error;
	@FindBy(xpath="//div//div//div//div[2][@class='p-toast-detail ng-tns-c20-39' and contains (text(),' Batch Created Successfully')]") WebElement SuccessfulMessage;
	
	
	public void Select_dropdown() {
		PrognameDropDown.click();
	}
	public void Fields_Enabled() {
		if (BatchName.isEnabled() && BatchDescription.isEnabled() && 
			NoOfClasses.isEnabled() && Active_Button.isEnabled() && Inactive_Button.isEnabled()) {
			System.out.println("All the fields are enabled");
		}
		else {
			System.out.println("Not all the fields are enabled");
		}
	}
	public void Fields_Displayed() {
		if (BatchName.isDisplayed() && BatchDescription.isDisplayed() && 
			NoOfClasses.isDisplayed() && Active_Button.isDisplayed() && Inactive_Button.isDisplayed()) {
				System.out.println("Mandetory fields are included");
			}
			else {
				System.out.println("Mandetory field is missing");
			}
	}
	public void Select_ProgramName_From_Dropdown() throws InterruptedException {
		System.out.println(drpProgNameXPATH);
		//WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", PrognameDropDown); // Scroll to the bottom;
		Thread.sleep(200);
		drpProgname.click();
	}
	public void Selected_Prog_Same_BatchName() {
		String BatchName=Batchname_Prefix.getText();
		System.out.println("BatchName:"+BatchName);
	}
	public void empty_Batch_Prefix() {
		String data=Batchname_Prefix.getText();
		if (data== null) {
			System.out.println("No data present");
		}
		else {
			System.out.println("data is present");
		}
	}
	public void EnterAlphabets() {
		String alpha="abcd";
		BatchName.sendKeys(alpha);
	}
	public void WriteData_In_BatchPrefix() {
		Batchname_Prefix.sendKeys("xyz");
		System.out.println("Not allowed to print");
	}
	public void AddBatch_ValidData() throws InterruptedException {
		PrognameDropDown.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", PrognameDropDown); // Scroll to the bottom;
		Thread.sleep(200);
		drpProgname.click();
		BatchName.sendKeys(reader.BatchNum());
		BatchDescription.sendKeys(reader.BatchDescription());
		Active_Button.click();
		NoOfClasses.sendKeys(reader.No_Of_Classes());
		SaveButton.click();
	}
	public void AddBatch_CancelClick() throws InterruptedException {
		PrognameDropDown.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", PrognameDropDown); // Scroll to the bottom;
		Thread.sleep(200);
		drpProgname.click();
		BatchName.sendKeys(reader.BatchNum());
		BatchDescription.sendKeys(reader.BatchDescription());
		Active_Button.click();
		NoOfClasses.sendKeys(reader.No_Of_Classes());
		CancelButton.click();
	}
	public void AddBatch_CloseClick() throws InterruptedException {
//		PrognameDropDown.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", PrognameDropDown); // Scroll to the bottom;
//		Thread.sleep(200);
//		drpProgname.click();
//		BatchName.sendKeys(reader.BatchNum());
//		BatchDescription.sendKeys(reader.BatchDescription());
//		Active_Button.click();
//		NoOfClasses.sendKeys(reader.No_Of_Classes());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", CloseButton);
	}
	
	public void AddBatch_MissingData() throws InterruptedException {
		PrognameDropDown.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", PrognameDropDown); // Scroll to the bottom;
		Thread.sleep(200);
		drpProgname.click();
		BatchName.sendKeys(reader.BatchNum());
		Active_Button.click();
		NoOfClasses.sendKeys(reader.No_Of_Classes());
		SaveButton.click();
	}
	public void ReadError() {
		String act_Error=Description_Error.getText();
		String exp_Error="Batch Description is required.";
		Assert.assertEquals(act_Error, exp_Error);
	}
	public void ReadError_ClassNo() {
		String Exp_Error="This field accept only numbers and max 5 count.";
		String act_Error="";
		Assert.assertEquals(Exp_Error, act_Error);
	}
	public void get_CurrentPage() {
		driver.getCurrentUrl();
	}
	public void Batch_Created_Successful_Message() {
		String act_Message=SuccessfulMessage.getText();
		String Exp_Message=" Batch Created Successfully";
		Assert.assertEquals(act_Message, Exp_Message);
	}
}
