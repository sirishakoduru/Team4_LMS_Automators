package pageFactory;

import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	//Add Program
	@FindBy(xpath="//input[@id = 'programName']") WebElement programName ;
	@FindBy(xpath="//span[text()='Program Details']")  WebElement programDetails ;
	
	
	
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
		
		if(subMenu.isDisplayed())
		{
			subMenu.click();
			subMenuClose.click();
		}
		return pgmMgmtText.isDisplayed();
		
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
	
	//Add Program
	
	public Boolean subMenuClick() {
		try {
			Boolean b=subMenu.isDisplayed();
			subMenu.click();
			System.out.println("The try click");
			return b;
	    
		} catch (Exception e) {
		    programLink.click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subMenu);
			Boolean b=subMenu.isDisplayed();
			subMenu.click();
			System.out.println("The catch click");
			System.out.println("The boolean: "+b);
			return b;
		}
	}
	
	public boolean isProgramDetailsPopup() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) programName));
			return programName.isSelected();
		} catch (Exception e) {
			return false;
		}
	}
	public void seeAddPgmWindow() {
		programName.sendKeys("Hiii");
	}
}
