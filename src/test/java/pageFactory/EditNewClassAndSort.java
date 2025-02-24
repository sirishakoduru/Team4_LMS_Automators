package pageFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import utilities.ConfigReader;

public class EditNewClassAndSort {
	
	String baseURL = ConfigReader.baseUrl();
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait;
	
	@FindBy(xpath = "//div[contains(@class, 'cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing')]")
    WebElement manageClassPage;
	@FindBy(xpath = "//tbody/tr[1]/td[8]/div[1]/span[1]/button[1]")
    WebElement editBtn;
	@FindBy(xpath = "//div[@role='dialog']")
    WebElement EditPopupWindow;
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")WebElement batchNameDisabled;
	@FindBy(xpath = "//div[contains(text(),' Inactive ')]//div[2]")WebElement StatusInactive;
	@FindBy(xpath = "//input[@id='classTopic']")WebElement classTopicDisabled;
	@FindBy(xpath = "//div[text()='Class Updated']")WebElement SuccessMsg1;
	@FindBy(xpath = "//div[text()='Successful']")WebElement SuccessMsg2;
	@FindBy(xpath = "//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")WebElement SortBatchName;
	@FindBy(xpath = "//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")List<WebElement> BatchNamesList;
	@FindBy(xpath = "//th[text()='Class Topic ']")WebElement SortclassTopic;
	@FindBy(xpath = "//th[text()='Class Topic ']")List<WebElement> classTopicList;
	@FindBy(xpath = "//th[text()='Class Description ']")WebElement SortclassDescription;
	@FindBy(xpath = "//th[text()='Class Description ']")List<WebElement> classDescriptionList;
	@FindBy(xpath = "//th[text()=' Status ']")WebElement SortStatus;
	@FindBy(xpath = "//th[text()=' Status ']")List<WebElement> StatusList;
	@FindBy(xpath = "//th[text()=' Class Date ']")WebElement SortClassDate;
	@FindBy(xpath = "//th[text()=' Class Date ']")List<WebElement> ClassDateList;
	@FindBy(xpath = "//th[text()=' Staff Name ']")WebElement SortStaffName;
	@FindBy(xpath = "//th[text()=' Staff Name ']")List<WebElement> StaffNameList;
	
