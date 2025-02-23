package pageFactory;

import java.time.Duration;
import java.util.*;

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
	@FindBy(xpath="//button[@ng-reflect-icon='pi pi-trash'])[1]") WebElement multipleDelBtn;
	@FindBy(id="filterGlobal") WebElement searchBar;

	
	public Program() {
		PageFactory.initElements(driver, this);		
	}
	
	public void getbaseurl() {
		driver.get(baseURL);
	}
	
	public Home clickHomeLink() throws InterruptedException {
		
		System.out.println("Inside Program home link click");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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


}
