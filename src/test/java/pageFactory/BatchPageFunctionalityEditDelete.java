package pageFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.ConfigReader;

public class BatchPageFunctionalityEditDelete {
	WebDriver driver=DriverFactory.getDriver();
	//driver.manage().window().maximize();
	ConfigReader reader=new ConfigReader();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public BatchPageFunctionalityEditDelete() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div//button[3][@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']")
	WebElement BatchButton;
	@FindBy(xpath="//button[text()='Add New Batch']")WebElement AddNewBatch;
	@FindBy(id="pr_id_3-label") WebElement BatchDetails;
	@FindBy(xpath="//table//tbody//tr[1]//td[7]//div//span[1]//button")WebElement EditButton;
	@FindBy(xpath="//table//tbody//tr[1]//td[7]//div//span[2]//button")WebElement DeleteButton;
	@FindBy(id="programName") WebElement ProgramName;
	@FindBy(id="batchName") WebElement BatchName;
	@FindBy(id="batchDescription")WebElement batchDescription;
	@FindBy(id="batchNoOfClasses") WebElement ClassNum;
	@FindBy(xpath="//p-dialog[1]//div//div//div[3]//button[2]//span[@class='p-button-icon p-button-icon-left pi pi-check']")
	WebElement BatchDetails_SaveButton;
	@FindBy(xpath="//div//div[3]//button[1][@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']")
	WebElement BatchDetails_CancelButton;
	@FindBy(xpath="//div//div//button[@class='ng-tns-c81-9 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']")
	WebElement BatchDetails_CloseButton;
	@FindBy(xpath="//*[@id=\"text-danger\" and contains(text(),'This field should start with an alphabet and min 2 character.')]") 
	WebElement ErrorMessageDescription;
	@FindBy(xpath="//*[@id=\"text-danger\" and contains(text(),'Number of classes is required.')]")
	WebElement ErrorMessageNoOfClass;
	@FindBy (id="filterGlobal") WebElement SearchData;
	@FindBy (xpath="//table//tbody/tr/td[2]") List<WebElement> batchnamelist; 
	@FindBy(xpath="//div//div[3]//button[1][@class='ng-tns-c118-11 p-confirm-dialog-reject p-ripple p-button p-component ng-star-inserted']")
	WebElement Delete_Popup_No;
	@FindBy(xpath="//div//div[3]//button[2][@class='ng-tns-c118-11 p-confirm-dialog-accept p-ripple p-button p-component ng-star-inserted']")
	WebElement Delete_Popup_Yes;
	@FindBy(xpath="//div//div//button[@class='ng-tns-c118-11 p-dialog-header-icon p-dialog-header-close p-link ng-star-inserted']")
	WebElement Delete_Popup_Close;
	@FindBy(xpath="//tr[1]/td[1]")WebElement SingleCheckbox;
	@FindBy(xpath="//td[1]") WebElement MultipleCheckbox;
	@FindBy(xpath="//div[2]//div//button[@class='p-button-danger p-button p-component p-button-icon-only']") WebElement DeleteAllButton;
	@FindBy(xpath="//*[text(),'batch Updated']") WebElement BatchUpdatedMessage;
	
