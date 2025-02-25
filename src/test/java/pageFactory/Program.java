package pageFactory;

import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.DriverFactory;
import utilities.ConfigReader;

public class Program {
	
	String baseURL = ConfigReader.baseUrl();
	WebDriver driver = DriverFactory.getDriver();
	
	@FindBy(xpath="//button[contains(@id,'program')]") WebElement programLink;
	@FindBy(xpath="//span[contains(@class,'mat-button-wrapper') and contains(text(),'Home')]") WebElement homeLink;
	@FindBy(xpath="//span[contains(text(),'Batch')]") WebElement batchLink;
	@FindBy(xpath="//span[contains(text(),'Class')]") WebElement classLink;
	@FindBy(xpath="//span[contains(text(),'Logout')]") WebElement logoutLink;	
	@FindBy(xpath="//div[contains(text(),' Manage Program')]") WebElement pgmMgmtText;
	@FindBy(xpath="//div[contains(text(),' LMS - Learning Management System')]") WebElement LMSText;
	@FindBy(xpath="//span[contains(@class,'mat-button-wrapper')]") List<WebElement> listMenu;
	@FindBy(xpath="//button[contains(@role,'menuitem') and contains(text(),'Add New Program')]") WebElement subMenu;
	@FindBy(xpath="//button[@tabindex = '-1']") WebElement subMenuClose;
	@FindBy(xpath="//tr/th") List<WebElement> colHeaders;
	@FindBy(xpath="//tr/th") WebElement tableBody;
	@FindBy(xpath="//div[@class='action']") List<WebElement> editdelicons;
	@FindBy(xpath="//button[@ng-reflect-icon='pi pi-trash'])[1]") WebElement multipleDelBtn;
	@FindBy(id="filterGlobal") WebElement searchBar;
	@FindBy(xpath="//div[@class='p-checkbox p-component'])[1]") WebElement headerCheckBox ;
	@FindBy(xpath="//div[@class='p-checkbox p-component']") List<WebElement> allCheckBoxes;
	@FindBy(xpath="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']") List<WebElement> sorticons ;
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']") WebElement paginator ;
	@FindBy(xpath="//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']") WebElement prevSetofPagesMove;
	@FindBy(xpath="//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']") WebElement nextSetofPagesMove ;
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']") WebElement nextPageMove ;
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-left']") WebElement prevPageMove;
	@FindBy(xpath="//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']") WebElement programFooter ;
	@FindBy(xpath="//body[contains(@class, 'mat-typography')]") WebElement bodyElement  ;
	
	//Add Program
	@FindBy(xpath="//input[@id = 'programName']") WebElement programName ;
	@FindBy(xpath="//label[text()='Name' and  '*']") WebElement programNameAs;
	@FindBy(xpath="//span[@id = 'pr_id_8-label']")  WebElement programDetails ;
	@FindBy(xpath="//label[text()='Name']")  WebElement programDesc ;
	@FindBy(xpath="//label[text()='Name']")  WebElement programStatus ;
	@FindBy(xpath="//span[text()='Save']")  WebElement saveBtn ;
	@FindBy(xpath="//span[text()='Cancel']")  WebElement cancelBtn ;
	@FindBy(xpath="//small[text()='Program name is required.']")  WebElement progNameError;
	@FindBy(xpath="//input[@id='programName']")  WebElement progNameTextBox;
	@FindBy(xpath="//input[@id='programDescription']")  WebElement progDescTextBox;
	@FindBy(xpath="(//p-radiobutton[@name='category'])[1]")  WebElement activeStatusBtn;
	@FindBy(xpath="(//p-radiobutton[@name='category'])[2]")  WebElement inactiveStatusBtn;


	private By progDescError = By.xpath("//small[text()='Description is required.']");
	private By progStatuserror = By.xpath("//small[text()='Status is required.']");
	private By validProgNameCheck = By.xpath("(//tbody[@class='p-datatable-tbody']/tr/td)[2]");
	private By validProgDescCheck = By.xpath("(//tbody[@class='p-datatable-tbody']/tr/td)[3]");
	private By validProgStatusCheck = By.xpath("(//tbody[@class='p-datatable-tbody']/tr/td)[4]");
	private By closeBtnPopUp = By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c168-6 pi pi-times']");
	private By alertmsg = By.xpath("//div[contains(@class, 'p-toast-detail')]");
	private By delCloseBtnPopup=By.xpath("(//button[@ng-reflect-ng-class='[object Object]'])[10]");
	
	
	
