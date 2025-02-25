package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.ConfigReader;

public class BatchPagination {
	WebDriver driver=DriverFactory.getDriver();
	//driver.manage().window().maximize();
	ConfigReader reader=new ConfigReader();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public BatchPagination() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button//span[@class='p-paginator-icon pi pi-angle-right']")WebElement NextPageLink;
	@FindBy(xpath="//button//span[@class='p-paginator-icon pi pi-angle-double-right']")WebElement LastPageLink;
	@FindBy(xpath="//button//span[@class='p-paginator-icon pi pi-angle-left']")WebElement PreviousPageLink;
	@FindBy(xpath="//button[@class='p-paginator-page p-paginator-element p-link p-highlight p-ripple ng-star-inserted' and contains(text(),'1')]")
	WebElement FirstPagelink;
	@FindBy(xpath="//button[2][@class='p-paginator-page p-paginator-element p-link p-ripple ng-star-inserted' and contains (text(),'2')]")
	WebElement Page2Link;
	@FindBy(id="logout") WebElement LogoutBtn;
	
	public void Click_NextPageLink() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		js.executeScript("arguments[0].click();",NextPageLink);
	}
	public void Page2Link_IsEnabled() throws InterruptedException {
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//		Thread.sleep(200);
		Page2Link.isEnabled();
	}
	public void Click_LastPageLink() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		js.executeScript("arguments[0].click();",LastPageLink);
	}
	public boolean NextPageLink_IsDisabled() {
		boolean isenabled=true;
		if (NextPageLink.isEnabled()) {
			isenabled=false;
			System.out.println("Link is disabled");
		}
		else {
			System.out.println("Link is enabled");
		}
		return isenabled;
	}
	public void Click_PreviousPageLink() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		js.executeScript("arguments[0].click();",NextPageLink);
		js.executeScript("arguments[0].click();",PreviousPageLink);
	}
	public void PreviousPageLink_IsDisplayed() {
		FirstPagelink.isDisplayed();
	}
	public void Click_FirstPageLink() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		js.executeScript("arguments[0].click();",FirstPagelink);
	}
	public void FirstPageLink_IsDisplayed() {
		FirstPagelink.isDisplayed();
	}
	public void Click_LogOutButton() {
		js.executeScript("arguments[0].click();",LogoutBtn);
	}
	public void Admin_Loggedout() {
		String currentURL=driver.getCurrentUrl();
		if (currentURL.equals("https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login")) {
			System.out.println("URL is verified:"+currentURL);
			}
		else {
			System.out.println("URL is not verified");
		}
	}
	
}
