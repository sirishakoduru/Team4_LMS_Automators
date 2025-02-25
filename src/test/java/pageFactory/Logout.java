package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.ConfigReader;

public class Logout {
	WebDriver driver=DriverFactory.getDriver();
	ConfigReader reader=new ConfigReader();


	@FindBy(xpath="//*[@id=\"logout\"]")WebElement logoutbt;
	
	
	public Logout() {
		PageFactory.initElements(driver, this);
	}	
	
	
	public void logout() {
		Actions action= new Actions(driver);
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
        action.moveByOffset(0, 0).click().perform();
		logoutbt.isDisplayed();
		logoutbt.click();
	}
	public void clickBack() {
		// Navigate to the previous page
		driver.navigate().back();
	}
	
}
