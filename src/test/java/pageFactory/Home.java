package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class Home {
	
	WebDriver driver = DriverFactory.getDriver();
	@FindBy(xpath="//strong[contains(text(),\"Welcome sdetnumpyninja@gmail.com\")]") WebElement homePageText;
	@FindBy(xpath="//span[contains(@class,'mat-button-wrapper') and contains(text(),'Home')]") WebElement homeLink;
	@FindBy(xpath="//button[contains(@id,'program')]") WebElement programLink;
	@FindBy(xpath="//button[contains(@role,'menuitem') and contains(text(),'Add New Program')]") WebElement subMenu;
	@FindBy(xpath="//button[@tabindex = '-1']") WebElement subMenuClose;
	@FindBy(xpath="//div[contains(text(),' Manage Program')]") WebElement pgmMgmtText;
	
	public Home() {
		PageFactory.initElements(driver, this);		
	}
	
	public Boolean homePageVerify() {

		System.out.println("Inside Home homepageverify");
		try {
			System.out.println("Inside Home homepageverify Try");
				subMenu.click();
				subMenuClose.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(homeLink)));
			    homeLink.click();
		    
		} catch (Exception e) {
			
			System.out.println("Inside Home homepageverify Exception");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(homeLink)));
		    homeLink.click();
		}
		
		return homePageText.isDisplayed();
	}
	
	public Program clickProgramLink() throws InterruptedException {
		
		System.out.println("Inside Home programlink click");

		try {
			subMenu.click();
			subMenuClose.click();
	    
		} catch (Exception e) {
		    programLink.click();
		}
		System.out.println("Inside Home programlink click");
		return new Program();
		
	}

}
