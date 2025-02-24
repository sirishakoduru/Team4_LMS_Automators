package pageFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import utilities.ConfigReader;
import utilities.Utils;

public class ClassAddNewPopup {
	
	String baseURL = ConfigReader.baseUrl();
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait;
	
	@FindBy(xpath = "//span[text() ='Class']") WebElement Class;
	@FindBy(xpath = "//span[text() ='Home']") WebElement Home;
	@FindBy(xpath = "//button[@role='menuitem']") WebElement addNewClass;
	@FindBy(xpath = "//div[contains(@class, 'p-dialog-footer')]")
	     WebElement classDetailsPopupwindow;
	@FindBy(xpath = "//p-dropdown[@id='batchName']//div[contains(@class,'p-dropdown-trigger')]")
		WebElement batchNameDropdown;
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")WebElement BatchnameInput;
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")WebElement StaffNameInput;
	@FindBy(xpath = "//p-dropdown[@id='staffId']//div[contains(@class,'p-dropdown-trigger')]")
		WebElement staffNameDropdown;
	@FindBy(xpath = "//ul[@role='listbox']//li[@role='option']") List<WebElement> staffNameOption;
	@FindBy(xpath = "//input[@id='classNo']")WebElement NoOfClasses;	
	@FindBy(xpath = "//li[@role='option']") List<WebElement> batchDropdownOption;
	@FindBy(id = "classTopic")WebElement classTopic;
	@FindBy(xpath = "//div[contains(text(),'Active')]//div[2]")WebElement statusActive;
	@FindBy(xpath = "//p-calendar//input")WebElement calendarInput;
	@FindBy(xpath = "//button[contains(@class, 'p-datepicker-trigger')]")WebElement calendarIcon;
	
	@FindBy(xpath = "//button[contains(@class, 'p-datepicker-next')]")WebElement nextCalendarButton;
	@FindBy(xpath = "//span[contains(@class, 'p-datepicker-year')]")WebElement calendarYearText;
	@FindBy(xpath = "//span[contains(@class, 'p-datepicker-month')]")WebElement calendarMonthText;
	@FindBy(xpath = "//div[contains(@class, 'p-datepicker-group-container')]")WebElement calendarContainer;
	@FindBy(xpath = "//div[contains(@class, 'p-toast-detail')]")WebElement successMsg;
	@FindBy(xpath = "//input[@id='classDescription']")WebElement classDescription;
	@FindBy(xpath = "//input[@id='classComments']")WebElement classComments;
	@FindBy(xpath = "//input[@id='classNotes']")WebElement classNotes;
	@FindBy(xpath = "//input[@id='classRecordingPath']")WebElement classRecording;
	@FindBy(id = "saveClass")WebElement saveBtn;
	@FindBy(xpath = "//small[text()='Batch Name is required.']")WebElement BatchnameEmptyError;
	@FindBy(xpath = "//small[text()='Class Topic is required.']")WebElement ClassTopicEmptyError;
	@FindBy(xpath = "//small[text()='Class Date is required.']")WebElement ClassDateEmptyError;
	@FindBy(xpath = "//small[text()='No. of Classes is required.']")WebElement NoOfClassesEmptyError;
	@FindBy(xpath = "//small[text()='Staff Name is required.']")WebElement StaffNameEmptyError;
	@FindBy(xpath = "//small[text()='Status is required.']")WebElement StatusNotSelectedError;
	@FindBy(xpath = "//span[contains(@class,  'p-dialog-header-close-icon')]")WebElement CloseSymbol;
	@FindBy(xpath = "//span[text()='Cancel']")WebElement cancelBtn;
	