	public EditNewClassAndSort() {
		PageFactory.initElements(driver, this);
	}
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	public void clickEditBtn() {
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
		Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().perform();
		editBtn.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", editBtn);
	}
	public boolean isEditPopupappear() {
		return EditPopupWindow.isDisplayed();
	}
	public boolean isBatchNameDisabled() {
		return !batchNameDisabled.isEnabled();
	}
	public boolean isClassTopicDisabled() {
		return !classTopicDisabled.isEnabled();
	}
	public String getSuccessMsg() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String Message1 = SuccessMsg1.getText();
		String Message2 = SuccessMsg2.getText();
		String Message = Message1 + " " + Message2;
		System.out.println("Actual message appeared on the screen is: " + Message);
		return Message;
	}
	public void selectStatus() {
		StatusInactive.click();
	}
	public void clickSortBatchName() {
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
		Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().perform();
		SortBatchName.click();
	}
	public List<String> getBatchNameList() {
		List<WebElement>Batchnames = BatchNamesList;
		List<String> OriginalList = Batchnames.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		System.out.println("Batchnames List: " +OriginalList);
		return OriginalList;
	}
	public List<String> getSortedBatchnameAsc() {
		List<String> SortedList = getBatchNameList();
		Collections.sort(SortedList);
		System.out.println("Batchnames sorted list:" +SortedList);
		return SortedList;
	}
	public void clickSortClassTopic() {
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
		Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().perform();
        SortclassTopic.click(); 
	}
	public List<String> getClassTopicList() {
		List<WebElement>ClassTopic = classTopicList;
		List<String> OriginalClassTopicList = ClassTopic.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		System.out.println("ClassTopic List: " +OriginalClassTopicList);
		return OriginalClassTopicList;
	}
	public List<String> getSortedClassTopicAsc() {
		List<String> SortedClassTopicList = getClassTopicList();
		Collections.sort(SortedClassTopicList);
		System.out.println("ClassTopics sorted list:" +SortedClassTopicList);
		return SortedClassTopicList;
	}
	public List<String> getSortedClassTopicdesc() {
		List<String> SortedClassTopicListdesc = getSortStatus().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("ClassTopics sorted list:" +SortedClassTopicListdesc);
		return SortedClassTopicListdesc;
	}
	public void clickSortClassDescription() {
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
		Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().perform();
        SortclassDescription.click(); 
	}
	public List<String> getSortclassDescription() {
		List<WebElement>Classdescription = classDescriptionList;
		List<String> OriginalClassDescriptionList = classDescriptionList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		System.out.println("ClassTopic List: " +OriginalClassDescriptionList);
		return OriginalClassDescriptionList;
	}
	public List<String> getSortedClassDescriptionAsc() {
		List<String> SortedClassDescriptionList = getSortclassDescription();
		Collections.sort(SortedClassDescriptionList);
		System.out.println("ClassTopics sorted list:" +SortedClassDescriptionList);
		return SortedClassDescriptionList;
	}
	public List<String> getSortedClassDescriptiondesc() {
		List<String> SortedClassDescriptionListdesc = getSortStatus().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("ClassTopics sorted list:" +SortedClassDescriptionListdesc);
		return SortedClassDescriptionListdesc;
	}
	public void clickSortStatus() {
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
		Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().perform();
        SortStatus.click(); 
	}
	public List<String> getSortStatus() {
		List<WebElement>Classdescription = StatusList;
		List<String> OriginalStatusList = StatusList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		System.out.println("ClassTopic List: " +OriginalStatusList);
		return OriginalStatusList;
	}
	public List<String> getSortedStatusAsc() {
		List<String> SortedStatusList = getSortStatus();
		Collections.sort(SortedStatusList);
		System.out.println("ClassTopics sorted list:" +SortedStatusList);
		return SortedStatusList;
	}
	public List<String> getSortedStatusdesc() {
		List<String> SortedStatusListdesc = getSortStatus().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("ClassTopics sorted list:" +SortedStatusListdesc);
		return SortedStatusListdesc;
	}
	public void clickSortClassDate() {
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
		Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().perform();
        SortClassDate.click(); 
	}
	public List<String> getSortClassDate() {
		List<WebElement>ClassDate = ClassDateList;
		List<String> OriginalClassDateList = ClassDateList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		System.out.println("ClassDate List: " +OriginalClassDateList);
		return OriginalClassDateList;
	}
	public List<String> getSortedClassDteAsc() {
		List<String> SortedClassDateList = getSortClassDate();
		Collections.sort(SortedClassDateList);
		System.out.println("ClassTopics sorted list:" +SortedClassDateList);
		return SortedClassDateList;
	}
	public List<String> getSortedClassDtedesc() {
		List<String> SortedClassDateListDesc = getSortClassDate().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("ClassTopics sorted list:" +SortedClassDateListDesc);
		return SortedClassDateListDesc;
	}
	
	public void clickSortStaffName() {
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
		Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().perform();
        SortStaffName.click(); 
	}
	public List<String> getSortStaffName() {
		List<WebElement>StaffName = StaffNameList;
		List<String> OriginalStaffNameList = StaffNameList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		System.out.println("ClassDate List: " +OriginalStaffNameList);
		return OriginalStaffNameList;
	}
	public List<String> getSortedStaffNameAsc() {
		List<String> SortedStaffNameList = getSortStaffName();
		Collections.sort(SortedStaffNameList);
		System.out.println("ClassTopics sorted list:" +SortedStaffNameList);
		return SortedStaffNameList;
	}
	public List<String> getSortedStaffNamedesc() {
		List<String> SortedStaffNameListdesc = getSortClassDate().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("ClassTopics sorted list:" +SortedStaffNameListdesc);
		return SortedStaffNameListdesc;
	}
	
	
//	public void enterValidDetails() throws InterruptedException {
//		driver.findElement(By.xpath("//input[@id='classDescription']")).sendKeys("locate the elements");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//p-calendar//input")).click();
//		WebElement futureDayElement = driver.findElement(By.xpath("//span[not(contains(@class, 'p-disabled'))][text()='28']"));
//        futureDayElement.click();
////		date.sendKeys("02/28/2025");
//		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
//		Actions action = new Actions(driver);
//        action.moveByOffset(0, 0).click().perform();
//		driver.findElement(By.xpath("//input[@id='classNo']")).isEnabled();
//		WebElement ele = driver.findElement(By.xpath("//label[normalize-space()='Recording']"));
//		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView()", ele);
//		driver.findElement(By.xpath("//input[@placeholder='Select a Staff Name']")).sendKeys("saranya");
//		driver.findElement(By.xpath(
//				"//p-radiobutton[@ng-reflect-input-id='Active']//div[@ng-reflect-ng-class='[object Object]']//div[@ng-reflect-ng-class='[object Object]']"))
//				.click();
//		driver.findElement(By.id("saveClass")).click();
//	}
	

}