	public Program() {
		PageFactory.initElements(driver, this);		
	}
	
	public void getbaseurl() {
		driver.get(baseURL);
	}
	
	public Home clickHomeLink() throws InterruptedException {
		
		System.out.println("Inside Program home link click");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(homeLink)));
		homeLink.click();
		return new Home();
	}
	
	public Boolean homeDisplay() {
		
		return homeLink.isDisplayed();
	}

	public Boolean programDisplay() {
		
		return programLink.isDisplayed();
	}
	
	public Boolean classDisplay() {
		
		return classLink.isDisplayed();
	}
	
	public Boolean batchDisplay() {
		
		return batchLink.isDisplayed();
	}
	
	public Boolean logoutDisplay() {
		
		return logoutLink.isDisplayed();
	}
	
	public List actualOrderMenu() {

		List<String> actualOrder = new ArrayList<>();
		for (WebElement link : listMenu) {
		    actualOrder.add(link.getText().trim()); // Trim to remove spaces
		}
		System.out.println("Actual Link Order: " + actualOrder);
		return actualOrder;
	}
	
	public Boolean programPageVerify() {
		
		try	{
			if(subMenu.isDisplayed())
			{
				subMenu.click();
				subMenuClose.click();
			}
				return pgmMgmtText.isDisplayed();
		}
		catch(Exception e){
			programLink.click();
			return pgmMgmtText.isDisplayed();
		}
		
	}
	
	public String getLMSText() {

		String txt = LMSText.getText();
		return txt;
	}
	
	public String getPgmMgmtText() {
		
		String txt = pgmMgmtText.getText();
		return txt;
	}
	
	public Boolean isSubMenuDisplay() {
		
		try {
			Boolean b=subMenu.isDisplayed();
			subMenu.click();
			subMenuClose.click();			
			return b;
	    
		} catch (Exception e) {
		    programLink.click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subMenu);
			Boolean b=subMenu.isDisplayed();
			System.out.println("The boolean: "+b);
			return b;
		}
		
	}
	
	public boolean tableBodyCheck() {
	
		if(tableBody.isDisplayed()) {return true;}
		else {return false;}
	}
	
	public boolean validateMultipleDeleteBtnDisabled() {
		try {
			return !multipleDelBtn.isEnabled();
		} catch (Exception e) {
			return false;
		}

	}
	
	public String validateSearchBar() {
		if (searchBar.isDisplayed()) {
			
			String actualSearchPlaceholder = searchBar.getAttribute("placeholder");
			return actualSearchPlaceholder;
		
		}
		else {return "";}
	}
	
	public List<String> colHeadersCheck() {
		
		List<String> actualColOrder = new ArrayList<>();
		for (WebElement link : colHeaders) {
		    actualColOrder.add(link.getText().trim()); // Trim to remove spaces
		}
		System.out.println("Actual Link Order: " + actualColOrder);
		return actualColOrder;
	}	

	public boolean validateheaderCheckBoxUnchecked() {
		try {
			return headerCheckBox.isSelected();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean validateAllCheckBoxesUnchecked() {
		try {
			List<WebElement> uncheckedBoxes = allCheckBoxes;
			for (int i = 1; i < uncheckedBoxes.size(); i++) {
				if (uncheckedBoxes.get(i).isSelected())
					return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean validateSortIcons() {
		try {
			List<WebElement> sortIcons = sorticons;

			for (int i = 0; i < sortIcons.size(); i++) {
				if (sortIcons.get(i).isDisplayed())
					return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean validateEditDelIcons() {
		try {
			List<WebElement> editDelIcons = editdelicons;

			for (int i = 0; i < editDelIcons.size(); i++) {
				if (editDelIcons.get(i).isDisplayed())
					return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public Boolean validatePaginationTextandIcons(String text) throws InterruptedException  {
		Thread.sleep(1000);
		WebElement paginatorElement = paginator;
		boolean areIconsPresent = prevPageMove.isDisplayed()
				&& prevSetofPagesMove.isDisplayed()
				&& nextPageMove.isDisplayed()
				&& nextSetofPagesMove.isDisplayed();
		try {
			if (areIconsPresent) {
				String textValidation = paginatorElement.getText();
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(textValidation);
				List<Integer> numericValues = new ArrayList<Integer>();
				while (matcher.find()) {
					int numericValue = Integer.parseInt(matcher.group());
					numericValues.add(numericValue);
				}
				text = String.format("Showing %d to %d of %d entries", numericValues.get(0), numericValues.get(1),
						numericValues.get(2));
				
				String actualText = text.replaceAll("\\d", "").trim();
				String expectedText ="Showing 5 to 10 of 20 entries";
				expectedText = expectedText.replaceAll("\\d", "").trim();
				Boolean result = actualText.equalsIgnoreCase(expectedText);
				return result;
			}
		} catch (Exception e) {
			System.out.println("Pagination Icons are not displayed" + e);
			Boolean result = false;
		}
		return false;
	}

	public Boolean validateFooter(String count) {

		String actualFooter = programFooter.getText();
		actualFooter = actualFooter.replaceAll("\\d+", "").trim();
		//Integer.parseInt(count.trim());
		String expectedFooter ="In total there are 20 programs.";
		expectedFooter = expectedFooter.replaceAll("\\d+", "").trim();
		System.out.println(actualFooter);
		System.out.println(expectedFooter);
		boolean result = actualFooter.equals(expectedFooter);
		return result;

	}
	
	///////                       Add Program                          ////////////////////////
	
	public void programLinkAddClick() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try
		{
			if(subMenu.isEnabled()) {
				System.out.println("The sub menu is enabled.");
				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subMenu);
				subMenu.click();
				System.out.println("The sub menu is clicked.");
			}
			else {
				if(subMenuClose.isEnabled())
				{
					System.out.println("The sub menu closed is enabled.");
					//subMenuClose.click();
					programLink.click();
					subMenu.click();
				}
			}
		}
		catch(Exception e)
		{
			//System.out.println("The sub menu is not enabled: "+e);
			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
			programLink.click();
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subMenu);
			subMenu.click();
		}

	}
	
	public boolean isProgramDetailsPopup() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			try{
				boolean b= subMenuClose.isDisplayed();
				if(b==true) {
					subMenuClose.click();}
					return b;
			}
			catch(Exception e)
			{
				return false;
			}
	}
	
	public void validateProgramDetailsTitle(String expectedTitle) {
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 30 seconds timeout
		System.out.println(programDetails.getText());
		subMenuClose.click();
	}
	
	public boolean validateAsterisk(String field) {
		
		String expectedColor = "rgba(255, 0, 0, 1)";


		try {
				if (programNameAs.isDisplayed()) {
					return true;
					
			}
		} catch (Exception e) {
			return false; // Return false if an exception occurs
		}

		return false; // Return false if no conditions were met
	}
	
	public void programLinkAddForm() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try
		{
			
			if(programLink.isEnabled())
			{
				programLink.click();
				subMenu.click();
			}
			else if(subMenu.isEnabled()) {
				System.out.println("The sub menu is enabled.");
				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subMenu);
				subMenu.click();
			}
			
		}
		catch(Exception e)
		{
		
			if(subMenuClose.isEnabled())
			{
				subMenuClose.click();
				programLink.click();
				subMenu.click();
			}
			else {
			//System.out.println("The sub menu is not enabled: "+e);
			programLink.click();
			subMenu.click();
			}
		}

	}
	
	public void clickSaveAdd() {
		saveBtn.click();
	}
	
	public Boolean mandatoryError() {
		
		if(progNameError.isDisplayed())
			return true;
		return false;
	}
	
	public void clickCancelAdd() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
		System.out.println("inside Cancel button");
		cancelBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("location.reload()");
	}
	
	public void enterPgName() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", progNameTextBox);
		progNameTextBox.sendKeys("First Pg nm");
	}
	
	public void dispPgName()
	{
		System.out.println(progNameTextBox.getText());
	}
	
	public void enterPgDescName() {
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", progDescTextBox);
		progDescTextBox.sendKeys("First Pg Desc");
	}
	
	public void dispPgDescName()
	{
		System.out.println(progDescTextBox.getText());
	}
	
	public void selBtn() {
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activeStatusBtn);
		activeStatusBtn.click();
	}
	
	public void dispSelBtn()
	{
		System.out.println(activeStatusBtn.isSelected());
	}
	
	/***************************                    SORTING                       ********************************/
	
	public void ProgramNameSortClick() {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		System.out.println("ProgramNameSortClick");
		WebElement programNameHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[contains(text(),'programName')]")));
		System.out.println(programNameHeader.getText());
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
        actions.moveByOffset(0, 0).click().perform();
//		WebElement programNameHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]")));
		actions.moveToElement(programNameHeader).click().perform();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table/tbody/tr")));
	}

	public boolean verifyingProgramNameSorting(String ASCorDES) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
        actions.moveByOffset(0, 0).click().perform();
		List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath("//table/tbody/tr"));
		List<String> actualData = new ArrayList<>();
		for (WebElement row : rows) {
			actualData.add(row.findElement(By.xpath(".//td[2]")).getText());
		}
		List<String> sortedData = new ArrayList<>(actualData);

		switch (ASCorDES.trim().toLowerCase()) {
			case "ascending":
				Collections.sort(sortedData, String.CASE_INSENSITIVE_ORDER);
				break;
			case "descending":
//				Collections.sort(sortedData, Collections.reverseOrder());
				Collections.sort(sortedData, String.CASE_INSENSITIVE_ORDER.reversed());
				break;
			default:
				System.out.println("Invalid sort option: " + ASCorDES);
				return false;
		}
		System.out.println("ActualData:"+actualData);
		System.out.println("SortedData:"+sortedData);
				return actualData.equals(sortedData);
	}

	public void ProgramDescriptionSortClick() {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
        actions.moveByOffset(0, 0).click().perform();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
//		WebElement programDescHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[contains(text(),'programDescription')]")));
		WebElement programDescHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]")));
		actions.moveToElement(programDescHeader).click().perform();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table/tbody/tr")));
	}

	public boolean verifyingProgramDescSorting(String ASCorDES) {
		List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath("//table/tbody/tr"));
		List<String> actualData = new ArrayList<>();
		for (WebElement row : rows) {
			actualData.add(row.findElement(By.xpath(".//td[3]")).getText());
		}
		List<String> sortedData = new ArrayList<>(actualData);

		switch (ASCorDES.trim().toLowerCase()) {
			case "ascending":
				Collections.sort(sortedData, String.CASE_INSENSITIVE_ORDER);
				break;
			case "descending":
//				Collections.sort(sortedData, Collections.reverseOrder());
				Collections.sort(sortedData, String.CASE_INSENSITIVE_ORDER.reversed());
				break;
			default:
				System.out.println("Invalid sort option: " + ASCorDES);
				return false;
		}

		return actualData.equals(sortedData);
	}

	public void ProgramStatusSortClick() {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
        actions.moveByOffset(0, 0).click().perform();
//		WebElement programStatusHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[contains(text(),'programStatus')]")));
		WebElement programStatusHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]")));
		actions.moveToElement(programStatusHeader).click().perform();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table/tbody/tr")));
	}

	public boolean verifyingProgramStatusSorting(String ASCorDES) {
		List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath("//table/tbody/tr"));
		List<String> actualData = new ArrayList<>();
		for (WebElement row : rows) {
			actualData.add(row.findElement(By.xpath(".//td[4]")).getText());
		}
		List<String> sortedData = new ArrayList<>(actualData);

		switch (ASCorDES.trim().toLowerCase()) {
			case "ascending":
				Collections.sort(sortedData, String.CASE_INSENSITIVE_ORDER);
				break;
			case "descending":
//				Collections.sort(sortedData, Collections.reverseOrder());
				Collections.sort(sortedData, String.CASE_INSENSITIVE_ORDER.reversed());
				break;
			default:
				System.out.println("Invalid sort option: " + ASCorDES);
				return false;
		}

		return actualData.equals(sortedData);
	}

}