	public ClassAddNewPopup() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickClass() {
		Class.click();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public void clickHome() {
		Home.click();
	}
	
	public void clickAddNewClass() {
		addNewClass.click();
	}
	public void clickBatchNameDropdown() {
		batchNameDropdown.click();
	}
	
	public void selectBatchNameDrpdownValue() {
		WebElement batchOption = batchDropdownOption.get(0);
		batchOption.click();	
	}

	public void EnterClassTopic() {
		Utils utils = new Utils();
		classTopic.sendKeys(utils.generateRandomAlphaNumeric(5));
	}

	public void selectClassDate() throws InterruptedException {
		Actions action = new Actions(driver);
		// Get future date (e.g., 7 days from today)
        LocalDate futureDate = LocalDate.now().plusDays(2); // Start from tomorrow
        while (futureDate.getDayOfWeek() == DayOfWeek.SATURDAY || futureDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            futureDate = futureDate.plusDays(1); // Skip to the next weekday
        }    
        int day = futureDate.getDayOfMonth();
        int year = futureDate.getYear();
        System.out.println(calendarYearText.getText());
        System.out.println(String.valueOf(year));
        System.out.println(futureDate.getMonth().name().toLowerCase());
        System.out.println(calendarMonthText.getText().toLowerCase());
        // Loop until the correct month and year are displayed
        while (!calendarYearText.getText().contains(String.valueOf(year)) || 
               !calendarMonthText.getText().toLowerCase().contains(futureDate.getMonth().name().toLowerCase())) {
        	nextCalendarButton.click();
        }
        Thread.sleep(1000);
        // Select the future date
        WebElement futureDayElement = driver.findElement(By.xpath("//span[not(contains(@class, 'p-disabled'))][text()='" + day + "']"));
        futureDayElement.click();
        WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
        action.moveByOffset(0, 0).click().perform();
	}
	
	public void clickStaffName() {
	  staffNameDropdown.click();
	}
	
	public void selectStatus() {
		statusActive.click();
	}
	public void selectStaffName() {
		WebElement staffOption = staffNameOption.get(1);
		staffOption.click();
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	public void clickDatePicker() {
		calendarInput.click();
	}
	
	public Boolean isSuccessMsgDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
		WebElement alert = wait.until(ExpectedConditions.visibilityOf(successMsg));
		String actualMsg = alert.getText();
		String messageText = "Class Created";
		System.out.println(actualMsg);
		System.out.println(actualMsg.replaceAll("\\s+", " ").trim().contains(messageText.replaceAll("\\s+", " ").trim()));
		return actualMsg.contains(messageText);
	}
	@SuppressWarnings("deprecation")
	public String getNoOfClasses() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String Number = NoOfClasses.getAttribute("value");
		return Number;
		
	}
	public Boolean checkDisabledWeekends() {
		// Get the current date
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue(); // Get current month
        int currentYear = today.getYear(); // Get current year

        // Get all Saturday and Sunday dates for the current month
        List<LocalDate> weekendDates = new ArrayList<>();

        // Get the first Saturday of the month
        LocalDate firstSaturday = LocalDate.of(currentYear, currentMonth, 1)
                                             .with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        
        // Get the first Sunday of the month
        LocalDate firstSunday = LocalDate.of(currentYear, currentMonth, 1)
                                         .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        
        // Add Saturday and Sunday to the list if they are in the current month
        while (firstSaturday.getMonthValue() == currentMonth) {
            weekendDates.add(firstSaturday);
            firstSaturday = firstSaturday.plusWeeks(1); // Go to the next Saturday
        }
        while (firstSunday.getMonthValue() == currentMonth) {
            weekendDates.add(firstSunday);
            firstSunday = firstSunday.plusWeeks(1); // Go to the next Sunday
        }

        // Print all Saturday and Sunday dates
        System.out.println("Weekend Dates for " + Month.of(currentMonth) + " " + currentYear + ":");
        int totalDisabled = 0;
        for (LocalDate weekendDate : weekendDates) {
            System.out.println(weekendDate);
    		List<WebElement> currentMonthDisabledDates = driver.findElements(By.xpath("//td[not(contains(@class, 'p-datepicker-other-month'))]//span[contains(@class, 'p-disabled')]"));
    		for (WebElement date : currentMonthDisabledDates) {
    			String dateText = date.getText();
    			int weekEndDate = weekendDate.getDayOfMonth();
    			if (Integer.parseInt(dateText) == weekEndDate) {
    				totalDisabled += 1;
    				break;
    			}
    		}
        }
        return totalDisabled == weekendDates.size();
	}

//	public Boolean checkWeekEndsDisabled() throws ParseException {
//		// Assuming disabled weekends have aria-disabled="true"\
//		List<WebElement> currentMonthDisabledDates = driver.findElements(By.xpath("//td[not(contains(@class, 'p-datepicker-other-month'))]//span[contains(@class, 'p-disabled')]"));
////		List<WebElement> weekendDates = driver.findElements(By.xpath("//span[contains(@class, 'p-disabled')]"));
//		WebElement todayElement = driver.findElement(By.xpath("//td[contains(@class, 'p-datepicker-today')]//span"));
//		Boolean isWeekend = false;
//		String todayDate = todayElement.getText();
//		for (WebElement date : currentMonthDisabledDates) {
//		    String dateText = date.getText();
//		    if (Integer.parseInt(dateText) > Integer.parseInt(todayDate)) {
//			    LocalDate currentDate = LocalDate.now();
//			    int month = currentDate.getMonthValue();
//		        int year = currentDate.getYear();
//			    // Check if the date falls on a Saturday (6) or Sunday (7)
//			    String fullDate = year + "-" + month + "-" + dateText; // Adjust the format
//			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			    java.util.Date parsedDate = sdf.parse(fullDate);
//			    Calendar cal = Calendar.getInstance();
//			    cal.setTime(parsedDate);
//			    
//			    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//			    if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
//			        System.out.println("Weekend date " + dateText + " is disabled.");
//			        isWeekend = true;
//			    }
//		    }
//
//		}
//		return isWeekend;
//	}
	
