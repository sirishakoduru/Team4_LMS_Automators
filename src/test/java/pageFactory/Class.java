package pageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import driver.DriverFactory;
import utilities.ConfigReader;

public class Class {
	WebDriver driver=DriverFactory.getDriver();
	ConfigReader reader=new ConfigReader();
	
	@FindBy(id="dashboard")WebElement HomeButton;
	@FindBy(xpath="//*[text()='Class']")WebElement Classbtn;
	@FindBy(xpath="/html/body/app-root/app-header/mat-toolbar/span[1]")WebElement LMSTitle;
	@FindBy(xpath="/html/body/app-root/app-session/div/mat-card/mat-card-title/div[1]")WebElement classheader;
	@FindBy(xpath="/html/body/app-root/app-dashboard/div/div[1]/mat-card/mat-card-title/div")WebElement dashboardhr;
	@FindBy(xpath="/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input")WebElement searchbar;
	@FindBy(xpath = "//input[@id='filterGlobal']") public WebElement search;
	//@FindBy(xpath="//tr/th")List<WebElement>private By  classcolheader;
	@FindBy(xpath="//tr/th") List<WebElement> colHeaders;
	@FindBy(className="ng-star-inserted")WebElement pagination;
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']") WebElement paginator ;
	@FindBy(xpath = "//span[contains(@class, 'p-paginator-current')]")WebElement currentEntriesText;
	@FindBy(xpath="/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[1]")WebElement startbtn;
    @FindBy(xpath = "//button[contains(@class, 'p-paginator-first')]")WebElement firstBtn;
    @FindBy(xpath = "//button[contains(@class, 'p-paginator-prev')]")WebElement prevBtn;
    @FindBy(xpath = "//button[contains(@class, 'p-paginator-next')]") WebElement nextBtn;
    @FindBy(xpath = "//button[contains(@class, 'p-paginator-last')]")WebElement lastBtn;
    @FindBy(xpath = "//button[contains(@class, 'p-paginator-page')]")List<WebElement> pageBtns;
	@FindBy(xpath="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")private By sorticon;
	@FindBy(xpath="/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[1]/button")WebElement comdelete;
	@FindBy(xpath="//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")WebElement noofclass;
	@FindBy(xpath="/html/body/app-root/app-session/div/mat-card")WebElement outside;
	public Class() {
		PageFactory.initElements(driver, this);
	}
	
	public void home() {
		Actions action= new Actions(driver);
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
        action.moveByOffset(0, 0).click().perform();
		HomeButton.click();
	}
	
	public void classbtn() {
		Actions action= new Actions(driver);
		WebElement bodyElement = driver.findElement(By.xpath("//body[contains(@class, 'mat-typography')]"));
        action.moveByOffset(0, 0).click().perform();
		Classbtn.click();
}
	public void lmstitle() {
		//String title = driver.getTitle();
		//Assert.assertEquals("LMS", title);
		String actual=LMSTitle.getText();
		//String expect="Manage Batch";
		Assert.assertEquals(actual, "LMS - Learning Management System");
}
	public void classheader() {
		
		String actual = classheader.getText();
		Assert.assertEquals(actual,"Manage Class");
}
public void dashboardhr() {
		
		String actual = dashboardhr.getText();
		Assert.assertEquals(actual,"Dashboard");
}
	public String searchbar() {
		
if (search.isDisplayed()) {
			
			String actualSearchPlaceholder = search.getAttribute("placeholder");
			return actualSearchPlaceholder;
		
		}
		else {return "";}
	}
public List<String> classcolheader() {
	List<String> actualColOrder = new ArrayList<>();
	for (WebElement link : colHeaders) {
	    actualColOrder.add(link.getText().trim()); // Trim to remove spaces
	}
	System.out.println("Actual Link Order: " + actualColOrder);
	return actualColOrder;

}
	public Boolean validatePaginationTextandIcons(String text) throws InterruptedException  {
		Thread.sleep(1000);
		WebElement paginatorElement = paginator;
		boolean areIconsPresent = prevBtn.isDisplayed()
				&& startbtn.isDisplayed()
				&& nextBtn.isDisplayed()
				&& lastBtn.isDisplayed();
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



public boolean sortingicons() {
	try {
		List<WebElement> sortIcons = driver.findElements(sorticon);

		for (int i = 0; i < sortIcons.size(); i++) {
			if (sortIcons.get(i).isDisplayed())
				return true;
		}

	} catch (Exception e) {
		return false;
	}
	return false;
}
public void comdeleteicon() {
	Assert.assertEquals(comdelete.isDisplayed(),true);
}
public boolean noofclasses() {
	Assert.assertEquals(noofclass.isDisplayed(), true);
	return true;
}
public void searchbatch() {
	search.clear(); 
	search.sendKeys("Python101");
	search.sendKeys(Keys.ENTER);
}
public void searchclasstopic() {
	search.clear(); 
	search.sendKeys("API01MYTOC"); 
	//search.findBy(xpath="/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]")
	search.sendKeys(Keys.ENTER);
}
public void searchstaffname() {
	search.clear(); 
	search.sendKeys("Kevin Thomas"); 
	search.sendKeys(Keys.ENTER);
}
public void clickNextPg() {
    if (isNextButtonEnabled()) {
        doubleClick(nextBtn);
    }
    }
public void clickPrevPg() {
    if (isPrevButtonEnabled()) {
    	  doubleClick (prevBtn);
    }
}
public void clickstartbtn() {
    if (isstartbtnEnabled()) {
    	  doubleClick (startbtn);
    }
}
public void clickFirstPg() {
	
      doubleClick(firstBtn);
}
public void clickLastPage() {
    doubleClick(lastBtn);
}

public boolean NextPg() {
    return nextBtn.isEnabled();
    }
    
public boolean PrevPg() {
    return prevBtn.isEnabled();
}
public boolean FirstPg() {
	
      return firstBtn.isEnabled();
}
public boolean startbtn() {
	
    return startbtn.isEnabled();
}

public boolean LastPage() {
    return lastBtn.isEnabled();
}
public void clickPageNumber(int pageIndex) {
	 doubleClick(pageBtns.get(pageIndex - 1));
}

public boolean isNextButtonEnabled() {
    return !nextBtn.getAttribute("class").contains("p-disabled");
}
public boolean isstartbtnEnabled() {
    return !startbtn.getAttribute("class").contains("p-disabled");
}

public boolean isPrevButtonEnabled() {
    return !prevBtn.getAttribute("class").contains("p-disabled");
}

public String getCurrentEntriesText() {
    return currentEntriesText.getText();
}

//public boolean hasNextPageResults() {
//    //    return !rows.isEmpty(); 
//}
private void doubleClick(WebElement element) {
    Actions actions = new Actions(driver); 
    actions.moveToElement(element).doubleClick().perform(); 
}

public void outsidebox() {
	outside.click();
}
}