	public void Click_Batch() {
		BatchButton.click();
	}
	public void Verify_AddNewBatch() {
		if (AddNewBatch.isDisplayed()) {
			System.out.println("Add New Batch Link is Displayed");
		}
		else{
			System.out.println("Add New Batch link is not displayed");
		};
	}
	public void Click_AddNewBatch() {
		AddNewBatch.click();
	}
	public void Verify_BatchDetails() {
		BatchDetails.isDisplayed();
	}
	public void BatchUpdated_Message() {
		String message=BatchUpdatedMessage.getText();
		String Exp_Message="BatchUpdatedMessage";
		Assert.assertEquals(message, Exp_Message);
	}
	public void Click_EditIcon() throws InterruptedException {
		Thread.sleep(1000);
		   js.executeScript("arguments[0].click();", EditButton);
	}
	public boolean ProgName_Disabled() {
		boolean isEnabled=true;
		if (ProgramName.isEnabled()!=true) {
			System.out.println("Program name field is disabled");
			isEnabled=false;
		}
		else {
			System.out.println("Program name is Enabled");
		}
		return isEnabled;
	}
	public boolean BatchName_Disabled() {
		boolean isEnabled=true;
		if (BatchName.isEnabled()!=true) {
			System.out.println("Batch name field is disabled");
			isEnabled=false;
		}
		else {
			System.out.println("Batch name is Enabled");
		}
		return isEnabled;
	}
	public void Click_BatchButton() {
		BatchButton.click();
	}
	public void update_InvalidField (String Description, String No_of_classes) throws InterruptedException {
		batchDescription.clear();
		batchDescription.sendKeys(Description);
		ClassNum.clear();
		ClassNum.sendKeys(No_of_classes);
		Thread.sleep(200);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BatchDetails_SaveButton);;
	}
	public void ReadErrorMessage() {
		String Classnumber=ClassNum.getText();
		String desc=batchDescription.getText();
		String pattern = "[^a-zA-Z0-9\\s]";
		// To Create a Pattern object
        Pattern compiledPattern = Pattern.compile(pattern);
     // Create a Matcher object
        Matcher matcher = compiledPattern.matcher(desc);
        // If special character found
        if (matcher.find()) {
            System.out.println("Special characters found!");
            ErrorMessageDescription.isDisplayed();
            
        } else {
            System.out.println("No special characters found.");
        }
		if (Classnumber=="") {
			ErrorMessageNoOfClass.isDisplayed();
			System.out.println("Class number is empty");
		}
	}
	 public void SearchData() {
		 SearchData.sendKeys(reader.BatchDescription());
	 }
	 
	 public void EditBatchName_MandetoryFields( ) throws InterruptedException {
		 SearchData.sendKeys(reader.BatchDescription());
		 Thread.sleep(1000);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", EditButton);
		 batchDescription.clear();
			batchDescription.sendKeys(reader.BatchDescription());
			ClassNum.clear();
			ClassNum.sendKeys(reader.No_Of_Classes());
			Thread.sleep(200);
			js.executeScript("arguments[0].click();", BatchDetails_SaveButton);
	 }
	 public void EditBatchName_MandetoryFields_Cancel_Button( ) throws InterruptedException{
		 SearchData.sendKeys(reader.BatchDescription());
		 Thread.sleep(1000);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", EditButton);
		 batchDescription.clear();
			batchDescription.sendKeys(reader.BatchDescription());
			ClassNum.clear();
			ClassNum.sendKeys(reader.No_Of_Classes());
			Thread.sleep(200);
			//BatchDetails_CancelButton.click();
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("arguments[0].click();", BatchDetails_CancelButton);
	 }
	 public void Delete_DialogueBox() {
		 Delete_Popup_Yes.isDisplayed();
	 }
	 public void Batch_Verification() {
		 driver.getCurrentUrl();
	 }
	 
	 public void click_Delete_Icon() throws InterruptedException {
		 Thread.sleep(1000);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", DeleteButton);
	 }
	 public void Delete_Popup_No() {
		 js.executeScript("arguments[0].click();", DeleteButton);
		 js.executeScript("arguments[0].click();", Delete_Popup_No);
	 }
	 public void Delete_Popup_Yes() {
		 js.executeScript("arguments[0].click();", DeleteButton);
		 js.executeScript("arguments[0].click();", Delete_Popup_Yes);
	 }
	 public void Delete_Popup_Close() {
		 js.executeScript("arguments[0].click();", DeleteButton);
		 js.executeScript("arguments[0].click();", Delete_Popup_Close);
	 }
	 public void check_checkbox_DeleteAll_Button() {
		 js.executeScript("arguments[0].click();", SingleCheckbox);
		 js.executeScript("arguments[0].click();", DeleteAllButton);
	 }
	 public void checkAll_DeleteAll() {
		 js.executeScript("arguments[0].click();", MultipleCheckbox);
		 js.executeScript("arguments[0].click();", DeleteAllButton);
	 }
	 public String searchlist() {
		 SearchData.clear();
		 SearchData.sendKeys(reader.BatchDescription());
		   StringBuilder batchNames = new StringBuilder();
	    for (WebElement names : batchnamelist) {
	    	System.out.println(names.getText());
	    	 batchNames.append(names.getText()).append(", ");
		 }
		return batchNames.toString();
	   }
}