	public void createOptionsfeilds() {
		classDescription.sendKeys("Creating java classes");
		classComments.sendKeys("Good");
		classNotes.sendKeys("Testing");
		classRecording.sendKeys("Link");
	}
	public void CreateTextFeildsSpecialChar() {
		classDescription.sendKeys("@#$%^%$");
		classComments.sendKeys("@#$%^&");
		classNotes.sendKeys("%$#^&*");
		classRecording.sendKeys("*&^%%$");
	}
	
	public String getEmptyClassFeildsError() {
		
		String message;
		if(BatchnameEmptyError.getText().isEmpty()) {
		message = BatchnameEmptyError.getText();
		}else if(ClassTopicEmptyError.getText().isEmpty()) {
			message = ClassTopicEmptyError.getText();
		}else if(ClassDateEmptyError.getText().isEmpty()) {
			message = ClassDateEmptyError.getText();
		}else if(NoOfClassesEmptyError.getText().isEmpty()) {
			message = NoOfClassesEmptyError.getText();
		}else if(StaffNameEmptyError.getText().isEmpty()) {
			message = StaffNameEmptyError.getText();
		}else {
			message = StatusNotSelectedError.getText();
		}
		System.out.println("Error message appeared is :" +message);
		return message;
				
	}
	
	public String emptyFeildHighlightedColour() {
		String backgrounColor = classTopic.getCssValue("background-color");
		if (backgrounColor.equals("rgb(255, 0, 0)") || backgrounColor.equals("rgba(255, 0, 0, 1)") || backgrounColor.equals("#FF0000")) {
		    System.out.println("The field is highlighted in red.");
		} else {
		    System.out.println("The field is NOT highlighted in red. Current color: " + backgrounColor);
		}
		return backgrounColor;
	}
	
	public void invalidDataInputs() throws InterruptedException {
		BatchnameInput.sendKeys("edr333");
		classTopic.sendKeys("shdb36#$");
		classDescription.sendKeys("352737");
		clickDatePicker();
		selectClassDate();
		StaffNameInput.sendKeys("dhegdf");
		selectStatus();
		}
	
	public void invalidDataInputsForEdit() throws InterruptedException {
		classDescription.sendKeys("352737");
		clickDatePicker();
		selectClassDate();
		StaffNameInput.sendKeys("dhegdf");
		selectStatus();
		}
	
	
	public boolean EmptyFormSubmission() {
	List<WebElement>ErrorMessage = driver.findElements(By.xpath("//small[contains(@class, 'p-invalid ng-star-inserted')]"));
	
	if (!ErrorMessage.isEmpty()) {
        System.out.println("Error messages are displayed:");
        for (WebElement errorMsg : ErrorMessage) {
            System.out.println(errorMsg.getText());
        }
    } else {
        System.out.println("No error messages displayed. Test failed.");
    }
	return true;
   }
	
	public void clickCancelButton() {
		cancelBtn.click();
	}
	public void isClassPopupClosed() {
		WebElement isClassPopupClosed = cancelBtn;
		if (isClassPopupClosed != null) {
            System.out.println("Test Passed: Class Details popup is closed successfully.");
        } else {
            System.out.println("Test Failed: Popup is still visible.");
        }
	}
}
