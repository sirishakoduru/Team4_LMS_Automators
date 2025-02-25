package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import driver.DriverFactory;
//import io.cucumber.messages.types.Duration;
import utilities.ConfigReader;

public class ClassDelete {
	WebDriver driver=DriverFactory.getDriver();
	ConfigReader reader=new ConfigReader();
	
	// Constructors

		//@FindBy(xpath = "(//button[@icon='pi pi-trash'])[2]")private WebElement deletebtn;
	@FindBy(xpath ="//button[@class='p-button-danger p-button p-component p-button-icon-only']")WebElement deletebtn;
		//@FindBy(xpath ="//table/tbody/tr//button[contains(@icon, 'pi-trash')]")WebElement deletebtn;
		@FindBy(xpath = "//button//span[text()='Yes']")private WebElement confirmyes;
		@FindBy(xpath = "//button//span[text()='No']")private WebElement confirmno;
		@FindBy(xpath = "//div[text()='Successful']")private WebElement successdelete;
		@FindBy(xpath="/html/body/app-root/app-session/p-confirmdialog/div/div/div[1]/div/button/span")private WebElement clsdel;

		
		@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")private WebElement checkbox1;
		@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]")private WebElement checkbox2;
		@FindBy(xpath = "//div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")private WebElement dbdelete_icon;
		@FindBy(xpath = "//button//span[text()='Yes']")private WebElement dbdelete_yes;
		@FindBy(xpath = "//div/p-toastitem/div/div/div/div[2]")private WebElement success_dbdelete;
//Actions
		
		public void clickOnDeleteIcon() {
			Actions actions = new Actions(driver);
			WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
	        actions.moveByOffset(0, 0).click().perform();
			//deletebtn.click();
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			//wait.until(ExpectedConditions.elementToBeClickable(deletebtn)).click();
			actions.doubleClick(deletebtn).perform();
		}
		public void close() {
			WebElement clsdel = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
			Actions action = new Actions(driver);
	        action.moveByOffset(0, 0).click().perform();
			clsdel.click();
		}
		
		public void validatedelicons() {
			confirmyes.isDisplayed();
			confirmno.isDisplayed();
			clsdel.isDisplayed();
			
		}
		public void no() {
			confirmno.click();
		}

		public void deloneprgm() {
			confirmyes.click();
			String text1;
			text1 = successdelete.getText();
			System.out.println(text1);
		}

		public void DropDelonePrgm() {
			confirmno.click();

		}

		public void CheckBox() {
			Actions actions = new Actions(driver);
			actions.doubleClick(checkbox1).perform();
			checkbox2.click();
			System.out.println("Checkbox selected");

		}

		public void MultipleDel() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(dbdelete_icon)).click();

		}

		public void DeleteSuccess() {
			dbdelete_yes.click();
			String value;
			value = success_dbdelete.getText();
			System.out.println(value);
		}

}
